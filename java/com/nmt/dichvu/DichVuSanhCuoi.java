/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.dichvu;

import com.nmt.csdl.SanhCuoi;
import java.util.List;

/**
 *
 * @author hp
 */
public interface DichVuSanhCuoi {
    List<SanhCuoi> getSanhCuois(String kw, int page);
    long demSanhCuoi();
    boolean addOrUpdate(SanhCuoi sanhCuoi);
    SanhCuoi getSanhCuoiTheoMa(int maSC);
}
