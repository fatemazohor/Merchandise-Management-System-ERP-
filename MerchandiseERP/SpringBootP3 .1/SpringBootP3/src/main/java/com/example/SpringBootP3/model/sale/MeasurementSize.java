package com.example.SpringBootP3.model.sale;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MeasurementSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String measurement;
    @ManyToOne
    @JoinColumn(name = "style_id")
    private Style styleId;
    @ManyToOne
    @JoinColumn(name = "measurement_id")
    private Measurement measurementId;
    @ManyToOne
    @JoinColumn(name = "size_id")
    private Size sizeId;
}
