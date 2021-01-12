package com.kuznetsovka.managercounters.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Stack;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_counters")
public class Counter implements Entities {
    private static final String SEQ_NAME = "counter_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Type type;
    private String name;
    @ManyToOne
    @JoinColumn(name = "tariff_id")
    private Tariff tariff;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "counter_id")
    private List<Value> values;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "house_id")
    private House house;
    @UpdateTimestamp
    private LocalDateTime dateChecking;
    @OneToOne(mappedBy = "counter")
    private CounterDetail detail;
    boolean isChecking;

    @Override
    public String toString() {
        return "Counter{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", tariff=" + tariff +
                ", values=" + values +
                ", dateChecking=" + dateChecking +
                ", detail=" + detail +
                ", isChecking=" + isChecking +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass () != o.getClass ()) return false;

        Counter counter = (Counter) o;

        return new EqualsBuilder ()
                .append (isChecking, counter.isChecking)
                .append (id, counter.id)
                .append (type, counter.type)
                .append (name, counter.name)
                .append (tariff, counter.tariff)
                .append (values, counter.values)
                .append (dateChecking, counter.dateChecking)
                .append (detail, counter.detail)
                .isEquals ();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder (17, 37)
                .append (id)
                .append (type)
                .append (name)
                .append (tariff)
                .append (values)
                .append (dateChecking)
                .append (detail)
                .append (isChecking)
                .toHashCode ();
    }
}
