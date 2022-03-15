package com.hunglp.hibernate_overview.entity.one_to_one_join_column;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class WorkStation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String division;

    private String floor;

    @OneToOne(mappedBy = "workStation")
    private Staff staff;

    public WorkStation(String division, String floor, Staff staff) {
        this.division = division;
        this.floor = floor;
        this.staff = staff;
    }
}
