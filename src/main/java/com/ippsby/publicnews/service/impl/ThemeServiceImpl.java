package com.ippsby.publicnews.service.impl;


import com.ippsby.publicnews.model.ThemeModel;
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
    public ThemeModel save(ThemeModel themeModel) {
        return null;
    }

    @Override
    public List<ThemeModel> findAll() {
        return null;
    }

    @Override
    public ThemeModel delete(ThemeModel themeId) {
        return null;
    }

    private final ThemeRepository themeRepository;
}
