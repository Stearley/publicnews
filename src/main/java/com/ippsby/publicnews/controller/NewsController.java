package com.ippsby.publicnews.controller;

import com.ippsby.publicnews.model.NewsModel;
import com.ippsby.publicnews.model.PeModel;

import com.ippsby.publicnews.service.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/news")

public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/all")
    public List<NewsModel> getAllNews() {
        return newsService.findAll();
    }

    @PostMapping("/add")
    public @ResponseBody
    String addNewNews(@RequestParam long newsId ,
                      @RequestParam() String title ,
                      @RequestParam(name = "qwe",required = false, defaultValue = "-1") String annotation ,
                      @RequestParam Date publicationDate ) {

        NewsModel news = new NewsModel();
        news.setNewsId(newsId);
        news.setTitle(title);
        news.setAnnotation(annotation);
        news.setPublicationDate(publicationDate);
        newsService.save(news);
        return "Saved";
    }

    @GetMapping("/news/{newsId}")
    public NewsModel getNewsById(@PathVariable NewsModel newsId) {
        return newsId;
    }

    @DeleteMapping("/news/{newsId}")
    public ResponseEntity<?> deleteNewsData(@PathVariable NewsModel newsId) {
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
