/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.dichvu.impl;

import com.nmt.csdl.LoaiSanh;
import com.nmt.dichvu.DichVuLoaiSanh;
import com.nmt.kho.KhoLoaiSanh;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class DichVuLoaiSanhImpl implements DichVuLoaiSanh{
    
    @Autowired
    private KhoLoaiSanh khoLoaiSanh;
    
    @Override
    public List<LoaiSanh> getLoaiSanhs() {
        return this.khoLoaiSanh.getLoaiSanhs();
    }    

    @Override
    public LoaiSanh getLoaiSanhTheoMa(int maLS) {
        
        return this.khoLoaiSanh.getLoaiSanhTheoMa(maLS);
    }
    
}
