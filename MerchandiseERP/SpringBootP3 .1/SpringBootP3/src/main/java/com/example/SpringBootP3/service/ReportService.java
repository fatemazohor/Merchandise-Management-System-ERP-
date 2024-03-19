package com.example.SpringBootP3.service;

import com.example.SpringBootP3.model.buyer.Buyers;
import com.example.SpringBootP3.repository.buyer.IBuyerRepo;
import com.example.SpringBootP3.restController.BuyerRest;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

@Autowired
    private IBuyerRepo buyerRepo;

public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
    String path="F:\\New folder\\BOOK\\New folder\\github\\Merchandise-Management-System-ERP-\\reports";
    // data list
    List<Buyers> buyers = buyerRepo.findAll();
    //load file
    File file = ResourceUtils.getFile("F:\\New folder\\BOOK\\New folder\\github\\Merchandise-Management-System-ERP-\\MerchandiseERP\\SpringBootP3 .1\\SpringBootP3\\src\\main\\resources\\reports\\buyers.jrxml");
    //compile file for jasper
    JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(buyers);
    Map<String,Object> para = new HashMap<>();
    para.put("cratedBy","Fatema Tuz Zohora");
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,para,dataSource);
    if(reportFormat.equalsIgnoreCase("html")){
        JasperExportManager.exportReportToHtmlFile(jasperPrint,path+"\\buyersList.html");
    }
    if(reportFormat.equalsIgnoreCase("pdf")){
        JasperExportManager.exportReportToPdfFile(jasperPrint,path+"\\buyersList.pdf");
    }
    return "report generated in path:"+path;



}



}
