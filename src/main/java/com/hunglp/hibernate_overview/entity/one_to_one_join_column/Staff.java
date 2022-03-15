package com.hunglp.hibernate_overview.entity.one_to_one_join_column;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "staff_workstation",
            joinColumns =
                    { @JoinColumn(name = "staff_id", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "workstation_id", referencedColumnName = "id") })
    private WorkStation workStation;

    public Staff(String name) {
        this.name = name;
    }
}
