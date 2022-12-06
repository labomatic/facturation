package com.example.manage_client_app.dao;

import com.example.manage_client_app.connection.PersistenceManager;
import com.example.manage_client_app.model.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.hibernate.id.factory.spi.CustomIdGeneratorCreationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDao implements Dao<Customer> {

    @Override
    public Optional<Customer> get(Long id) {
        Customer foundCustomer = null;
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            foundCustomer = em.find(Customer.class, id);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return Optional.of(foundCustomer);
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customerList = new ArrayList<>();
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c", Customer.class);
            customerList = query.getResultList();
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(customer);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Customer customer) {
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            em.merge(customer);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(Customer customer) {
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Customer customerToDelete= em.find(Customer.class, customer.getCustomerId());
            em.remove(customerToDelete);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
    }
}
