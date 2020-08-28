package com.piyush.uploadservice.Services;

import java.util.Comparator;
import java.util.List;

import com.piyush.uploadservice.Dto.SummaryDto;
import com.piyush.uploadservice.Entities.StockPrices;
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
            throw new Exception("Invalid Excel Format");
        }

        List<StockPrices> stockList = ExcelHelper.uploadExcel(file.getInputStream());

        logger.info("extracted data from excel");
        
        stockRepository.saveAll(stockList);
        return this.getSummary(stockList);

    }

    private SummaryDto getSummary(List<StockPrices> stockList) {
        SummaryDto summaryDto = new SummaryDto();

        if (stockList.size() != 0) 
			{
	            summaryDto.setNumOfRecords(stockList.size());
	            summaryDto.setCompanyCode(stockList.get(0).getCompanyCode());
	            summaryDto.setStockExCode(stockList.get(0).getStockCode());
	            
	            stockList.sort(Comparator.comparing(StockPrices::getDate));
	            
	            summaryDto.setStartDate(stockList.get(0).getDate());
	            summaryDto.setEndDate(stockList.get(stockList.size()-1).getDate());
	        }
        return summaryDto ;
    }

}