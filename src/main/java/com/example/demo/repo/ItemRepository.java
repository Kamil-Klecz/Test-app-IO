package com.example.demo.repo;

import com.example.demo.model.Rower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Rower, Long> {
    // standardowe CRUD zapewnione przez JpaRepository
}