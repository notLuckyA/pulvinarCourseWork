package com.alekssh.pulvinarcoursework.functional;

import com.alekssh.pulvinarcoursework.tables.User;

public class InterfaceDB {
    public User findByLogin(String login) {
        return (User) HibernateSession.getSessionFactory().openSession().createQuery("from User U where U.login = '" + login + "'").uniqueResult();
    }

}
