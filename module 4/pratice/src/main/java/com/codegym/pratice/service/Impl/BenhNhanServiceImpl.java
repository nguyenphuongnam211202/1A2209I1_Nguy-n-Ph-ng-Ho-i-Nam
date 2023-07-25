package com.codegym.pratice.service.Impl;

import com.codegym.pratice.model.BenhNhan;
import com.codegym.pratice.repository.IBenhNhanReposity;
import com.codegym.pratice.service.IBenhNhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenhNhanServiceImpl implements IBenhNhanService {
    @Autowired
    private IBenhNhanReposity iBenhNhanReposity;


    @Override
    public List<BenhNhan> findAllBenhNhan() {
        return iBenhNhanReposity.findAll();
    }

    @Override
    public void save(BenhNhan benhNhan) {
        iBenhNhanReposity.save(benhNhan);
    }

    @Override
    public void remove(String id) {
        iBenhNhanReposity.delete(findById(id));
    }

    @Override
    public BenhNhan findById(String id) {
        return iBenhNhanReposity.findById(id).orElse(null);
    }
}
