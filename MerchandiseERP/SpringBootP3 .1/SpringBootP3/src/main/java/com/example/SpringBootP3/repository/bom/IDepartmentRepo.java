package com.example.SpringBootP3.repository.bom;

import com.example.SpringBootP3.model.bom.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartmentRepo extends JpaRepository<Department,Integer> {
}
