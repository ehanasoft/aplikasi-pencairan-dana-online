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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Accio
 */
@Entity
public class SatuanKerja implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String kodeSatker;
    private String kodeUnit;
    private String kodeDept;
    private String namaSatker;
    private String namaDept;
    private String namaUnit;
    @ManyToOne
    @JoinColumn(name="kodeLokasi")
    private Lokasi lokasi;

    public Lokasi getLokasi() {
        return lokasi;
    }

    public void setLokasi(Lokasi lokasi) {
        this.lokasi = lokasi;
    }

    public String getNamaDept() {
        return namaDept;
    }

    public void setNamaDept(String namaDept) {
        this.namaDept = namaDept;
    }

    public String getNamaUnit() {
        return namaUnit;
    }

    public void setNamaUnit(String namaUnit) {
        this.namaUnit = namaUnit;
    }

    
    public String getNamaSatker() {
        return namaSatker;
    }

    public void setNamaSatker(String namaSatker) {
        this.namaSatker = namaSatker;
    }


    public String getKodeDept() {
        return kodeDept;
    }

    public void setKodeDept(String kodeDept) {
        this.kodeDept = kodeDept;
    }

    public String getKodeSatker() {
        return kodeSatker;
    }

    public void setKodeSatker(String kodeSatker) {
        this.kodeSatker = kodeSatker;
    }

    public String getKodeUnit() {
        return kodeUnit;
    }

    public void setKodeUnit(String kodeUnit) {
        this.kodeUnit = kodeUnit;
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
        if (!(object instanceof SatuanKerja)) {
            return false;
        }
        SatuanKerja other = (SatuanKerja) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apdol.entity.SatuanKerja[ id=" + id + " ]";
    }
    public boolean isKodeNoChange(String kode) {
        if (kode.equalsIgnoreCase(this.kodeSatker)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isNamaSatkerNoChange(String nama) {
        if (nama.equalsIgnoreCase(this.namaSatker)) {
            return true;
        } else {
            return false;
        }
    }    
}
