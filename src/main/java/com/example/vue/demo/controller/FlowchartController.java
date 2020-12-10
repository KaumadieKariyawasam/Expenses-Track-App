package com.example.vue.demo.controller;

import java.util.Collection;

import com.example.vue.demo.entities.Flowchart;
import com.example.vue.demo.repository.FlowchartRepository;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flowchart")
public class FlowchartController {
    private FlowchartRepository flowchartRepository;


    public FlowchartController(FlowchartRepository flowchartRepository) {
        super();
        this.flowchartRepository=flowchartRepository;
    }


    @GetMapping("/getall")
    Collection<Flowchart> getAlls(){
        return flowchartRepository.findAll();
    }

    
}
