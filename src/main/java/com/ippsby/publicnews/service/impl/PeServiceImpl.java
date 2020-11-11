package com.ippsby.publicnews.service.impl;

import com.ippsby.publicnews.model.PeModel;
import com.ippsby.publicnews.repository.PeRepository;
import com.ippsby.publicnews.service.PeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeServiceImpl implements PeService {

    public PeServiceImpl(PeRepository peRepository) {
        this.peRepository = peRepository;
    }


    @Override
    public List<PeModel> findAll() {
        return null;
    }

    @Override
    public PeModel save(PeModel peModel) {
        return null;
    }

    private final PeRepository peRepository;
}
