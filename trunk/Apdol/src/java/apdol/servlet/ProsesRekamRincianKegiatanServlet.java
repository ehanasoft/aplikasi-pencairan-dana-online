/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.comparator.RincianKegiatanComparator;
import apdol.entity.Kegiatan;
import apdol.entity.MataAnggaran;
import apdol.entity.Output;
import apdol.entity.RincianKegiatan;
import apdol.entity.SatuanKerja;
import apdol.model.DaftarKegiatan;
import apdol.model.DaftarMataAnggaran;
import apdol.model.DaftarOutput;
import apdol.model.DaftarRincianKegiatan;
import apdol.model.DaftarSatuanKerja;
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
@WebServlet(name = "ProsesRekamRincianKegiatanServlet", urlPatterns = {"/proses_rekam_rincian_kegiatan"})
public class ProsesRekamRincianKegiatanServlet extends HttpServlet {

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

            RincianKegiatan rincianKegiatan = new RincianKegiatan();
            DaftarRincianKegiatan daftarRincianKegiatan = new DaftarRincianKegiatan();
            String jsp = "";
           
            String kodeSatker = request.getParameter("satker");
            String kdgiat = request.getParameter("kegiatan");
            String kodeOutput = request.getParameter("output");
            String kodeMataAnggaran = request.getParameter("mata_anggaran");
            
            Output output = new Output();
            DaftarOutput daftarOutput = new DaftarOutput();
            List<Output> listOutput = daftarOutput.findOutputByKode(kodeOutput);
            output = listOutput.get(0);
            
            MataAnggaran mataAnggaran = new MataAnggaran();
            DaftarMataAnggaran daftarMataAnggaran = new DaftarMataAnggaran();
            List<MataAnggaran> listMataAnggaran = daftarMataAnggaran.findMataAnggaranByKode(kodeMataAnggaran);
            mataAnggaran = listMataAnggaran.get(0);
            
            Kegiatan kegiatan = new Kegiatan();
            DaftarKegiatan daftarKegiatan = new DaftarKegiatan();
            List<Kegiatan> listKegiatan = daftarKegiatan.findKegiatanByKode(kdgiat);
            kegiatan = listKegiatan.get(0);
            
            SatuanKerja satker = new SatuanKerja();
            DaftarSatuanKerja daftarSatker = new DaftarSatuanKerja();
            List<SatuanKerja> listSatker = daftarSatker.findSatkerByKode(kodeSatker);
            if(listSatker.isEmpty()){
            satker = null;
            } else {
                satker = listSatker.get(0);
            }

            //validate blank field
            if (kodeSatker == "") {
                JOptionPane.showMessageDialog(null, "Satuan Kerja tidak boleh kosong !");
                jsp = "pages/rekam_rincian_kegiatan.jsp";
            } else if (kdgiat == "") {
                JOptionPane.showMessageDialog(null, "Kegiatan tidak boleh kosong !");
                jsp = "pages/rekam_rincian_kegiatan.jsp";
            } else if (kodeOutput == "") {
                JOptionPane.showMessageDialog(null, "Output tidak boleh kosong !");
                jsp = "pages/rekam_rincian_kegiatan.jsp";   
            } else if (kodeMataAnggaran == "") {
                JOptionPane.showMessageDialog(null, "Mata Anggaran tidak boleh kosong !");
                jsp = "pages/rekam_rincian_kegiatan.jsp";                   
            } else {
                rincianKegiatan.setSatker(satker);
                rincianKegiatan.setKegiatan(kegiatan);
                rincianKegiatan.setOutput(output);
                rincianKegiatan.setMataAnggaran(mataAnggaran);
                daftarRincianKegiatan.rekamRincianKegiatan(rincianKegiatan);
                jsp = "pages/rincian_kegiatan.jsp";
            }

            List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
            Collections.sort(listRincianKegiatan, new RincianKegiatanComparator());
            request.setAttribute("list_rincianKegiatan", listRincianKegiatan);
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
