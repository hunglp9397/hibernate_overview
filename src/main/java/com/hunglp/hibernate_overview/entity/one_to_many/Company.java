package com.hunglp.hibernate_overview.entity.one_to_many;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = CascadeType.ALL)
    private List<Employee> employeeList = new ArrayList<>();

    public Company(String name, String address, List<Employee> employeeList) {
        this.name = name;
        this.address = address;
        this.employeeList = employeeList;
    }
}
