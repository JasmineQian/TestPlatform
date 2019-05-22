package com.example.demo.controller;


import com.example.demo.bean.CaseReport;
import com.example.demo.service.CaseReportService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class ExcelController {

    // 记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CaseReportService caseReportService;

    @RequestMapping("/excelExport")
    public void excelExport(HttpServletRequest request, HttpServletResponse response,
                            @RequestParam(value = "pid", defaultValue = "0") int pid,
                            @RequestParam(value = "crnum",required = false) String crnum,
                            @RequestParam(value = "description",required = false) String description) throws Exception {
/*        request.setCharacterEncoding("utf-8");
        int aa = Integer.parseInt(request.getParameter("pid"));
        String bb = request.getParameter("crnum");
        String n = request.getParameter("description");
        String pid = new String(aa.getBytes("ISO-8859-1"),"UTF-8");
        String crnum = new String(bb.getBytes("ISO-8859-1"),"UTF-8");
        String description = new String(n.getBytes("ISO-8859-1"),"UTF-8");*/


        List<CaseReport> lists = caseReportService.findByCondtion(pid, crnum, description);
        System.out.println(pid);
        System.out.println(crnum);
        System.out.println(description);


        //EXCEL表导出核心代码
        //   声明一个Excel
        HSSFWorkbook wb = null;

        //title代表的是你的excel表开头每列的名字
        String[] title = new String[]{"task_id", "project_name", "object_name", "task_name", "task_crname", "task_description", "task_details",
                "task_note", "case_id", "case_num", "pirority_name", "case_name", "case_precondition", "case_body", "case_assertion",
                "casepassflag_name", "case_memo", "case_creationdt", "case_updatedt"};


        String name = "测试用例";
        //excel文件名
        String fileName = name + ".xls";

        //sheet名
        String sheetName = name + "表";

        //二维数组铺满整个Excel

        String[][] content = new String[lists.size()][title.length];
        //--------------------------------------------------------------------------------------------

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if (wb == null) {
            wb = new HSSFWorkbook();
        }

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);


        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);

/*        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        //设置背景色
        style.setFillForegroundColor(HSSFColor.LIGHT_BLUE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        //设置边框
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置居右
        style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);//水平居右
        style.setVerticalAlignment(HSSFCellStyle.ALIGN_RIGHT);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        //设置字体
        HSSFFont font = wb.createFont();
        font.setFontName("黑体");
        font.setFontHeightInPoints((short) 16);//设置字体大小
        HSSFFont font2 = wb.createFont();
        font2.setFontName("仿宋_GB2312");
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font2.setFontHeightInPoints((short) 12);

        style.setFont(font);//选择需要用到的字体格式

        //设置列宽
        sheet.setColumnWidth(0, 12000);//第一个参数代表列id（从0开始），第二个参数代表宽度值
        sheet.setColumnWidth(1, 4567);//第一个参数代表列id（从1开始），第二个参数代表宽度值
        sheet.setColumnWidth(2, 4567);//第一个参数代表列id（从2开始），第二个参数代表宽度值
        sheet.setColumnWidth(3, 4567);//第一个参数代表列id（从3开始），第二个参数代表宽度值
        sheet.setColumnWidth(4, 4567);//第一个参数代表列id（从4开始），第二个参数代表宽度值
        style.setWrapText(true);//设置自动换行

        //加边框
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        cellStyle.setRightBorderColor(HSSFColor.BLACK.index);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
        cellStyle.setTopBorderColor(HSSFColor.BLACK.index);*/

        //声明列对象
        HSSFCell cell = null;

        //创建标题
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            // cell.setCellStyle(style);
        }


        //把list放进content里

        for (int i = 0; i < lists.size(); i++) {
            content[i] = new String[title.length];
            CaseReport obj = lists.get(i);
            content[i][0] = String.valueOf(obj.getTask_id());
            content[i][1] = obj.getProject_name();
            content[i][2] = obj.getObject_name();
            content[i][3] = obj.getTask_name();
            content[i][4] = obj.getTask_crname();
            content[i][5] = obj.getTask_description();
            content[i][6] = obj.getTask_details();
            content[i][7] = obj.getTask_note();
            content[i][8] = obj.getCase_id();
            content[i][9] = String.valueOf(obj.getCase_num());
            content[i][10] = obj.getPirority_name();
            content[i][11] = obj.getCase_name();
            content[i][12] = obj.getCase_precondition();
            content[i][13] = obj.getCase_body();
            content[i][14] = obj.getCase_assertion();
            content[i][15] = obj.getCasepassflag_name();
            content[i][16] = obj.getCase_memo();
            content[i][17] = obj.getCase_creationdt();
            content[i][18] = obj.getCase_updatedt();


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
