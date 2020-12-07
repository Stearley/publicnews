package com.ippsby.publicnews.dto;

import java.io.Serializable;

public class SubscribePe implements Serializable {

    public SubscribePe(long userId, long peId) {
        this.userId = userId;
        this.peId = peId;

    }

    private long userId;

    private long peId;


    public long getUserId() {
        return userId;
    }

    public long getPeId() {
        return peId;
    }


}

