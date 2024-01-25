package com.example.SpringBootP3.repository.sale;

import com.example.SpringBootP3.model.sale.StyleSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStyleSizeRepository extends JpaRepository<StyleSize,Integer> {
}
