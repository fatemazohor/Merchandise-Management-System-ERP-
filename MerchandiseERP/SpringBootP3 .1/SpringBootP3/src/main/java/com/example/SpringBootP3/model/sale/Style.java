package com.example.SpringBootP3.model.sale;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Style {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String description;
    private Date CreatedAt;
    private Date UpdatedAt=new Date();

    @ManyToOne
    @JoinColumn(name = "style_cat_id")
    public StyleCategories categoriesId;
    
//    @OneToMany(mappedBy = "style")
//    private List<Measurement> styleMeasurement;

//    @ManyToMany
//    @JoinTable(
//            name = "style_related_size",
//            joinColumns =@JoinColumn(name="style_id"),
//            inverseJoinColumns = @JoinColumn(name="size_id")
//    )
//    private Set<Size> styleSize=new HashSet<>();




}
