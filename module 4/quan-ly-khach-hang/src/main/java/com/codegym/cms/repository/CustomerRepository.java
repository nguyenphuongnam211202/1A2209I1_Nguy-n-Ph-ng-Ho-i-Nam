package com.codegym.cms.repository;

import com.codegym.cms.model.Customer;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CustomerRepository implements ICustomerRepository {
    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = em.createQuery("select c from Customer c", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(int id) {
        TypedQuery<Customer> query = em.createQuery("select c from Customer c where  c.id=:id", Customer.class);
        query.setParameter("id", id);
        return null;
    }

    @Override
    public void save(Customer customer) {
        if (customer.getId() != 0) {
            em.merge(customer);
        } else {
            em.persist(customer);
        }
    }

    @Override
    public void remove(int id) {
        Customer customer = findById(id);
        if(customer != null){
            em.remove(customer);
        }
    }
}
