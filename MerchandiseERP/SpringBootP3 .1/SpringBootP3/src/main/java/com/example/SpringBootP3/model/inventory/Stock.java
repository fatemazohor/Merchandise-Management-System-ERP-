package com.example.SpringBootP3.model.inventory;

import com.example.SpringBootP3.model.sale.RawMaterial;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Stock {
    @Id
    @GeneratedValue
    private Integer id;
    private double quantity;
    @CreationTimestamp
    private Date createDate;
    @UpdateTimestamp
    private Date updateDate;

    @OneToOne
    @JoinColumn
    private RawMaterial rawMaterialId;
}
