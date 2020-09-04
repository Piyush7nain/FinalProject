package com.piyush.uploadservice.Controllers;

import java.util.List;

import com.piyush.uploadservice.Dto.SummaryDto;
import com.piyush.uploadservice.Entities.StockPrices;
import com.piyush.uploadservice.Services.UploadService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class UpoloadController {

    @Autowired
    UploadService uploadService;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/excel")
    public ResponseEntity<SummaryDto> uploadExcel(@RequestParam("file") MultipartFile file) throws Exception{
        SummaryDto summary = uploadService.uploadExcel(file);
        logger.info("Summary recieved in Controller");
        return ResponseEntity.status(HttpStatus.OK).body(summary);
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/all")
    public ResponseEntity<List<StockPrices>> getAllStocks()  {
        List<StockPrices> allStocks = uploadService.getAllStocks();
        if (allStocks.size() == 0) {
            //throw new StockNotFoundException("No Stocks listed anywhere");
            return null;   
        }
        return ResponseEntity.status(HttpStatus.OK).body(allStocks);
    }
    
}