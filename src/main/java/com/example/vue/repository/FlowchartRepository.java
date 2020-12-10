package com.example.vue.repository;

import com.example.vue.demo.entities.Flowchart;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowchartRepository extends JpaRepository<Flowchart,Long>{
    
}
