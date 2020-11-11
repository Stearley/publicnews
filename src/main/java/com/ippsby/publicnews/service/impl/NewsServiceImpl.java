package com.ippsby.publicnews.service.impl;


import com.ippsby.publicnews.model.NewsModel;
import com.ippsby.publicnews.model.PeModel;
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
    public NewsModel save(NewsModel news) {
        return null;
    }

    @Override
    public NewsModel delete(NewsModel newsId) {
        return null;
    }

    @Override
    public List<NewsModel> findAll() {
        return null;
    }

    private final NewsRepository newsRepository;


}
