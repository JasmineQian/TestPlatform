package com.example.demo.controller;

import com.example.demo.bean.*;
import com.example.demo.service.ApiCaseService;
import com.example.demo.service.ApiInfoService;
import com.example.demo.service.ProjectService;
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
public class ApiInfoController {

    // 记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ApiInfoService apiInfoService;


    @Autowired
    private ApiCaseService apiCaseService;

    @Autowired
    private ProjectService projectService;


    @RequestMapping("/findAllApi")
    public String findAllApi(Model model, @RequestParam(value = "pageon", defaultValue = "1") int pageon,
                             @RequestParam(value = "pid", defaultValue = "0") int pid,
                             @RequestParam(value = "apiname", required = false) String apiname) {
        List<Project> projects = projectService.findAll();
        List<ApiInfoBean> lists = apiInfoService.findAllApi(pageon, pid, apiname);

        model.addAttribute("pid", pid);
        if (apiname != null) {
            model.addAttribute("apiname", apiname);
        } else {
            model.addAttribute("apiname", " ");
        }

        Page page =new Page();

        int pagerow=20;

        int TotalRows = apiInfoService.countAll(pageon, pid, apiname);
        System.out.println("目前总共的条数是"+TotalRows);
        int pages= 0;
        if(TotalRows % pagerow == 0){ pages = TotalRows / pagerow;}
        else { pages = TotalRows / pagerow +1 ;}
        System.out.println("目前分页的总页数是"+pages);

        page.setRowcount(TotalRows);
        page.setEnd(pages);
        page.setStart(0);
        page.setPagecount(pages);
        page.setPageNumber(pageon);
        page.setPageon(pageon);

        model.addAttribute("projects", projects);
        model.addAttribute("lists", lists);
        model.addAttribute("page", page);
        return "api/apis";
    }


    @RequestMapping("/insertApiCasePage")
    public String insertApiCasePage(Model model) {
        logger.info("转页面");
        List<Project> projects = projectService.findAll();
        model.addAttribute("projects", projects);
        return "api/api_insert";
    }

    @PostMapping("/apiCasecreate")
    public String apiCasecreate(Model model, ApiInfoBean apiInfoBean) {
        logger.info("新增bug记录");
        int count = apiInfoService.createApi(apiInfoBean);
        if (count == 1) {
            logger.info("新增API接口成功！");
            model.addAttribute("message", "新增API接口成功");
            return "api/api_auto";
        } else {
            model.addAttribute("message", "新增API接口失败");
            return "api/api_auto";
        }
    }

    @RequestMapping("/apiInfotoUpdate")
    public String apiInfotoUpdate(Model model, int api) {
        ApiInfoBean apiInfoBean = apiInfoService.findApiById(api);
        model.addAttribute("apiID", api);
        model.addAttribute("api", apiInfoBean);
        return "api/api_update";
    }

    @PostMapping("/apiInfoUpdate")
    public String apiInfoUpdate(Model model, ApiInfoBean apiInfoBean) {
        int count = apiInfoService.updateApi(apiInfoBean);
        if (count == 1) {
            logger.info("更新API接口成功！");
            model.addAttribute("message", "更新API接口成功");
            return "api/api_auto";
        } else {
            model.addAttribute("message", "更新API接口失败");
            return "api/api_auto";
        }


    }


    @GetMapping("/findApiById")
    public String findApiById(Model model, int api) {
        ApiInfoBean apiInfoBean = apiInfoService.findApiById(api);
        model.addAttribute("api", apiInfoBean);
        return "api/api_details";
    }


    @GetMapping("/delApiById")
    public String delApiById(Model model, int api) {
        int count = apiInfoService.deleteApi(api);
        if (count > 0) {
            logger.info("删除成功!");
            model.addAttribute("message", "删除成功");
            return "api/api_auto";
        } else {
            model.addAttribute("message", "删除失败");
            return "api/api_auto";
        }
    }
}
