package com.ippsby.publicnews.service;

import com.ippsby.publicnews.model.Pe;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PeService {

    List<Pe> findAll();

    Pe save(Pe pe);

    void delete(Pe peId);
}
