package com.example.SpringBootP3.model.buyer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TimeAction {
    @Id
    @GeneratedValue
    private Integer id;
    private String remarks;
    private Date expectedStartDate;
    private Date actualStartDate;
    private Date expectedEndDate;
    private Date actualEndDate;

    @ManyToOne
    @JoinColumn
    private OrderDetails orderId;
    @ManyToOne
    @JoinColumn
    private Task taskId;
}
