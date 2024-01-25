package com.example.SpringBootP3.repository.sale;

import com.example.SpringBootP3.model.sale.MeasurementDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMeasurementDetailsRepo extends JpaRepository<MeasurementDetails,Integer> {

    @Query("select det from MeasurementDetails det where det.styleId.id=?1")
    public List<MeasurementDetails> findByStyleId(int id);
}
