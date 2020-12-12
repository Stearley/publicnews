package com.ippsby.publicnews.dto;

import java.io.Serializable;

public class PeDto  implements Serializable {
    public PeDto (long peId, String description, String fullName, String name){
        this.peId = peId;
        this.description = description;
        this.fullName = fullName;
        this.name = name;
    }
    private long peId;
    private String description;
    private String fullName;
    private String name;


    public long getPeId() {
        return peId;
    }

    public void setPeId(long peId) {
        this.peId = peId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
