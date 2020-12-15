package com.kuznetsovka.managercounters.domain;

import jdk.nashorn.internal.ir.annotations.Ignore;
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
@Table(name = "tbl_houses")
public class House implements Entities {
    private static final String SEQ_NAME = "house_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    private String address;
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "house")
    private List<Counter> counters;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
