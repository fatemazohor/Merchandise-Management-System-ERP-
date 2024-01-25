package com.example.SpringBootP3.repository.sale;

import com.example.SpringBootP3.model.sale.StyleMaterialQuantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStyleMaterialQuantityRepo extends JpaRepository<StyleMaterialQuantity,Integer> {
    //get qty * unit price
//    @Query("select rm.name,rm.vendorId,rm.uomId,rm.unitPrice,sm.quantity from StyleMaterialQuantity sm inner join sm.rawMaterialId rm where sm.styleId.id=?1")
    @Query("select rm.name,rm.vendorId,rm.uomId,rm.unitPrice,sm.quantity from StyleMaterialQuantity sm inner join sm.rawMaterialId rm inner join rm.styleId s where s.id=:id")
    public List<StyleMaterialQuantity> findByqty(int id);

    @Query("SELECT sm FROM StyleMaterialQuantity sm JOIN sm.rawMaterialId rm WHERE sm.sizeId.id = :sizeId AND sm.styleId.id = :styleId")
    List<StyleMaterialQuantity> findBySizeIdAndStyleId(@Param("sizeId") int sizeId, @Param("styleId") int styleId);
}
