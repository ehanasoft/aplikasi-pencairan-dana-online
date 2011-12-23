/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.comparator.MataAnggaranComparator;
import apdol.entity.MataAnggaran;
import apdol.model.DaftarMataAnggaran;
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
 * @author Hari RZ
 */
@WebServlet(name = "ProsesRekamMataAnggaranServlet", urlPatterns = {"/ProsesRekamMataAnggaranServlet"})
public class ProsesRekamMataAnggaranServlet extends HttpServlet {

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

            MataAnggaran mataAnggaran = new MataAnggaran();
            DaftarMataAnggaran daftarMataAnggaran = new DaftarMataAnggaran();
            String jsp = "";

            String kodeMataAnggaran = request.getParameter("kode_mata_anggaran");
            String namaMataAnggaran = request.getParameter("nama_mata_anggaran");
            String namaBKPK = request.getParameter("nama_bkpk");

            //validate blank field
            if (kodeMataAnggaran == "") {
                JOptionPane.showMessageDialog(null, "Kode Mata Anggaran tidak boleh kosong !");
                jsp = "pages/rekam_mata_anggaran.jsp";
            } else if (namaMataAnggaran == "") {
                JOptionPane.showMessageDialog(null, "Nama Mata Anggaran tidak boleh kosong !");
                jsp = "pages/rekam_mata_anggaran.jsp";
            } else if (namaBKPK == "") {
                JOptionPane.showMessageDialog(null, "Nama BKPK tidak boleh kosong !");
                jsp = "pages/rekam_mata_anggaran.jsp";
            } //validate length field
            else if (kodeMataAnggaran.length() < 6) {
                JOptionPane.showMessageDialog(null, "Kode Mata Anggaran harus 6 angka !");
                jsp = "pages/rekam_mata_anggaran.jsp";
            } //validate kodeMataAnggaran are numbers
            else if (!this.valNumber(kodeMataAnggaran)) {
                JOptionPane.showMessageDialog(null, "Kode Mata Anggaran harus angka dan tidak boleh minus !");
                jsp = "pages/rekam_mata_anggaran.jsp";
            } //validate zero value
            else if (kodeMataAnggaran.equalsIgnoreCase("0000")) {
                JOptionPane.showMessageDialog(null, "Kode Mata Anggaran tidak boleh bernilai nol !");
                jsp = "pages/rekam_mata_anggaran.jsp";
            } //validate record on database
            else if (daftarMataAnggaran.isKodeExist(kodeMataAnggaran)) {
                JOptionPane.showMessageDialog(null, "Kode Mata Anggaran sudah ada dalam data base !");
                jsp = "pages/rekam_mata_anggaran.jsp";
            } else if (daftarMataAnggaran.isNamaExist(namaMataAnggaran)) {
                JOptionPane.showMessageDialog(null, "Mata Anggaran sudah ada dalam data base !");
                jsp = "pages/rekam_mata_anggaran.jsp";
            } else {
                mataAnggaran.setKodeMataAnggaran(kodeMataAnggaran);
                mataAnggaran.setNamaMataAnggaran(namaMataAnggaran);
                mataAnggaran.setNamaBKPK(namaBKPK);
                daftarMataAnggaran.rekamMataAnggaran(mataAnggaran);
                List<MataAnggaran> listMataAnggaran = daftarMataAnggaran.getMataAnggaran();
                Collections.sort(listMataAnggaran, new MataAnggaranComparator());
                request.setAttribute("list_mata_anggaran", listMataAnggaran);
                jsp = "pages/mata_anggaran.jsp";
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
