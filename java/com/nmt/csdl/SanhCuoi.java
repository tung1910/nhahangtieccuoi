/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.csdl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "sanhcuoi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SanhCuoi.findAll", query = "SELECT s FROM SanhCuoi s"),
    @NamedQuery(name = "SanhCuoi.findByMaSC", query = "SELECT s FROM SanhCuoi s WHERE s.maSC = :maSC"),
    @NamedQuery(name = "SanhCuoi.findByTenSC", query = "SELECT s FROM SanhCuoi s WHERE s.tenSC = :tenSC"),
    @NamedQuery(name = "SanhCuoi.findByDonGia", query = "SELECT s FROM SanhCuoi s WHERE s.donGia = :donGia"),
    @NamedQuery(name = "SanhCuoi.findByNgayToChuc", query = "SELECT s FROM SanhCuoi s WHERE s.ngayToChuc = :ngayToChuc"),
    @NamedQuery(name = "SanhCuoi.findByNgayTao", query = "SELECT s FROM SanhCuoi s WHERE s.ngayTao = :ngayTao"),
    @NamedQuery(name = "SanhCuoi.findByHinhSC", query = "SELECT s FROM SanhCuoi s WHERE s.hinhSC = :hinhSC"),
    @NamedQuery(name = "SanhCuoi.findByMoTa", query = "SELECT s FROM SanhCuoi s WHERE s.moTa = :moTa"),
    @NamedQuery(name = "SanhCuoi.findByDienTich", query = "SELECT s FROM SanhCuoi s WHERE s.dienTich = :dienTich"),
    @NamedQuery(name = "SanhCuoi.findByHoTro", query = "SELECT s FROM SanhCuoi s WHERE s.hoTro = :hoTro"),
    @NamedQuery(name = "SanhCuoi.findBySoBan", query = "SELECT s FROM SanhCuoi s WHERE s.soBan = :soBan")})
public class SanhCuoi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaSC")
    private Integer maSC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TenSC")
    private String tenSC;
    @Column(name = "DonGia")
    private Long donGia;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "NgayToChuc")
    private String ngayToChuc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NgayTao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao;
    @Size(max = 500)
    @Column(name = "HinhSC")
    private String hinhSC;
    @Size(max = 500)
    @Column(name = "MoTa")
    private String moTa;
    @Size(max = 100)
    @Column(name = "DienTich")
    private String dienTich;
    @Size(max = 100)
    @Column(name = "HoTro")
    private String hoTro;
    @Size(max = 100)
    @Column(name = "SoBan")
    private String soBan;   
    @JoinColumn(name = "MaC", referencedColumnName = "MaC")
    @ManyToOne(optional = false)
    @NotNull
    private Ca ca;
    @JoinColumn(name = "MaLS", referencedColumnName = "MaLS")
    @ManyToOne(optional = false)
    @NotNull
    private LoaiSanh loaisanh;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sanhcuoi")
    private Collection<ChiTietHoaDon> cthds;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sanhcuoi", fetch = FetchType.EAGER)
    private Collection<BinhLuan> bls;
    @Transient
    private MultipartFile file;

    public SanhCuoi() {
    }

    public SanhCuoi(Integer maSC) {
        this.maSC = maSC;
    }

    public SanhCuoi(Integer maSC, String tenSC) {
        this.maSC = maSC;
        this.tenSC = tenSC;
    }

    public Integer getMaSC() {
        return maSC;
    }

    public void setMaSC(Integer maSC) {
        this.maSC = maSC;
    }

    public String getTenSC() {
        return tenSC;
    }

    public void setTenSC(String tenSC) {
        this.tenSC = tenSC;
    }

    public Long getDonGia() {
        return donGia;
    }

    public void setDonGia(Long donGia) {
        this.donGia = donGia;
    }

    public String getNgayToChuc() {
        return ngayToChuc;
    }

    public void setNgayToChuc(String ngayToChuc) {
        this.ngayToChuc = ngayToChuc;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getHinhSC() {
        return hinhSC;
    }

    public void setHinhSC(String hinhSC) {
        this.hinhSC = hinhSC;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getDienTich() {
        return dienTich;
    }

    public void setDienTich(String dienTich) {
        this.dienTich = dienTich;
    }

    public String getHoTro() {
        return hoTro;
    }

    public void setHoTro(String hoTro) {
        this.hoTro = hoTro;
    }

    public String getSoBan() {
        return soBan;
    }

    public void setSoBan(String soBan) {
        this.soBan = soBan;
    }
    /**
     * @return the ca
     */
    public Ca getCa() {
        return ca;
    }

    /**
     * @param ca the ca to set
     */
    public void setCa(Ca ca) {
        this.ca = ca;
    }

    /**
     * @return the loaisanh
     */
    public LoaiSanh getLoaisanh() {
        return loaisanh;
    }

    /**
     * @param loaisanh the loaisanh to set
     */
    public void setLoaisanh(LoaiSanh loaisanh) {
        this.loaisanh = loaisanh;
    }

    /**
     * @return the cthds
     */
    public Collection<ChiTietHoaDon> getCthds() {
        return cthds;
    }

    /**
     * @param cthds the cthds to set
     */
    public void setCthds(Collection<ChiTietHoaDon> cthds) {
        this.cthds = cthds;
    }

    /**
     * @return the bls
     */
    public Collection<BinhLuan> getBls() {
        return bls;
    }

    /**
     * @param bls the bls to set
     */
    public void setBls(Collection<BinhLuan> bls) {
        this.bls = bls;
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maSC != null ? maSC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SanhCuoi)) {
            return false;
        }
        SanhCuoi other = (SanhCuoi) object;
        if ((this.maSC == null && other.maSC != null) || (this.maSC != null && !this.maSC.equals(other.maSC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nmt.csdl.SanhCuoi[ maSC=" + maSC + " ]";
    }
    
}
