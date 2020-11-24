package com.ippsby.publicnews.service;

import com.ippsby.publicnews.model.News;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface NewsService {

    List<News> findAll();

    News save(News news);

    News delete(News newsId);
}
