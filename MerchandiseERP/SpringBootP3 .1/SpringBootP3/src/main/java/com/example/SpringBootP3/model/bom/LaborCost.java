package com.example.SpringBootP3.model.bom;

import com.example.SpringBootP3.model.sale.Style;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class  LaborCost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double unitCost;
    private double hour;

    @ManyToOne
    @JoinColumn
    private Style styleId;
    @ManyToOne
    @JoinColumn
    private Department departmentId;
}
