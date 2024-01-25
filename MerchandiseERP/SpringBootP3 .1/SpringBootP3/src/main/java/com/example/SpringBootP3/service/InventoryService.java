package com.example.SpringBootP3.service;

import com.example.SpringBootP3.model.buyer.TimeAction;
import com.example.SpringBootP3.model.sale.MeasurementDetails;
import com.example.SpringBootP3.model.sale.RawMaterial;
import com.example.SpringBootP3.repository.buyer.ITimeActionRepo;
import com.example.SpringBootP3.repository.sale.IRawMaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    @Autowired
    private IRawMaterialRepo rawMaterialRepo;
    @Autowired
    private ITimeActionRepo timeActionRepo;


    public Page<TimeAction> findTimePaginated(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return this.timeActionRepo.findAll(pageable);
    }

    public RawMaterial getMaterial(int id){
        RawMaterial material=rawMaterialRepo.findById(id).get();
        return material;
    }
}
