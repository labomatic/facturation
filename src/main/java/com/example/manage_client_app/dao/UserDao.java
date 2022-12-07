package com.example.manage_client_app.dao;

import com.example.manage_client_app.connection.PersistenceManager;
import com.example.manage_client_app.model.Customer;
import com.example.manage_client_app.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.Optional;

public class UserDao {
    public User findByUsername (String username) {
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        EntityTransaction et = em.getTransaction();
        User user = null;
        try {
            et.begin();
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                    .setParameter("username", username);
            user = query.getSingleResult();
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return user;
    }
}
