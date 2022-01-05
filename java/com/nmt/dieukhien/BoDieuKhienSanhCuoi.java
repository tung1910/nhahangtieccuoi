/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.dieukhien;

import com.nmt.csdl.SanhCuoi;
import com.nmt.dichvu.DichVuSanhCuoi;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author hp
 */
@Controller
public class BoDieuKhienSanhCuoi {
    
    @Autowired
    private DichVuSanhCuoi dichVuSanhCuoi;
    
    @GetMapping("/sanhcuois/{maSC}")
    public String detail(Model model, @PathVariable(value = "maSC") int maSC){
        model.addAttribute("sanhcuoi", this.dichVuSanhCuoi.getSanhCuoiTheoMa(maSC));
        
        return "chitietsanhcuoi";
    }
    
    @GetMapping("/admin/sanhcuois")
    public String List(Model model){
        model.addAttribute("sanhcuoi", new SanhCuoi());
        
        return "sanhcuoi";
    }
    
    @PostMapping("/admin/sanhcuois")
    public String add(Model model, @ModelAttribute(value = "sanhcuoi") @Valid SanhCuoi sanhCuoi, BindingResult result){
        
        if(!result.hasErrors()){
            if(this.dichVuSanhCuoi.addOrUpdate(sanhCuoi) == true)
                
                return "redirect:/";
            else
                model.addAttribute("errMsg", "Something wrong!!!");
        }
        
        return "sanhcuoi";
    }
}
