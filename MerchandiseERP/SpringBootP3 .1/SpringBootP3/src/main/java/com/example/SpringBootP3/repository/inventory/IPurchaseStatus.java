package com.example.SpringBootP3.repository.inventory;

import com.example.SpringBootP3.model.inventory.PurchaseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPurchaseStatus extends JpaRepository<PurchaseStatus,Integer> {
}
