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
    private String nomorSpm;
    private String statusSpm;
    private String keteranganNotifikasi;
    private String nomorPembatalan;
    private String nomorTolak;
    private String keteranganTolak;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tanggalTerima;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tanggalTolak;

    public String getKeteranganTolak() {
        return keteranganTolak;
    }

    public void setKeteranganTolak(String keteranganTolak) {
        this.keteranganTolak = keteranganTolak;
    }

    public String getNomorTolak() {
        return nomorTolak;
    }

    public void setNomorTolak(String nomorTolak) {
        this.nomorTolak = nomorTolak;
    }

    public Date getTanggalTolak() {
        return tanggalTolak;
    }

    public void setTanggalTolak(Date tanggalTolak) {
        this.tanggalTolak = tanggalTolak;
    }

    public String getKeteranganNotifikasi() {
        return keteranganNotifikasi;
    }

    public void setKeteranganNotifikasi(String keteranganNotifikasi) {
        this.keteranganNotifikasi = keteranganNotifikasi;
    }

    public String getStatusSpm() {
        return statusSpm;
    }

    public void setStatusSpm(String statusSpm) {
        this.statusSpm = statusSpm;
    }

    public String getNomorPembatalan() {
        return nomorPembatalan;
    }

    public void setNomorPembatalan(String nomorPembatalan) {
        this.nomorPembatalan = nomorPembatalan;
    }

    public Date getTanggalTerima() {
        return tanggalTerima;
    }

    public void setTanggalTerima(Date tanggalTerima) {
        this.tanggalTerima = tanggalTerima;
    }

    public String getNomorSpm() {
        return nomorSpm;
    }

    public void setNomorSpm(String nomorSpm) {
        this.nomorSpm = nomorSpm;
    }
     
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

    public void kurangiDipa () {
        DaftarDipa daftarDipa = new DaftarDipa();
        Dipa dipa = daftarDipa.findDipaByRincianKegiatan(this.rincianKegiatan);
        BigInteger nilaiSpm = new BigInteger(this.jumlahKeluar);
        BigInteger iReal = new BigInteger(dipa.getRealisasi());
        BigInteger totalReal = iReal.add(nilaiSpm);
        dipa.setRealisasi(totalReal.toString());
        dipa.setSisaDana();
        daftarDipa.edit(dipa);
    }
    public void tambahiDipa () {
        DaftarDipa daftarDipa = new DaftarDipa();
        Dipa dipa = daftarDipa.findDipaByRincianKegiatan(this.rincianKegiatan);
        BigInteger nilaiSpm = new BigInteger(this.jumlahKeluar);
        BigInteger iReal = new BigInteger(dipa.getRealisasi());
        BigInteger totalReal = iReal.subtract(nilaiSpm);
        dipa.setRealisasi(totalReal.toString());
        dipa.setSisaDana();
        daftarDipa.edit(dipa);
    }
}
