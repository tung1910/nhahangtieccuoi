/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.cauhinh.xuly;

import com.nmt.csdl.TaiKhoan;
import com.nmt.dichvu.DichVuTaiKhoan;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author hp
 */
@Component
public class TrinhXuLySauDangNhap implements AuthenticationSuccessHandler{

    @Autowired
    private DichVuTaiKhoan userDetailsService;
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication a) throws IOException, ServletException {
        TaiKhoan tk = this.userDetailsService.geTaiKhoans(a.getName()).get(0);
        request.getSession().setAttribute("nguoiDungHienTai", tk);
        
        response.sendRedirect("/NhaHangTiecCuoi");
    }
    
}
