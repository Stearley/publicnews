package com.ippsby.publicnews.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.ippsby.publicnews.model.Security;

public class SubscribePe {

    public SubscribePe(long userId, long peId) {
        this.userId = userId;
        this.peId = peId;
    }
    @JsonView(Security.Local.class)
    private long userId;

    @JsonView(Security.Local.class)
    private long peId;

    public long getUserId() {
        return getUserId();
    }

    public long getPeId() {
        return peId;
    }
}

