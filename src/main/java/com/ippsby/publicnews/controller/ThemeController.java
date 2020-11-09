package com.ippsby.publicnews.controller;

import com.ippsby.publicnews.model.ThemeModel;
import com.ippsby.publicnews.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping(path = "/theme")
public class ThemeController {

    @Autowired
    private ThemeRepository themeRepository;

    @GetMapping("/all")
    public List<ThemeModel> getAllTheme() {
        return themeRepository.findAll();
    }

    @PostMapping("/add")
    public @ResponseBody
    String addNewTheme(@RequestParam long themeId
            , @RequestParam String themeName) {


        ThemeModel theme = new ThemeModel();
        theme.setThemeId(themeId);
        theme.setThemeName(themeName);
        themeRepository.save(theme);
        return "Saved";
    }

    //@GetMapping("/theme/findById")
    //public List <ThemeModel> getById(){
      //  return themeRepository.findById();


    //}
    @GetMapping("/theme/{themeId}")
    public ThemeModel getThemeById(@PathVariable ThemeModel themeId) {
        return themeId;
    }

    @DeleteMapping("/theme/{themeId}")
    public ResponseEntity<?> deleteUserData(@PathVariable ThemeModel themeId) {
        themeRepository.delete(themeId);
        return ResponseEntity.ok().build();
    }
}


