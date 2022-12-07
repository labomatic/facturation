package com.example.manage_client_app.dao;

import com.example.manage_client_app.connection.PersistenceManager;
import com.example.manage_client_app.model.InvoiceProductAssociation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class AssociationDao implements Dao<InvoiceProductAssociation> {

    @Override
    public Optional<InvoiceProductAssociation> get(Long id) {
        return Optional.empty();
    }

    @Override
    public List<InvoiceProductAssociation> getAll() {
        return null;
    }

    @Override
    public void save(InvoiceProductAssociation invoiceProductAssociation) {
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(invoiceProductAssociation);
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
    public void update(InvoiceProductAssociation invoiceProductAssociation) {

    }

    @Override
    public void delete(InvoiceProductAssociation invoiceProductAssociation) {

    }
}
