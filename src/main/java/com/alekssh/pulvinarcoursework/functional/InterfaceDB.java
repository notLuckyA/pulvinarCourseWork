package com.alekssh.pulvinarcoursework.functional;

import com.alekssh.pulvinarcoursework.tables.User;
import org.hibernate.Session;

public class InterfaceDB {
    public User findByLogin(String login) {
        return (User) HibernateSession.getSessionFactory().openSession().createQuery("from User U where U.login = '" + login + "'").uniqueResult();
    }

    public void createUser(User user) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }
}
