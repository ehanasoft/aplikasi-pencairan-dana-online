/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.comparator;

import apdol.entity.Output;
import java.util.Comparator;

/**
 *
 * @author Hari RZ
 */
public class OutputComparator implements Comparator<Output> {

    @Override
    public int compare(Output output1, Output output2) {
        int kode = output1.getKodeOutput().compareTo(output2.getKodeOutput());
        return kode;
    }
}
