package com.ippsby.publicnews.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class NewsStatus implements Serializable {
    public NewsStatus(long newsId, long newsStatus){
        this.newsId = newsId;
        this.newsStatus = newsStatus;
    }
    private long newsId;
    private long newsStatus;
}
