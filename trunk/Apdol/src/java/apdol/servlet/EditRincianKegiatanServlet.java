/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.comparator.RincianKegiatanComparator;
import apdol.comparator.SatuanKerjaComparator;
import apdol.entity.Lokasi;
import apdol.entity.RincianKegiatan;
import apdol.entity.SatuanKerja;
import apdol.model.DaftarLokasi;
import apdol.model.DaftarRincianKegiatan;
import apdol.model.DaftarSatuanKerja;
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
public class EditRincianKegiatanServlet extends HttpServlet {

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
            DaftarSatuanKerja daftarSatker = new DaftarSatuanKerja();
            List<SatuanKerja> listSatker = daftarSatker.getSatuanKerja();
            request.setAttribute("list_satker", listSatker);
            
            
            DaftarRincianKegiatan daftarRincianKegiatan = new DaftarRincianKegiatan();
            RincianKegiatan satkerRincianKegiatan = new RincianKegiatan();
            RincianKegiatan kegiatanRincianKegiatan = new RincianKegiatan();
            RincianKegiatan outputRincianKegiatan = new RincianKegiatan();
            RincianKegiatan mataAnggaranRincianKegiatan = new RincianKegiatan();
            List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
            Collections.sort(listRincianKegiatan, new RincianKegiatanComparator());
            request.setAttribute("list_rincian_kegiatan", listRincianKegiatan);
            String jsp = "";
            String cekRincianKegiatan[] = request.getParameterValues("cek_rincian_kegiatan");


            if (cekRincianKegiatan == null) {
                JOptionPane.showMessageDialog(null, "Rincian Kegiatan tidak ada yang dipilih");
                jsp = "pages/rincian_kegiatan.jsp";
            } else if (cekRincianKegiatan.length > 1) {
                JOptionPane.showMessageDialog(null, "Edit salah satu Rincian Kegiatan saja !");
                jsp = "pages/rincian_kegiatan.jsp";
            } else {
                Long idRincianKegiatan = Long.parseLong(cekRincianKegiatan[0]);
                RincianKegiatan rincianKegiatan = daftarRincianKegiatan.findRincianKegiatan(idRincianKegiatan);
                request.setAttribute("rincian_kegiatan_edit", rincianKegiatan);
                request.setAttribute("satkerRincianKegiatan", satkerRincianKegiatan.getSatker());
                jsp = "/pages/edit_rincian_kegiatan.jsp";
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher(jsp);
            requestDispatcher.forward(request, response);
        } finally {            
            out.close();
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
