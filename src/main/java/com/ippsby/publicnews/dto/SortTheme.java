package com.ippsby.publicnews.dto;

import java.io.Serializable;

public class SortTheme implements Serializable {

    public SortTheme(long themeId, long peId) {
        this.themeId = themeId;
//        this.themName = themeName;
        this.peId = peId;

    }

    private long themeId;

    private long peId;


    public long getThemeId() {
        return themeId;
    }

    public long getPeId() {
        return peId;
    }

}
