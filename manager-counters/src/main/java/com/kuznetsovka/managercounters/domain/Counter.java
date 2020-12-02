package com.kuznetsovka.managercounters.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "counters")
public class Counter {
    private static final String SEQ_NAME = "counter_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Type type;
    private String name;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "tariff_id")
    private Tariff tariff;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "house_id")
    private House house;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "value_id")
    private List<Value> value;
    @UpdateTimestamp
    private LocalDateTime dateChecking;
    boolean isChecking;
}
