package com.ippsby.publicnews.repository;

import com.ippsby.publicnews.model.Pe;
import com.ippsby.publicnews.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThemeRepository extends JpaRepository<Theme,Long> {



}
