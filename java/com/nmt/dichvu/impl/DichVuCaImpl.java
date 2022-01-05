/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.dichvu.impl;

import com.nmt.csdl.Ca;
import com.nmt.dichvu.DichVuCa;
import com.nmt.kho.KhoCa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class DichVuCaImpl implements DichVuCa{
    
    @Autowired
    private KhoCa khoCa;
    
    @Override
    public List<Ca> getCas() {
        return this.khoCa.getCas();
    }    

    @Override
    public Ca getCaTheoMa(int maC) {
        
        return this.khoCa.getCaTheoMa(maC);
    }
}
