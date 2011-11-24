/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.comparator;

import apdol.entity.MataAnggaran;
import java.util.Comparator;

/**
 *
 * @author Hari RZ
 */
public class MataAnggaranComparator implements Comparator<MataAnggaran> {

    @Override
    public int compare(MataAnggaran mataAnggaran1, MataAnggaran mataAnggaran2) {
        int kode = mataAnggaran1.getKodeMataAnggaran().compareTo(mataAnggaran2.getKodeMataAnggaran());
        return kode;
    }
}
