/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.dao;

import com.starr.smartbuilds.entity.Item;
import com.starr.smartbuilds.entity.Tag;
import com.starr.smartbuilds.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tanya
 */
@Repository
public class TagDAOImpl implements TagDAO {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void addTag(Tag tag) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.save(tag);
        trans.commit();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Tag> listTags() {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        List<Tag> tags = session.createQuery("SELECT t FROM Tag t ORDER BY name ASC").list();
        trans.commit();
        return tags;
    }

    @Override
    public void removeTag(Tag tag) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.delete(tag);
        trans.commit();
    }

    @Override
    public Tag getTag(Integer id) {
        return (Tag) sessionFactory.getCurrentSession().get(Tag.class, id);
    }

    @Override
    public void updateTag(Tag tag) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.update(tag);
        trans.commit();
    }

}
