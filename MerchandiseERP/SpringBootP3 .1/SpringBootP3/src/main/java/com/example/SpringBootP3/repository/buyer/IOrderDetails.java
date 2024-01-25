package com.example.SpringBootP3.repository.buyer;

import com.example.SpringBootP3.model.buyer.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDetails extends JpaRepository<OrderDetails,Integer> {
    @Query("select count(od.id) from OrderDetails od")
    public Integer findByOrder();

    @Query("select sum(od.totalAmount) from OrderDetails od")
    public double findByTotal();


}
