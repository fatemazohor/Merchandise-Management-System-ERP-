package com.example.SpringBootP3.service.techPack;

import com.example.SpringBootP3.model.buyer.TimeAction;
import com.example.SpringBootP3.repository.buyer.ITimeActionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeActionService {

    @Autowired
    private ITimeActionRepo timeActionRepo;

    public List<TimeAction> getTNA(int id){
//        List<TimeAction> tnaList = timeActionRepo.findByOrderId(id);
        return timeActionRepo.findByOrderId(id);

    }
}
