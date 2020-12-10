package com.ippsby.publicnews.repository;

import com.ippsby.publicnews.model.Pe;
import com.ippsby.publicnews.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeRepository extends JpaRepository<Pe,Long> {




}
