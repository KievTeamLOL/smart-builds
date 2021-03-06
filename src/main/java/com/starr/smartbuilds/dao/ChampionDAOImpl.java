/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.dao;

import com.starr.smartbuilds.entity.Champion;
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
public class ChampionDAOImpl implements ChampionDAO{
    
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void addChampion(Champion champion) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.persist(champion);
        trans.commit();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Champion> listChampions() {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        List<Champion> champions = session.createCriteria(Champion.class)
                .addOrder(Order.asc("name"))
                .list();
        trans.commit();
        return champions;
    }

    @Override
    public void removeChampion(Champion champion) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.delete(champion);
        trans.commit();
    }

    @Override
    public Champion getChampion(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        Champion champion = (Champion) session.get(Champion.class, id);
        trans.commit();
        return champion;
    }

    @Override
    public void updateChampion(Champion champion) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.update(champion);
        trans.commit();
    }

}
