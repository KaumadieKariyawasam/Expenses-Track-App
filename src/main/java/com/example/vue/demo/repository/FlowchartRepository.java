package com.example.vue.demo.repository;

import java.util.Collection;

import com.example.vue.demo.entities.Flowchart;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowchartRepository extends JpaRepository<Flowchart,Long>{
    Flowchart findByName(String name);
    

    
}
