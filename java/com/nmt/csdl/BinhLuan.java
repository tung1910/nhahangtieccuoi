/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.csdl;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "binhluan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BinhLuan.findAll", query = "SELECT b FROM BinhLuan b"),
    @NamedQuery(name = "BinhLuan.findByMaBL", query = "SELECT b FROM BinhLuan b WHERE b.maBL = :maBL"),
    @NamedQuery(name = "BinhLuan.findByBinhLuan", query = "SELECT b FROM BinhLuan b WHERE b.binhLuan = :binhLuan"),
    @NamedQuery(name = "BinhLuan.findByNgayDang", query = "SELECT b FROM BinhLuan b WHERE b.ngayDang = :ngayDang")})
public class BinhLuan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaBL")
    private Integer maBL;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 700)
    @Column(name = "BinhLuan")
    private String binhLuan;
    @Column(name = "NgayDang")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayDang;
    @JoinColumn(name = "MaSC", referencedColumnName = "MaSC")
    @ManyToOne(optional = false)
    private SanhCuoi sanhcuoi;
    @JoinColumn(name = "MaTK", referencedColumnName = "MaTK")
    @ManyToOne(optional = false)
    private TaiKhoan taikhoan;

    public BinhLuan() {
    }

    public BinhLuan(Integer maBL) {
        this.maBL = maBL;
    }

    public BinhLuan(Integer maBL, String binhLuan) {
        this.maBL = maBL;
        this.binhLuan = binhLuan;
    }

    public Integer getMaBL() {
        return maBL;
    }

    public void setMaBL(Integer maBL) {
        this.maBL = maBL;
    }

    public String getBinhLuan() {
        return binhLuan;
    }

    public void setBinhLuan(String binhLuan) {
        this.binhLuan = binhLuan;
    }

    public Date getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(Date ngayDang) {
        this.ngayDang = ngayDang;
    }

    public SanhCuoi getMaSC() {
        return sanhcuoi;
    }

    public void setMaSC(SanhCuoi maSC) {
        this.sanhcuoi = maSC;
    }

    public TaiKhoan getMaTK() {
        return taikhoan;
    }

    public void setMaTK(TaiKhoan maTK) {
        this.taikhoan = maTK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maBL != null ? maBL.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BinhLuan)) {
            return false;
        }
        BinhLuan other = (BinhLuan) object;
        if ((this.maBL == null && other.maBL != null) || (this.maBL != null && !this.maBL.equals(other.maBL))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nmt.csdl.BinhLuan[ maBL=" + maBL + " ]";
    }
    
}
