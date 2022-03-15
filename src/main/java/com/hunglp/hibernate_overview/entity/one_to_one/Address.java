package com.hunglp.hibernate_overview.entity.one_to_one;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String city;

    private String district;

    @OneToOne(mappedBy = "address")
    private User user;

    public Address(String city, String district) {
        this.city = city;
        this.district = district;
    }
}
