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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tanya
 */
@Repository
public class ItemDAOImpl implements ItemDAO {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void addItem(Item item) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.save(item);
        trans.commit();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Item> listItems() {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        List<Item> items = session.createQuery("SELECT i FROM Item i ORDER BY name ASC").list();
        trans.commit();
        return items;
    }

    @Override
    public void removeItem(Item item) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.delete(item);
        trans.commit();
    }

    @Override
    public Item getItem(Integer id) {
        return (Item) sessionFactory.getCurrentSession().get(Item.class, id);
    }

    @Override
    public void updateItem(Item item) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.update(item);
        trans.commit();
    }

}
