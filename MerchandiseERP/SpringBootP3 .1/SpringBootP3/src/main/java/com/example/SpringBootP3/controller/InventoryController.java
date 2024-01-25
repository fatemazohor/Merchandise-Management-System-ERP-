package com.example.SpringBootP3.controller;

import com.example.SpringBootP3.model.Vendors;
import com.example.SpringBootP3.model.buyer.Buyers;
import com.example.SpringBootP3.model.buyer.OrderDetails;
import com.example.SpringBootP3.model.inventory.*;
import com.example.SpringBootP3.model.sale.RawMaterial;
import com.example.SpringBootP3.repository.buyer.IOrderDetails;
import com.example.SpringBootP3.repository.inventory.*;
import com.example.SpringBootP3.repository.other.IVendorRepo;
import com.example.SpringBootP3.repository.sale.IRawMaterialRepo;
import com.example.SpringBootP3.service.Stock.StockUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class InventoryController {
    @Autowired
    private IWareHouse wareHouseRepo;
    @Autowired
    private IPurchaseStatus purchaseStatusRepo;
    @Autowired
    private IPurchase iPurchaseRepo;
    @Autowired
    private IVendorRepo vendorRepo;
    @Autowired
    private IRawMaterialRepo iRawMaterialRepo;
    @Autowired
    private StockUpdateService stockUpdateService;
    @Autowired
    private IStockAdjustment stockAdjustmentRepo;
    @Autowired
    private IAdjustmentMaterial adjustmentMaterialRepo;
    @Autowired
    private IOrderDetails orderDetailsRepo;
    @Autowired
    private IStock iStockRepo;


    //WareHouse start
    @GetMapping("/warehouse/list")
    public String warehouseList(Model m){
        List<WareHouse> warehouseList=wareHouseRepo.findAll();
        m.addAttribute("title","Warehouse List");
        m.addAttribute("warehouseList", warehouseList);
        return "inventory/warehouseList";
    }
    @GetMapping("/warehouse/addform")
    public String warehouseform(Model m){


        m.addAttribute("warehouse",new WareHouse());
        m.addAttribute("title","Create new Warehouse");
        return "inventory/warehouseForm";
    }

    @PostMapping("/warehouse/save")
    public String warehouseSave(@ModelAttribute WareHouse wareHouse){
        wareHouseRepo.save(wareHouse);
        return "redirect:/warehouse/list";
    }
    @GetMapping("/warehouse/delete/{id}")
    public String warehouseDelete(@PathVariable int id){
        wareHouseRepo.deleteById(id);
        return "redirect:/warehouse/list";
    }

    @GetMapping("/warehouse_edit/{id}")
    public String warehouseEdit(@PathVariable int id,Model m){
        WareHouse warehousename=wareHouseRepo.findById(id).get();
        m.addAttribute("title","Update Warehouse");
        m.addAttribute("warehouse",warehousename);
        return "inventory/warehouseForm";

    }
    //WareHouse end

    //Purchase Status

    @GetMapping("/purchase_status/list")
    public String purchaseStatusList(Model m){
        List<PurchaseStatus> purchaseStatusList=purchaseStatusRepo.findAll();
        m.addAttribute("title","Purchase Status List");
        m.addAttribute("purchaseStatusList", purchaseStatusList);
        return "inventory/purchaseStatusList";
    }
    @GetMapping("/purchase_status/addform")
    public String purchaseStatusform(Model m){

        m.addAttribute("purchaseStatus",new PurchaseStatus());
        m.addAttribute("title","Create new Purchase Status");
        return "inventory/purchaseStatusForm";
    }

    @PostMapping("/purchase_status/save")
    public String purchaseStatusSave(@ModelAttribute PurchaseStatus purchaseStatus){
        purchaseStatusRepo.save(purchaseStatus);
        return "redirect:/purchase_status/list";
    }
    @GetMapping("/purchase_status/delete/{id}")
    public String purchaseStatusDelete(@PathVariable int id){
        purchaseStatusRepo.deleteById(id);
        return "redirect:/purchase_status/list";
    }

    @GetMapping("/purchase_status_edit/{id}")
    public String purchaseStatusEdit(@PathVariable int id,Model m){
        PurchaseStatus purchaseStatusname=purchaseStatusRepo.findById(id).get();
        m.addAttribute("title","Update Purchase Status");
        m.addAttribute("purchaseStatus",purchaseStatusname);
        return "inventory/purchaseStatusForm";

    }



    //Purchase Status end

    //Purchase Table
    @GetMapping("/purchase/list")
    public String purchaseList(Model m){



        List<Purchase> purchaseList=iPurchaseRepo.findAll();
        m.addAttribute("title","Purchase List");
        m.addAttribute("purchaseList", purchaseList);
        return "inventory/purchaseList";
    }
    @GetMapping("/purchase/addform")
    public String purchaseform(Model m){
        //vendor dropdown
        List<Vendors> vendorList=vendorRepo.findAll();
        m.addAttribute("vendorList", vendorList);
        //purchase Status dropdown
        List<PurchaseStatus> purchaseStatusList=purchaseStatusRepo.findAll();
        m.addAttribute("purchaseStatusList", purchaseStatusList);
        //warehouse dropdown
        List<WareHouse> warehouseList=wareHouseRepo.findAll();
        m.addAttribute("warehouseList", warehouseList);
        //raw Material dropdown
        List<RawMaterial> rawMaterialList=iRawMaterialRepo.findAll();
        m.addAttribute("rawMaterialList", rawMaterialList);



        m.addAttribute("purchase",new Purchase());
        m.addAttribute("title","Create new Purchase");
        return "inventory/purchaseForm";
    }

    @PostMapping("/purchase/save")
    public String purchaseSave(@ModelAttribute Purchase purchase){
        double myquantity = purchase.getQuantity();
        int myid=purchase.getRawMaterialId().getId();
        stockUpdateService.addStockData(myid,myquantity);
        iPurchaseRepo.save(purchase);
        return "redirect:/purchase/list";
    }
    @GetMapping("/purchase/delete/{id}")
    public String purchaseDelete(@PathVariable int id){
        iPurchaseRepo.deleteById(id);
        return "redirect:/purchase/list";
    }

    @GetMapping("/purchase_edit/{id}")
    public String purchaseEdit(@PathVariable int id,Model m){
        //vendor dropdown
        List<Vendors> vendorList=vendorRepo.findAll();
        m.addAttribute("vendorList", vendorList);
        //purchase Status dropdown
        List<PurchaseStatus> purchaseStatusList=purchaseStatusRepo.findAll();
        m.addAttribute("purchaseStatusList", purchaseStatusList);
        //warehouse dropdown
        List<WareHouse> warehouseList=wareHouseRepo.findAll();
        m.addAttribute("warehouseList", warehouseList);
        //raw Material dropdown
        List<RawMaterial> rawMaterialList=iRawMaterialRepo.findAll();
        m.addAttribute("rawMaterialList", rawMaterialList);

        Purchase purchaseName=iPurchaseRepo.findById(id).get();
        m.addAttribute("title","Update Purchase");
        m.addAttribute("purchase",purchaseName);
        return "inventory/purchaseForm";

    }
    //Purchase Table end

    //Stock Adjustment

    @GetMapping("/stock_adjustment_status/list")
    public String stockAdjustmentStatusList(Model m){
        List<StockAdjustment> stockAdjustmentStatusList=stockAdjustmentRepo.findAll();
        m.addAttribute("title","Stock Adjustment Status List");
        m.addAttribute("stockAdjustmentStatusList", stockAdjustmentStatusList);
        return "inventory/stockAdjustmentList";
    }
    @GetMapping("/stock_adjustment_status/addform")
    public String stockAdjustmentStatusform(Model m){

        m.addAttribute("stockAdjustment",new StockAdjustment());
        m.addAttribute("title","Create new Stock Adjustment Status");
        return "inventory/stockAdjustmentForm";
    }

    @PostMapping("/stock_adjustment_status/save")
    public String stockAdjustmentStatusSave(@ModelAttribute StockAdjustment stockAdjustment){


        stockAdjustmentRepo.save(stockAdjustment);
        return "redirect:/stock_adjustment_status/list";
    }
    @GetMapping("/stock_adjustment_status/delete/{id}")
    public String stockAdjustmentStatusDelete(@PathVariable int id){
        stockAdjustmentRepo.deleteById(id);
        return "redirect:/stock_adjustment_status/list";
    }

    @GetMapping("/stock_adjustment_status_edit/{id}")
    public String stockAdjustmentStatusEdit(@PathVariable int id,Model m){
        StockAdjustment stockAdjustmentStatusname=stockAdjustmentRepo.findById(id).get();
        m.addAttribute("title","Update Stock Adjustment Status");
        m.addAttribute("stockAdjustment",stockAdjustmentStatusname);
        return "inventory/stockAdjustmentForm";

    }


    //Stock Adjustment end
    //Adjustment Material (Raw Materials used for order and Materials damaged will be recoded here and
    // stock of Material (Stock Table)  will be subtract here)
    // Adjustment Material and Stock both table will be updated here;
    @GetMapping("/adjustment_material/list")
    public String adjustmentMatList(Model m){
        List<AdjustmentMaterial> adjustmentMatList=adjustmentMaterialRepo.findAll();
        m.addAttribute("title","Adjustment Material List");
        m.addAttribute("adjustmentMatList", adjustmentMatList);
        return "inventory/adjustmentMatList";
    }
    @GetMapping("/adjustment_material/addform")
    public String adjustmentMatform(Model m){

        //warehouse dropdown
        List<WareHouse> warehouseList=wareHouseRepo.findAll();
        m.addAttribute("warehouseList", warehouseList);
        //raw Material dropdown
        List<RawMaterial> rawMaterialList=iRawMaterialRepo.findAll();
        m.addAttribute("rawMaterialList", rawMaterialList);
        //Stock adjustment dropdown
        List<StockAdjustment> stockAdjustmentsList=stockAdjustmentRepo.findAll();
        m.addAttribute("stockAdjustmentsList", stockAdjustmentsList);
        //Order Details Dropdown
        List<OrderDetails> orderDetailsList=orderDetailsRepo.findAll();
        m.addAttribute("orderDetailsList",orderDetailsList);


        m.addAttribute("adjustmentMat",new AdjustmentMaterial());
        m.addAttribute("title","Create new Adjustment Material");
        return "inventory/adjustmentMatForm";
    }

    @PostMapping("/adjustment_material/save")
    public String adjustmentMatSave(@ModelAttribute AdjustmentMaterial adjustmentMaterial){
        //stock subtract
        double myquantity = adjustmentMaterial.getQuantity();
        int myid=adjustmentMaterial.getRawMaterialId().getId();
        stockUpdateService.subtractStock(myid,myquantity);
        //stock subtract end

        adjustmentMaterialRepo.save(adjustmentMaterial);
        return "redirect:/adjustment_material/list";
    }
    @GetMapping("/adjustment_material/delete/{id}")
    public String adjustmentMatDelete(@PathVariable int id){
        adjustmentMaterialRepo.deleteById(id);
        return "redirect:/adjustment_material/list";
    }

    @GetMapping("/adjustment_material_edit/{id}")
    public String adjustmentMatEdit(@PathVariable int id,Model m){
        //warehouse dropdown
        List<WareHouse> warehouseList=wareHouseRepo.findAll();
        m.addAttribute("warehouseList", warehouseList);
        //raw Material dropdown
        List<RawMaterial> rawMaterialList=iRawMaterialRepo.findAll();
        m.addAttribute("rawMaterialList", rawMaterialList);
        //Stock adjustment dropdown
        List<StockAdjustment> stockAdjustmentsList=stockAdjustmentRepo.findAll();
        m.addAttribute("stockAdjustmentsList", stockAdjustmentsList);
        //Order Details Dropdown
        List<OrderDetails> orderDetailsList=orderDetailsRepo.findAll();
        m.addAttribute("orderDetailsList",orderDetailsList);


        AdjustmentMaterial adjustmentMatname=adjustmentMaterialRepo.findById(id).get();
        m.addAttribute("title","Update Adjustment Material");
        m.addAttribute("adjustmentMat",adjustmentMatname);
        return "inventory/adjustmentMatForm";

    }

    //Adjustment Material end
    //Stock table
    //stock tables' data are inserted using purchase table and adjustment table
    //so individual update is not allowed
    @GetMapping("/stock/list")
    public String stockList(Model m){
        List<Stock> stockList=iStockRepo.findAll();
        m.addAttribute("title","Stock List");
        m.addAttribute("stockList", stockList);
        return "inventory/stockList";
    }
    //Stock table end
}
