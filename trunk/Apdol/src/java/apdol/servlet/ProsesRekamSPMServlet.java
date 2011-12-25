/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.entity.RincianKegiatan;
import apdol.entity.SPM;
import apdol.model.DaftarRincianKegiatan;
import apdol.model.DaftarSPM;
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
 * @author wahid
 */
public class ProsesRekamSPMServlet extends HttpServlet {

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

            SPM spm = new SPM();
            DaftarSPM daftarSPM = new DaftarSPM();
            String jsp = "";

            String tanggalSPM = request.getParameter("tanggal_spm");
            String jumlahKeluar = request.getParameter("jumlah_keluar");
            Long longJumlahKeluar = Long.parseLong(jumlahKeluar);
            String jumlahPotongan = request.getParameter("jumlah_potongan");
            Long longJumlahPotongan = Long.parseLong(jumlahPotongan);
            String jumlahBersih = request.getParameter("jumlah_bersih");
            Long longJumlahBersih = Long.parseLong(jumlahBersih);
            String rincianKegiatanId = request.getParameter("rincian_kegiatan");
            Long longId = Long.parseLong(rincianKegiatanId);
            DaftarRincianKegiatan daftarRincianKegiatan = new DaftarRincianKegiatan();
            RincianKegiatan rincianKegiatan = daftarRincianKegiatan.findRincianKegiatan(longId);
            
            //validate blank field
            if (tanggalSPM == "") {
                JOptionPane.showMessageDialog(null, "Tanggal SPM tidak boleh kosong !");
                List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
                request.setAttribute("list_rincian_kegiatan", listRincianKegiatan);
                jsp = "pages/rekam_spm.jsp";
            } else if (jumlahKeluar == "") {
                JOptionPane.showMessageDialog(null, "Jumlah Keluar tidak boleh kosong !");
                List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
                request.setAttribute("list_rincian_kegiatan", listRincianKegiatan);
                jsp = "pages/rekam_spm.jsp";
            } else if (jumlahBersih == "") {
                JOptionPane.showMessageDialog(null, "Jumlah Bersih tidak boleh kosong !");
                List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
                request.setAttribute("list_rincian_kegiatan", listRincianKegiatan);
                jsp = "pages/rekam_spm.jsp";    
            } else {
                spm.setTanggalSPM(tanggalSPM);
                spm.setJumlahKeluar(jumlahKeluar);
                spm.setJumlahPotongan(jumlahPotongan);
                spm.setRincianKegiatan(rincianKegiatan);
                daftarSPM.rekamSPM(spm);
                jsp = "pages/spm.jsp";
            }

            List<SPM> listSPM = daftarSPM.getSPM();
            Collections.sort(listSPM, new SPMComparator());
            request.setAttribute("list_spm", listSPM);
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
