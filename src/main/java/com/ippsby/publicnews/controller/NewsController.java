package com.ippsby.publicnews.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.ippsby.publicnews.dto.NewsStatus;
import com.ippsby.publicnews.model.News;
import com.ippsby.publicnews.model.Security;
import com.ippsby.publicnews.model.UserModel;
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

    @JsonView(Security.Public.class)
    @GetMapping
    public List<News> getAllNews() {
        return newsService.findAll();
    }


    @PostMapping
    @ResponseBody
    public ResponseEntity<News> addNewNews(@RequestBody News news, HttpServletRequest request) {
        if(Integer.parseInt(request.getHeader("Test"))>1){
            news.setNewsStatus(1L);
            newsService.save(news);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @JsonView(Security.Public.class)
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

    @JsonView(Security.Public.class)
    @PutMapping("/status")
    public ResponseEntity<?> updateStatus(@RequestBody News news, HttpServletRequest request) {
        if (Integer.parseInt(request.getHeader("Test")) > 2) {
            return new ResponseEntity<>(newsService.save(news), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @JsonView(Security.Public.class)
    @PutMapping
    public ResponseEntity<?> updateNews(@RequestBody News news, HttpServletRequest request) {
        if (Integer.parseInt(request.getHeader("Test")) > 1) {
            return new ResponseEntity<>(newsService.save(news), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}

