/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author AlfieSaHid
 */
@Entity
public class Pejabat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int nip;
    private String nama;
    private int kdgol;
    private String nmjabatan;
    private String ketjabatan;

    public int getKdgol() {
        return kdgol;
    }

    public void setKdgol(int kdgol) {
        this.kdgol = kdgol;
    }

    public String getKetjabatan() {
        return ketjabatan;
    }

    public void setKetjabatan(String ketjabatan) {
        this.ketjabatan = ketjabatan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }

    public String getNmjabatan() {
        return nmjabatan;
    }

    public void setNmjabatan(String nmjabatan) {
        this.nmjabatan = nmjabatan;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pejabat)) {
            return false;
        }
        Pejabat other = (Pejabat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apdol.entity.Pejabat[ id=" + id + " ]";
    }
    
}
