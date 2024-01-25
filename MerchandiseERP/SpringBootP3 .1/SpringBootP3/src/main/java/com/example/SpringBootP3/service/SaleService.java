package com.example.SpringBootP3.service;

import com.example.SpringBootP3.model.sale.MeasurementDetails;
import com.example.SpringBootP3.model.sale.RawMaterial;
import com.example.SpringBootP3.model.sale.StyleMaterialQuantity;
import com.example.SpringBootP3.repository.sale.IMeasurementDetailsRepo;
import com.example.SpringBootP3.repository.sale.IRawMaterialRepo;
import com.example.SpringBootP3.repository.sale.IStyleMaterialQuantityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SaleService {
    @Autowired
    private IMeasurementDetailsRepo measurementDetailsRepo;
    @Autowired
    private IStyleMaterialQuantityRepo styleMaterialQuantityRepo;
    @Autowired
    private IRawMaterialRepo rawMaterialRepo;

    public Page<MeasurementDetails> findPaginated(int pageNo,int pageSize){
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return this.measurementDetailsRepo.findAll(pageable);
    }

    public Page<StyleMaterialQuantity> findMatPaginated(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return this.styleMaterialQuantityRepo.findAll(pageable);
    }

    public Page<RawMaterial> findRawPaginated(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return this.rawMaterialRepo.findAll(pageable);
    }

}
