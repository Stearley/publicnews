package com.ippsby.publicnews.controller;

import com.ippsby.publicnews.dto.PeDto;
import com.ippsby.publicnews.dto.ThemeDto;
import com.ippsby.publicnews.model.Pe;
import com.ippsby.publicnews.model.Theme;
import com.ippsby.publicnews.service.ThemeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping(path = "/theme")
public class ThemeController {


    private final ThemeService themeService;

    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @GetMapping
    public List<Theme> getAllTheme() {
        return themeService.findAll();
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Theme> addNewTheme(@RequestBody Theme theme, HttpServletRequest request) {
        if (Integer.parseInt(request.getHeader("Test")) > 1) {
            themeService.save(theme);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/{themeId}")
    public Theme getThemeById(@PathVariable Theme themeId) {
        return themeId;
    }

    @DeleteMapping("/{themeId}")
    public ResponseEntity<?> deleteThemeData(@PathVariable Theme themeId, HttpServletRequest request) {
        if (Integer.parseInt(request.getHeader("Test")) > 1) {
            themeService.delete(themeId);
            return ResponseEntity.ok().build();
        }
        else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PutMapping
    public ResponseEntity<?> updateTheme(@RequestBody Theme theme, HttpServletRequest request) {
        if (Integer.parseInt(request.getHeader("Test")) > 4) {
            return new ResponseEntity<>(themeService.save(theme), HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
//
//    @GetMapping("/sort/{theme}")
//    public ResponseEntity<?> sort (@PathVariable long theme){
////        List<Pe> pes = theme.getPeList();
//       // themeService.getByThems(theme)
//        List<ThemeDto> themeDtoList = themeService.findAllDto();
//        return ResponseEntity.ok(themeDtoList);
//    }

//    @GetMapping("/sort/{theme}")
//    public ResponseEntity<?> sort (@PathVariable long theme){
////        List<Pe> pes = theme.getPeList();
//        // themeService.getByThems(theme)
//        List<ThemeDto> themeDtoList = themeService.findAllDto();
//        return ResponseEntity.ok(themeDtoList);

//    @GetMapping("/sort/{theme}")
//    public ResponseEntity<?> sort (@PathVariable long theme){
////        List<Pe> pes = theme.();
//        themeService.getByThems(theme);
//        return ResponseEntity.ok(theme);
//    }

    @GetMapping("/sort")
    public ResponseEntity<?> sort (){
        List<ThemeDto> themeDtoList = themeService.findAllDto();
        return ResponseEntity.ok(themeDtoList);
    }
}




