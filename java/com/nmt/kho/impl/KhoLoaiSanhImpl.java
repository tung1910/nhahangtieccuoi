/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.kho.impl;

import com.nmt.csdl.LoaiSanh;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.nmt.kho.KhoLoaiSanh;

/**
 *
 * @author hp
 */
@Repository
@Transactional
public class KhoLoaiSanhImpl implements KhoLoaiSanh{
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<LoaiSanh> getLoaiSanhs(){
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From LoaiSanh");
        
        return q.getResultList();
    }

    @Override
    public LoaiSanh getLoaiSanhTheoMa(int maLS) {
        Session s = sessionFactory.getObject().getCurrentSession();
        
        return s.get(LoaiSanh.class, maLS);
    }
    
}
