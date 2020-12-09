package com.ippsby.publicnews.service.impl;

import com.ippsby.publicnews.model.Pe;
import com.ippsby.publicnews.model.Theme;
import com.ippsby.publicnews.repository.PeRepository;
import com.ippsby.publicnews.service.PeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeServiceImpl implements PeService {

    public PeServiceImpl(PeRepository peRepository) {
        this.peRepository = peRepository;
    }


    @Override
    public List<Pe> findAll() {
        return peRepository.findAll();
    }

    @Override
    public Pe save(Pe pe) {
        return peRepository.saveAndFlush(pe);
    }

    @Override
    public void delete(Pe peId) {
        peRepository.delete(peId);
    }

    @Override
    public Pe sort (Theme theme) {
        return peRepository.findByThemes(theme);
    }

    private final PeRepository peRepository;
}
