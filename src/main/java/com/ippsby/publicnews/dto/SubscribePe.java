package com.ippsby.publicnews.dto;

import java.io.Serializable;

public class SubscribePe implements Serializable {

    public SubscribePe(long Id, long peId) {
        this.Id = Id;
        this.peId = peId;

    }

    private long Id;

    private long peId;


    public long getId() {
        return Id;
    }

    public long getPeId() {
        return peId;
    }


}

