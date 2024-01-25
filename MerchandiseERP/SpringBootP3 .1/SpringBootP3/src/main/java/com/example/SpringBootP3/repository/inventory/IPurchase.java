package com.example.SpringBootP3.repository.inventory;

import com.example.SpringBootP3.model.inventory.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPurchase extends JpaRepository<Purchase,Integer> {

    @Query("select sum(pr.paid) from Purchase pr")
    public double findByTotalPurchase();
}
