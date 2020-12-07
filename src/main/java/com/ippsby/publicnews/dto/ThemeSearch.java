package com.ippsby.publicnews.dto;

import java.io.Serializable;

public class ThemeSearch implements Serializable {
    public ThemeSearch (long themeId, long peId, long newsId){
        this.themeId = themeId;
        this.peId = peId;
        this.newsId = newsId;
    }

    private long peId;
    private long newsId;
    private long themeId;

    public long getPeId() {
        return peId;
    }

    public long getNewsId() {
        return newsId;
    }

    public long getThemeId() {
        return themeId;
    }
}
