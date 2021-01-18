package com.example.vue.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "kpi")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kpi {
    @Id
     
    private Long id;
    private String name;
   
    private String kpistring;
}
