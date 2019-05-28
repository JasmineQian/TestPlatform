package com.example.demo.controller;


import com.example.demo.bean.*;
import com.example.demo.service.CasePassService;
import com.example.demo.service.CaseProirityService;
import com.example.demo.service.CaseService;
import com.example.demo.service.TaskService;
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
public class CaseController {

    // 记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CaseService caseService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private CasePassService casePassService;

    @Autowired
    private CaseProirityService caseProirityService;


    @RequestMapping("/findCaseByTaskId")
    public String findCaseByTaskId(Model model, @RequestParam(value = "pageon", defaultValue = "1") int pageon
            , @RequestParam("taskId") int id) {

        Task task = taskService.findById(id);
        model.addAttribute("taskid", id);
        model.addAttribute("task", task);

        List<Case> testcase = caseService.findCasesbyTaskid(id, pageon);

        CasePage page = new CasePage();
        int pagerow = 20;
        int TotalRows = caseService.countCasesbyTaskid(id, pageon);
        System.out.println("目前总共的条数是" + TotalRows);
        int pages = 0;
        if (TotalRows % pagerow == 0) {
            pages = TotalRows / pagerow;
        } else {
            pages = TotalRows / pagerow + 1;
        }
        System.out.println("目前分页的总页数是" + pages);

        page.setRowcount(TotalRows);
        page.setEnd(pages);
        page.setStart(0);
        page.setPagecount(pages);
        page.setPageNumber(pageon);
        page.setPageon(pageon);
        page.setVar(id);


        model.addAttribute("page", page);

        if (testcase != null) {
            logger.info("查询成功！");

            model.addAttribute("testcase", testcase);
            return "case/cases";
        } else {

            model.addAttribute("message", "查询失败");
            return "case/case_auto";
        }
    }


    @GetMapping("/findCaseById")
    public String findCaseById(Model model, @RequestParam("caseId") int id) {
        logger.info("根据Case的ID来查找case信息");
        model.addAttribute("caseId", "id");
        Case testCase = caseService.findById(id);
        int taskid= testCase.getCase_taskid();
        if (testCase != null) {
            logger.info("查询成功！");
            model.addAttribute("taskid", taskid);
            model.addAttribute("testcase", testCase);
            return "case/case_details";
        } else {
            model.addAttribute("taskid", taskid);
            model.addAttribute("message", "查询失败");
            return "case/case_auto";
        }
    }


    @GetMapping("/delCaseById")
    public String delCaseById(Model model, @RequestParam("caseId") int id) {
        Case testcase= caseService.findById(id);
        int taskid= testcase.getCase_taskid();
        int count = caseService.deleteByID(id);
        if (count != 0) {
            model.addAttribute("message", "删除Case成功");
            model.addAttribute("taskid", taskid);
            return "case/case_auto";
        } else {
            model.addAttribute("message", "删除Case失败");
            model.addAttribute("taskid", taskid);
            return "case/case_auto";
        }
    }


    @GetMapping("/SearchCaseById")
    public String SearchCaseById(Model model, @RequestParam("caseId") int id) {

        Case testcase = caseService.findById(id);
        int taskid = testcase.getCase_taskid();

        if (testcase != null) {
            model.addAttribute("cc", testcase);
            return "case/case_details";
        } else {
            model.addAttribute("message", "查询case失败");
            model.addAttribute("taskid", taskid);
            return "case/case_auto";
        }
    }

    @PostMapping("/UpdateCaseById")
    public String UpdateCaseById(Model model, Case testcase) {
        int taskid = testcase.getCase_taskid();
        int count = caseService.update(testcase);
        System.out.println(taskid);
        System.out.println(testcase);
        if (count == 1) {
            logger.info("根据ID更新Case任务成功！");
            model.addAttribute("taskid", taskid);
            model.addAttribute("message", "根据ID更新Case成功");
            return "case/case_auto";
        } else {
            model.addAttribute("message", "根据ID更新Case失败");
            model.addAttribute("taskid", taskid);
            logger.info("新增task失败!");
            return "case/case_auto";
        }
    }

    @GetMapping("/casetoUpdate")
    public String casetoUpdate(Model model, @RequestParam("caseId") int id) {
        logger.info("转向更新页面,在页面提交之前，并未进行更新");

        Case testcase = caseService.findById(id);
        List<CaseProirity> caseProirities=caseProirityService.findAllCaseProirity();
        List<CasePass> casePasses=casePassService.findAllPass();

        model.addAttribute("cc", testcase);
        model.addAttribute("caseProirities", caseProirities);
        model.addAttribute("casePasses", casePasses);
        logger.info("转向==============================================更新");
        return "case/case_update";
    }


    @PostMapping("/insertCase")
    public String insertCase(Model model, Case testcase) {
        System.out.println(testcase);
        int taskid = testcase.getCase_taskid();
        int count = caseService.create(testcase);
        if (count == 1) {
            model.addAttribute("taskid", taskid);
            model.addAttribute("message", "新增测试用例成功");
            return "case/case_auto";
        } else {
            model.addAttribute("taskid", taskid);
            model.addAttribute("message", "新增测试用例失败");
            logger.info("新增task失败!");
            return "case/case_auto";
        }
    }

    @GetMapping("/insertCasePage")
    public String insertCasePage(Model model, @RequestParam("taskId") int id) {
        logger.info("转页面");
        Task task = taskService.findById(id);
        List<CaseProirity> caseProirities=caseProirityService.findAllCaseProirity();
        List<CasePass> casePasses=casePassService.findAllPass();
        model.addAttribute("task", task);
        model.addAttribute("taskId", id);
        model.addAttribute("caseProirities", caseProirities);
        model.addAttribute("casePasses", casePasses);
        return "case/case_insert";
    }
}
