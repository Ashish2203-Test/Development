package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import report.ExcelReportData;
import java.io.*;
import java.util.*;


public class ExcelUtils {

    public static Collection<Object[]> getLoginData(String file){

        List<Object[]> list=new ArrayList<>();

        FileInputStream fis=null;
        XSSFWorkbook wbk=null;

        try{
            fis=new FileInputStream(new File(file));
            wbk = new XSSFWorkbook(fis);
            XSSFSheet ws = wbk.getSheetAt(0);

            Iterator<Row> rowIter=ws.iterator();
            rowIter.next();

            while(rowIter.hasNext()){

                Row row=rowIter.next();

                String username=row.getCell(0).getStringCellValue();
                String password=row.getCell(1).getStringCellValue();

                list.add(new Object[]{username, password});
            }

            fis.close();

        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(fis!=null){
                try{
                    fis.close();
                }catch(Exception e){}
            }
        }
        return list;
    }

    public static void generateExcelReport(List<ExcelReportData> result, String outputFile){

        FileInputStream fis=null;
        FileOutputStream fos=null;
        XSSFWorkbook wbk=null;

        try{
            fis=new FileInputStream(new File(outputFile));
            wbk = new XSSFWorkbook(fis);
            XSSFSheet ws = wbk.getSheetAt(0);

            Iterator<Row> rowIter=ws.iterator();
            rowIter.next();

            int i=0;
            while(rowIter.hasNext()){

                Row row=rowIter.next();
                row.getCell(2).setCellValue(result.get(i).getResult());
                i++;
            }

            fis.close();

            fos=new FileOutputStream(outputFile);
            wbk.write(fos);
            fos.close();
        }catch(IOException exception){
            exception.printStackTrace();
        }finally{
            if(fis!=null){
                try{
                    fis.close();
                }catch(Exception ex){}
            }
            if(fos!=null){
                try{
                    fos.close();
                }catch(Exception e){}
            }
        }
    }
}
