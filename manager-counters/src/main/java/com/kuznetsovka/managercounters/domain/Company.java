package com.kuznetsovka.managercounters.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_companies")
public class Company extends Person implements Entities {
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

    @OneToMany(mappedBy = "company")
    private List<House> houses;
}
