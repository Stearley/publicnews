package com.ippsby.publicnews.service;

import com.ippsby.publicnews.model.PeModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PeService {

    List<PeModel> findAll();

    PeModel save(PeModel peModel);
}
