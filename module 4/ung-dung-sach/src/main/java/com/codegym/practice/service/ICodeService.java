package com.codegym.practice.service;

import com.codegym.practice.entity.Code;

import java.util.List;

public interface ICodeService {
    List<Code> findAllCodeByBookId(int id);
    void save(Code code);
    List<Code> findAllCode();
    Code findById(int id);
    Code findByCode(int code);
    List<Code> findAllCodeByBookIdAndNotBorrowed(int id);

}
