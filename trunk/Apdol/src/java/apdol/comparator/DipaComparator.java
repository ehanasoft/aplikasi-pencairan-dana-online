/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.comparator;

import apdol.entity.Dipa;
import java.util.Comparator;

/**
 *
 * @author wahid
 */
public class DipaComparator implements Comparator<Dipa> {

    @Override
    public int compare(Dipa dipa1, Dipa dipa2) {
        int nomor = dipa1.getNomorDipa().compareTo(dipa2.getNomorDipa());
        return nomor;
    }
}
