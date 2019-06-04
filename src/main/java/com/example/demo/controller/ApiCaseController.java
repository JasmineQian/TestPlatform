package com.example.demo.controller;

import com.example.demo.bean.ApiCaseBean;
import com.example.demo.bean.ApiInfoBean;
import com.example.demo.service.ApiCaseService;
import com.example.demo.service.ApiInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ApiCaseController {

    // 记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ApiInfoService apiInfoService;


    @Autowired
    private ApiCaseService apiCaseService;


    @GetMapping("/findApiCaseById")
    public String findApiCaseById(Model model, int api) {
        ApiInfoBean apiInfoBean = apiInfoService.findApiById(api);
        model.addAttribute("apiInfo", apiInfoBean);
        List<ApiCaseBean> lists = apiCaseService.findApiCaseById(api);
        model.addAttribute("api", api);
        model.addAttribute("lists", lists);
        return "api/api_cases";
    }


    @GetMapping("/UpdateApiCaseById")
    public String UpdateApiCaseById(Model model, int id) {
        ApiCaseBean apiCaseBean = apiCaseService.findApiCase(id);
        model.addAttribute("apiCaseBean", apiCaseBean);
        return "api/api_case";
    }


    @PostMapping("/UpdateApiCase")
    public String UpdateApiCase(Model model, ApiCaseBean apiCaseBean) {
        System.out.println(apiCaseBean);
        int count = apiCaseService.update(apiCaseBean);
        if (count > 0) {
            model.addAttribute("message", "更新自动化测试用例成功");
            return "api/api_auto";
        } else {
            model.addAttribute("message", "更新自动化测试用例失败");
            return "api/api_auto";
        }
    }



    @GetMapping("/delAPiCaseById")
    public String delAPiCaseById(Model model, int id) {
        int count = apiCaseService.delete(id);
        if (count > 0) {
            model.addAttribute("message", "删除自动化测试用例成功");
            return "api/api_auto";
        } else {
            model.addAttribute("message", "删除自动化测试用例失败");
            return "api/api_auto";
        }
    }
}
