/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.csdl;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "chitiethoadon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChiTietHoaDon.findAll", query = "SELECT c FROM ChiTietHoaDon c"),
    @NamedQuery(name = "ChiTietHoaDon.findByMaCT", query = "SELECT c FROM ChiTietHoaDon c WHERE c.maCT = :maCT"),
    @NamedQuery(name = "ChiTietHoaDon.findBySoLuongDatBan", query = "SELECT c FROM ChiTietHoaDon c WHERE c.soLuongDatBan = :soLuongDatBan"),
    @NamedQuery(name = "ChiTietHoaDon.findByDonGia", query = "SELECT c FROM ChiTietHoaDon c WHERE c.donGia = :donGia")})
public class ChiTietHoaDon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaCT")
    private Integer maCT;
    @Column(name = "SoLuongDatBan")
    private Integer soLuongDatBan;
    @Column(name = "DonGia")
    private Long donGia;
    @JoinColumn(name = "MaHD", referencedColumnName = "MaHD")
    @ManyToOne(optional = false)
    private HoaDon hoadon;
    @JoinColumn(name = "MaSC", referencedColumnName = "MaSC")
    @ManyToOne(optional = false)
    private SanhCuoi sanhcuoi;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(Integer maCT) {
        this.maCT = maCT;
    }

    public Integer getMaCT() {
        return maCT;
    }

    public void setMaCT(Integer maCT) {
        this.maCT = maCT;
    }

    public Integer getSoLuongDatBan() {
        return soLuongDatBan;
    }

    public void setSoLuongDatBan(Integer soLuongDatBan) {
        this.soLuongDatBan = soLuongDatBan;
    }

    public Long getDonGia() {
        return donGia;
    }

    public void setDonGia(Long donGia) {
        this.donGia = donGia;
    }

    public HoaDon getMaHD() {
        return hoadon;
    }

    public void setMaHD(HoaDon maHD) {
        this.hoadon = maHD;
    }

    public SanhCuoi getMaSC() {
        return sanhcuoi;
    }

    public void setMaSC(SanhCuoi maSC) {
        this.sanhcuoi = maSC;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maCT != null ? maCT.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiTietHoaDon)) {
            return false;
        }
        ChiTietHoaDon other = (ChiTietHoaDon) object;
        if ((this.maCT == null && other.maCT != null) || (this.maCT != null && !this.maCT.equals(other.maCT))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nmt.csdl.ChiTietHoaDon[ maCT=" + maCT + " ]";
    }
    
}
