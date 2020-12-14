package com.kuznetsovka.managercounters.domain;

public enum Type {
    HOT_WATER("HOT_WATER"),COLD_WATER("COLD_WATER"),ELECTRICITY("ELECTRICITY"),GAS("GAS"),DISCHARGE_WATER("DISCHARGE_WATER");
    private final String txt;

    Type(String txt) {
        this.txt= txt;
    }

    public String getTxt() {
        return txt;
    }

    public static Type getTypeByTxt(String txt) {
        for (Type env : values()) {
            if (env.getTxt().equals(txt)) {
                return env;
            }
        }
        throw new IllegalArgumentException("No enum found with url: [" + txt + "]");
    }
}
