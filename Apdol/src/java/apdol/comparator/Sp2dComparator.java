/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.comparator;

import apdol.entity.SP2D;
import java.util.Comparator;

/**
 *
 * @author AlfieSaHid
 */
public class Sp2dComparator implements Comparator<SP2D> {

    @Override
    public int compare(SP2D sp2d1, SP2D sp2d2) {
        int id = sp2d1.getId().compareTo(sp2d2.getId());
        return id;
    }
    
}
