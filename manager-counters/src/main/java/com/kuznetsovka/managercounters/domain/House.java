package com.kuznetsovka.managercounters.domain;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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
    @OneToMany(mappedBy = "house")
    private List<Counter> counters;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", region=" + region.getTitle () +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass () != o.getClass ()) return false;

        House house = (House) o;

        return new EqualsBuilder ()
                .append (id, house.id)
                .append (address, house.address)
                .append (region, house.region)
                .append (counters, house.counters)
                .isEquals ();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder (17, 37)
                .append (id)
                .append (address)
                .append (region)
                .append (counters)
                .toHashCode ();
    }
}
