package com.example.demo.service.impl;


import com.example.demo.bean.Bug;
import com.example.demo.bean.SearchResult;
import com.example.demo.jdbc.BugRowMapper;
import com.example.demo.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BugServiceImpl implements BugService {

    @Value("${dateformat}")
    String dateformat;



    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Bug> findAllbyPage(int pageon, int pid, String crnum, String tasknum, int testerid, int devid) {
        SearchResult searchResult = new SearchResult();
        int start = (pageon - 1) * 20;
        String sql = "select bug_id,project_name,cr_name,bug_cr_num,bug_task_num,object_name,bug_description,bug_rca,bug_solution,b.employ_name developer,a.employ_name tester,qa_creationdt,qa_updatedt,bug_deleted_flag,status_des\n" +
                "from qa_buglist\n" +
                "join qa_project on bug_project_id = project_id  \n" +
                "join qa_crtype on cr_id = bug_cr_type_id  \n" +
                "join qa_rtype on object_id = qa_type_id  \n" +
                "join qa_employ a on a.employ_id = qa_tester_id and a.employ_group = 1   \n" +
                "join qa_employ b on b.employ_id= qa_assignee_id and b.employ_group = 2  \n" +
                "join qa_bugstatus on status_id =  bug_status_id\n" +
                "where bug_deleted_flag =0";
        List<Object> queryList = new ArrayList<Object>();
        if (pid != 0) {
            sql += " and bug_project_id = ? ";
            queryList.add(pid);
        }
        if (crnum != null) {
            sql += " and bug_cr_num like ? ";
            queryList.add("%" + crnum.trim() + "%");
        }
        if (tasknum != null) {
            sql += " and bug_task_num  like ? ";
            queryList.add("%" + tasknum.trim() + "%");
        }
        if (testerid != 0) {
            sql += " and qa_tester_id = ? ";
            queryList.add(testerid);
        }
        if (devid != 0) {
            sql += " and qa_assignee_id = ?  ";
            queryList.add(devid);
        }

        String sql2 = sql + " order by 1 desc limit " + start + " , 20";
        //String sql2 = sql + " order by 1 desc offset  " + start + "  rows fetch next  20 rows only";

        List<Bug> lists = jdbcTemplate.query(sql2, queryList.toArray(), new BugRowMapper());
        searchResult.getList(lists);
        System.out.println(searchResult);
        System.out.println(sql2);
        return lists;
    }


    @Override
    public int countAll(int pid, String crnum, String tasknum, int testerid, int devid) {

        String sql = "select bug_id,project_name,cr_name,bug_cr_num,bug_task_num,object_name,bug_description,bug_rca,bug_solution,b.employ_name developer,a.employ_name tester,qa_creationdt,qa_updatedt,bug_deleted_flag,status_des\n" +
                "from qa_buglist\n" +
                "join qa_project on bug_project_id = project_id  \n" +
                "join qa_crtype on cr_id = bug_cr_type_id  \n" +
                "join qa_rtype on object_id = qa_type_id  \n" +
                "join qa_employ a on a.employ_id = qa_tester_id and a.employ_group = 1   \n" +
                "join qa_employ b on b.employ_id= qa_assignee_id and b.employ_group = 2  \n" +
                "join qa_bugstatus on status_id =  bug_status_id\n" +
                "where bug_deleted_flag =0";
        List<Object> queryList = new ArrayList<Object>();
        if (pid != 0) {
            sql += " and BUG_PROJECT_ID = ? ";
            queryList.add(pid);
        }
        if (crnum != null) {
            sql += " and bug_cr_num like ? ";
            queryList.add("%" + crnum.trim() + "%");
        }
        if (tasknum != null) {
            sql += " and bug_task_num  like ? ";
            queryList.add("%" + tasknum.trim() + "%");
        }
        if (testerid != 0) {
            sql += " and qa_tester_id = ? ";
            queryList.add(testerid);
        }
        if (devid != 0) {
            sql += " and qa_assignee_id = ?  ";
            queryList.add(devid);
        }

        int count = jdbcTemplate.query(sql, queryList.toArray(), new BugRowMapper()).size();
        return count;
    }

    @Override
    public Bug findById(int id) {
        String sql = "select bug_id,project_name,cr_name,bug_cr_num,bug_task_num,object_name,bug_description,bug_rca,bug_solution,b.employ_name developer,a.employ_name tester,qa_creationdt,qa_updatedt,bug_deleted_flag,status_des\n" +
                "from qa_buglist\n" +
                "join qa_project on bug_project_id = project_id  \n" +
                "join qa_crtype on cr_id = bug_cr_type_id  \n" +
                "join qa_rtype on object_id = qa_type_id  \n" +
                "join qa_employ a on a.employ_id = qa_tester_id and a.employ_group = 1   \n" +
                "join qa_employ b on b.employ_id= qa_assignee_id and b.employ_group = 2  \n" +
                "join qa_bugstatus on status_id =  bug_status_id\n" +
                "where bug_deleted_flag =0 and bug_id = ?";
        Bug bug = jdbcTemplate.queryForObject(sql, new BugRowMapper(), id);
        return bug;
    }


    @Override
/*    public int create(String pname, String crname, String crnum, String tasknum, String oname, String description,
                      String rca, String solution, String developer, String tester, String bugStatus) {*/
    public int create(Bug bug) {
        Date dt = new Date();
        DateFormat bf = new SimpleDateFormat(dateformat);
        String date = bf.format(dt);

        String pname = bug.getPname().trim();
        String crname = bug.getCrname().trim();
        String crnum = bug.getCrnum().trim();
        String oname = bug.getOname().trim();
        String tasknum = bug.getTasknum().trim();
        String description = bug.getDescription().trim();
        String rca = bug.getRca().trim();
        String solution = bug.getSolution().trim();
        int developer = new Integer(bug.getDeveloper());
        int tester = new Integer(bug.getTester());
        int bugStatus = new Integer(bug.getBugStatus());

        String sql = "INSert qa_buglist(bug_project_id,bug_cr_type_id,bug_cr_num,bug_task_num,qa_type_id,bug_description,bug_rca,bug_solution,qa_assignee_id,qa_tester_id,qa_creationdt,qa_updatedt,bug_status_id)\n" +
                "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, pname, crname, crnum, tasknum, oname, description, rca, solution, developer, tester, date, date, bugStatus);
    }

    @Override
/*    public int update(long id, String pname, String crname, String crnum, String oname, String tasknum,
                      String description, String rca, String solution, String developer, String tester, String bugStatus) {*/
    public int update(Bug bug) {
        long id = bug.getId();


        String sql2 = "select bug_id,project_name,cr_name,bug_cr_num,bug_task_num,object_name,bug_description,bug_rca,bug_solution,b.employ_name developer,a.employ_name tester,qa_creationdt,qa_updatedt,bug_deleted_flag,status_des\n" +
                "from qa_buglist\n" +
                "join qa_project on bug_project_id = project_id  \n" +
                "join qa_crtype on cr_id = bug_cr_type_id  \n" +
                "join qa_rtype on object_id = qa_type_id  \n" +
                "join qa_employ a on a.employ_id = qa_tester_id and a.employ_group = 1   \n" +
                "join qa_employ b on b.employ_id= qa_assignee_id and b.employ_group = 2  \n" +
                "join qa_bugstatus on status_id =  bug_status_id\n" +
                "where bug_deleted_flag =0 and bug_id = ?";
        Bug oldbug = jdbcTemplate.queryForObject(sql2, new BugRowMapper(), id);

        String rcaold = oldbug.getRca();
        String solutionold = oldbug.getSolution();

        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
        String date = sdf.format(dt);

        String pname = bug.getPname().trim();
        String crname = bug.getCrname().trim();
        String crnum = bug.getCrnum().trim();
        String oname = bug.getOname().trim();
        String tasknum = bug.getTasknum().trim();
        String description = bug.getDescription().trim();
        String rca = bug.getRca().trim();
        String solution = bug.getSolution().trim();
        String tracking=bug.getTracking().trim();
        int developer = new Integer(bug.getDeveloper());
        int tester = new Integer(bug.getTester());
        int bugStatus = new Integer(bug.getBugStatus());

        System.out.println(rca.length());
        System.out.println(solution.length());

        if (rca.length() < 1) {
            rca = rcaold;
        } else {
            rca = rcaold + " \n" + tracking+"\n" +rca;
        }

        if (solution.length() < 1) {
            solution = solutionold;
        } else {
            solution = solutionold + " \n" + tracking+"\n"+ solution;
        }

        String sql = "update qa_buglist set bug_project_id = ?,bug_cr_type_id=?, bug_cr_num =?, qa_type_id =?,bug_task_num =?,bug_description=?," +
                "bug_rca=?,bug_solution= ?,qa_assignee_id = ? ,qa_tester_id =? ,qa_updatedt =? ,bug_status_id = ? " +
                "where bug_id = ?";
        return jdbcTemplate.update(sql, pname, crname, crnum, oname, tasknum, description, rca, solution, developer, tester, date, bugStatus, id);
    }

    @Override
    public int deleteByID(int id) {
        String sql = "update qa_buglist set bug_deleted_flag = 1,  bug_deleted_comment = '逻辑删除' where bug_id = ?";
        int count = jdbcTemplate.update(sql, id);
        return count;
    }
}
