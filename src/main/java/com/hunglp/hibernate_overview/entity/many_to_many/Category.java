package com.hunglp.hibernate_overview.entity.many_to_many;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="product_category",
            joinColumns = {@JoinColumn(name="category_id")},
            inverseJoinColumns = {@JoinColumn(name="product_id")})

    private List<Product> products  = new ArrayList<>();


    public Category(String name) {
        this.name = name;
    }


}
