package com.example.SpringBootP3.service.dashboard;

import com.example.SpringBootP3.repository.buyer.IOrderDetails;
import com.example.SpringBootP3.repository.inventory.IPurchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderPurchaseRevenueService {
    @Autowired
    private IOrderDetails orderDetailsRepo;
    @Autowired
    private IPurchase iPurchaseRepo;

    public int revenue(){
        double orderTotal=orderDetailsRepo.findByTotal();
        double purchaseTotal=iPurchaseRepo.findByTotalPurchase();
        return (int)(((orderTotal-purchaseTotal)/purchaseTotal)*100);
    }
}
