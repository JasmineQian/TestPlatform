package com.example.demo.controller;


import com.example.demo.bean.*;
import com.example.demo.service.ApiCaseService;
import com.example.demo.service.ApiInfoService;
import com.example.demo.service.ApiVarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ApiVarController {

    // 记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ApiInfoService apiInfoService;


    @Autowired
    private ApiCaseService apiCaseService;

    @Autowired
    private ApiVarService apiVarService;

    // 新增一个变量
    @PostMapping("/apiVarcreate")
    public String apiVarcreate(Model model, ApiVarBean apiVarBean) {
        int count = apiVarService.save(apiVarBean);
        if (count == 1) {
            model.addAttribute("message", "新增API的变量成功");
            return "var/var_auto";
        } else {
            model.addAttribute("message", "新增API的变量失败");
            return "var/var_auto";
        }
    }


    @GetMapping("/insertAPIVarPage")
    public String insertAPIVarPage(Model model, @RequestParam("apiInfoId") int id) {
        logger.info("转页面");
        ApiInfoBean apiInfoBean = apiInfoService.findApiById(id);
        model.addAttribute("apiInfoBean", apiInfoBean);
        model.addAttribute("api", id);
        return "var/api_varinsert";
    }

    @PostMapping("/apiVarUpdate")
    public String apiVarUpdate(Model model, ApiVarBean apiVarBean) {
        int count = apiVarService.update(apiVarBean);
        if (count == 1) {
            model.addAttribute("message", "更新接口变量成功");
            return "var/var_auto";
        } else {
            model.addAttribute("message", "更新接口变量失败");
            return "var/var_auto";
        }
    }

    @RequestMapping("/apiVartoUpdate")
    public String apiInfotoUpdate(Model model, int id) {
        ApiVarBean apivar =  apiVarService.selectByid(id);
        model.addAttribute("apivar", apivar);
        return "var/api_varupdate";
    }


    //查看API中的所有变量的信息
    @GetMapping("/findApiVarById")
    public String findApiVarById(Model model, int api) {
        List<ApiVarBean> lists = apiVarService.CheckAllVar(api);
        ApiInfoBean infoBean = apiInfoService.findApiById(api);
        model.addAttribute("var", lists);
        model.addAttribute("infoBean", infoBean);
        return "var/api_vars";
    }


    //删除API中的一个变量的信息
    @GetMapping("/delAPiVarById")
    public String delAPiVarById(Model model, int id) {
        System.out.println(id);
        int count = apiVarService.deleteByid(id);
        if (count == 1) {
            model.addAttribute("message", "删除接口变量成功");
            return "var/var_auto";
        } else {
            model.addAttribute("message", "删除接口变量失败");
            return "var/var_auto";
        }
    }





}
