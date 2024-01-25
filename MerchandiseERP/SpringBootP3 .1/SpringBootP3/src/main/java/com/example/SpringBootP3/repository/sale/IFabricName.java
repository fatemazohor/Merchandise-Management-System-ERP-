package com.example.SpringBootP3.repository.sale;

import com.example.SpringBootP3.model.sale.Fabric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFabricName extends JpaRepository<Fabric,Integer> {
}
