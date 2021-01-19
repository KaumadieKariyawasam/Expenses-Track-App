package com.example.vue.demo.repository;

import com.example.vue.demo.entities.Kpi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KpiRepository extends JpaRepository<Kpi,String>{
    
}
