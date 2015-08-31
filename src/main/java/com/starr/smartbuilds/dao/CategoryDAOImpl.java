/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.dao;

import com.starr.smartbuilds.entity.Category;
import com.starr.smartbuilds.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tanya
 */
@Repository
public class CategoryDAOImpl implements CategoryDAO{
     private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void addCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.save(category);
        trans.commit();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Category> listCategories() {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        List<Category> categories = session.createQuery("SELECT c FROM Category c").list();
        trans.commit();
        return categories;
    }

    @Override
    public void removeCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.delete(category);
        trans.commit();
    }

    @Override
    public Category getCategory(Integer id) {
        return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
    }

}
