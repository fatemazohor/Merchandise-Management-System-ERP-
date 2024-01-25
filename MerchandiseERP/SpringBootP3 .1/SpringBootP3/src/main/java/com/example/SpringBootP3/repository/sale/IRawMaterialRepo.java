package com.example.SpringBootP3.repository.sale;

import com.example.SpringBootP3.model.sale.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRawMaterialRepo extends JpaRepository<RawMaterial,Integer> {
//    @Query("select raw from RawMaterial raw where raw.styleId.id=:styleId order by raw.rawMaterialCatId.id")

//    public List<RawMaterial> findBystyleId(Integer styleId);

//    @Query("SELECT raw.description, raw.name from  Style s join RawMaterial raw on raw.styleId.id= s.id where s.id=:id")
    @Query("SELECT raw from RawMaterial raw inner JOIN raw.styleId s where s.id=:id order by raw.rawMaterialCatId.id")
    public  List<RawMaterial> findRawMaterialByStyleId(int id);
}
