/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.entity;

import apdol.model.DaftarDipa;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Accio
 */
@Entity
public class SPM implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tanggalSPM;
    @ManyToOne
    private RincianKegiatan rincianKegiatan;
    private String jumlahKeluar;
    private String jumlahPotongan;    
    private String jumlahBersih;
     
    public RincianKegiatan getRincianKegiatan() {
        return rincianKegiatan;
    }

    public void setRincianKegiatan(RincianKegiatan rincianKegiatan) {
        this.rincianKegiatan = rincianKegiatan;
    }
    
    public String getJumlahKeluar() {
        return jumlahKeluar;
    }

    public void setJumlahKeluar(String jumlahKeluar) {
        this.jumlahKeluar = jumlahKeluar;
    }

    public String getJumlahPotongan() {
        return jumlahPotongan;
    }

    public void setJumlahPotongan(String jumlahPotongan) {
        this.jumlahPotongan = jumlahPotongan;
    }
    
    public String getJumlahBersih() {
        return jumlahBersih;
    }

    public void setJumlahBersih() {
        BigInteger iKeluar = new BigInteger(this.jumlahKeluar);
        BigInteger iPotongan = new BigInteger(this.jumlahPotongan);
        BigInteger iBersih = iKeluar.subtract(iPotongan);
        this.jumlahBersih = iBersih.toString();
    }

    public Date getTanggalSPM() {
        return tanggalSPM;
    }

    public void setTanggalSPM(Date tanggalSPM) {
        this.tanggalSPM = tanggalSPM;
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
        if (!(object instanceof SPM)) {
            return false;
        }
        SPM other = (SPM) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apdol.entity.SPM[ id=" + id + " ]";
    }

 
    
    public void kurangiDipa (RincianKegiatan rincianKegiatan, String nilai) {
        DaftarDipa daftarDipa = new DaftarDipa();
        Dipa dipa = daftarDipa.findDipaByRincianKegiatan(rincianKegiatan);
        BigInteger nilaiSpm = new BigInteger(nilai);
        BigInteger iReal = new BigInteger(dipa.getRealisasi());
        BigInteger totalReal = iReal.add(nilaiSpm);
        dipa.setRealisasi(totalReal.toString());
        dipa.setSisaDana();
        daftarDipa.edit(dipa);
    }
    public void tambahiDipa (RincianKegiatan rincianKegiatan, String nilai) {
        DaftarDipa daftarDipa = new DaftarDipa();
        Dipa dipa = daftarDipa.findDipaByRincianKegiatan(rincianKegiatan);
        BigInteger nilaiSpm = new BigInteger(nilai);
        BigInteger iReal = new BigInteger(dipa.getRealisasi());
        BigInteger totalReal = iReal.subtract(nilaiSpm);
        dipa.setRealisasi(totalReal.toString());
        dipa.setSisaDana();
        daftarDipa.edit(dipa);
    }
}
