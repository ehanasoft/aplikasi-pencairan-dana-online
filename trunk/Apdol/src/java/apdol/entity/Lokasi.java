/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.entity;

import apdol.model.DaftarLokasi;
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
public class Lokasi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String kodeLokasi;
    private String namaPropinsi;
    private String namaKota;

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

    /*@Override
    public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Lokasi)) {
    return false;
    }
    Lokasi other = (Lokasi) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
    return false;
    }
    return true;
    }*/
    public boolean valKodeLokasi() {
        DaftarLokasi daftarLokasi = new DaftarLokasi();
        List<Lokasi> listLokasi = daftarLokasi.getLokasi();
        Iterator<Lokasi> iterator = listLokasi.iterator();
        Lokasi tes = new Lokasi();

        while (iterator.hasNext()) {
            tes = iterator.next();
            if (tes.kodeLokasi.equalsIgnoreCase(this.kodeLokasi)) {
                return true;
            }
        }
        return false;
    }

    public boolean valNamaKota() {
        DaftarLokasi daftarLokasi = new DaftarLokasi();
        List<Lokasi> listLokasi = daftarLokasi.getLokasi();
        Iterator<Lokasi> iterator = listLokasi.iterator();
        Lokasi tes = new Lokasi();

        while (iterator.hasNext()) {
            tes = iterator.next();
            if (tes.namaKota.equalsIgnoreCase(this.namaKota)) {
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

    @Override
    public String toString() {
        return "apdol.entity.Lokasi[ id=" + id + " ]";
    }

    public String getKodeLokasi() {
        return kodeLokasi;
    }

    public void setKodeLokasi(String kodeLokasi) {
        this.kodeLokasi = kodeLokasi;
    }

    public String getNamaKota() {
        return namaKota;
    }

    public void setNamaKota(String namaKota) {
        this.namaKota = namaKota;
    }

    public String getNamaPropinsi() {
        return namaPropinsi;
    }

    public void setNamaPropinsi(String namaPropinsi) {
        this.namaPropinsi = namaPropinsi;
    }
}
