package com.example.SpringBootP3.model.inventory;

import com.example.SpringBootP3.model.buyer.OrderDetails;
import com.example.SpringBootP3.model.sale.RawMaterial;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdjustmentMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String remarks;
    private double quantity;
    private double price;

    @ManyToOne
    @JoinColumn
    private StockAdjustment stockAdjustmentId;
    @ManyToOne
    @JoinColumn
    private WareHouse wareHouseId;
    @ManyToOne
    @JoinColumn
    private RawMaterial rawMaterialId;
    @ManyToOne
    @JoinColumn
    private OrderDetails orderDetailsId;


}
