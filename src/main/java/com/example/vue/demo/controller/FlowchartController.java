package com.example.vue.demo.controller;

import java.util.Collection;
import java.util.Optional;

import com.example.vue.demo.entities.Flowchart;
import com.example.vue.demo.repository.FlowchartRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/getall/{name}")
    ResponseEntity<?> getChart(@PathVariable String name){
        Optional<Flowchart> flowChart= Optional.ofNullable(flowchartRepository.findByName(name));
        return flowChart.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
       
    }
    
}
