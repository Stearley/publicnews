package com.ippsby.publicnews.service.impl;


import com.ippsby.publicnews.model.Theme;
import com.ippsby.publicnews.repository.ThemeRepository;
import com.ippsby.publicnews.service.ThemeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeServiceImpl implements ThemeService {

    public ThemeServiceImpl (ThemeRepository themeRepository) {

        this.themeRepository = themeRepository;
    }

    @Override
    public Theme save(Theme theme) {
        return themeRepository.saveAndFlush(theme);
    }

    @Override
    public List<Theme> findAll() {
        return null;
    }

    @Override
    public Theme delete(Theme themeId) {
        return null;
    }

    private final ThemeRepository themeRepository;
}
