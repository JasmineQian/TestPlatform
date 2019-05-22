package com.example.demo.service.impl;

import com.example.demo.bean.Bug;
import com.example.demo.bean.SearchResult;
import com.example.demo.bean.Task;
import com.example.demo.jdbc.BugRowMapper;
import com.example.demo.jdbc.TaskRowMapper;
import com.example.demo.service.TaskService;
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
public class TaskServiceImpl implements TaskService {

    @Value("${dateformat}")
    String dateformat;


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Task> findAll() {
        String sql = "select task_id,task_pid,project_name,task_tid, object_name,\n" +
                "task_name,task_crname,task_description,task_details,task_note,task_creationdt,task_updatedt\n" +
                "from qa_task \n" +
                "join  qa_project on task_pid =  project_id\n" +
                "join  qa_rtype on object_id = task_tid\n" +
                "where  task_deleted_flag = 0 order by 1 desc";
        List<Task> lists = jdbcTemplate.query(sql, new TaskRowMapper());
        return lists;
    }

    @Override
    public List<Task> findMultiByCondtion(int pageon, int pid, String name, String description) {

        int start = (pageon - 1) * 20;
        String sql = "select task_id,task_pid,project_name,task_tid, object_name,\n" +
                "task_name,task_crname,task_description,task_details,task_note,task_creationdt,task_updatedt\n" +
                "from qa_task \n" +
                "join  qa_project on task_pid =  project_id\n" +
                "join  qa_rtype on object_id = task_tid\n" +
                "where  task_deleted_flag = 0";

        List<Object> queryList = new ArrayList<Object>();
        if (pid != 0) {
            sql += " and task_pid = ? ";
            queryList.add(pid);
        }
        if (name!=null) {
            sql += " and task_crname like ? ";
            queryList.add("%" + name.trim() + "%");
        }
        if (description!=null) {
            sql += " and task_description  like ? ";
            queryList.add("%" + description.trim() + "%");
        }


        String sql2 = sql + " order by 1 desc limit " + start + " , 20";
        //String sql2 = sql+" order by 1 desc offset  "+ start+  "  rows fetch next  20 rows only";

        List<Task> lists = jdbcTemplate.query(sql2, queryList.toArray(), new TaskRowMapper());
        System.out.println(sql2);
        return lists;

    }

    @Override
    public int countAll(int pageon, int pid, String name, String description) {

        String sql = "select task_id,task_pid,project_name,task_tid, object_name,\n" +
                "task_name,task_crname,task_description,task_details,task_note,task_creationdt,task_updatedt\n" +
                "from qa_task \n" +
                "join  qa_project on task_pid =  project_id\n" +
                "join  qa_rtype on object_id = task_tid\n" +
                "where  task_deleted_flag = 0";

        List<Object> queryList = new ArrayList<Object>();
        if (pid != 0) {
            sql += " and task_pid = ? ";
            queryList.add(pid);
        }
        if (name!=null) {
            sql += " and task_crname like ? ";
            queryList.add("%" + name.trim() + "%");
        }
        if (description!=null) {
            sql += " and task_description  like ? ";
            queryList.add("%" + description.trim() + "%");
        }

        int count = jdbcTemplate.query(sql, queryList.toArray(), new TaskRowMapper()).size();
        return count;
    }


    @Override
    public Task findById(int id) {
        String sql = "select task_id,task_pid,project_name,task_tid, object_name,\n" +
                "task_name,task_crname,task_description,task_details,task_note,task_creationdt,task_updatedt\n" +
                "from qa_task \n" +
                "join  qa_project on task_pid =  project_id\n" +
                "join  qa_rtype on object_id = task_tid\n" +
                "where  task_deleted_flag = 0\n" +
                "and task_id = ?";

        Task task = jdbcTemplate.queryForObject(sql, new TaskRowMapper(), id);
        return task;
    }

    @Override
    public int create(Task task) {
        String sql = "insert qa_task(task_pid,task_tid,task_name,task_crname,task_description,task_details,task_note,task_creationdt,task_updatedt)\n" +
                "values(?,?,?,?,?,?,?,?,?)";

        Date dt = new Date();
        DateFormat bf = new SimpleDateFormat(dateformat);
        String date = bf.format(dt);

        int pid = task.getTask_pid();
        int tid = task.getTask_tid();
        String taskname = task.getTaskname();
        String taskcrname = task.getCrname();
        String desciprtion = task.getDescription();
        String Details = task.getDetails();
        String note = task.getNote();


        int count = jdbcTemplate.update(sql, pid, tid, taskname, taskcrname, desciprtion, Details, note, date, date);
        return count;
    }

    @Override
    public int update(Task task) {
        String sql = "update qa_task set task_name=? ,task_crname =? ,task_description =? ,task_details =? ,task_note =? ,task_updatedt =?\n" +
                "where task_id = ?";

        Date dt = new Date();
        DateFormat bf = new SimpleDateFormat(dateformat);
        String date = bf.format(dt);

        int id = task.getTaskid();
        String taskname = task.getTaskname();
        String taskcrname = task.getCrname();
        String desciprtion = task.getDescription();
        String Details = task.getDetails();
        String note = task.getNote();
        int count = jdbcTemplate.update(sql, taskname, taskcrname, desciprtion, Details, note, date, id);
        return count;
    }

    @Override
    public int deleteByID(int id) {
        String sql = "update qa_task set task_deleted_flag = 1, task_deleted_comment = '逻辑删除', task_updatedt = ? where task_id= ?";
        Date dt = new Date();
        DateFormat bf = DateFormat.getDateTimeInstance();
        String date = bf.format(dt);
        int count = jdbcTemplate.update(sql, date, id);
        return count;
    }
}
