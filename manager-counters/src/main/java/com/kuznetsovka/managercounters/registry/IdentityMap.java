package com.kuznetsovka.managercounters.registry;

import com.kuznetsovka.managercounters.domain.Counter;
import com.kuznetsovka.managercounters.domain.House;
import com.kuznetsovka.managercounters.domain.Type;

import java.util.HashMap;
import java.util.Map;

public class IdentityMap {
    private static final ThreadLocal<IdentityMap> current = new ThreadLocal<> ();

    public static void init(){
        current.set(new IdentityMap());
    }

    public static IdentityMap getCurrent(){
        return current.get();
    }

    private Map<Long, Counter> entities = new HashMap<> ();

    public Counter find(Integer id){
        return entities.get(id);
    }

    public void add(Counter counter){
        entities.put(counter.getId(), counter);
    }

    public void remove(Counter counter){
        entities.remove(counter.getId(), counter);
    }

    public void clear(){
        entities.clear();
    }
}
