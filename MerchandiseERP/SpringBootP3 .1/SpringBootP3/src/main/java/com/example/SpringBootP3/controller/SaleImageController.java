package com.example.SpringBootP3.controller;

import com.example.SpringBootP3.repository.buyer.IOrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SaleImageController {
    @Autowired
    private IOrderDetails orderDetailsRepo;

    @GetMapping("/page2")
    private String page2(Model m){
        int orderCount=orderDetailsRepo.findByOrder();
        m.addAttribute("orderCount",orderCount);
        return "page2";
    }





}
