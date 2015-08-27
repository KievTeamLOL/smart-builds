/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.dao;

import com.starr.smartbuilds.entity.Champion;
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
public class ChampionDAOImpl implements ChampionDAO{
    
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void addChampion(Champion champion) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.save(champion);
        trans.commit();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Champion> listChampions() {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        List<Champion> champions = session.createQuery("from Champion").list();
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
    public Champion getChampion(Integer id) {
        return (Champion) sessionFactory.getCurrentSession().get(Champion.class, id);
    }

    @Override
    public void updateChampion(Champion champion) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.update(champion);
        trans.commit();
    }

}
