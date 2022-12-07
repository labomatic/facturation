package com.example.manage_client_app.dao;

import com.example.manage_client_app.connection.PersistenceManager;
import com.example.manage_client_app.model.Invoice;
import com.example.manage_client_app.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDao implements Dao<Product> {
    @Override
    public Optional<Product> get(Long id) {
        Product foundProduct = null;
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            foundProduct = em.find(Product.class, id);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return Optional.of(foundProduct);
    }

    @Override
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
            productList = query.getResultList();
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return productList;
    }

    @Override
    public void save(Product product) {
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(product);
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
    public void update(Product product) {
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(product);
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
    public void delete(Product product) {
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Product productToDelete= em.find(Product.class, product.getProductId());
            em.remove(productToDelete);
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
