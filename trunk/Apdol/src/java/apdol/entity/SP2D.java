/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Accio
 */
@Entity
public class SP2D implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tanggalSP2D;

    public String getNomorSP2D() {
        return nomorSP2D;
    }

    public void setNomorSP2D(String nomorSP2D) {
        this.nomorSP2D = nomorSP2D;
    }

    public Date getTanggalSP2D() {
        return tanggalSP2D;
    }

    public void setTanggalSP2D(Date tanggalSP2D) {
        this.tanggalSP2D = tanggalSP2D;
    }
    private String nomorSP2D;

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
        if (!(object instanceof SP2D)) {
            return false;
        }
        SP2D other = (SP2D) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apdol.entity.SP2D[ id=" + id + " ]";
    }
    
}
