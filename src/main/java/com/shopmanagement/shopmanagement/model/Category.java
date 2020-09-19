package com.shopmanagement.shopmanagement.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Category {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "cid", updatable = false, nullable = false)
    private UUID cid;

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Type type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    public UUID getCid() {
        return cid;
    }

    public void setCid(UUID cid) {
        this.cid = cid;
    }

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

    @Override
    public String toString() {
        return "Category [cid=" + cid + ", name=" + name + ", type=" + type + ", status=" + status + "]";
    }

    /**
     * this is a string {test},{test1}
     * {} /error
     * }
     * {{deepak}} - deepak
     * {{singh} -singh
     * }}}}}}{{{{{ - no error
     * {test{}}}}} - test
     *
     * O(n)
     */

}
