package com.piyush.uploadservice.Controllers;

import com.piyush.uploadservice.Dto.SummaryDto;
import com.piyush.uploadservice.Services.UploadService;

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

    @PostMapping("/excel")
    public ResponseEntity<SummaryDto> uploadExcel(@RequestParam("file") MultipartFile file) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(uploadService.uploadExcel(file));
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    
}