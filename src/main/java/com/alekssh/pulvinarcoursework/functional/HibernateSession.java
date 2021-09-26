package com.example.pulvinar.functional;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSession {
    private static SessionFactory factory;
    private static StandardServiceRegistry registry;

    private HibernateSession() {
    }

    public static SessionFactory getSessionFactory() {
        if (factory == null) {
            registry = new StandardServiceRegistryBuilder().configure().build();

            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }
        return factory;
    }
}
