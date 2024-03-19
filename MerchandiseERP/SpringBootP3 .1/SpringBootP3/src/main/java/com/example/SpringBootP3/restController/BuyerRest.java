package com.example.SpringBootP3.restController;

import com.example.SpringBootP3.model.buyer.Buyers;
import com.example.SpringBootP3.repository.buyer.IBuyerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class BuyerRest {

    @Autowired
    private IBuyerRepo buyerRepo;

    @GetMapping("/buyer_list_rest")
    public List<Buyers> getBuyers(){
        return buyerRepo.findAll();
    }
}
