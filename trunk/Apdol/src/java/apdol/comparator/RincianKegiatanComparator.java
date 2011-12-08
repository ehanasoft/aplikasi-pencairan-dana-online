/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.comparator;

import apdol.entity.RincianKegiatan;
import java.util.Comparator;

/**
 *
 * @author wahid
 */
public class RincianKegiatanComparator implements Comparator<RincianKegiatan> {

    @Override
    public int compare(RincianKegiatan rincianKegiatan1, RincianKegiatan rincianKegiatan2) {
        int nomor = rincianKegiatan1.getId().compareTo(rincianKegiatan2.getId());
        return nomor;
    }
}
