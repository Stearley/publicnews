package com.ippsby.publicnews.service;

import com.ippsby.publicnews.model.Pe;
import com.ippsby.publicnews.model.Theme;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PeService {

    List<Pe> findAll();

    Pe save(Pe pe);

    void delete(Pe peId);


}
