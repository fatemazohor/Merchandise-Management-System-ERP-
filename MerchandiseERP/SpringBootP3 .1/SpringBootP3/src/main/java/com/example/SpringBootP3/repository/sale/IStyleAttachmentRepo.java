package com.example.SpringBootP3.repository.sale;

import com.example.SpringBootP3.model.sale.MeasurementAttachment;
import com.example.SpringBootP3.model.sale.Style;
import com.example.SpringBootP3.model.sale.StyleAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStyleAttachmentRepo extends JpaRepository<StyleAttachment,Integer> {

    @Query("select sat from StyleAttachment sat where sat.styleId.id=?1")
    public List<StyleAttachment> findstyleAttachmentbyStyleId(int id);
}
