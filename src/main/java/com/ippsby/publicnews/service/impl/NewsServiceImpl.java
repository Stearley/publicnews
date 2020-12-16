package com.ippsby.publicnews.service.impl;


import com.ippsby.publicnews.model.News;
import com.ippsby.publicnews.repository.NewsRepository;
import com.ippsby.publicnews.service.NewsService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NewsServiceImpl implements NewsService {

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public News save(News news) {
        return newsRepository.saveAndFlush(news);
    }

    @Override
    public void delete(News newsId) {
        newsRepository.delete(newsId);
    }

    @Override
    public List<News> findAll() {
        return newsRepository.findAll();
    }

    private final NewsRepository newsRepository;

}

