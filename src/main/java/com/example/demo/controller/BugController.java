package com.example.demo.controller;

import com.example.demo.bean.*;
import com.example.demo.security.AnyUserDetailsService;
import com.example.demo.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class BugController {


    @Value("${dateformat}")
    String dateformat;

    // 记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BugService bugService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployService employService;

    @Autowired
    private TestTypeService testTypeService;

    @Autowired
    private CRService crService;

    @Autowired
    private BugStatusService bugStatusService;

    @Autowired
    private AnyUserDetailsService anyUserDetailsService;

    @RequestMapping("/listpage")
    public String findAll(Model model, @RequestParam(value = "pageon", defaultValue = "1") int pageon,
                          @RequestParam(value = "pid", defaultValue = "0") int pid,
                          @RequestParam(value = "crnum", required = false) String crnum,
                          @RequestParam(value = "tasknum", required = false) String tasknum,
                          @RequestParam(value = "testid", defaultValue = "0") int testid,
                          @RequestParam(value = "devid", defaultValue = "0") int devid,
                          @AuthenticationPrincipal Principal principal) {

        String userid =principal.getName();
        UserDetails userDetails =anyUserDetailsService.loadUserByUsername(userid);
        System.out.println(userDetails.getAuthorities());
        System.out.println(userDetails.getAuthorities().toArray());
        List<Object> auth = Arrays.asList(userDetails.getAuthorities());
        System.out.println(auth);
        Collection<? extends GrantedAuthority> auth2=userDetails.getAuthorities();
        System.out.println(auth2);
        Iterator iterator =auth2.iterator();
        int userflag=0;
        while (iterator.hasNext()) {
            String ei = iterator.next().toString();
            System.out.println("iterator value: " + ei);
            if(ei.toLowerCase().equals("role_admin"))
                userflag = 1;
            break;
        }
        model.addAttribute("userflag", userflag);

        model.addAttribute("pid", pid);
        if (crnum != null) {
            model.addAttribute("crnum", crnum);
        } else {
            model.addAttribute("crnum", " ");
        }
        ;
        if (tasknum != null) {
            model.addAttribute("tasknum", tasknum);
        } else {
            model.addAttribute("tasknum", " ");
        }
        ;
        model.addAttribute("testid", testid);
        model.addAttribute("devid", devid);

        System.out.println(pid);
        System.out.println(crnum);
        System.out.println(tasknum);
        System.out.println(testid);
        System.out.println(devid);


        List<Project> projects = projectService.findAll();
        List<Employ> testers = employService.findTester();
        List<Employ> developers = employService.findDeveloper();
        List<TestType> testType = testTypeService.findTestType();
        List<CR> crtype = crService.findCRType();
        List<BugStatus> bugStatuses = bugStatusService.findBugStatus();
        model.addAttribute("projects", projects);
        model.addAttribute("testers", testers);
        model.addAttribute("developers", developers);
        model.addAttribute("testType", testType);
        model.addAttribute("crtype", crtype);
        model.addAttribute("bugStatus", bugStatuses);

        Page page = new Page();

        int pagerow = 20;
        List<Bug> lists = bugService.findAllbyPage(pageon, pid, crnum, tasknum, testid, devid);
        int TotalRows = bugService.countAll(pid, crnum, tasknum, testid, devid);
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

        model.addAttribute("list", lists);
        model.addAttribute("page", page);
        return "bug/bugs";
    }


    @RequestMapping("/findByIdpage")
    public String findByIdpage(Model model, @RequestParam("BugListId") int id) {
        logger.info("根据用户ID查询用户信息");
        Bug bug = bugService.findById(id);
        logger.info(String.valueOf(bug));
        if (bug != null) {
            logger.info("查询成功！");
            model.addAttribute("bug", bug);
            model.addAttribute("message", "查询成功");
            return "bug/bug_details";
        } else {
            model.addAttribute("message", "查询失败");
            return "auto";
        }
    }

    @RequestMapping("/insert")
    public String insert(Model model) {
        logger.info("转页面");
        List<Project> projects = projectService.findAll();
        List<Employ> testers = employService.findTester();
        List<Employ> developers = employService.findDeveloper();
        List<TestType> testType = testTypeService.findTestType();
        List<CR> crtype = crService.findCRType();
        List<BugStatus> bugStatuses = bugStatusService.findBugStatus();
        model.addAttribute("projects", projects);
        model.addAttribute("testers", testers);
        model.addAttribute("developers", developers);
        model.addAttribute("testType", testType);
        model.addAttribute("crtype", crtype);
        model.addAttribute("bugStatus", bugStatuses);
        return "bug/bug_insert";
    }


    @PostMapping("/create")
    public String create(Model model, Bug bug) {
        logger.info("新增bug记录");
        int result = bugService.create(bug);
        if (result == 1) {
            logger.info("新增bug成功！");
            model.addAttribute("message", "新增bug成功");
            return "bug/bug_auto";
        } else {
            model.addAttribute("message", "新增bug失败");
            logger.info("新增bug失败!");
            return "bug/bug_auto";
        }

    }

    //@Secured("ROLE_ADMIN")//此方法只允许 ROLE_ADMIN 角色访问
    @GetMapping("/del")
    public String del(Model model, @RequestParam("BugListId") int id) {
        int temp = bugService.deleteByID(id);
        logger.info(String.valueOf(temp));
        if (temp > 0) {
            logger.info("删除成功!");
            model.addAttribute("message", "删除成功");
            return "bug/bug_auto";
        } else {
            model.addAttribute("message", "删除失败");
            return "bug/bug_auto";
        }

    }


    @RequestMapping("/toUpdate")
    public String toupdate(Model model, @RequestParam("BugListId") int id, @AuthenticationPrincipal Principal principal) {
        logger.info("转向更新页面,在页面提交之前，并未进行更新");
        List<Project> projects = projectService.findAll();
        List<Employ> testers = employService.findTester();
        List<Employ> developers = employService.findDeveloper();
        List<TestType> testType = testTypeService.findTestType();
        List<CR> crtype = crService.findCRType();
        List<BugStatus> bugStatuses = bugStatusService.findBugStatus();

        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
        String date = sdf.format(dt);

        model.addAttribute("projects", projects);
        model.addAttribute("testers", testers);
        model.addAttribute("developers", developers);
        model.addAttribute("testType", testType);
        model.addAttribute("crtype", crtype);
        model.addAttribute("bugStatuslist", bugStatuses);
        model.addAttribute("bugtracking", "用户" + principal.getName() + "于" + date + "增加comments\n");


        Bug bug = bugService.findById(id);
        model.addAttribute("bug", bug);
        logger.info("转向==============================================更新");
        return "bug/bug_update";
    }


    @RequestMapping("/Update")
    public String update(Model model, Bug bug) {
        logger.info("修改用户" + bug);

        int result = bugService.update(bug);
        if (result == 1) {
            logger.info("修改Bug信息成功！");
            model.addAttribute("message", "修改Bug信息成功");
            return "bug/bug_auto";
        } else {
            logger.info("修改Bug信息失败!");
            model.addAttribute("message", "修改Bug信息成功");
            return "bug/bug_auto";
        }
    }

}
