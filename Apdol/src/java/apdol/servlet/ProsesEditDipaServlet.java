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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author wahid
 */
public class ProsesEditDipaServlet extends HttpServlet {

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
            String pagu = request.getParameter("pagu");
            String realisasi = request.getParameter("realisasi");
            String rincianKegiatanId = request.getParameter("rincian_kegiatan");
            
            Long longId = Long.parseLong(rincianKegiatanId);
            DaftarRincianKegiatan daftarRincianKegiatan = new DaftarRincianKegiatan();
            RincianKegiatan rincianKegiatan = daftarRincianKegiatan.findRincianKegiatan(longId);
            
            String idDipa = request.getParameter("id_edit_dipa");
            Long longIdDipa = Long.parseLong(idDipa);
            dipa = daftarDipa.findDipa(longIdDipa);

            //validate blank field
            if (nomorDipa == "") {
                JOptionPane.showMessageDialog(null, "Nomor Dipa tidak boleh kosong !");
                List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
                request.setAttribute("list_rincian_kegiatan", listRincianKegiatan);
                request.setAttribute("dipa_edit", dipa);
                jsp = "pages/edit_dipa.jsp";
            } else if (pagu == "") {
                JOptionPane.showMessageDialog(null, "Pagu tidak boleh kosong !");
                List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
                request.setAttribute("list_rincian_kegiatan", listRincianKegiatan);
                request.setAttribute("dipa_edit", dipa);
                jsp = "pages/edit_dipa.jsp";
            } else if (realisasi == "") {
                JOptionPane.showMessageDialog(null, "Realisasi tidak boleh kosong !");
                List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
                request.setAttribute("list_rincian_kegiatan", listRincianKegiatan);
                request.setAttribute("dipa_edit", dipa);
                jsp = "pages/edit_dipa.jsp";
            } else if (!this.valNumber(pagu)) {
                JOptionPane.showMessageDialog(null, "Pagu harus angka dan bulat !");
                List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
                request.setAttribute("list_rincian_kegiatan", listRincianKegiatan);
                request.setAttribute("dipa_edit", dipa);
                jsp = "pages/edit_dipa.jsp";
            } else if (!this.valNumber(realisasi)) {
                JOptionPane.showMessageDialog(null, "Realisasi harus angka  dan bulat !");
                List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
                request.setAttribute("list_rincian_kegiatan", listRincianKegiatan);
                request.setAttribute("dipa_edit", dipa);
                jsp = "pages/edit_dipa.jsp";
            } else if (Float.parseFloat(pagu) < Float.parseFloat(realisasi)) {
                JOptionPane.showMessageDialog(null, "Pagu harus lebih besar daripada Realisasi !");
                List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
                request.setAttribute("list_rincian_kegiatan", listRincianKegiatan);
                request.setAttribute("dipa_edit", dipa);
                jsp = "pages/edit_dipa.jsp";
            } //validate record no change
            else if (daftarDipa.isNomorExist(nomorDipa) && !dipa.isKodeNoChange(nomorDipa)) {
                JOptionPane.showMessageDialog(null, "Nomor Dipa sudah ada dalam database !");
                List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
                request.setAttribute("list_rincian_kegiatan", listRincianKegiatan);
                request.setAttribute("dipa_edit", dipa);
                jsp = "pages/edit_dipa.jsp";
            } //validate record on database
            else if (daftarDipa.isRincianKegiatanExist(rincianKegiatan) && !dipa.isRincianKegiatanNoChange(rincianKegiatan)) {
                JOptionPane.showMessageDialog(null, "Dipa dengan rincian kegiatan ini sudah ada dalam database !");
                List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
                request.setAttribute("list_rincian_kegiatan", listRincianKegiatan);
                request.setAttribute("dipa_edit", dipa);
                jsp = "pages/edit_dipa.jsp";
            } else {
                dipa.setNomorDipa(nomorDipa);
                dipa.setPagu(pagu);
                dipa.setRealisasi(realisasi);
                dipa.setSisaDana();
                dipa.setRincianKegiatan(rincianKegiatan);
                daftarDipa.edit(dipa);
                List<Dipa> listDipa = daftarDipa.getDipa();
                Collections.sort(listDipa, new DipaComparator());
                request.setAttribute("list_dipa", listDipa);
                jsp = "pages/dipa.jsp";
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
