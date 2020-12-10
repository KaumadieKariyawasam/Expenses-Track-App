package com.example.vue.demo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.h2.table.Column;
import org.hibernate.annotations.Columns;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="flowchart")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlowChart {
    @Id
    private Long id;
    private String name;
    private Date currentdate;
    private String json;
}
