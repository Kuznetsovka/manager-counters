package com.kuznetsovka.managercounters.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "companies")
public class Company extends Person {
    private static final String SEQ_NAME = "company_seq";
    @Enumerated(EnumType.STRING)
    private final Role role = Role.COMPANY;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    private String name;
    private String password;
    private String email;
    private Long INN;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "housesOfCompanies",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "house_id"))
    private List<House> house;
}
