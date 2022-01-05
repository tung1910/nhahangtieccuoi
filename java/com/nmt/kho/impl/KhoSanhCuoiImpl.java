/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.kho.impl;

import com.nmt.csdl.SanhCuoi;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.nmt.kho.KhoSanhCuoi;

/**
 *
 * @author hp
 */
@Repository
@Transactional
public class KhoSanhCuoiImpl implements KhoSanhCuoi{
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<SanhCuoi> getSanhCuois(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<SanhCuoi> query = builder.createQuery(SanhCuoi.class);
        Root root = query.from(SanhCuoi.class);
        query = query.select(root);
        
        query = query.orderBy(builder.desc(root.get("maSC")));
        
        if (kw !=null) {
            Predicate p = builder.like(root.get("tenSC").as(String.class), String.format("%%%s%%", kw));
            query = query.where(p);
        }
        
        query = query.orderBy(builder.desc(root.get("maSC")));
        
        Query q = session.createQuery(query);
        
        int max = 20;
        q.setMaxResults(max);
        q.setFirstResult((page - 1) * max);
        
        return q.getResultList();
    }

    @Override
    public long demSanhCuoi() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("Select Count(*) From SanhCuoi");
        
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public boolean addOrUpdate(SanhCuoi sanhCuoi) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(sanhCuoi);
                    
            return true;
        } catch (Exception ex) {
            System.err.println("~~ ADD PRODUCT ERRPR ~~" + ex.getMessage());
            ex.printStackTrace();
        }
        
        return false;
    }

    @Override
    public SanhCuoi getSanhCuoiTheoMa(int maSC) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        return session.get(SanhCuoi.class, maSC);
    }

}
