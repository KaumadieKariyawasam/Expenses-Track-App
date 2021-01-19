package com.example.vue.demo.controller;

import java.net.URI;
import java.net.URISyntaxException;

import com.example.vue.demo.entities.Kpi;
import com.example.vue.demo.repository.KpiRepository;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kpi")
@CrossOrigin(origins = "*")
public class KpiController {
    private KpiRepository kpiRepository;

    public KpiController(KpiRepository kpiRepository){
        super();
        this.kpiRepository=kpiRepository;
    }
    @PostMapping("/savekpi")
    ResponseEntity<Kpi> savekpi(@Validated @RequestBody Kpi kpi)throws URISyntaxException{
        Kpi rslt=kpiRepository.save(kpi);
        return ResponseEntity.created(new URI("/kpi/savekpi"+rslt.getName())).body(rslt);
    }

    @GetMapping("/getkpis")
    Collection<Kpi> getAll(){
        return kpiRepository.findAll();
    }
   
  

  
}

