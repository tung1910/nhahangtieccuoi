/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.kho.impl;

import com.nmt.csdl.ChiTietHoaDon;
import com.nmt.csdl.HoaDon;
import com.nmt.csdl.LoaiSanh;
import com.nmt.csdl.SanhCuoi;
import com.nmt.kho.KhoThongKe;
import java.util.ArrayList;
import java.util.Date;
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

/**
 *
 * @author hp
 */
@Repository
@Transactional
public class KhoThongKeImpl implements KhoThongKe{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Object[]> thongKeLoai() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootS = q.from(SanhCuoi.class);
        Root rootL = q.from(LoaiSanh.class);
        
        q.where(b.equal(rootS.get("loaisanh"), rootL.get("maLS")));
        
        q.multiselect(rootL.get("maLS"), rootL.get("tenLS"), b.count(rootS.get("maSC")));
        
        q.groupBy(rootL.get("maLS"));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public List<Object[]> thongKeSanhCuoi(String kw, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootS = q.from(SanhCuoi.class);
        Root rootH = q.from(HoaDon.class);
        Root rootC = q.from(ChiTietHoaDon.class);
        
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rootC.get("sanhcuoi"), rootS.get("maSC")));
        predicates.add(b.equal(rootC.get("hoadon"), rootH.get("maHD")));
        
        q.multiselect(rootS.get("maSC"), rootS.get("tenSC"), b.sum(b.prod(rootC.get("donGia"), rootC.get("soLuongDatBan"))));
        
        if(kw != null && !kw.isEmpty())
            predicates.add(b.like(rootS.get("tenSC"), String.format("%%%s%%", kw)));
        
        if(fromDate != null)
            predicates.add(b.greaterThanOrEqualTo(rootH.get("ngayDatHang"), fromDate));
        
        if(toDate != null)
            predicates.add(b.lessThanOrEqualTo(rootH.get("ngayDatHang"), toDate));
        
        q.where(predicates.toArray(new Predicate[]{}));
        
        q.groupBy(rootS.get("maSC"));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public List<Object[]> tkeSanhCuoiThang(String kw, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootS = q.from(SanhCuoi.class);
        Root rootH = q.from(HoaDon.class);
        Root rootC = q.from(ChiTietHoaDon.class);
        
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rootC.get("sanhcuoi"), rootS.get("maSC")));
        predicates.add(b.equal(rootC.get("hoadon"), rootH.get("maHD")));
        
        q.multiselect(b.function("MONTH", Integer.class, rootH.get("ngayDatHang")),
                b.function("YEAR", Integer.class, rootH.get("ngayDatHang")),
                b.sum(b.prod(rootC.get("donGia"), rootC.get("soLuongDatBan"))));
        
        if(kw != null && !kw.isEmpty())
            predicates.add(b.like(rootS.get("tenSC"), String.format("%%%s%%", kw)));
        
        if(fromDate != null)
            predicates.add(b.greaterThanOrEqualTo(rootH.get("ngayDatHang"), fromDate));
        
        if(toDate != null)
            predicates.add(b.lessThanOrEqualTo(rootH.get("ngayDatHang"), toDate));
        
        q.where(predicates.toArray(new Predicate[]{}));
        
        q.groupBy(b.function("MONTH", Integer.class, rootH.get("ngayDatHang")),
                b.function("YEAR", Integer.class, rootH.get("ngayDatHang")));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }
    
}
