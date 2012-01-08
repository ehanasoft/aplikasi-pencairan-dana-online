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
import javax.swing.JOptionPane;

/**
 *
 * @author wahid
 */
@Entity
public class RincianKegiatan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private SatuanKerja satker;
    @ManyToOne
    private Kegiatan kegiatan;
    @ManyToOne
    private Output output;
    @ManyToOne
    private MataAnggaran mataAnggaran;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SatuanKerja getSatker() {
        return satker;
    }

    public void setSatker(SatuanKerja satker) {
        this.satker = satker;
    }

    public Kegiatan getKegiatan() {
        return kegiatan;
    }

    public void setKegiatan(Kegiatan kegiatan) {
        this.kegiatan = kegiatan;
    }

    public MataAnggaran getMataAnggaran() {
        return mataAnggaran;
    }

    public void setMataAnggaran(MataAnggaran mataAnggaran) {
        this.mataAnggaran = mataAnggaran;
    }

    public Output getOutput() {
        return output;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "apdol.entity.RincianKegiatan[ id=" + id + " ]";
    }

    public boolean isRincianKegiatanNoChange(Kegiatan kegiatan,MataAnggaran mataAnggaran, Output output, SatuanKerja satker) {

        if (kegiatan.getKdgiat().equals(this.kegiatan.getKdgiat()) &&
                mataAnggaran.getKodeMataAnggaran().equals(this.mataAnggaran.getKodeMataAnggaran()) &&
                output.getKodeOutput().equals(this.getOutput().getKodeOutput()) &&
                satker.getKodeSatker().equals(this.satker.getKodeSatker())) {
            return true;
        } else {
            return false;
        }
    }
}
