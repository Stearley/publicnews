package com.ippsby.publicnews.repository;

import com.ippsby.publicnews.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{



}
