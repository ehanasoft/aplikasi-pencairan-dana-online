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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Hari RZ
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Output.findByKode", query = "SELECT l FROM Output l where l.kodeOutput like :kodeOutput"),})
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
