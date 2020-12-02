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
@Table(name = "houses")
public class House {
    private static final String SEQ_NAME = "house_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    private String address;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "housesOfCompanies",
            joinColumns = @JoinColumn(name = "house_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id"))
    private List<Company> company;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "region_id")
    private Region region;
    private String email;
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "counter_id")
    private List<Counter> counter;

}
