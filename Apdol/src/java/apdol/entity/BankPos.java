/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.entity;

import apdol.model.DaftarBankPos;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
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
        if (!(object instanceof BankPos)) {
            return false;
        }
        BankPos other = (BankPos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apdol.entity.BankPos[ id=" + id + " ]";
    }
    
    public boolean valKodeBank() {
        DaftarBankPos daftarBank = new DaftarBankPos();
        List<BankPos> listBank = daftarBank.getBankPos();
        Iterator<BankPos> iterator = listBank.iterator();
        BankPos tes = new BankPos();

        while (iterator.hasNext()) {
            tes = iterator.next();
            if (tes.kdbankpos.equalsIgnoreCase(this.kdbankpos)) {
                return true;
            }
        }
        return false;
    }

    public boolean valNamaBank() {
        DaftarBankPos daftarBank = new DaftarBankPos();
        List<BankPos> listBank = daftarBank.getBankPos();
        Iterator<BankPos> iterator = listBank.iterator();
        BankPos tes = new BankPos();

        while (iterator.hasNext()) {
            tes = iterator.next();
            if (tes.nmbankpos.equalsIgnoreCase(this.nmbankpos)) {
                return true;
            }
        }
        return false;
    }

    public boolean valNumber(String kode) {
        try {
            int i = Integer.parseInt(kode);
            if (i > 0) {
                return true;
            } return false;
        } catch (Exception e) {
            return false;
        }
    }
    
}
