/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.comparator;

import apdol.entity.SPM;
import java.util.Comparator;

/**
 *
 * @author wahid
 */
public class SpmComparator implements Comparator<SPM> {

    @Override
    public int compare(SPM spm1, SPM spm2) {
        int id = spm1.getId().compareTo(spm2.getId());
        return id;
    }
}
