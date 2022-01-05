/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.dinhdang;

import com.nmt.csdl.LoaiSanh;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author hp
 */
public class DinhDangLoaiSanh implements Formatter<LoaiSanh>{

    @Override
    public String print(LoaiSanh object, Locale locale) {
        return String.valueOf(object.getMaLS());
    }

    @Override
    public LoaiSanh parse(String maLS, Locale locale) throws ParseException {
        LoaiSanh ls = new LoaiSanh();
        ls.setMaLS(Integer.parseInt(maLS));
        
        return ls;
    }
    
}
