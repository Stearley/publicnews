package com.ippsby.publicnews.dto;

import java.io.Serializable;
import java.util.List;

public class ThemeDto implements Serializable {
    public ThemeDto(long themeId, String themeName, List<PeDto> peList){
        this.themeId = themeId;
        this.themeName = themeName;
        this.peList = peList;
    }

    private long themeId;
    private String themeName;

    private List<PeDto> peList;

    public List<PeDto> getPeList() {
        return peList;
    }

    public void setPeList(List<PeDto> peList) {
        this.peList = peList;
    }

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
