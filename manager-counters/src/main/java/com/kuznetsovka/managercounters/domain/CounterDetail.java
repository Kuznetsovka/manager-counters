package com.kuznetsovka.managercounters.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
