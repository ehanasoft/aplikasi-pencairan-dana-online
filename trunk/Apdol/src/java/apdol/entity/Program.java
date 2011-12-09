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
public class Program implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String kdprogram;
    private String nmprogram;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKdprogram() {
        return kdprogram;
    }

    public void setKdprogram(String kdprogram) {
        this.kdprogram = kdprogram;
    }

    public String getNmprogram() {
        return nmprogram;
    }

    public void setNmprogram(String nmprogram) {
        this.nmprogram = nmprogram;
    }

    @Override
    public String toString() {
        return "apdol.entity.Program[ id=" + id + " ]";
    }
    public boolean isKodeNoChange(String kode) {
        if (kode.equalsIgnoreCase(this.kdprogram)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isNamaNoChange(String nama) {
        if (nama.equalsIgnoreCase(this.nmprogram)) {
            return true;
        } else {
            return false;
        }
    }
    
}
