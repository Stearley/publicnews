package com.ippsby.publicnews.repository;

import com.ippsby.publicnews.model.Pe;
import com.ippsby.publicnews.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeRepository extends JpaRepository<Pe,Long> {


//    @Query(value = "select t.* from theme t inner  join pe_thematics p on  where p.peId = :themeId", nativeQuery = true)
//    void findByThems(@Param("theme") long theme);
//
//    @Query("select t from Pe t left join t.themes tt where tt.themeId = :them ")
//    void findByThems(@Param("theme") long theme);
//
//
//    List<Pe> findByThemesIn(Theme theme);
}
