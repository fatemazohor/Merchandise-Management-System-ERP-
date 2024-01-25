package com.example.SpringBootP3.service.techPack;

import com.example.SpringBootP3.model.sale.MeasurementAttachment;
import com.example.SpringBootP3.model.sale.MeasurementDetails;
import com.example.SpringBootP3.model.sale.RawMaterial;
import com.example.SpringBootP3.model.sale.Style;
import com.example.SpringBootP3.repository.sale.IMeasurementAttachmentRepo;
import com.example.SpringBootP3.repository.sale.IMeasurementDetailsRepo;
import com.example.SpringBootP3.repository.sale.IRawMaterialRepo;
import com.example.SpringBootP3.repository.sale.IStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechPackService {

    @Autowired
    private IStyle styleRepo;

    @Autowired
    private IRawMaterialRepo rawMaterialRepo;

    @Autowired
    private IMeasurementDetailsRepo detailsRepo;
    @Autowired
    private IMeasurementAttachmentRepo attachmentRepo;

//    public List<RawMaterial> getQueryList(int id){
//        List<RawMaterial> materialList=rawMaterialRepo.findBystyleId(id);
//        return materialList;
//    }

    // raw material repo join query
    public List<RawMaterial> getTechPack(int id){
        List<RawMaterial> rawMaterialList=rawMaterialRepo.findRawMaterialByStyleId(id);
        return rawMaterialList;
    }
// style repo join query
    public List<Style> getStyleMaterial(int id){
        List<Style> materialList=styleRepo.findStyleById(id);
        return materialList;
    }

    //Measurement Details table list by style id
    public List<MeasurementDetails> getMeasuermentDetList(int id){
        return detailsRepo.findByStyleId(id);
    }

    public List<MeasurementAttachment> getMSketchList(int id){
        return attachmentRepo.findMatbyStyleId(id);
    }

}
