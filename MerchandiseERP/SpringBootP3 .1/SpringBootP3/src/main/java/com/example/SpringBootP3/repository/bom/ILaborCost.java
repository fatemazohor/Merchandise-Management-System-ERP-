package com.example.SpringBootP3.repository.bom;

import com.example.SpringBootP3.model.bom.LaborCost;
import com.example.SpringBootP3.model.sale.StyleAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILaborCost extends JpaRepository<LaborCost,Integer> {

    @Query("select lcost from LaborCost lcost where lcost.styleId.id=?1")
    public List<LaborCost> findCostbyStyleId(int id);
}
