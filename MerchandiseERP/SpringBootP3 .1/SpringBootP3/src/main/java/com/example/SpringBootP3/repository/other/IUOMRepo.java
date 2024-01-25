package com.example.SpringBootP3.repository.other;

import com.example.SpringBootP3.model.UOM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUOMRepo extends JpaRepository<UOM,Integer> {
}
