package com.ippsby.publicnews.dto;

import java.io.Serializable;

public class ThemeDto implements Serializable {
    public ThemeDto(){

    }
    private long themeId;
    private String themeName;

    public long getThemeId() {
        return themeId;
    }

    public void setThemeId(long themeId) {
        this.themeId = themeId;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }
}
