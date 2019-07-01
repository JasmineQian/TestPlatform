package com.example.demo.email;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BugNotifyRowMapper implements RowMapper<BugNotifyBean> {
    @Override
    public BugNotifyBean mapRow(ResultSet resultSet, int i) throws SQLException {
        //此处要使用表中的字段，不能使用属性
        long id = resultSet.getInt("BUG_ID");
        String pname = resultSet.getString("PROJECT_NAME");
        String img = resultSet.getString("project_img");
        String cr_name = resultSet.getString("CR_NAME");
        String crmnum = resultSet.getString("BUG_CR_NUM");
        String tasknum = resultSet.getString("BUG_TASK_NUM");
        String oname = resultSet.getString("OBJECT_NAME");
        String description = resultSet.getString("BUG_DESCRIPTION");
        String rca = resultSet.getString("BUG_RCA");
        String solution = resultSet.getString("BUG_SOLUTION");
        String developerMail = resultSet.getString("DEVELOPER");
        String testerMail = resultSet.getString("TESTER");
        String creationdt = resultSet.getString("QA_CREATIONDT");
        String updatedt = resultSet.getString("QA_UPDATEDT");
        String bugStatus = resultSet.getString("status_des");

        //rca=rca.replaceAll("/n","<br />");

        BugNotifyBean bugNotifyBean = new BugNotifyBean();
        bugNotifyBean.setId(id);
        bugNotifyBean.setPname(pname);
        bugNotifyBean.setImg(img);
        bugNotifyBean.setOname(oname);
        bugNotifyBean.setCrname(cr_name);
        bugNotifyBean.setCrnum(crmnum);
        bugNotifyBean.setTasknum(tasknum);
        bugNotifyBean.setDescription(description);
        bugNotifyBean.setRca(rca);
        bugNotifyBean.setSolution(solution);
        bugNotifyBean.setDeveloperEmail(developerMail);
        bugNotifyBean.setTesterEmail(testerMail);
        bugNotifyBean.setCreationdt(creationdt);
        bugNotifyBean.setUpdatedt(updatedt);
        bugNotifyBean.setBugStatus(bugStatus);

        return bugNotifyBean;

    }
}
