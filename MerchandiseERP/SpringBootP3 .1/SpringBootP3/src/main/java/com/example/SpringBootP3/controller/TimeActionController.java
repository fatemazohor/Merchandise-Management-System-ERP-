package com.example.SpringBootP3.controller;

import com.example.SpringBootP3.model.buyer.OrderDetails;
import com.example.SpringBootP3.model.buyer.TimeAction;
import com.example.SpringBootP3.repository.buyer.IOrderDetails;
import com.example.SpringBootP3.service.techPack.TimeActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TimeActionController {

    @Autowired
    private IOrderDetails orderDetailsrepo;

    @Autowired
    private TimeActionService timeActionService;

    @GetMapping("/time_action/{id}")
    public String getTimeAction(@PathVariable int id, Model m){
        // buyer and style details in tna
        OrderDetails orDe=orderDetailsrepo.findById(id).get();
        m.addAttribute("orderdetails",orDe);
        m.addAttribute("title","Time & Action Plan");

        //time and action plan table
        List<TimeAction> tnaList=timeActionService.getTNA(id);
        m.addAttribute("tnaList",tnaList);



        return "other/timeAction";
    }
}
