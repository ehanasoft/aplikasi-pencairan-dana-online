/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.comparator.KegiatanComparator;
import apdol.entity.Kegiatan;
import apdol.model.DaftarKegiatan;
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
@WebServlet(name = "ProsesRekamKegiatanServlet", urlPatterns = {"/proses_rekam_kegiatan"})
public class ProsesRekamKegiatanServlet extends HttpServlet {

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

            Kegiatan kegiatan = new Kegiatan();
            DaftarKegiatan daftarKegiatan = new DaftarKegiatan();
            String jsp = "";

            String kdgiat = request.getParameter("kode_kegiatan");
            String nmgiat = request.getParameter("nama_kegiatan");

            //validate blank field
            if (kdgiat == "") {
                JOptionPane.showMessageDialog(null, "Kode Kegiatan tidak boleh kosong !", 
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                jsp = "pages/rekam_kegiatan.jsp";
            } else if (nmgiat == "") {
                JOptionPane.showMessageDialog(null, "Nama Kegiatan tidak boleh kosong !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                jsp = "pages/rekam_kegiatan.jsp";            
            } //validate length field
            else if (kdgiat.length() < 4) {
                JOptionPane.showMessageDialog(null, "Kode Kegiatan harus 4 angka !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                jsp = "pages/rekam_kegiatan.jsp";
            } //validate kdgiat are numbers
            else if (!this.valNumber(kdgiat)) {
                JOptionPane.showMessageDialog(null, "Kode Kegiatan harus angka !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                jsp = "pages/rekam_kegiatan.jsp";
            } //validate zero value
            else if (kdgiat.equalsIgnoreCase("000000")) {
                JOptionPane.showMessageDialog(null, "Kode Kegiatan tidak boleh bernilai nol !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                jsp = "pages/rekam_kegiatan.jsp";
            } //validate record on database
            else if (daftarKegiatan.isKodeExist(kdgiat)) {
                JOptionPane.showMessageDialog(null, "Kode Kegiatan sudah ada dalam database !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                jsp = "pages/rekam_kegiatan.jsp";
            } //validate record on database
            else if (daftarKegiatan.isNamaExist(nmgiat)) {
                JOptionPane.showMessageDialog(null, "Nama Kegiatan sudah ada dalam database !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                jsp = "pages/rekam_kegiatan.jsp";
            } else {
                kegiatan.setKdgiat(kdgiat);
                kegiatan.setNmgiat(nmgiat);                
                daftarKegiatan.rekamKegiatan(kegiatan);
                jsp = "pages/kegiatan.jsp";
            }

            List<Kegiatan> listKegiatan = daftarKegiatan.getKegiatan();
            Collections.sort(listKegiatan, new KegiatanComparator());
            request.setAttribute("list_kegiatan", listKegiatan);
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
