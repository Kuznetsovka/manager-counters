package com.kuznetsovka.managercounters.domain;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_values")
public class Value implements Entities {
    private static final String SEQ_NAME = "value_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    private BigDecimal value;
    @UpdateTimestamp
    private LocalDateTime date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "counter_id")
    private Counter counter;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass () != o.getClass ()) return false;

        Value value1 = (Value) o;

        return new EqualsBuilder ()
                .append (id, value1.id)
                .append (value, value1.value)
                .append (date, value1.date)
                .isEquals ();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder (17, 37)
                .append (id)
                .append (value)
                .append (date)
                .toHashCode ();
    }

    @Override
    public String toString() {
        return "Value{" +
                "id=" + id +
                ", value=" + value +
                ", date=" + date +
                '}';
    }
}
