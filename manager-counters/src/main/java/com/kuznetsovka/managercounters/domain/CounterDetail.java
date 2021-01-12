package com.kuznetsovka.managercounters.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_counter_detail")
public class CounterDetail {
    private static final String SEQ_NAME = "counter_detail_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "counter_id")
    private Counter counter;

    private BigDecimal price;
    private LocalDateTime lastDate;
    private BigDecimal oldValue;

    public CounterDetail(Counter counter) {
        this.price = counter.getTariff ().getPrice ();
        int lastIndex = counter.getValues ().size ()-1;
        this.oldValue = counter.getValues().get (lastIndex).getValue ();
        this.lastDate = counter.getValues().get (lastIndex).getDate ();
    }

    @Override
    public String toString() {
        return "CounterDetail{" +
                "id=" + id +
                ", price=" + price +
                ", lastDate=" + lastDate +
                ", oldValue=" + oldValue +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass () != o.getClass ()) return false;

        CounterDetail that = (CounterDetail) o;

        return new EqualsBuilder ()
                .append (id, that.id)
                .append (price, that.price)
                .append (lastDate, that.lastDate)
                .append (oldValue, that.oldValue)
                .isEquals ();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder (17, 37)
                .append (id)
                .append (price)
                .append (lastDate)
                .append (oldValue)
                .toHashCode ();
    }
}
