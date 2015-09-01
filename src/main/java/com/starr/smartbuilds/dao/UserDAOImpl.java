/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.dao;

import com.starr.smartbuilds.entity.User;
import com.starr.smartbuilds.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tanya
 */
@Repository
public class UserDAOImpl implements UserDAO {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.save(user);
        trans.commit();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        List<User> users = session.createQuery("from User").list();
        trans.commit();
        return users;
    }

    @Override
    public void removeUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.delete(user);
        trans.commit();
    }

    @Override
    public User getUserById(Integer id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.update(user);
        trans.commit();
    }

    public User getUserByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        Criteria userCrit = session.createCriteria(User.class).add(Restrictions.eq("email",email));
        User user = (User) userCrit.uniqueResult();
        trans.commit();
        return user;
    }

}

