package com.codegym.Service;

import com.codegym.Entity.Address;

import java.util.List;

public interface IAddressService {

    List<Address> findAll();

    Address FindById(Integer id);
}
