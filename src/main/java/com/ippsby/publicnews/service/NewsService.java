package com.ippsby.publicnews.service;

import com.ippsby.publicnews.model.NewsModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface NewsService {

    List<NewsModel> findAll();

    NewsModel save(NewsModel news);

    NewsModel delete(NewsModel newsId);
}
