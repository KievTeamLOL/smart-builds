/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.dao;

import com.starr.smartbuilds.entity.Build;
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
public class BuildDAOImpl implements BuildDAO{
 private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Long addBuild(Build build) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
       Long id = (Long) session.save(build);
        trans.commit();
        return id;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Build> listBuilds() {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        List<Build> categories = session.createQuery("SELECT c FROM Build c").list();
        trans.commit();
        return categories;
    }

    @Override
    public void removeBuild(Build build) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.delete(build);
        trans.commit();
    }

    @Override
    public Build getBuild(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        Build build = (Build) session.get(Build.class, id);
        trans.commit();
        return build;
    }

}
