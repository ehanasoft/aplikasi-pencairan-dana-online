/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.comparator;

import apdol.entity.Pejabat;
import java.util.Comparator;

/**
 *
 * @author AlfieSaHid
 */
public class PejabatComparator implements Comparator<Pejabat> {

    @Override
    public int compare(Pejabat pejabat1, Pejabat pejabat2) {
        int kode = pejabat1.getNip().compareTo(pejabat2.getNip());
        return kode;
    }  
}
