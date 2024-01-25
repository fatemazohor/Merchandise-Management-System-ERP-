package com.example.SpringBootP3.controller;

import com.example.SpringBootP3.model.bom.LaborCost;
import com.example.SpringBootP3.model.sale.*;
import com.example.SpringBootP3.repository.bom.ILaborCost;
import com.example.SpringBootP3.repository.sale.IStyle;
import com.example.SpringBootP3.repository.sale.IStyleAttachmentRepo;
import com.example.SpringBootP3.service.techPack.BillOfMaterialService;
import com.example.SpringBootP3.service.techPack.TechPackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Random;

@Controller
public class HomeController {
    @Autowired
    private IStyle iStyleRepo;
    @Autowired
    private TechPackService techPackService;
    @Autowired
    private BillOfMaterialService billOfMaterialService;
    @Autowired
    private IStyleAttachmentRepo styleAttachmentRepo;
    @Autowired
    private ILaborCost laborCostRepo;

    @GetMapping("/home")
    private String home(){
        return "index";
    }
//    @GetMapping("/dashboard")
//    private String dashboard(){
//        return "dashboard";
//    }
    @GetMapping("/page")
    private String page(){
        return "page";
    }
    //shifted to saleImageController
//    @GetMapping("/page2")
//    private String page2(){
//        return "page2";
//    }


//    Tech pack page Data
    @GetMapping("/techpage/{id}")
    private String techpage(@PathVariable int id, Model m){
        Style styleData=iStyleRepo.findById(id).get();
        m.addAttribute("styleData",styleData);

// getQueryList method
//        List<RawMaterial> materialList=techPackService.getQueryList(Integer.valueOf(id));
//        m.addAttribute("materialList",materialList);


//        find by style id method from raw material table
        List<RawMaterial> rawMaterialList=techPackService.getTechPack(id);
        m.addAttribute("rawMaterialList",rawMaterialList);

        //find by style and raw material table join query
//        List<Style> styleMaterialList=techPackService.getStyleMaterial(id);
//        m.addAttribute("styleMaterialList",styleMaterialList);

        //Measurement details list to tech pack
        List<MeasurementDetails> measurementDetailsList=techPackService.getMeasuermentDetList(id);
        m.addAttribute("measurementDetailsList",measurementDetailsList);
        //Measurement Att or sketch to tech pack
        List<MeasurementAttachment> measurementAttachmentList=techPackService.getMSketchList(id);
        m.addAttribute("measurementAttachmentList",measurementAttachmentList);
        return "other/techpage";
    }




    // BOM first page start

    @GetMapping("/style_bom")
    private String getStyleBom(Model m){
        List<Style> styleList=iStyleRepo.findAll();
        m.addAttribute("styleList", styleList);
        m.addAttribute("style", new Style());
        m.addAttribute("title","Bill Of Materila");
        return "sale/styleBOM";
    }

    // BOM first page end
    //BOM 2nd or main page start

    @GetMapping("/bill_of_material/{id}")
    private String getBillPage(@PathVariable int id, Model m){
        Style styleData=iStyleRepo.findById(id).get();
        m.addAttribute("styleData",styleData);

        //style attachment start
        List<StyleAttachment> styleAttachment=billOfMaterialService.getStyleImage(id);
        m.addAttribute("styleAttachment",styleAttachment);


        //style attachment end



        //small size table start
        List<StyleMaterialQuantity> sMatQtyList=billOfMaterialService.getPriceList(3,id);
        m.addAttribute("sMatQtyList",sMatQtyList);
        //small size table end

        //medium size table start
        List<StyleMaterialQuantity> midMatQtyList=billOfMaterialService.getPriceList(2,id);
        m.addAttribute("midMatQtyList",midMatQtyList);
        //medium size table end

        //large size table start
        List<StyleMaterialQuantity> largeMatQtyList=billOfMaterialService.getPriceList(1,id);
        m.addAttribute("largeMatQtyList",largeMatQtyList);
        //large size table end

        //Labor Cost table start
        List<LaborCost> laborCostsList=laborCostRepo.findCostbyStyleId(id);
        m.addAttribute("laborCostsList",laborCostsList);
        //Labor Cost table end



        return "other/billOfMaterial";
    }
    //BOM 2nd or main page end




    //demo data check page --work
//    @GetMapping("/demo_page/{sizeid}/{styleid}")
//    public String demoCheck(@PathVariable int sizeid,@PathVariable int styleid, Model m){
////        List<MeasurementDetails> measurementDetailsList=techPackService.getMeasuermentDetList(id);
////        m.addAttribute("measurementDetailsList",measurementDetailsList);
////        List<StyleMaterialQuantity> materailQtyList=billOfMaterialService.getPriceBySize(id);
////        m.addAttribute("materailQtyList",materailQtyList);
//
//        List<StyleMaterialQuantity> materailQtyList=billOfMaterialService.getPriceList(sizeid,styleid);
//        m.addAttribute("materailQtyList",materailQtyList);
//
//        return "other/demopage";
//
//    }


    @GetMapping("/demo_page/{styleid}")
    public String demoCheck(@PathVariable int styleid, Model m){
//        List<MeasurementDetails> measurementDetailsList=techPackService.getMeasuermentDetList(id);
//        m.addAttribute("measurementDetailsList",measurementDetailsList);
//        List<StyleMaterialQuantity> materailQtyList=billOfMaterialService.getPriceBySize(id);
//        m.addAttribute("materailQtyList",materailQtyList);

        List<StyleMaterialQuantity> materailQtyList=billOfMaterialService.getPriceList(3,styleid);
        m.addAttribute("materailQtyList",materailQtyList);

        return "other/demopage";

    }
}
