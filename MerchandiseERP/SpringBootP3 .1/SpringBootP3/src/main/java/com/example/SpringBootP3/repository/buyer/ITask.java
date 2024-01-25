package com.example.SpringBootP3.repository.buyer;

import com.example.SpringBootP3.model.buyer.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITask extends JpaRepository<Task,Integer> {
}
