/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.comparator.DipaComparator;
import apdol.entity.Dipa;
import apdol.entity.RincianKegiatan;
import apdol.model.DaftarDipa;
import apdol.model.DaftarRincianKegiatan;
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
@WebServlet(name = "ProsesRekamDipaServlet", urlPatterns = {"/ProsesRekamDipaServlet"})
public class ProsesRekamDipaServlet extends HttpServlet {

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

            Dipa dipa = new Dipa();
            DaftarDipa daftarDipa = new DaftarDipa();
            String jsp = "";

            String nomorDipa = request.getParameter("nomor_dipa");
            String idRincianKegiatan = request.getParameter("id_rincian_kegiatan");
            String pagu = request.getParameter("pagu");
            String realisasi = request.getParameter("realisasi");
            String sisaDana = request.getParameter("sisa_dana");
            String rincianKegiatanId = request.getParameter("rincian_kegiatan");
            JOptionPane.showMessageDialog(null, "hai");
            Long longId = Long.parseLong(rincianKegiatanId);
            DaftarRincianKegiatan daftarRincianKegiatan = new DaftarRincianKegiatan();
            RincianKegiatan rincianKegiatan = daftarRincianKegiatan.findRincianKegiatan(longId);
            

            //validate blank field
            if (nomorDipa == "") {
                JOptionPane.showMessageDialog(null, "Nomor Dipa tidak boleh kosong !");
                jsp = "pages/rekam_dipa.jsp";
            } else if (pagu == "") {
                JOptionPane.showMessageDialog(null, "Pagu tidak boleh kosong !");
                jsp = "pages/rekam_dipa.jsp";
            } else if (realisasi == "") {
                JOptionPane.showMessageDialog(null, "Realisasi tidak boleh kosong !");
                jsp = "pages/rekam_dipa.jsp";
            } else if (sisaDana == "") {
                JOptionPane.showMessageDialog(null, "Sisa Dana tidak boleh kosong !");
                jsp = "pages/rekam_dipa.jsp";    
            } //validate record on database
            else if (daftarDipa.isNomorExist(nomorDipa)) {
                JOptionPane.showMessageDialog(null, "Nomor Dipa sudah ada dalam database !");
                jsp = "pages/rekam_dipa.jsp";
            } else {
                dipa.setNomorDipa(nomorDipa);
                dipa.setPagu(pagu);
                dipa.setRealisasi(realisasi);
                dipa.setSisaDana(sisaDana);
                dipa.setRincianKegiatan(rincianKegiatan);
                daftarDipa.rekamDipa(dipa);
                jsp = "pages/dipa.jsp";
            }

            List<Dipa> listDipa = daftarDipa.getDipa();
            Collections.sort(listDipa, new DipaComparator());
            request.setAttribute("list_dipa", listDipa);
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
