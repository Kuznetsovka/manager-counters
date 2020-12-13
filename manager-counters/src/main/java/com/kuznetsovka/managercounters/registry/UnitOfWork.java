package com.kuznetsovka.managercounters.registry;

import com.kuznetsovka.managercounters.domain.Counter;
import com.kuznetsovka.managercounters.domain.House;
import com.kuznetsovka.managercounters.repo.CounterRepository;

import java.util.LinkedList;
import java.util.List;

/**
 * Класс для поддержки транзакций в сущности {@link }
 */
public class UnitOfWork {

    //Используем ThreadLocal , то поможет инициировать новый объект UnitOfWork в рамках текущего потока
    private static ThreadLocal<UnitOfWork> current = new ThreadLocal<> ();
    private IdentityMap identityMap;
    private CounterRepository repository;

    private List<Counter> newCounters = new LinkedList<> ();
    private List<Counter> dirtyCounters  = new LinkedList<> ();
    private List<Counter> removedCounters  = new LinkedList<> ();

    public UnitOfWork(IdentityMap identityMap) {
        this.identityMap = identityMap;
    }

    /**
     * процесс инициализации транзакции
     * создаются новые объекты {@link UnitOfWork} и {@link IdentityMap},
     * т.к. сам {@link UnitOfWork} нуждается в {@link IdentityMap} при регистрации новых и удалении старых сущностей
     */
    public static void init(){
        IdentityMap.init();
        setCurrent(new UnitOfWork(IdentityMap.getCurrent()));
    }

    /**
     * устанавливает текущий {@link UnitOfWork} в локальный(текущий) поток
     * @param unitOfWork
     */
    private static void setCurrent(UnitOfWork unitOfWork){
        current.set(unitOfWork);
    }

    /**
     * возвращает текущий объект {@link UnitOfWork}
     * альтернатива использованию {@link Registry}
     * @return
     */
    public static UnitOfWork getCurrent(){
        return current.get();
    }

    /**
     * При создании новой сущности {@link House} добавим ее в кэш созданных новых
     * @param entity новая созданная сущность
     */
    public void registerNew(Counter entity){
        identityMap.add(entity);
        if(!newCounters.contains(entity)){
            newCounters.add(entity);
        }
    }

    /**
     * По аналогии регистрируем измененные сущности
     * @param counter
     */
    public void registerDirty(Counter counter){
        if(newCounters.contains(counter)){
            throw new IllegalArgumentException ();
        }

        dirtyCounters.add(counter);
    }

    public List<Counter> getNewCounters() {
        return newCounters;
    }

    /**
     * регистрация удаленных из бд сущностей
     * @param counter
     */
    public void registerRemoved(Counter counter){
        newCounters.remove(counter);
        dirtyCounters.remove(counter);
    }

    /**
     * в самом конце обработки запроса фиксируем изменения в бд( проливаем сущности из коллекций в бд единым скриптом)
     */
    public void commit(){
        insertNew();
        update();
        delete();
    }

    private void delete() {

    }

    private void update() {

    }

    /**
     * сохраняем все сущности из newBranches
     */
    private void insertNew() {
        repository.saveAll (newCounters);
    }
}
