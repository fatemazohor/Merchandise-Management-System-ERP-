package com.example.SpringBootP3.service.techPack;

import com.example.SpringBootP3.model.sale.StyleAttachment;
import com.example.SpringBootP3.model.sale.StyleMaterialQuantity;
import com.example.SpringBootP3.repository.sale.IStyleAttachmentRepo;
import com.example.SpringBootP3.repository.sale.IStyleMaterialQuantityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillOfMaterialService{

    @Autowired
    private IStyleMaterialQuantityRepo iStyleMaterialQuantityRepo;

    @Autowired
    private IStyleAttachmentRepo iStyleAttachmentRepo;

    public  List<StyleMaterialQuantity> getPriceBySize(int id){
        return iStyleMaterialQuantityRepo.findByqty(id);
    }


    public  List<StyleMaterialQuantity> getPriceList(int sizeId, int styleId){
        return iStyleMaterialQuantityRepo.findBySizeIdAndStyleId(sizeId,styleId);
    }

    //get style attachment picture

    public  List<StyleAttachment> getStyleImage(int styleId){
        return iStyleAttachmentRepo.findstyleAttachmentbyStyleId(styleId);
    }

}
