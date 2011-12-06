/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.comparator;

import apdol.entity.SatuanKerja;
import java.util.Comparator;

/**
 *
 * @author Accio
 */
public class SatuanKerjaComparator implements Comparator<SatuanKerja> {

    @Override
    public int compare(SatuanKerja satker1, SatuanKerja satker2) {
        int kode = satker1.getKodeSatker().compareTo(satker2.getKodeSatker());
        return kode;
    }
}
