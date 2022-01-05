/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.dinhdang;

import com.nmt.csdl.Ca;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author hp
 */
public class ĐinhDangCa implements Formatter<Ca>{

    @Override
    public String print(Ca object, Locale locale) {
        return String.valueOf(object.getMaC());
    }

    @Override
    public Ca parse(String maC, Locale locale) throws ParseException {
        Ca c = new Ca();
        c.setMaC(Integer.parseInt(maC));
        
        return c;
    }
    
}
