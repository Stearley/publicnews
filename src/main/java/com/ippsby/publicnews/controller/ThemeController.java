package com.ippsby.publicnews.controller;

import com.ippsby.publicnews.model.Theme;
import com.ippsby.publicnews.service.ThemeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/theme")
public class ThemeController {


    private final ThemeService themeService;

    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @GetMapping("/all")
    public List<Theme> getAllTheme() {
        return themeService.findAll();
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Theme> addNewTheme(@RequestBody Theme theme) {
        themeService.save(theme);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/theme/{themeId}")
    public Theme getThemeById(@PathVariable Theme themeId) {
        return themeId;
    }

    @DeleteMapping("/theme/{themeId}")
    public ResponseEntity<?> deleteThemeData(@PathVariable Theme themeId) {
        themeService.delete(themeId);
        return ResponseEntity.ok().build();
    }
}


