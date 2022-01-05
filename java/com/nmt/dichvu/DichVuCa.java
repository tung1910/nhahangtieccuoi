/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.dichvu;

import com.nmt.csdl.Ca;
import java.util.List;

/**
 *
 * @author hp
 */
public interface DichVuCa {
    List<Ca> getCas();
    Ca getCaTheoMa(int maC);
}
