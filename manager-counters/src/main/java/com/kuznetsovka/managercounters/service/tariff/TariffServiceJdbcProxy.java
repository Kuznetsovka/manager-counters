package com.kuznetsovka.managercounters.service.tariff;

import com.kuznetsovka.managercounters.domain.Tariff;
import com.kuznetsovka.managercounters.domain.Type;
import com.kuznetsovka.managercounters.dto.RegionDto;
import com.kuznetsovka.managercounters.dto.ViewTariffs;
import com.kuznetsovka.managercounters.service.region.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TariffServiceJdbcProxy {

    private final TariffServiceJdbc tariffServiceJdbc;

    private Map<Long,List<Tariff>> regionListCache = null;

    public TariffServiceJdbcProxy(TariffServiceJdbc tariffServiceJdbc) {
        this.tariffServiceJdbc = tariffServiceJdbc;
    }

    public List<Tariff> findById(Long id) {
        if(regionListCache == null) {
            regionListCache.put(id,tariffServiceJdbc.findById (id));
        }
        for (Long key : regionListCache.keySet ()) {
            if (key==id) return regionListCache.get (id);
        }
        return regionListCache.get (id);
    }

}
