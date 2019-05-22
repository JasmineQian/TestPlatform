package com.example.demo.jdbc;


import com.example.demo.bean.Bug;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BugRowMapper implements RowMapper<Bug> {
    @Override
    public Bug mapRow(ResultSet resultSet, int i) throws SQLException {
        //此处要使用表中的字段，不能使用属性
        long id = resultSet.getInt("bug_id");
        String pname = resultSet.getString("project_name");
        String cr_name = resultSet.getString("cr_name");
        String crmnum = resultSet.getString("bug_cr_num");
        String tasknum = resultSet.getString("bug_task_num");
        String oname = resultSet.getString("object_name");
        String description = resultSet.getString("bug_description");
        String rca = resultSet.getString("bug_rca");
        String solution = resultSet.getString("bug_solution");
        String developer = resultSet.getString("developer");
        String tester = resultSet.getString("tester");
        String creationdt = resultSet.getString("qa_creationdt");
        String updatedt = resultSet.getString("qa_updatedt");
        String bugStatus = resultSet.getString("status_des");

        Bug bug = new Bug();
        bug.setId(id);
        bug.setPname(pname);
        bug.setOname(oname);
        bug.setCrname(cr_name);
        bug.setCrnum(crmnum);
        bug.setTasknum(tasknum);
        bug.setDescription(description);
        bug.setRca(rca);
        bug.setSolution(solution);
        bug.setDeveloper(developer);
        bug.setTester(tester);
        bug.setCreationdt(creationdt);
        bug.setUpdatedt(updatedt);
        bug.setBugStatus(bugStatus);

        return bug;

    }
}
