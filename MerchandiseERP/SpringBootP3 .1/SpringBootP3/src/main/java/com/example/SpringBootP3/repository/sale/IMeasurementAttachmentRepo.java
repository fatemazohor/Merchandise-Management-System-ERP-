package com.example.SpringBootP3.repository.sale;

import com.example.SpringBootP3.model.sale.MeasurementAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMeasurementAttachmentRepo extends JpaRepository<MeasurementAttachment,Integer> {
    @Query("select mat from MeasurementAttachment mat where mat.styleId.id=?1")
    public List<MeasurementAttachment>findMatbyStyleId(int id);
}
