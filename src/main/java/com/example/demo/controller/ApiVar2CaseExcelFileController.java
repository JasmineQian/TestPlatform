package com.example.demo.controller;


import com.example.demo.bean.ApiCaseBean;
import com.example.demo.bean.ApiInfoBean;
import com.example.demo.service.ApiCaseService;
import com.example.demo.service.ApiInfoService;
import com.example.demo.service.ApiVarService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class ApiVar2CaseExcelFileController {


    // 记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ApiInfoService apiInfoService;


    @Autowired
    private ApiCaseService apiCaseService;

    @Autowired
    private ApiVarService apiVarService;

    @GetMapping("/downloadcases")
    public void downloadcases(HttpServletResponse response, int apiInfoId) {
        List<ApiCaseBean> cases = apiCaseService.findApiCaseById(apiInfoId);
        ApiInfoBean infoBean = apiInfoService.findApiById(apiInfoId);
        //EXCEL表导出核心代码
        //   声明一个Excel
        HSSFWorkbook wb = null;

        //title代表的是你的excel表开头每列的名字
        String[] title = new String[]{"用例序号", "项目名称", "接口名称", "测试用例描述", "测试请求体", "测试断言",
                "测试等级", "是否通过", "备注", "创建时间", "更新时间"};


        String name = infoBean.getApi_name() + "接口的自动化测试用例";
        //excel文件名
        String fileName = name + ".xls";

        //sheet名
        String sheetName = name + "表";

        //二维数组铺满整个Excel

        String[][] content = new String[cases.size()][title.length];
        //--------------------------------------------------------------------------------------------

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if (wb == null) {
            wb = new HSSFWorkbook();
        }

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);


        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);


        //声明列对象
        HSSFCell cell = null;

        //创建标题
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            // cell.setCellStyle(style);
        }


        //把list放进content里

        for (int i = 0; i < cases.size(); i++) {
            content[i] = new String[title.length];
            ApiCaseBean obj = cases.get(i);
            content[i][0] = String.valueOf(obj.getApiCase_num());
            content[i][1] = obj.getApiCase_projectname();
            content[i][2] = obj.getApiCase_taskname();
            content[i][3] = obj.getApiCase_name();
            content[i][4] = obj.getApiCase_body();
            content[i][5] = obj.getApiCase_asseertion();
            content[i][6] = obj.getApiCase_priority();
            content[i][7] = obj.getApiCase_passinfo();
            content[i][8] = obj.getApiCase_memo();
            content[i][9] = obj.getCreatedt();
            content[i][10] = obj.getUpdatedt();

        }
        //添加数据进入excel

        for (int i = 0; i < content.length; i++) {

            row = sheet.createRow(i + 1);

            for (int j = 0; j < content[i].length; j++) {

                //将内容按顺序赋给对应的列对象
                HSSFCell cel = row.createCell(j);
                cel.setCellValue(content[i][j]);

            }
        }


        //响应到客户端
        try {
            try {
                try {
                    fileName = new String(fileName.getBytes(), "ISO8859-1");
                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                response.setContentType("application/octet-stream;charset=ISO8859-1");
                response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
                response.addHeader("Pargam", "no-cache");
                response.addHeader("Cache-Control", "no-cache");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
