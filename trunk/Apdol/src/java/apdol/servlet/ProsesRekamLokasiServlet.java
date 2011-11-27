/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.comparator.LokasiComparator;
import apdol.entity.Lokasi;
import apdol.model.DaftarLokasi;
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
@WebServlet(name = "ProsesRekamLokasiServlet", urlPatterns = {"/ProsesRekamLokasiServlet"})
public class ProsesRekamLokasiServlet extends HttpServlet {

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

            Lokasi lokasi = new Lokasi();
            DaftarLokasi daftarLokasi = new DaftarLokasi();
            String jsp = "";

            String kodeLokasi = request.getParameter("kode_lokasi");
            String namaKota = request.getParameter("nama_kota");
            String namaPropinsi = request.getParameter("nama_propinsi");

            //validate blank field
            if (kodeLokasi == "") {
                JOptionPane.showMessageDialog(null, "Kode Lokasi tidak boleh kosong !");
                jsp = "pages/rekam_lokasi.jsp";
            } else if (namaKota == "") {
                JOptionPane.showMessageDialog(null, "Nama Kota tidak boleh kosong !");
                jsp = "pages/rekam_lokasi.jsp";
            } else if (namaPropinsi == "") {
                JOptionPane.showMessageDialog(null, "Nama Propinsi tidak boleh kosong !");
                jsp = "pages/rekam_lokasi.jsp";
            } //validate length field
            else if (kodeLokasi.length() < 4) {
                JOptionPane.showMessageDialog(null, "Kode Lokasi harus 4 angka !");
                jsp = "pages/rekam_lokasi.jsp";
            } //validate kodeLokasi are numbers
            else if (!this.valNumber(kodeLokasi)) {
                JOptionPane.showMessageDialog(null, "Kode Lokasi harus angka !");
                jsp = "pages/rekam_lokasi.jsp";
            } //validate zero value
            else if (kodeLokasi.equalsIgnoreCase("000000")) {
                JOptionPane.showMessageDialog(null, "Kode Lokasi tidak boleh bernilai nol !");
                jsp = "pages/rekam_lokasi.jsp";
            } //validate record on database
            else if (daftarLokasi.isKodeExist(kodeLokasi)) {
                JOptionPane.showMessageDialog(null, "Kode Lokasi sudah ada dalam database !");
                jsp = "pages/rekam_lokasi.jsp";
            } //validate record on database
            else if (daftarLokasi.isKotaExist(namaKota)) {
                JOptionPane.showMessageDialog(null, "Kota sudah ada dalam database !");
                jsp = "pages/rekam_lokasi.jsp";
            } else {
                lokasi.setKodeLokasi(kodeLokasi);
                lokasi.setNamaKota(namaKota);
                lokasi.setNamaPropinsi(namaPropinsi);
                daftarLokasi.rekamLokasi(lokasi);
                response.sendRedirect("lokasi");
            }

            List<Lokasi> listLokasi = daftarLokasi.getLokasi();
            Collections.sort(listLokasi, new LokasiComparator());
            request.setAttribute("list_lokasi", listLokasi);
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
