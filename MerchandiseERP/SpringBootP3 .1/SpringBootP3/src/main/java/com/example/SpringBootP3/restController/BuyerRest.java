package com.example.SpringBootP3.restController;

import com.example.SpringBootP3.model.buyer.Buyers;
import com.example.SpringBootP3.repository.buyer.IBuyerRepo;
import com.example.SpringBootP3.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@CrossOrigin("*")
public class BuyerRest {

    @Autowired
    private IBuyerRepo buyerRepo;
    @Autowired
    private ReportService reportService;

    @GetMapping("/buyer_list_rest")
    public List<Buyers> getBuyers(){
        return buyerRepo.findAll();
    }

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws JRException, FileNotFoundException {
        return reportService.exportReport(format);
    }
}
