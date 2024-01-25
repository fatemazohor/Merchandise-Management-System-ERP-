package com.example.SpringBootP3.model.sale;

import com.example.SpringBootP3.SpringBootP3Application;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StyleSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "style_id")
    Style styleId;
    @ManyToOne
    @JoinColumn(name = "size_id")
    Size sizeId;
}
