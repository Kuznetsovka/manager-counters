package com.kuznetsovka.managercounters.service.tariff;

import com.kuznetsovka.managercounters.domain.Tariff;
import com.kuznetsovka.managercounters.domain.Type;
import com.kuznetsovka.managercounters.dto.ViewTariffs;
import com.kuznetsovka.managercounters.registry.IdentityMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TariffServiceJdbcImpl {
    private JdbcTemplate jdbcTemplate;
    private final IdentityMap identityMap;
    @Autowired
    public TariffServiceJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.identityMap = new IdentityMap<Tariff> ();
    }

    public List<Tariff> findById(Long id) {
        if (identityMap.getList ().isEmpty ()) {
            List<ViewTariffs> view = jdbcTemplate.query (
                    "select t.id, t.price, t.type" +
                            " from tbl_tariffs t " +
                            "join tbl_regions r on r.id = t.region_id" +
                            " where r.id = ?",
                    (r, i) -> ViewTariffs.builder ()
                            .tariff_id (r.getLong (1))
                            .price (r.getBigDecimal (2))
                            .type (Type.getTypeByTxt (r.getString (3)))
                            .build (),
                    id
            );
            identityMap.addAll (view.stream ().map (this::mapTariff).collect (Collectors.toList ()));
        }
        return identityMap.getList ();
    }

    private Tariff mapTariff(ViewTariffs view){
        return Tariff.builder()
                .id(view.getTariff_id ())
                .type (view.getType ())
                .price (view.getPrice ())
                .build();
    }
}
