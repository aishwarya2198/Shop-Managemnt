package com.shopmanagement.shopmanagement.dto;

import com.shopmanagement.shopmanagement.commons.Status;
import com.shopmanagement.shopmanagement.commons.Type;

public class CategoryDto {

    private String name;
    private Type type;
    private Status status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}
