package com.codegym.pratice.service.Impl;

import com.codegym.pratice.model.BenhAn;
import com.codegym.pratice.repository.IBenhAnRepository;
import com.codegym.pratice.service.IBenhAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenhAnServiceImpl implements IBenhAnService {

    @Autowired
    private IBenhAnRepository iBenhAnRepository;
    @Override
    public List<BenhAn> findAllBenhAn() {
        return iBenhAnRepository.findAll();
    }

    @Override
    public void save(BenhAn benhAn) {
        iBenhAnRepository.save(benhAn);
    }

    @Override
    public void remove(String id) {
        iBenhAnRepository.delete(findById(id));
    }

    @Override
    public BenhAn findById(String id) {
        return iBenhAnRepository.findById(id).orElse(null);
    }
}
