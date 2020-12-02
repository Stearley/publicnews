package com.ippsby.publicnews.controller;

import com.ippsby.publicnews.model.News;
import com.ippsby.publicnews.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(path = "/news")

public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public List<News> getAllNews() {
        return newsService.findAll();
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<News> addNewNews(@RequestBody News news, HttpServletRequest request) {
       if(Integer.parseInt(request.getHeader("Test"))>1){
           newsService.save(news);
           return new ResponseEntity<>(HttpStatus.OK);
       }
       else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/{newsId}")
    public News getNewsById(@PathVariable News newsId) {
        return newsId;
    }

    @DeleteMapping("/{newsId}")
    public ResponseEntity<?> deleteNewsData(@PathVariable News newsId, HttpServletRequest request) {
        if (Integer.parseInt(request.getHeader("Test")) > 1) {
            newsService.delete(newsId);
            return ResponseEntity.ok().build();
        }
        else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }


}

