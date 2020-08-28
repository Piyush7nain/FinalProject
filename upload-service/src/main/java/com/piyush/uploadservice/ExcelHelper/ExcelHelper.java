package com.piyush.uploadservice.ExcelHelper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.piyush.uploadservice.Entities.StockPrices;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelHelper {

    static Logger logger = LoggerFactory.getLogger(ExcelHelper.class);

    public static List<StockPrices> uploadExcel(InputStream is) throws Exception{

        List<StockPrices> stockList = new ArrayList<>();
        Workbook workbook = null;
        InputStream inputStream = is;
        ;
        
        
            workbook = new XSSFWorkbook(inputStream);
            logger.info("workBook created -> {}", workbook);

            Sheet sheet = workbook.getSheetAt(0);
            logger.info("Sheet created with columns -> {}", sheet.getRow(0).getPhysicalNumberOfCells());
            logger.info("Sheet created with rows -> {}", sheet.getLastRowNum());
            if(sheet.getRow(0).getPhysicalNumberOfCells() <4){
                workbook.close(); 
                throw new Exception("File format not Correct,Some Columns Missing");
            }
            int rowNum = sheet.getLastRowNum()+1;
            for(int i =1;i<rowNum;i++){
                Row row = sheet.getRow(i);
                if(row.getRowNum() == 0){continue;}

                StockPrices sp = new StockPrices(
                    row.getCell(0,MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue(),
                    row.getCell(1,MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue(),
                    row.getCell(2,MissingCellPolicy.RETURN_BLANK_AS_NULL).getNumericCellValue(),
                    row.getCell(3,MissingCellPolicy.RETURN_BLANK_AS_NULL).getDateCellValue(),
                    row.getCell(4,MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue()
                );
                logger.info("new Stock -> {}", sp);
                stockList.add(sp);
            }


            logger.info("No exception thrown till in try");

        
        logger.info("Closing workbook and sheet");
            if (inputStream != null) {
                inputStream.close();
            }
            if (workbook != null) {
                workbook.close();
            }
        return stockList;
    }

    
}