package com.example.SpringBootP3.model.inventory;

import com.example.SpringBootP3.model.Vendors;
import com.example.SpringBootP3.model.sale.RawMaterial;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date purchaseDate;
    private Date deliveryDate;
    private double price;
    private double quantity;
    private double paid;
    private double total;

    @ManyToOne
    @JoinColumn
    private Vendors vendorsId;
    @ManyToOne
    @JoinColumn
    private PurchaseStatus statusId;
    @ManyToOne
    @JoinColumn
    private WareHouse wareHouseId;
    @ManyToOne
    @JoinColumn
    private RawMaterial rawMaterialId;

}
