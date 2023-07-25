package com.codegym.Service.impl;

import com.codegym.Entity.FootballPitches;
import com.codegym.Repository.IFootballPitchesRepository;
import com.codegym.Service.IFootballPitchesService;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FootballPitchesServiceImpl implements IFootballPitchesService {
    private final IFootballPitchesRepository repository;

    public FootballPitchesServiceImpl(IFootballPitchesRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<FootballPitches> findAll(Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber-1,3);
        return repository.findAll(pageable);
    }

    @Override
    public FootballPitches findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<FootballPitches> order(FootballPitches footballPitches) {
       return (List<FootballPitches>) repository.save(footballPitches);
    }

    @Override
    public boolean create(FootballPitches footballPitches) {
        repository.save(footballPitches);
        return true;
    }

    @Override
    public List<FootballPitches> findFootballPitchesByNamePitchesContaining(String name){
        return repository.findFootballPitchesByNamePitchesContaining(name);
    }

    @Override
    public boolean delete(Integer id) {
        repository.deleteById(id);
        return true;
    }
}
