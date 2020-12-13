package com.kuznetsovka.managercounters.service.tariff;

import com.kuznetsovka.managercounters.domain.Tariff;
import com.kuznetsovka.managercounters.domain.Type;
import com.kuznetsovka.managercounters.dto.ViewTariffs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TariffServiceJdbc {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public TariffServiceJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Tariff> findById(Long id) {
        List<ViewTariffs> view = jdbcTemplate.query(
                "select t.price, t.type" +
                        " from tariff t " +
                        "join region r on r.id = t.region_id" +
                        "where r.id = ?",
                (r, i) -> ViewTariffs.builder()
                        .tariff_id (r.getLong (1))
                        .type (Type.getTypeByTxt(r.getString (2)))
                        .price (r.getBigDecimal (3))
                        .build(),
                id
        );

        return view.stream().map(this::mapTariff).collect(Collectors.toList());
    }

    private Tariff mapTariff(ViewTariffs view){
        return Tariff.builder()
                .id(view.getTariff_id ())
                .type (view.getType ())
                .build();
    }
}
