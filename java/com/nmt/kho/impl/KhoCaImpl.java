/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.kho.impl;

import com.nmt.csdl.Ca;
import com.nmt.kho.KhoCa;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hp
 */
@Repository
@Transactional
public class KhoCaImpl implements KhoCa{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Ca> getCas(){
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Ca");
        
        return q.getResultList();
    }

    @Override
    public Ca getCaTheoMa(int maC) {
        Session s = sessionFactory.getObject().getCurrentSession();
        
        return s.get(Ca.class, maC);
    }
}
