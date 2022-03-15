package com.hunglp.hibernate_overview.entity.one_to_many;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "company_id",nullable = false)
    private Company company;

    public Employee(String name, Company company) {
        this.name = name;
        this.company = company;
    }
}
