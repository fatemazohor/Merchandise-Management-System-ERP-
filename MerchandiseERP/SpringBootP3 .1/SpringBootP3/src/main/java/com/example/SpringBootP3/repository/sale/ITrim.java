package com.example.SpringBootP3.repository.sale;

import com.example.SpringBootP3.model.sale.Trim;
import org.hibernate.query.criteria.JpaDerivedRoot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrim extends JpaRepository<Trim,Integer> {
}
