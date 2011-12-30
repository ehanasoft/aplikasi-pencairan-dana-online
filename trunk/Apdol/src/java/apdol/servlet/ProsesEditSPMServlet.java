/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.comparator.SpmComparator;
import apdol.entity.RincianKegiatan;
import apdol.entity.SPM;
import apdol.model.DaftarRincianKegiatan;
import apdol.model.DaftarSPM;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ProsesEditSPMServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            SPM spm = new SPM();
            DaftarSPM daftarSPM = new DaftarSPM();
            String jsp = "";

            String tanggal = request.getParameter("tanggal") + "/";
            String bulan = request.getParameter("bulan") + "/";
            String tahun = request.getParameter("tahun");
            String stringDate = tanggal+bulan+tahun;
            DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
            Date date = df.parse(stringDate);
            
            String nomorSpm = request.getParameter("nomor_spm");
            String jumlahKeluar = request.getParameter("jumlah_keluar");
            String jumlahPotongan = request.getParameter("jumlah_potongan");
            String rincianKegiatanId = request.getParameter("rincian_kegiatan");
            
            Long longId = Long.parseLong(rincianKegiatanId);
            DaftarRincianKegiatan daftarRincianKegiatan = new DaftarRincianKegiatan();
            RincianKegiatan rincianKegiatan = daftarRincianKegiatan.findRincianKegiatan(longId);
            
            String idSPM = request.getParameter("id_edit_spm");
            Long longIdSPM = Long.parseLong(idSPM);
            spm = daftarSPM.findSPM(longIdSPM);

            //validate blank field
            if (nomorSpm == "") {
                JOptionPane.showMessageDialog(null, "Nomor SPM tidak boleh kosong !");
                List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
                request.setAttribute("list_rincian_kegiatan", listRincianKegiatan);
                jsp = "pages/rekam_spm.jsp";
            } else if (tanggal == "") {
                JOptionPane.showMessageDialog(null, "Tanggal SPM tidak boleh kosong !");
                List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
                request.setAttribute("list_rincian_kegiatan", listRincianKegiatan);
                jsp = "pages/rekam_spm.jsp";
            } else if (jumlahKeluar== "") {
                JOptionPane.showMessageDialog(null, "Jumlah Keluar tidak boleh kosong !");
                List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
                request.setAttribute("list_rincian_kegiatan", listRincianKegiatan);
                request.setAttribute("spm_edit", spm);
                jsp = "pages/edit_spm.jsp";
            } else if (jumlahPotongan== "") {
                JOptionPane.showMessageDialog(null, "Jumlah Potongan tidak boleh kosong !");
                List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
                request.setAttribute("list_rincian_kegiatan", listRincianKegiatan);
                request.setAttribute("spm_edit", spm);
                jsp = "pages/edit_spm.jsp";   
            } else if (!this.valNumber(jumlahKeluar)) {
                JOptionPane.showMessageDialog(null, "Jumlah Keluar harus angka dan bulat !");
                List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
                request.setAttribute("list_rincian_kegiatan", listRincianKegiatan);
                request.setAttribute("spm_edit", spm);
                jsp = "pages/edit_spm.jsp";
            } else if (!this.valNumber(jumlahPotongan)) {
                JOptionPane.showMessageDialog(null, "Jumlah Potongan harus angka  dan bulat !");
                List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
                request.setAttribute("list_rincian_kegiatan", listRincianKegiatan);
                request.setAttribute("spm_edit", spm);
                jsp = "pages/edit_spm.jsp";
            } else if (Float.parseFloat(jumlahKeluar) < Float.parseFloat(jumlahPotongan)) {
                JOptionPane.showMessageDialog(null, "Jumlah Keluar harus lebih besar daripada Jumlah Potongan !");
                List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
                request.setAttribute("list_rincian_kegiatan", listRincianKegiatan);
                request.setAttribute("spm_edit", spm);
                jsp = "pages/edit_spm.jsp";
            } else {
                spm.setNomorSpm(nomorSpm);
                spm.setTanggalSPM(date);
                spm.tambahiDipa();
                spm.setJumlahKeluar(jumlahKeluar);
                spm.kurangiDipa();
                spm.setJumlahPotongan(jumlahPotongan);
                spm.setJumlahBersih();
                spm.setRincianKegiatan(rincianKegiatan);
                daftarSPM.edit(spm);
                List<SPM> listSPM = daftarSPM.getSPM();
                Collections.sort(listSPM, new SpmComparator());
                request.setAttribute("list_spm", listSPM);
                jsp = "pages/spm.jsp";
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher(jsp);
            requestDispatcher.forward(request, response);
        } finally {
            out.close();
        }
    }

    public boolean valNumber(String kode) {
        int j;
        try {
            for (int i = 0; i < kode.length(); i++) {
                String c = kode.substring(i, i + 1);
                j = Integer.parseInt(c);
            }
            return true;
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ProsesEditSPMServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ProsesEditSPMServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
