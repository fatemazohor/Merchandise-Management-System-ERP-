package com.example.SpringBootP3.controller;

import com.example.SpringBootP3.model.UOM;
import com.example.SpringBootP3.model.Vendors;
import com.example.SpringBootP3.model.sale.Size;
import com.example.SpringBootP3.repository.other.IUOMRepo;
import com.example.SpringBootP3.repository.other.IVendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OTherController {

    @Autowired
    private IUOMRepo iuomRepo;

    @Autowired
    private IVendorRepo vendorRepo;


    //    UOM start
    @GetMapping("/uom/list")
    public String uomList(Model m){
        List<UOM> uomList=iuomRepo.findAll();
        m.addAttribute("title","Unit of Measurement List");
        m.addAttribute("uomList", uomList);
        return "other/uomList";
    }
    @GetMapping("/uom/addform")
    public String uomform(Model m){


        m.addAttribute("uom",new UOM());
        m.addAttribute("title","Create new Unit of Measurement");
        return "other/uomForm";
    }
    @PostMapping("/uom/save")
    public String uomSave(@ModelAttribute UOM uom){
        iuomRepo.save(uom);
        return "redirect:/uom/list";
    }
    @GetMapping("/uom/delete/{id}")
    public String uomDelete(@PathVariable int id){
        iuomRepo.deleteById(id);
        return "redirect:/uom/list";
    }

    @GetMapping("/uom_edit/{id}")
    public String uomEdit(@PathVariable int id,Model m){
        UOM uomName=iuomRepo.findById(id).get();
        m.addAttribute("title","Update Unit of Measurement");
        m.addAttribute("uom",uomName);
        return "other/uomForm";

    }

//   UOM end

//   Vendor start

    @GetMapping("/vendor/list")
    public String vendorList(Model m){
        List<Vendors> vendorList=vendorRepo.findAll();
        m.addAttribute("title","Vendor List");
        m.addAttribute("vendorList", vendorList);
        return "other/vendorList";
    }
    @GetMapping("/vendor/addform")
    public String vendorform(Model m){


        m.addAttribute("vendor",new Vendors());
        m.addAttribute("title","Create new Vendor");
        return "other/vendorForm";
    }
    @PostMapping("/vendor/save")
    public String vendorSave(@ModelAttribute Vendors vendors){
        vendorRepo.save(vendors);
        return "redirect:/vendor/list";
    }
    @GetMapping("/vendor/delete/{id}")
    public String vendorDelete(@PathVariable int id){
        vendorRepo.deleteById(id);
        return "redirect:/vendor/list";
    }

    @GetMapping("/vendor_edit/{id}")
    public String vendorEdit(@PathVariable int id,Model m){
        Vendors vendorName=vendorRepo.findById(id).get();
        m.addAttribute("title","Update Vendor");
        m.addAttribute("vendor",vendorName);
        return "other/vendorForm";

    }

//   Vendor end



}
