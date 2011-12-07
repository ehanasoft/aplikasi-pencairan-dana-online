/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.comparator.SatuanKerjaComparator;
import apdol.entity.SatuanKerja;
import apdol.model.DaftarSatuanKerja;
import apdol.entity.Lokasi;
import apdol.model.DaftarLokasi;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Accio
 */
public class ProsesRekamSatuanKerjaServlet extends HttpServlet {

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
            SatuanKerja satker = new SatuanKerja();
            DaftarSatuanKerja daftarSatker = new DaftarSatuanKerja();

            String jsp = "";

            //String kodeLokasi = 
            String kodeSatker = request.getParameter("kode_satker");
            String namaSatker = request.getParameter("nama_satker");
            String kodeMenteri = request.getParameter("kode_dept");
            String namaMenteri = request.getParameter("nama_dept");
            String kodeUnit = request.getParameter("kode_unit");
            String namaUnit = request.getParameter("nama_unit");
            Long idLokasi = Long.parseLong(request.getParameter("lokasi"));
            Lokasi lokasi = new Lokasi();
            DaftarLokasi daftarLokasi = new DaftarLokasi();
            lokasi = daftarLokasi.findLokasi(idLokasi);
            //validate blank field
            if (kodeSatker.equals("")) {
                JOptionPane.showMessageDialog(null, "Kode Satker tidak boleh kosong !");
                response.sendRedirect("rekam_satker");
                //jsp = "pages/rekam_satker.jsp";
            } else if (namaSatker.equals("")) {
                JOptionPane.showMessageDialog(null, "Nama Satker tidak boleh kosong !");
                response.sendRedirect("rekam_satker");
                //jsp = "pages/rekam_satker.jsp";
            } else if (kodeMenteri.equals("")) {
                JOptionPane.showMessageDialog(null, "Kode Kementerian tidak boleh kosong !");
                response.sendRedirect("rekam_satker");
                //jsp = "pages/rekam_satker.jsp";
            } else if (namaMenteri.equals("")) {
                JOptionPane.showMessageDialog(null, "Nama Kementerian tidak boleh kosong !");
                response.sendRedirect("rekam_satker");
                //jsp = "pages/rekam_satker.jsp";
            } else if (kodeUnit.equals("")) {
                JOptionPane.showMessageDialog(null, "Kode Kementerian tidak boleh kosong !");
                response.sendRedirect("rekam_satker");
                //jsp = "pages/rekam_satker.jsp";
            } else if (namaUnit.equals("")) {
                JOptionPane.showMessageDialog(null, "Nama Kementerian tidak boleh kosong !");
                response.sendRedirect("rekam_satker");
                //jsp = "pages/rekam_satker.jsp";
            } //validate length field
            else if (kodeSatker.length() < 6) {
                JOptionPane.showMessageDialog(null, "Kode Satker harus 6 angka !");
                response.sendRedirect("rekam_satker");
                //jsp = "pages/rekam_satker.jsp";
            } //validate kodeSatker are numbers
            else if (!this.valNumber(kodeSatker)) {
                JOptionPane.showMessageDialog(null, "Kode Satker harus angka dan tidak boleh minus !");
                response.sendRedirect("rekam_satker");
                //jsp = "pages/rekam_satker.jsp";
            } //validate zero value
            else if (kodeSatker.equalsIgnoreCase("000000")) {
                JOptionPane.showMessageDialog(null, "Kode Satker tidak boleh bernilai nol !");
                response.sendRedirect("rekam_satker");
                //jsp = "pages/rekam_satker.jsp";
            } //validate record on database
            else if (daftarSatker.isKodeExist(kodeSatker)) {
                JOptionPane.showMessageDialog(null, "Kode Satker sudah ada dalam database !");
                response.sendRedirect("rekam_satker");
                //jsp = "pages/rekam_satker.jsp";
            } //validate record on database
            else if (daftarSatker.isNamaSatkerExist(namaSatker)) {
                JOptionPane.showMessageDialog(null, "Nama Satker sudah ada dalam database !");
                jsp = "pages/rekam_satker.jsp";
            } else {
                satker.setKodeSatker(kodeSatker);
                satker.setNamaSatker(namaSatker);
                satker.setKodeDept(kodeMenteri);
                satker.setNamaDept(namaMenteri);
                satker.setKodeUnit(kodeUnit);
                satker.setNamaUnit(namaUnit);
                satker.setLokasi(lokasi);
                daftarSatker.rekamSatuanKerja(satker);
                jsp = "pages/satker.jsp";
            }
            
            List<SatuanKerja> listSatker = daftarSatker.getSatuanKerja();
            Collections.sort(listSatker, new SatuanKerjaComparator());
            request.setAttribute("list_satker", listSatker);
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
    }// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
