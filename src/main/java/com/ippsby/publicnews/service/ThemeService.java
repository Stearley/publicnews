package com.ippsby.publicnews.service;

import com.ippsby.publicnews.model.ThemeModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ThemeService {

    ThemeModel save (ThemeModel theme);

    List<ThemeModel> findAll();

    ThemeModel delete(ThemeModel themeId);
}
