package com.example.SpringBootP3.model.sale;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StyleMaterialQuantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double quantity;
    @ManyToOne
    @JoinColumn(name = "style_id")
    Style styleId;
//    add after makeing raw material table
    @ManyToOne
    @JoinColumn(name = "raw_material_id")
    RawMaterial rawMaterialId;
    //size id dropdown
    @ManyToOne
    @JoinColumn(name = "size_id")
    Size sizeId;

}
