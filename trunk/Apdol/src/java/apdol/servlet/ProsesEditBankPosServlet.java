/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.comparator.BankPosComparator;
import apdol.entity.BankPos;
import apdol.model.DaftarBankPos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author AlfieSaHid
 */
@WebServlet(name = "ProsesRekamBankPosServlet", urlPatterns = {"/proses_rekam_bank_pos"})
public class ProsesEditBankPosServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            DaftarBankPos daftarBankPos = new DaftarBankPos();
            String jsp = "";           

            String kdbankpos = request.getParameter("kode_bankpos");
            String nmbankpos = request.getParameter("nama_bankpos");
            
            String idBankPos = request.getParameter("id_edit_bankpos");
            Long longIdBankPos = Long.parseLong(idBankPos);
            BankPos bankpos = daftarBankPos.findBankPos(longIdBankPos);

            if (kdbankpos == "") {
                JOptionPane.showMessageDialog(null, "Kode Bank Pos tidak boleh kosong !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("bankpos_edit", bankpos);
                jsp = "pages/edit_bank_pos.jsp";
            } else if (nmbankpos == "") {
                JOptionPane.showMessageDialog(null, "Nama Bank Pos tidak boleh kosong !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("bankpos_edit", bankpos);
                jsp = "pages/edit_bank_pos.jsp";
            } //validate length field
            else if (kdbankpos.length() < 3) {
                JOptionPane.showMessageDialog(null, "Kode Bank Pos harus 3 angka !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("bankpos_edit", bankpos);
                jsp = "pages/edit_bank_pos.jsp";
            } //validate kdbankpos are numbers and not minus
            else if (!this.valNumber(kdbankpos)) {
                JOptionPane.showMessageDialog(null, "Kode Bank Pos harus angka dan tidak boleh minus !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("bankpos_edit", bankpos);
                jsp = "pages/edit_bank_pos.jsp";
            } //validate zero value
            else if (kdbankpos.equalsIgnoreCase("0000")) {
                JOptionPane.showMessageDialog(null, "Kode Bank Pos tidak boleh bernilai nol !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("bankpos_edit", bankpos);
                jsp = "pages/edit_bank_pos.jsp";
            } //validate kdbankpos on database
            else if (daftarBankPos.isKodeExist(kdbankpos) && !bankpos.isKodeNoChange(kdbankpos)) {
                JOptionPane.showMessageDialog(null, "Kode Bank Pos sudah ada dalam database !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("bankpos_edit", bankpos);
                jsp = "pages/edit_bank_pos.jsp";
            } //validate nmbankpos on database
            else if (daftarBankPos.isNamaExist(nmbankpos) && !bankpos.isNamaNoChange(nmbankpos)) {
                JOptionPane.showMessageDialog(null, "Bank Pos sudah ada dalam database !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("bankpos_edit", bankpos);
                jsp = "pages/edit_bank_pos.jsp";
            } else {
                bankpos.setKdbankpos(kdbankpos);
                bankpos.setNmbankpos(nmbankpos);
                daftarBankPos.edit(bankpos);
                List<BankPos> listBankPos = daftarBankPos.getBankPos();
                listBankPos = daftarBankPos.getBankPos();
                Collections.sort(listBankPos, new BankPosComparator());
                request.setAttribute("list_bankpos", listBankPos);
                jsp = "pages/bank_pos.jsp";
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(jsp);
            requestDispatcher.forward(request, response);
        } finally {
            out.close();
        }
    }

    public boolean valNumber(String kode) {
        try {
            int i = Integer.parseInt(kode);
            //validate minus input
            if (i >= 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
