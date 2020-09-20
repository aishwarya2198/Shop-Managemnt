package com.shopmanagement.shopmanagement.commons;

public enum Status {

    ACCEPT("accept"),
    UNACCEPTABLE("unacceptable");

    private final String store;

    Status(String store) {
        this.store = store;
    }

    public String getStatus() {
        return store;
    }
}
