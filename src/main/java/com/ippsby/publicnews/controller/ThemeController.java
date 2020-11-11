package com.ippsby.publicnews.controller;

import com.ippsby.publicnews.model.ThemeModel;
import com.ippsby.publicnews.repository.ThemeRepository;
import com.ippsby.publicnews.service.ThemeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequestMapping(path = "/theme")
public class ThemeController {


    private final ThemeService themeService;

    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @GetMapping("/all")
    public List<ThemeModel> getAllTheme() {
        return themeService.findAll();
    }

    @PostMapping("/add")
    public @ResponseBody
    String addNewTheme(@RequestParam long themeId
            , @RequestParam String themeName) {


        ThemeModel theme = new ThemeModel();
        theme.setThemeId(themeId);
        theme.setThemeName(themeName);
        themeService.save(theme);
        return "Saved";
    }


    @GetMapping("/theme/{themeId}")
    public ThemeModel getThemeById(@PathVariable ThemeModel themeId) {
        return themeId;
    }

    @DeleteMapping("/theme/{themeId}")
    public ResponseEntity<?> deleteThemeData(@PathVariable ThemeModel themeId) {
        themeService.delete(themeId);
        return ResponseEntity.ok().build();
    }
}


