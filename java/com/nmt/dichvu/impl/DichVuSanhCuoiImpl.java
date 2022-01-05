/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.dichvu.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nmt.csdl.SanhCuoi;
import com.nmt.dichvu.DichVuSanhCuoi;
import com.nmt.kho.KhoSanhCuoi;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class DichVuSanhCuoiImpl implements DichVuSanhCuoi{
    
    @Autowired
    private KhoSanhCuoi khoSanhCuoi;
    
    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public List<SanhCuoi> getSanhCuois(String kw, int page) {
        return this.khoSanhCuoi.getSanhCuois(kw, page);
    }

    @Override
    public long demSanhCuoi() {
        return this.khoSanhCuoi.demSanhCuoi();
    }

    @Override
    public boolean addOrUpdate(SanhCuoi sanhCuoi) {
        try {
            Map m = this.cloudinary.uploader().upload(sanhCuoi.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
            sanhCuoi.setHinhSC((String) m.get("secure_url"));
            
            return this.khoSanhCuoi.addOrUpdate(sanhCuoi);
        } catch(IOException ex) {
            System.err.println("~~ ADD PRODUCT ~~" + ex.getMessage());
        }
        
        return false; 
    }

    @Override
    public SanhCuoi getSanhCuoiTheoMa(int maSC) {
        return this.khoSanhCuoi.getSanhCuoiTheoMa(maSC);
    }   
    
}
