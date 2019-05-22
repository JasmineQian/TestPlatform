package com.example.demo.jdbc;

import com.example.demo.bean.Task;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskRowMapper implements RowMapper<Task> {
    @Override
    public Task mapRow(ResultSet resultSet, int i) throws SQLException {
        //此处要使用表中的字段，不能使用属性
        int id = resultSet.getInt("task_id");
        int task_pid =resultSet.getInt("task_pid");
        String task_project =resultSet.getString("project_name");
        int task_tid =resultSet.getInt("task_pid");
        String task_tname = resultSet.getString("object_name");
        String taskname = resultSet.getString("task_name");
        String crname = resultSet.getString("task_crname");;
        String description = resultSet.getString("task_description");
        String details = resultSet.getString("task_details");;
        String note = resultSet.getString("task_note");;
        String creationdt = resultSet.getString("task_creationdt");;
        String updatedt = resultSet.getString("task_updatedt");;

        Task task= new Task();
        task.setTaskid(id);
        task.setTask_pid(task_pid);
        task.setTask_project(task_project);
        task.setTask_tid(task_tid);
        task.setTask_tname(task_tname);
        task.setTaskname(taskname);
        task.setCrname(crname);
        task.setDescription(description);
        task.setDetails(details);
        task.setNote(note);
        task.setCreationdt(creationdt);
        task.setUpdatedt(updatedt);

        return task;
    }



}
