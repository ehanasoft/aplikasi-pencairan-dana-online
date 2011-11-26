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
public class BankPos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String kdbankpos;
    private String nmbankpos;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKdbankpos() {
        return kdbankpos;
    }

    public void setKdbankpos(String kdbankpos) {
        this.kdbankpos = kdbankpos;
    }

    public String getNmbankpos() {
        return nmbankpos;
    }

    public void setNmbankpos(String nmbankpos) {
        this.nmbankpos = nmbankpos;
    }    

    @Override
    public String toString() {
        return "apdol.entity.BankPos[ id=" + id + " ]";
    }
    
    public boolean isKodeNoChange(String kode) {
        if (kode.equalsIgnoreCase(this.kdbankpos)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isNamaNoChange(String nama) {
        if (nama.equalsIgnoreCase(this.nmbankpos)) {
            return true;
        } else {
            return false;
        }
    }
    
}
