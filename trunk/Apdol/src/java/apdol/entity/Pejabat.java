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
import javax.persistence.ManyToOne;

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
    private String nip;
    private String nama;
    private String kdgol;
    private String nmjabatan;
    private String ketjabatan;
    @ManyToOne    
    private SatuanKerja satker;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKdgol() {
        return kdgol;
    }

    public void setKdgol(String kdgol) {
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

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNmjabatan() {
        return nmjabatan;
    }

    public void setNmjabatan(String nmjabatan) {
        this.nmjabatan = nmjabatan;
    }

    public SatuanKerja getSatker() {
        return satker;
    }

    public void setSatker(SatuanKerja satker) {
        this.satker = satker;
    }

    @Override
    public String toString() {
        return "apdol.entity.Pejabat[ id=" + id + " ]";
    }
    
    public boolean isKodeNoChange(String kode) {
        if (kode.equalsIgnoreCase(this.nip)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isNamaNoChange(String nama) {
        if (nama.equalsIgnoreCase(this.nama)) {
            return true;
        } else {
            return false;
        }
    }
    
}
