package com.example.SpringBootP3.model.sale;

import com.example.SpringBootP3.model.UOM;
import com.example.SpringBootP3.model.Vendors;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RawMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private double unitPrice;
    private String attachment;
    @ManyToOne
    @JoinColumn(name = "style_id")
    private Style styleId;
    @ManyToOne
    @JoinColumn(name = "raw_material_cat_id")
    private RawMaterialCat rawMaterialCatId;
    @ManyToOne
    @JoinColumn(name = "uom_id")
    private UOM uomId;
    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendors vendorId;




}
