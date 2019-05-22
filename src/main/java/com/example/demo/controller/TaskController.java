package com.example.demo.controller;


import com.example.demo.bean.*;
import com.example.demo.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskController {

    // 记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TaskService taskService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployService employService;

    @Autowired
    private TestTypeService testTypeService;

    @Value("${defaultString}")
    private String defaultString;

    @RequestMapping("/findTaskById")
    public String findTaskById(Model model, @RequestParam("taskId") int id) {
        logger.info("根据Task的ID来查找Task信息");

        Task task = taskService.findById(id);
        System.out.println(task);

        if (task != null) {
            logger.info("查询成功！");
            model.addAttribute("task", task);
            return "task/task_details";
        } else {
            model.addAttribute("message", "查询失败");
            return "task/task_auto";
        }
    }


    @RequestMapping("/findAllTask")
    public String findAllTask(Model model,@RequestParam(value="pageon",defaultValue="1")int pageon,
    @RequestParam(value="pid",required = false,defaultValue="0")int pid,
    @RequestParam(value="crnum",required = false)String crnum,
    @RequestParam(value="description",required = false)String description) {

        if (crnum!=null) {model.addAttribute("crnum", crnum);} else {model.addAttribute("crnum", " ");};
        if (description!=null) {model.addAttribute("description", description);}else {model.addAttribute("description", " ");}
        model.addAttribute("pid", pid);
        Page page =new Page();

        int pagerow=20;
        List<Task> lists= taskService.findMultiByCondtion(pageon,pid,crnum,description);
        int TotalRows = taskService.countAll(pageon,pid,crnum,description);
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

        List<Project> projects = projectService.findAll();
        List<TestType> testType = testTypeService.findTestType();

        model.addAttribute("projects", projects);
        model.addAttribute("testType", testType);
        model.addAttribute("tasklist", lists);

        model.addAttribute("page", page);
        return "task/tasks";

    }

    @GetMapping("/TaskInsert")
    public String insert(Model model) {
        logger.info("转页面");
        List<Project> projects = projectService.findAll();
        List<Employ> testers = employService.findTester();
        List<Employ> developers = employService.findDeveloper();
        List<TestType> testType = testTypeService.findTestType();

        model.addAttribute("projects", projects);
        model.addAttribute("testers", testers);
        model.addAttribute("developers", developers);
        model.addAttribute("testType", testType);

        return "task/task_insert";
    }

    @PostMapping("/TaskCreation")
    public String TaskCreation(Model model, Task task) {
        logger.info("新增Task记录");
        int result = taskService.create(task);
        if (result == 1) {
            logger.info("新增task成功！");
            model.addAttribute("message", "新增测试任务成功");
            return "task/task_auto";
        } else {
            model.addAttribute("message", "新增测试任务失败");
            logger.info("新增task失败!");
            return "task/task_auto";
        }
    }


    @GetMapping("/delTaskbyID")
    public String delTaskbyID(Model model, @RequestParam("taskId") int id) {
        logger.info("根据ID删除task任务");
        int result = taskService.deleteByID(id);
        if (result == 1) {
            logger.info("根据ID删除task任务成功！");
            model.addAttribute("message", "根据ID删除task任务成功");
            return "task/task_auto";
        } else {
            model.addAttribute("message", "根据ID删除task任务失败");
            logger.info("新增task失败!");
            return "task/task_auto";
        }
    }


    @GetMapping("/tasktoUpdate")
    public String tasktoUpdate(Model model, @RequestParam("taskId") int id) {
        logger.info("转向更新页面,在页面提交之前，并未进行更新");
        List<Project> projects = projectService.findAll();
        List<Employ> testers = employService.findTester();
        List<Employ> developers = employService.findDeveloper();
        List<TestType> testType = testTypeService.findTestType();
        Task task = taskService.findById(id);

        model.addAttribute("projects", projects);
        model.addAttribute("testers", testers);
        model.addAttribute("developers", developers);
        model.addAttribute("testType", testType);
        model.addAttribute("task", task);
        logger.info("转向==============================================更新");
        return "task/task_update";
    }


    @PostMapping("/TaskUpdate")
    public String TaskUpdate(Model model, Task task) {
        logger.info("根据ID更新task任务");
        int result = taskService.update(task);
        System.out.println(result);
        if (result == 1) {
            logger.info("根据ID更新task任务成功！");
            model.addAttribute("message", "根据ID更新task任务成功");
            return "task/task_auto";
        } else {
            model.addAttribute("message", "根据ID更新task任务失败");
            logger.info("新增task失败!");
            return "task/task_auto";
        }
    }

}
