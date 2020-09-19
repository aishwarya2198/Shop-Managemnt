package com.shopmanagement.shopmanagement.model;

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
