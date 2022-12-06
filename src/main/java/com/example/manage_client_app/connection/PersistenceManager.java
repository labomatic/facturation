package com.example.manage_client_app.connection;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceManager {
    private static EntityManagerFactory EMF_INSTANCE;

    private PersistenceManager() {}

    public static EntityManagerFactory getInstance() {
        if (EMF_INSTANCE==null) {
            EMF_INSTANCE = Persistence.createEntityManagerFactory("myPU");
        }
        return EMF_INSTANCE;
    }
}
