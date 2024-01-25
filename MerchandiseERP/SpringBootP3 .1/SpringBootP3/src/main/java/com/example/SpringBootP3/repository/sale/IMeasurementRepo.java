package com.example.SpringBootP3.repository.sale;

import com.example.SpringBootP3.model.sale.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMeasurementRepo extends JpaRepository<Measurement,Integer>{
}
