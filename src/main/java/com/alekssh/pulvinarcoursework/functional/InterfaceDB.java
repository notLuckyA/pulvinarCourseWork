package com.alekssh.pulvinarcoursework.functional;

import com.alekssh.pulvinarcoursework.tables.Order;
import com.alekssh.pulvinarcoursework.tables.Product;
import com.alekssh.pulvinarcoursework.tables.User;
import org.hibernate.Session;

import java.util.List;

public class InterfaceDB {
    public User findByLogin(String login) {
        return (User) HibernateSession.getSessionFactory().openSession().createQuery("from User U where U.login = '" + login + "'").uniqueResult();
    }

    public static List<User> selectFromUser() {
        return (List<User>) HibernateSession.getSessionFactory().openSession().createQuery("from User ").list();
    }

    public void createUser(User user) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public static void deleteUser(User user) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

    public static void updateUser(User user) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    public void createProduct(Product product) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
        session.close();
    }

    public static List<Product> selectFromProduct() {
        return (List<Product>) HibernateSession.getSessionFactory().openSession().createQuery("from Product").list();
    }

    public Product findByName(String name) {
        return (Product) HibernateSession.getSessionFactory().openSession().createQuery("from Product P where P.nameProduct = '" + name + "'").uniqueResult();
    }

    public static void deleteProduct(Product product) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(product);
        session.getTransaction().commit();
        session.close();
    }

    public static void updateProductr(Product product) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(product);
        session.getTransaction().commit();
        session.close();
    }

    public void createOrders(Order order) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
        session.close();
    }

}
