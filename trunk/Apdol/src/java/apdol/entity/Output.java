/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.entity;

import apdol.model.DaftarOutput;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.JOptionPane;

/**
 *
 * @author Hari RZ
 */
@Entity
public class Output implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String kodeOutput;
    private String namaOutput;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKodeOutput() {
        return kodeOutput;
    }

    public void setKodeOutput(String kodeOutput) {
        this.kodeOutput = kodeOutput;
    }

    public String getNamaOutput() {
        return namaOutput;
    }

    public void setNamaOutput(String namaOutput) {
        this.namaOutput = namaOutput;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "apdol.entity.Output[ id=" + id + " ]";
    }
    
    public boolean isKodeNoChange(String kode) {
        if (kode.equalsIgnoreCase(this.kodeOutput)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isNamaNoChange(String nama) {
        if (nama.equalsIgnoreCase(this.namaOutput)) {
            return true;
        } else {
            return false;
        }
    }

}
