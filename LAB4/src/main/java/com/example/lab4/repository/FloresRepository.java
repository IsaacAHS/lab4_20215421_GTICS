package com.example.lab4.repository;

import com.example.lab4.entity.Flores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloresRepository extends JpaRepository<Flores, Integer>{

}
