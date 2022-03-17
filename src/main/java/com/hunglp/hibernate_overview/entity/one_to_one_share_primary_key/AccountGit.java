package com.hunglp.hibernate_overview.entity.one_to_one_share_primary_key;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountGit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String accountNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Developer developer;

    public AccountGit(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
