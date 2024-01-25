package com.example.SpringBootP3.repository.inventory;

import com.example.SpringBootP3.model.inventory.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IStock extends JpaRepository<Stock,Integer> {

    @Query("select st from Stock st where st.rawMaterialId.id=?1")
    public Stock findByRawMaterialId(int id);
}
