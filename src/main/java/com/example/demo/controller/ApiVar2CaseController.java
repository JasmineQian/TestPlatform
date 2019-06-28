package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.ApiCaseBean;
import com.example.demo.bean.ApiInfoBean;
import com.example.demo.bean.ApiVarBean;
import com.example.demo.service.ApiCaseService;
import com.example.demo.service.ApiInfoService;
import com.example.demo.service.ApiVarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Random;


@Controller
public class ApiVar2CaseController {


    String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    String ALLINT = "0123456789";

    @Autowired
    private ApiInfoService apiInfoService;

    @Autowired
    private ApiVarService apiVarService;

    @Autowired
    private ApiCaseService apiCaseService;

    @RequestMapping("/CheckMustVar")
    //根据必传参数，依次生成"请求传入的xx参数未传，验证返回"
    public String CheckMustVar(Model model, int taskid) {
        List<ApiVarBean> list = apiVarService.CheckMustVar(taskid);
        apiCaseService.deleteByTypeId(taskid,1);
        System.out.println(list);
        System.out.println(list.size());
        int max = 0;
        String body = null;
        for (int i = 0; i < list.size(); i++) {
            String var = list.get(i).getVal();
            var = "请求中未传入" + var + "验证返回" + var + "~~更多断言";
            System.out.println(var);
            StringBuffer sb = new StringBuffer();
            JSONObject jsonObject = new JSONObject();
            body = jsonObject.toString();


            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).getVal() != list.get(j).getVal()) {
                    jsonObject.put(list.get(j).getVal(),list.get(j).getVal_sample());
                }
            }

            body = jsonObject.toString();
            System.out.println(body);
            ApiCaseBean apiCaseBean = new ApiCaseBean();
            apiCaseBean.setApiCase_taskid(taskid);
            apiCaseBean.setApiCase_name(var);
            apiCaseBean.setApiCase_body(body);
            apiCaseBean.setApiCase_asseertion(null);
            apiCaseBean.setApiCase_priorityid(3);
            apiCaseBean.setCasetype_id(1);

            int count = apiCaseService.add(apiCaseBean);
            System.out.println(count);
        }

        List<ApiVarBean> lists = apiVarService.CheckAllVar(taskid);
        ApiInfoBean infoBean = apiInfoService.findApiById(taskid);
        model.addAttribute("var", lists);
        model.addAttribute("infoBean", infoBean);
        return "var/api_vars";
    }




    //根据必传参数，依次生成"请求传入的XX参数为空字符串"
    @RequestMapping("/CheckMustVarEmpty")
    public String CheckMustVarEmpty(Model model,int taskid) {
        List<ApiVarBean> list = apiVarService.CheckMustVar(taskid);
        apiCaseService.deleteByTypeId(taskid,2);
        int max = 0;
        String body = null;
        for (int i = 0; i < list.size(); i++) {
            String var = list.get(i).getVal();
            var = "请求中传入" + var + "为空字符串验证返回" + var + "~~更多断言";
            System.out.println(var);
            StringBuffer sb = new StringBuffer();
            JSONObject jsonObject = new JSONObject();
            body = jsonObject.toString();
            for (int j = 0; j < list.size(); j++) {

                if (list.get(i).getVal() != list.get(j).getVal()) {
                    jsonObject.put(list.get(j).getVal(),list.get(j).getVal_sample());

                } else {
                    jsonObject.put(list.get(j).getVal(),"");
                }
            }

            body = jsonObject.toString();
            ApiCaseBean apiCaseBean = new ApiCaseBean();
            apiCaseBean.setApiCase_taskid(taskid);
            apiCaseBean.setApiCase_name(var);
            apiCaseBean.setApiCase_body(body);
            apiCaseBean.setApiCase_asseertion(null);
            apiCaseBean.setApiCase_priorityid(3);
            apiCaseBean.setCasetype_id(2);

            int count = apiCaseService.add(apiCaseBean);
            System.out.println(count);
        }
        List<ApiVarBean> lists = apiVarService.CheckAllVar(taskid);
        ApiInfoBean infoBean = apiInfoService.findApiById(taskid);
        model.addAttribute("var", lists);
        model.addAttribute("infoBean", infoBean);
        return "var/api_vars";
    }


    //根据接口中参数，依次生成"请求传入的XX参数为最大长度+1，即超过最大长度"
    @RequestMapping("/CheckVarOverLength")
    public String CheckVarOverLength(Model model,int taskid) {
        List<ApiVarBean> list = apiVarService.CheckMustVar(taskid);
        apiCaseService.deleteByTypeId(taskid,3);
        int max = 0;
        String body = null;
        for (int i = 0; i < list.size(); i++) {
            String var = list.get(i).getVal();
            int length = list.get(i).getInputLenght();
            var = "请求中传入" + var + "的长度为" + length + "实际传入的长度为" + (length + 1) + "验证返回" + var + "~~更多断言";
            System.out.println(var);
            StringBuffer sb = new StringBuffer();

            JSONObject jsonObject = new JSONObject();
            body = jsonObject.toString();

            for (int j = 0; j < list.size(); j++) {
                Random random = new Random();
                max = list.get(j).getInputLenght();
                sb = new StringBuffer("");
                if (list.get(i).getVal() != list.get(j).getVal()) {
                        sb.append(list.get(j).getVal_sample());
                } else {
                    for (int k = 0; k <= max; k++) {
                        sb.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));
                    }
                }

                jsonObject.put(list.get(j).getVal(),sb);
            }


            body = jsonObject.toString();
            ApiCaseBean apiCaseBean = new ApiCaseBean();
            apiCaseBean.setApiCase_taskid(taskid);
            apiCaseBean.setApiCase_name(var);
            apiCaseBean.setApiCase_body(body);
            apiCaseBean.setApiCase_asseertion(null);
            apiCaseBean.setApiCase_priorityid(3);
            apiCaseBean.setCasetype_id(3);

            int count = apiCaseService.add(apiCaseBean);
            System.out.println(count);
        }

        List<ApiVarBean> lists = apiVarService.CheckAllVar(taskid);
        ApiInfoBean infoBean = apiInfoService.findApiById(taskid);
        model.addAttribute("var", lists);
        model.addAttribute("infoBean", infoBean);
        return "var/api_vars";

    }


}
