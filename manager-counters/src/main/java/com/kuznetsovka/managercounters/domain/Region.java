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
@Table(name = "regions")
public class Region {
    private static final String SEQ_NAME = "region_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    private String title;
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "tariff_id")
    private List<Tariff> tariff;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "house_id")
    private House house;
}
