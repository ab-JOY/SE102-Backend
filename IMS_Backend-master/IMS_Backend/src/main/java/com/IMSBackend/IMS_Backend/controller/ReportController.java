package com.IMSBackend.IMS_Backend.controller;

import com.IMSBackend.IMS_Backend.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/report")
    public ResponseEntity<String> generateReport(){
        reportService.generateReportForAgeRange();
        return ResponseEntity.ok("report generated successfully");
    }
}
