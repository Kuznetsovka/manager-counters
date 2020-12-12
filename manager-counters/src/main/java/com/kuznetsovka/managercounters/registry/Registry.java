package com.kuznetsovka.managercounters.registry;

public class Registry {
    private static final Registry instance = new Registry();

    public static Registry getInstance(){
        return instance;
    }

    protected UnitOfWork unitOfWork = UnitOfWork.getCurrent();

    public UnitOfWork getUnitOfWork(){
        return unitOfWork;
    }

    protected IdentityMap identityMap = IdentityMap.getCurrent();

    public IdentityMap getIdentityMap(){
        return identityMap;
    }

}
