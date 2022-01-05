/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.dieukhien;

import com.nmt.csdl.GioHang;
import com.nmt.csdl.LoaiSanh;
import com.nmt.dichvu.DichVuCa;
import com.nmt.dichvu.DichVuLoaiSanh;
import com.nmt.dichvu.DichVuSanhCuoi;
import com.nmt.tienich.TienIch;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author hp
 */
@Controller
@ControllerAdvice
public class BoDieuKhienGoc {

    @Autowired
    private DichVuLoaiSanh dichVuLoaiSanh;
    
    @Autowired
    private DichVuCa dichVuCa;
    
    @Autowired
    private DichVuSanhCuoi dichVuSanhCuoi;
    
    @ModelAttribute
    public void commonAttr(Model model, HttpSession session){
        model.addAttribute("loaisanhs", this.dichVuLoaiSanh.getLoaiSanhs());
        model.addAttribute("cartCounter", TienIch.demGioHang((Map<Integer, GioHang>) session.getAttribute("giohang")));
        model.addAttribute("nguoiDungHienTai", session.getAttribute("nguoiDungHienTai"));
        model.addAttribute("cas", this.dichVuCa.getCas());
    }
    
    @RequestMapping("/")
    public String index(Model model, @RequestParam(required = false) Map<String, String> params, HttpSession session){
        
        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        
        String maLS = params.get("MaLS");
        if(maLS == null){
            model.addAttribute("sanhcuois", this.dichVuSanhCuoi.getSanhCuois(kw, page));
        }
        else{
            LoaiSanh ls = this.dichVuLoaiSanh.getLoaiSanhTheoMa(Integer.parseInt(maLS));
            model.addAttribute("sanhcuois", ls.getSanhCuois());
        }
            
        model.addAttribute("counter", this.dichVuSanhCuoi.demSanhCuoi());
        
        return "index";
    }
}
