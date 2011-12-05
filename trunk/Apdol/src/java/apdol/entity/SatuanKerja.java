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
    private Lokasi kodeLokasi;

    public String getKodeDept() {
        return kodeDept;
    }

    public void setKodeDept(String kodeDept) {
        this.kodeDept = kodeDept;
    }

    public Lokasi getKodeLokasi() {
        return kodeLokasi;
    }

    public void setKodeLokasi(Lokasi kodeLokasi) {
        this.kodeLokasi = kodeLokasi;
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
    
}
