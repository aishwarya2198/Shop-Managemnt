package com.shopmanagement.shopmanagement.commons;

public enum Type {

    ESSENTIAL("essential"),
    NONESSENTIAL("nonessential");

    private final String store;

    Type(String store) {
        this.store = store;
    }

    public String getStatus() {
        return store;
    }
}
