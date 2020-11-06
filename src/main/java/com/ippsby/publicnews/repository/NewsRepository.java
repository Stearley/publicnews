package com.ippsby.publicnews.repository;

import com.ippsby.publicnews.model.NewsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<NewsModel,Long> {

}
