package com.example.SpringBootP3.repository.buyer;

import com.example.SpringBootP3.model.buyer.TimeAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.List;

@Repository
public interface ITimeActionRepo extends JpaRepository<TimeAction,Integer> {

    @Query("select tna from TimeAction tna where tna.orderId.id=?1")
    public List<TimeAction> findByOrderId(int id);
}
