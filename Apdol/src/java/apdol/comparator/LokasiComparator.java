/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.comparator;

import apdol.entity.Lokasi;
import java.util.Comparator;

/**
 *
 * @author Hari RZ
 */
public class LokasiComparator implements Comparator<Lokasi> {

    @Override
    public int compare(Lokasi lokasi1, Lokasi lokasi2) {
        int kode = lokasi1.getKodeLokasi().compareTo(lokasi2.getKodeLokasi());
        return kode;
    }
}
