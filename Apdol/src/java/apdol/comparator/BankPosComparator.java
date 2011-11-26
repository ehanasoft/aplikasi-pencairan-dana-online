/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.comparator;

import apdol.entity.BankPos;
import java.util.Comparator;

/**
 *
 * @author AlfieSaHid
 */
public class BankPosComparator implements Comparator<BankPos> {

    @Override
    public int compare(BankPos bankpos1, BankPos bankpos2) {
        int kode = bankpos1.getKdbankpos().compareTo(bankpos2.getKdbankpos());
        return kode;
    }
}
