/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.entity;

import apdol.model.DaftarKegiatan;
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
public class Kegiatan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String kdgiat;
    private String nmgiat;

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
        if (!(object instanceof Kegiatan)) {
            return false;
        }
        Kegiatan other = (Kegiatan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apdol.entity.Kegiatan[ id=" + id + " ]";
    }
    public boolean valKodeKegiatan(String def) {
        DaftarKegiatan daftarKegiatan = new DaftarKegiatan();
        List<Kegiatan> listKegiatan = daftarKegiatan.getKegiatan();
        Iterator<Kegiatan> iterator = listKegiatan.iterator();
        Kegiatan tes = new Kegiatan();

        while (iterator.hasNext()) {
            tes = iterator.next();
            if (def.equalsIgnoreCase(tes.kdgiat)) {
                //validate if user doesn't change the field
                if (def.equalsIgnoreCase(this.kdgiat)) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean valNamaKegiatan(String def) {
        DaftarKegiatan daftarKegiatan = new DaftarKegiatan();
        List<Kegiatan> listKegiatan = daftarKegiatan.getKegiatan();
        Iterator<Kegiatan> iterator = listKegiatan.iterator();
        Kegiatan tes = new Kegiatan();

        while (iterator.hasNext()) {
            tes = iterator.next();
            if (def.equalsIgnoreCase(tes.nmgiat)) {
                //validate if user doesn't change the field
                if (def.equalsIgnoreCase(this.nmgiat)) {
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
    
}
