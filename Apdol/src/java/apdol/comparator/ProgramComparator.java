/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.comparator;

import apdol.entity.Program;
import java.util.Comparator;

/**
 *
 * @author AlfieSaHid
 */
public class ProgramComparator implements Comparator <Program> {
    
    @Override
    public int compare(Program program1, Program program2) {
        int kode = program1.getKdprogram().compareTo(program2.getKdprogram());
        return kode;
    }
    
}
