package com.kuznetsovka.managercounters.registry;

import com.kuznetsovka.managercounters.domain.Counter;
import com.kuznetsovka.managercounters.domain.Entities;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IdentityMap<T extends Entities> {

    private Map<Long, T> entities = new HashMap<> ();

    public T find(Long id){
        return entities.get(id);
    }

    public List<T> getList(){
        return entities.values().parallelStream().collect(Collectors.toList());
    }

    public void add(T entity){
        entities.put(entity.getId(), entity);
    }

    public void addAll(List<T> list){
        for (T entity : list) {
            entities.put(entity.getId(), entity);
        }
    }

    public void remove(T entity){
        entities.remove(entity.getId(), entity);
    }

    public void clear(){
        entities.clear();
    }
}
