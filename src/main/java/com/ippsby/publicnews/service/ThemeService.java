package com.ippsby.publicnews.service;

import com.ippsby.publicnews.dto.ThemeDto;
import com.ippsby.publicnews.model.Theme;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ThemeService {

    Theme save (Theme theme);

    List<Theme> findAll();

    void delete(Theme themeId);

    List<ThemeDto> findAllDto();
}
