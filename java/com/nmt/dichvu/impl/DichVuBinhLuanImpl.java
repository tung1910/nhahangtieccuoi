/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.dichvu.impl;

import com.nmt.csdl.BinhLuan;
import com.nmt.csdl.TaiKhoan;
import com.nmt.dichvu.DichVuBinhLuan;
import com.nmt.kho.KhoBinhLuan;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nmt.kho.KhoTaiKhoan;

/**
 *
 * @author hp
 */
@Service
public class DichVuBinhLuanImpl implements DichVuBinhLuan{

    
//    @Autowired
//    private KhoTaiKhoan khoTaiKhoan;
    
    @Autowired
    private KhoBinhLuan khoBinhLuan;

    @Override
    public BinhLuan addBinhLuan(String binhLuan, int maSC, TaiKhoan nguoiTao) {;
        
        BinhLuan d = new BinhLuan();
        d.setBinhLuan(binhLuan);
        d.setMaTK(nguoiTao);
        d.setNgayDang(new Date());
        
        return this.khoBinhLuan.addBinhLuan(d);
    }
    
}
