package com.example.service;

import com.example.model.Person;
import com.example.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService{
    @Autowired
    private IPersonRepository iPersonRepository;
    @Override
    public boolean create(Person person) {
        iPersonRepository.save(person);
        return true;
    }

    @Override
    public Person findById(int id) {
        return iPersonRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Person> findAllPage(Pageable pageable) {
        return iPersonRepository.findAll(pageable);
    }

    @Override
    public List<Person> findAll() {
        return iPersonRepository.findAll();
    }

    @Override
    public Page<Person> searchByName(String name, Pageable pageable) {
        return iPersonRepository.findAllByNamePersonContaining(name,pageable);
    }


}
