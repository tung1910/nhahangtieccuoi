/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.csdl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "taikhoan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaiKhoan.findAll", query = "SELECT t FROM TaiKhoan t"),
    @NamedQuery(name = "TaiKhoan.findByMaTK", query = "SELECT t FROM TaiKhoan t WHERE t.maTK = :maTK"),
    @NamedQuery(name = "TaiKhoan.findByHoTen", query = "SELECT t FROM TaiKhoan t WHERE t.hoTen = :hoTen"),
    @NamedQuery(name = "TaiKhoan.findByTenDN", query = "SELECT t FROM TaiKhoan t WHERE t.tenDN = :tenDN"),
    @NamedQuery(name = "TaiKhoan.findByMatKhau", query = "SELECT t FROM TaiKhoan t WHERE t.matKhau = :matKhau"),
    @NamedQuery(name = "TaiKhoan.findByDThoai", query = "SELECT t FROM TaiKhoan t WHERE t.dThoai = :dThoai"),
    @NamedQuery(name = "TaiKhoan.findByEmail", query = "SELECT t FROM TaiKhoan t WHERE t.email = :email"),
    @NamedQuery(name = "TaiKhoan.findByHinhDD", query = "SELECT t FROM TaiKhoan t WHERE t.hinhDD = :hinhDD"),
    @NamedQuery(name = "TaiKhoan.findByLoaiTK", query = "SELECT t FROM TaiKhoan t WHERE t.loaiTK = :loaiTK")})
public class TaiKhoan implements Serializable {

    public static final String ADMIN = "ROLE_ADMIN";
    public static final String USER = "ROLE_USER";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaTK")
    private Integer maTK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "HoTen")
    private String hoTen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "TenDN")
    private String tenDN;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "MatKhau")
    private String matKhau;
    @Transient
    @JsonIgnore
    private String xacNhanMK;
    @Size(max = 25)
    @Column(name = "DThoai")
    private String dThoai;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Email")
    private String email;
    @Size(max = 500)
    @Column(name = "HinhDD")
    private String hinhDD;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "LoaiTK")
    private String loaiTK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taikhoan")
    private Collection<BinhLuan> bls;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taikhoan")
    private Collection<HoaDon> hds;
    @Transient
    @JsonIgnore
    private MultipartFile file;

    public TaiKhoan() {
    }

    public TaiKhoan(Integer maTK) {
        this.maTK = maTK;
    }

    public TaiKhoan(Integer maTK, String hoTen, String tenDN, String matKhau, String email, String loaiTK) {
        this.maTK = maTK;
        this.hoTen = hoTen;
        this.tenDN = tenDN;
        this.matKhau = matKhau;
        this.email = email;
        this.loaiTK = loaiTK;
    }

    public Integer getMaTK() {
        return maTK;
    }

    public void setMaTK(Integer maTK) {
        this.maTK = maTK;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getTenDN() {
        return tenDN;
    }

    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getDThoai() {
        return dThoai;
    }

    public void setDThoai(String dThoai) {
        this.dThoai = dThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHinhDD() {
        return hinhDD;
    }

    public void setHinhDD(String hinhDD) {
        this.hinhDD = hinhDD;
    }

    public String getLoaiTK() {
        return loaiTK;
    }

    public void setLoaiTK(String loaiTK) {
        this.loaiTK = loaiTK;
    }

    @XmlTransient
    public Collection<BinhLuan> getBls() {
        return bls;
    }

    public void setBls(Collection<BinhLuan> bls) {
        this.bls = bls;
    }

    @XmlTransient
    public Collection<HoaDon> getHds() {
        return hds;
    }

    public void setHds(Collection<HoaDon> hds) {
        this.hds = hds;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maTK != null ? maTK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaiKhoan)) {
            return false;
        }
        TaiKhoan other = (TaiKhoan) object;
        if ((this.maTK == null && other.maTK != null) || (this.maTK != null && !this.maTK.equals(other.maTK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nmt.csdl.TaiKhoan[ maTK=" + maTK + " ]";
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

    /**
     * @return the xacNhanMK
     */
    public String getXacNhanMK() {
        return xacNhanMK;
    }

    /**
     * @param xacNhanMK the xacNhanMK to set
     */
    public void setXacNhanMK(String xacNhanMK) {
        this.xacNhanMK = xacNhanMK;
    }
    
}
