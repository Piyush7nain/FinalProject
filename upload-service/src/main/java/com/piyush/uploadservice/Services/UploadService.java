package com.piyush.uploadservice.Services;

import com.piyush.uploadservice.Dto.SummaryDto;
import com.piyush.uploadservice.ExcelHelper.ExcelHelper;
import com.piyush.uploadservice.Repo.StockRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {

    @Autowired
    StockRepository stockRepository;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public SummaryDto uploadExcel(MultipartFile file) throws Exception {
        //check for excel and generate inputStream
        String fileName = file.getOriginalFilename();
		String fileType = fileName.substring(fileName.lastIndexOf("."));

        if(fileType ==null || fileType.equals(".xls")||fileType.equals(".csv")){
            //throw new Exception("Invalid Excel Format");
            return new SummaryDto("failed","Incorrect file format");
        }
        logger.info("stockRepository in service -> {}", stockRepository);
        ExcelHelper excelHelper = new ExcelHelper(stockRepository);
        return excelHelper.uploadExcel(file.getInputStream());

        /* if(stockList.size()>0){
            stockRepository.saveAll(stockList);
            logger.info("Added all the stocks to Database");
            
            SummaryDto summary = this.getSummary(stockList);
            logger.info("Summary -> {}", summary);
            return summary;
        }else{
            SummaryDto summary = new SummaryDto("failed", "StockCode in File does not match the StockCode passed");
        } */

    }

    

	// public List<StockPrices> getAllStocks() {
	// 	return stockRepository.findAll();
	// }

}