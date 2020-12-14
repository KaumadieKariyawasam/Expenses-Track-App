package com.example.vue.demo.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import com.example.vue.demo.entities.Flowchart;
import com.example.vue.demo.repository.FlowchartRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/savechart")
    ResponseEntity<Flowchart> savechart(@Validated @RequestBody Flowchart flowchart)throws URISyntaxException{

        Flowchart result=flowchartRepository.save(flowchart);
        return ResponseEntity.created(new URI("/flowchart/savechart"+result.getId())).body(rslt);
    }
   

    
}
