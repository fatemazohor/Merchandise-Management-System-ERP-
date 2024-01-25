package com.example.SpringBootP3.model.buyer;

import com.example.SpringBootP3.model.sale.Style;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date oderDate;

    private Date deliveryDate;
    private String shippingAddress;
    private String orderUniId;
    private double sAmount;
    private double mAmount;
    private double lAmount;
    private double totalAmount;
    private double paid;
    @ManyToOne
    @JoinColumn
    private Style styleId;
    @ManyToOne
    @JoinColumn
    private Buyers buyersId;
    @ManyToOne
    @JoinColumn
    private OrderStatus orStatusId;



}
