/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.csdl;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "loaisanh")
public class LoaiSanh implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaLS")
    private Integer maLS;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TenLS")
    private String tenLS;
    @Lob
    @Size(max = 65535)
    @Column(name = "MoTa")
    private String moTa;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "loaisanh")
    private Collection<SanhCuoi> scs;

    public LoaiSanh() {
    }

    public LoaiSanh(Integer maLS) {
        this.maLS = maLS;
    }

    public LoaiSanh(Integer maLS, String tenLS) {
        this.maLS = maLS;
        this.tenLS = tenLS;
    }

    public Integer getMaLS() {
        return maLS;
    }

    public void setMaLS(Integer maLS) {
        this.maLS = maLS;
    }

    public String getTenLS() {
        return tenLS;
    }

    public void setTenLS(String tenLS) {
        this.tenLS = tenLS;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @XmlTransient
    public Collection<SanhCuoi> getSanhCuois() {
        return scs;
    }

    public void setSanhCuois(Collection<SanhCuoi> sanhCuois) {
        this.scs = sanhCuois;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maLS != null ? maLS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoaiSanh)) {
            return false;
        }
        LoaiSanh other = (LoaiSanh) object;
        if ((this.maLS == null && other.maLS != null) || (this.maLS != null && !this.maLS.equals(other.maLS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nmt.csdl.LoaiSanh[ maLS=" + maLS + " ]";
    }
    
}
