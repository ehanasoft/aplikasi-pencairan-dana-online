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
import javax.persistence.ManyToOne;

/**
 *
 * @author wahid
 */
@Entity
public class Dipa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomorDipa;
    private String pagu;
    private String realisasi;
    private String sisaDana;
    @ManyToOne
    private RincianKegiatan rincianKegiatan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomorDipa() {
        return nomorDipa;
    }

    public void setNomorDipa(String nomorDipa) {
        this.nomorDipa = nomorDipa;
    }

    public String getPagu() {
        return pagu;
    }

    public void setPagu(String pagu) {
        this.pagu = pagu;
    }

    public String getRealisasi() {
        return realisasi;
    }

    public void setRealisasi(String realisasi) {
        this.realisasi = realisasi;
    }

    public String getSisaDana() {
        return sisaDana;
    }

    public void setSisaDana(String sisaDana) {
        this.sisaDana = sisaDana;
    }

    public RincianKegiatan getRincianKegiatan() {
        return rincianKegiatan;
    }

    public void setRincianKegiatan(RincianKegiatan rincianKegiatan) {
        this.rincianKegiatan = rincianKegiatan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

   
@Override
        public String toString() {
        return "apdol.entity.Dipa[ id=" + id + " ]";
    }
}
