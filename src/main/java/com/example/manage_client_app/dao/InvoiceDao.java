package com.example.manage_client_app.dao;

import com.example.manage_client_app.connection.PersistenceManager;
import com.example.manage_client_app.model.Customer;
import com.example.manage_client_app.model.Invoice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InvoiceDao implements Dao<Invoice>{
    @Override
    public Optional<Invoice> get(Long id) {
        Invoice foundInvoice = null;
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            foundInvoice = em.find(Invoice.class, id);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return Optional.of(foundInvoice);
    }

    @Override
    public List<Invoice> getAll() {
        List<Invoice> invoiceList = new ArrayList<>();
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            TypedQuery<Invoice> query = em.createQuery("SELECT i FROM Invoice i", Invoice.class);
            invoiceList = query.getResultList();
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return invoiceList;
    }

    @Override
    public void save(Invoice invoice) {
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(invoice);
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
    public void update(Invoice invoice) {
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(invoice);
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
    public void delete(Invoice invoice) {
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Invoice invoiceToDelete= em.find(Invoice.class, invoice.getInvoiceId());
            em.remove(invoiceToDelete);
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
