package com.example.SpringBootP3.repository.other;

import com.example.SpringBootP3.model.Vendors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVendorRepo  extends JpaRepository<Vendors,Integer>{
}
