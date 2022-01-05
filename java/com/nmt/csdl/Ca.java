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
@Table(name = "ca")
public class Ca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaC")
    private Integer maC;
    @Size(max = 45)
    @Column(name = "TenC")
    @NotNull
    private String tenC;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "ca")
    private Collection<SanhCuoi> scs;

    public Ca() {
    }

    public Ca(Integer maC) {
        this.maC = maC;
    }

    public Integer getMaC() {
        return maC;
    }

    public void setMaC(Integer maC) {
        this.maC = maC;
    }

    public String getTenC() {
        return tenC;
    }

    public void setTenC(String tenC) {
        this.tenC = tenC;
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
        hash += (maC != null ? maC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ca)) {
            return false;
        }
        Ca other = (Ca) object;
        if ((this.maC == null && other.maC != null) || (this.maC != null && !this.maC.equals(other.maC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nmt.csdl.Ca[ maC=" + maC + " ]";
    }
}
