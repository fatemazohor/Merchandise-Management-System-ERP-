package com.example.SpringBootP3.controller;

import com.example.SpringBootP3.model.buyer.OrderDetails;
import com.example.SpringBootP3.model.inventory.Purchase;
import com.example.SpringBootP3.model.inventory.Stock;
import com.example.SpringBootP3.repository.buyer.IOrderDetails;
import com.example.SpringBootP3.repository.inventory.IPurchase;
import com.example.SpringBootP3.repository.inventory.IStock;
import com.example.SpringBootP3.service.dashboard.OrderPurchaseRevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashBoardController {
    @Autowired
    private IOrderDetails orderDetailsRepo;
    @Autowired
    private IPurchase iPurchaseRepo;
    @Autowired
    private IStock iStockRepo;
    @Autowired
    private OrderPurchaseRevenueService revenueService;

    //Dashboard All table
    @GetMapping("/dashboard")
    public String orderdetailsList(Model m){

        //Order Table
        List<OrderDetails> orderDetailsList=orderDetailsRepo.findAll();
        m.addAttribute("orderDetailsList", orderDetailsList);
        //Order Table end
        //Purchase Table
        List<Purchase> purchaseList=iPurchaseRepo.findAll();
        m.addAttribute("purchaseList", purchaseList);
        //Purchase Table end
        //Stock Table
        List<Stock> stocksList=iStockRepo.findAll();
        m.addAttribute("stocksList", stocksList);
        // Stock Table end

        //Transaction Order count
        int orderCount=orderDetailsRepo.findByOrder();
        m.addAttribute("orderCount",orderCount);
        //Transaction Order count end
        //Transaction Order total amount
        double totalOrderSale=orderDetailsRepo.findByTotal();
        m.addAttribute("totalOrderSale",totalOrderSale);
        //Transaction Order total amount end
        //Transaction Purchase total amount
        double totalPurchase=iPurchaseRepo.findByTotalPurchase();
        m.addAttribute("totalPurchase",totalPurchase);
        //Transaction Purchase total amount end
        //Transaction Revenue percentage
        int revenuePercentage=revenueService.revenue();
        m.addAttribute("revenuePercentage",revenuePercentage);
        //Transaction Revenue percentage end
        return "dashboard";

    }
    //Dashboard table end
}
