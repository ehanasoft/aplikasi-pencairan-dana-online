/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.entity;

import apdol.model.DaftarMataAnggaran;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Hari RZ
 */
@Entity
public class MataAnggaran implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String kodeMataAnggaran;
    private String namaBKPK;
    private String namaMataAnggaran;

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
    public boolean valKodeMataAnggaran(String def) {
        DaftarMataAnggaran daftarMA = new DaftarMataAnggaran();
        List<MataAnggaran> listMA = daftarMA.getMataAnggaran();
        Iterator<MataAnggaran> iterator = listMA.iterator();
        MataAnggaran tes = new MataAnggaran();

        while (iterator.hasNext()) {
            tes = iterator.next();
            if (def.equalsIgnoreCase(tes.kodeMataAnggaran)) {
                //validate if user doesn't change the field
                if (def.equalsIgnoreCase(this.kodeMataAnggaran)) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean valNamaMataAnggaran(String def) {
        DaftarMataAnggaran daftarMA = new DaftarMataAnggaran();
        List<MataAnggaran> listMA = daftarMA.getMataAnggaran();
        Iterator<MataAnggaran> iterator = listMA.iterator();
        MataAnggaran tes = new MataAnggaran();

        while (iterator.hasNext()) {
            tes = iterator.next();
            if (def.equalsIgnoreCase(tes.namaMataAnggaran)) {
                //validate if user doesn't change the field
                if (def.equalsIgnoreCase(this.namaMataAnggaran)) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean valNumber(String kode) {
        try {
            int i = Integer.parseInt(kode);
            //validate minus input
            if (i > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "apdol.entity.MataAnggaran[ id=" + id + " ]";
    }

    public String getKodeMataAnggaran() {
        return kodeMataAnggaran;
    }

    public void setKodeMataAnggaran(String kode) {
        this.kodeMataAnggaran = kode;
    }

    public String getNamaMataAnggaran() {
        return namaMataAnggaran;
    }

    public void setNamaMataAnggaran(String nama) {
        this.namaMataAnggaran = nama;
    }

    public String getNamaBKPK() {
        return namaBKPK;
    }

    public void setNamaBKPK(String nama) {
        this.namaBKPK = nama;
    }
}
