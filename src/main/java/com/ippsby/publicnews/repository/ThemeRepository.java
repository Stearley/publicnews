package com.ippsby.publicnews.repository;

import com.ippsby.publicnews.model.ThemeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ThemeRepository extends JpaRepository<ThemeModel,Long> {

}
