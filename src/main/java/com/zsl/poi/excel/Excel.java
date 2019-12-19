package com.zsl.poi.excel;

import com.zsl.util.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * @author zsl
 * @date 2019/11/18
 */
public class Excel {

    private static String path = "D:\\schoolStudio\\basic-learning\\data-structure\\src\\main\\java\\com\\zsl\\poi\\file\\";

    private static String tempPaht = path + "/temp_001.xlsx";

    private List<HashMap<String,String>> list = new ArrayList<>(5);

    public static String getPath(){
        return path + DateUtil.parseDate2String(new Date(),"yyyy_MM_dd_HH_mm_ss")+".xlsx";
    }

    @Before
    public void beforeList(){
        HashMap<String,String> map;
        for (int i=0;i<5;i++){
            map = new HashMap<String,String>(3);
            map.put("id",UUID.randomUUID().toString());
            map.put("age","10"+i);
            map.put("name","test_"+UUID.randomUUID().toString());
            list.add(map);
        }
    }

    /**
     * 根据现有的模板文件生成带数据的excel
     */
    @Test
    public void test2(){
        try (OutputStream outputStream = new FileOutputStream(new File(Excel.getPath()));
             InputStream inputStream = new FileInputStream(new File(Excel.tempPaht))) {
            //创建工作空间
            Workbook workbook = new XSSFWorkbook(inputStream);

            //设置sheet名
            workbook.setSheetName(0,"客户基本信息");

            //获取sheet
            Sheet sheet = workbook.getSheetAt(0);

            //获取模板行
            Row tplRow = sheet.getRow(1);

            //获取带数据的最后一行为第几行
            int lastRowNum = sheet.getLastRowNum();
            Row row;
            for (int i = 0; i < list.size(); i++) {
                row = sheet.createRow(lastRowNum+i+1);
                //创建列,根据模板的${}类型获取key，设置值
                for (int j = tplRow.getFirstCellNum();j<tplRow.getLastCellNum();j++){
                    String key = tplRow.getCell(j).getStringCellValue().replace("$", "")
                            .replace("{", "").replace("}", "");
                    row.createCell(j).setCellValue(list.get(i).get(key));
                }
            }
            //将模板数据以下的数据往上移
            sheet.shiftRows(2,2+list.size()-1,-1);
            workbook.write(outputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 简单生成Excel文件
     */
    @Test
    public void test1(){
        //创建工作空间
        Workbook workbook = new XSSFWorkbook();
        //创建sheet
        Sheet sheet = workbook.createSheet("test1");
        //创建row
        Row row = sheet.createRow(0);
        //创建cell并填充数据
        for (int i = 0; i < 4; i++) {
            row.createCell(i).setCellValue("test"+"_"+i);
        }
        try(OutputStream outputStream = new FileOutputStream(new File(Excel.getPath()))) {
            //写入文件
            workbook.write(outputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
