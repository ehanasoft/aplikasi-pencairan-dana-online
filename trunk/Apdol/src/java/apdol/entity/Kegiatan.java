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
public class Kegiatan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String kdgiat;
    private String nmgiat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getKdgiat() {
        return kdgiat;
    }

    public void setKdgiat(String kdgiat) {
        this.kdgiat = kdgiat;
    }

    public String getNmgiat() {
        return nmgiat;
    }

    public void setNmgiat(String nmgiat) {
        this.nmgiat = nmgiat;
    }

    @Override
    public String toString() {
        return "apdol.entity.Kegiatan[ id=" + id + " ]";
    }
    public boolean isKodeNoChange(String kode) {
        if (kode.equalsIgnoreCase(this.kdgiat)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isNamaNoChange(String nama) {
        if (nama.equalsIgnoreCase(this.nmgiat)) {
            return true;
        } else {
            return false;
        }
    }
    
}
