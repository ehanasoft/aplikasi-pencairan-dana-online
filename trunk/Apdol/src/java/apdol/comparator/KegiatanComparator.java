/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.comparator;

import apdol.entity.Kegiatan;
import java.util.Comparator;

/**
 *
 * @author AlfieSaHid
 */
public class KegiatanComparator implements Comparator<Kegiatan> {

    @Override
    public int compare(Kegiatan kegiatan1, Kegiatan kegiatan2) {
        int kode = kegiatan1.getKdgiat().compareTo(kegiatan2.getKdgiat());
        return kode;
    }
    
}
