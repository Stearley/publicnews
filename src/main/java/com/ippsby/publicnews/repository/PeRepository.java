package com.ippsby.publicnews.repository;

import com.ippsby.publicnews.model.Pe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeRepository extends JpaRepository<Pe,Long> {

}
