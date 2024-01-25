package com.example.SpringBootP3.service.Stock;

import com.example.SpringBootP3.model.inventory.Stock;
import com.example.SpringBootP3.model.sale.RawMaterial;
import com.example.SpringBootP3.repository.inventory.IStock;
import com.example.SpringBootP3.repository.sale.IRawMaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockUpdateService {
    @Autowired
    private IStock iStockRepo;
    @Autowired
    private IRawMaterialRepo rawMaterialRepo;


    public void addStockData(int id, double quantity) throws NullPointerException{
        System.out.println("inside StockUpdate Service");

        Stock targetStock=getStockById(id);
        if(targetStock != null){
            double quantityUp=targetStock.getQuantity();
            targetStock.setQuantity(quantityUp+quantity);
            iStockRepo.save(targetStock);

        }else{
            RawMaterial rawMaterial=rawMaterialRepo.findById(id).get();

            Stock st=new Stock();
            st.setRawMaterialId(rawMaterial);
            st.setQuantity(quantity);
            saveStock(st);
        }

    }
    public void subtractStock(int id, double quantity) throws NullPointerException{

        System.out.println("inside StockUpdate Service for subtract");

        Stock targetStock=getStockById(id);
        if(targetStock != null){
            double quantityDown=targetStock.getQuantity();
            targetStock.setQuantity(quantityDown-quantity);
            iStockRepo.save(targetStock);

        }else{
            RawMaterial rawMaterial=rawMaterialRepo.findById(id).get();

            Stock st=new Stock();
            st.setRawMaterialId(rawMaterial);
            st.setQuantity((-quantity));
            saveStock(st);
        }

    }
     private void saveStock(Stock stock){
         Stock stockNew=iStockRepo.save(stock);
     }
     private Stock getStockById(int id){
         Stock stockUpdate=iStockRepo.findByRawMaterialId(id);
         return stockUpdate;
     }
}
