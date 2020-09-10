package com.piyush.uploadservice.ExcelHelper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.piyush.uploadservice.Dto.SummaryDto;
import com.piyush.uploadservice.Entities.StockPrices;
import com.piyush.uploadservice.Repo.StockRepository;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelHelper {

    
    private StockRepository stockRepository;

    Logger logger = LoggerFactory.getLogger(ExcelHelper.class);

    public SummaryDto uploadExcel(InputStream is) throws Exception {

        List<StockPrices> stockList = new ArrayList<>();
        Workbook workbook = null;
        InputStream inputStream = is;
        ;

        workbook = new XSSFWorkbook(inputStream);
        logger.info("workBook created -> {}", workbook);

        Sheet sheet = workbook.getSheetAt(0);
        logger.info("Sheet created with columns -> {}", sheet.getRow(0).getPhysicalNumberOfCells());
        logger.info("Sheet created with rows -> {}", sheet.getLastRowNum());
        if (sheet.getRow(0).getPhysicalNumberOfCells() < 4) {
            workbook.close();
            //throw new Exception("");
            return new SummaryDto("failed", "File format not Correct,Some Columns Missing");
        }
        int rowNum = sheet.getLastRowNum() + 1;
        for (int i = 1; i < rowNum; i++) {
            Row row = sheet.getRow(i);
            if (row.getRowNum() == 0) {
                continue;
            }
            StockPrices sp = new StockPrices(
                    row.getCell(0, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue(),
                    row.getCell(1, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue(),
                    row.getCell(2, MissingCellPolicy.RETURN_BLANK_AS_NULL).getNumericCellValue(),
                    row.getCell(3, MissingCellPolicy.RETURN_BLANK_AS_NULL).getDateCellValue(),
                    row.getCell(4, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue());
                logger.info("new Stock -> {}", sp);
                stockList.add(sp);  
        }

        logger.info("Closing workbook and sheet");
        if (inputStream != null) {
            inputStream.close();
        }
        if (workbook != null) {
            workbook.close();
        }

        if(stockList.size()>0){
            stockRepository.saveAll(stockList);
            return getSummary(stockList);
        }else{
            return new SummaryDto("failed", "No Stock Code present in the file");
        }
    }

    private SummaryDto getSummary(List<StockPrices> stockList) {
        SummaryDto summaryDto = new SummaryDto();

        if (stockList.size() != 0) 
			{   
                summaryDto.setStatus("successful");
                summaryDto.setMessage("Uploaded all stocks successfully");
	            summaryDto.setNumOfRecords(stockList.size());
	            summaryDto.setCompanyCode(stockList.get(0).getCompanyCode());
	            summaryDto.setStockExCode(stockList.get(0).getStockCode());
	            
	            stockList.sort(Comparator.comparing(StockPrices::getDate));
	            
	            summaryDto.setStartDate(stockList.get(0).getDate());
	            summaryDto.setEndDate(stockList.get(stockList.size()-1).getDate());
            }
            logger.info("prepared summary");    
        return summaryDto ;
    }

    public ExcelHelper() {
    }

    public ExcelHelper(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
    
}
/* 
Integer.toString(
                    (int) row.getCell(0, MissingCellPolicy.RETURN_BLANK_AS_NULL).getNumericCellValue()) */