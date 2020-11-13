package com.ippsby.publicnews.repository;

import com.ippsby.publicnews.model.PeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeRepository extends JpaRepository<PeModel,Integer> {

}
