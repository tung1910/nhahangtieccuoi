/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.dieukhien;

import com.nmt.dichvu.DichVuThongKe;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author hp
 */
@Controller
@RequestMapping("/admin")
public class BoDieuKhienAdmin {
    
    @Autowired
    private DichVuThongKe dichVuThongKe;
    
    @GetMapping("/thongke-loaisanh")
    public String thongKeLoai(Model model){
    
        model.addAttribute("thongKeLoai", this.dichVuThongKe.thongKeLoai());
        
        return "thongke-loaisanh";
    }
    
    @GetMapping("/thongke-sanhcuoi")
    public String thongKeSanPham(Model model, @RequestParam(required = false) Map<String, String> params) throws ParseException{
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String kw = params.getOrDefault("kw", null);
        
        Date fromDate = null, toDate = null;
        
        try {
            String from = params.getOrDefault("fromDate", null);
            if(from != null)
                fromDate = f.parse(from);
        
            String to = params.getOrDefault("toDate", null);
            if(to != null)
                toDate = f.parse(to);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        model.addAttribute("thongKeSanhCuoi", this.dichVuThongKe.thongKeSanhCuoi(kw, fromDate, toDate));
        
        return "thongke-sanhcuoi";
    }
    
    @GetMapping("/thongke-sanhcuoi-theothang")
    public String tkSanPhamThang(Model model, @RequestParam(required = false) Map<String, String> params){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String kw = params.getOrDefault("kw", null);
        
        Date fromDate = null, toDate = null;
        
        try {
            String from = params.getOrDefault("fromDate", null);
            if(from != null)
                fromDate = f.parse(from);
        
            String to = params.getOrDefault("toDate", null);
            if(to != null)
                toDate = f.parse(to);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        model.addAttribute("tkSanhCuoiThang", this.dichVuThongKe.tkeSanhCuoiThang(kw, fromDate, toDate));

        return "thongke-sanhcuoi-theothang";
    }
}
