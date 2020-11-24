package com.ippsby.publicnews.controller;

import com.ippsby.publicnews.model.News;
import com.ippsby.publicnews.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/news")

public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/all")
    public List<News> getAllNews() {
        return newsService.findAll();
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<News> addNewNews(@RequestBody News news) {
        newsService.save(news);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/news/{newsId}")
    public News getNewsById(@PathVariable News newsId) {
        return newsId;
    }

    @DeleteMapping("/news/{newsId}")
    public ResponseEntity<?> deleteNewsData(@PathVariable News newsId) {
        newsService.delete(newsId);
        return ResponseEntity.ok().build();
    }


    //@GetMapping("/newsPe")
    //public NewsModel getNewsByIdPE(@RequestParam PeModel pe ,
      //                             @RequestParam NewsModel newsId) {
        //return pe.getNews();
        //return newsId;
    //}
}

