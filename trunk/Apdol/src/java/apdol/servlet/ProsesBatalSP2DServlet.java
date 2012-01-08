/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.comparator.Sp2dComparator;
import apdol.entity.SP2D;
import apdol.entity.SPM;
import apdol.model.DaftarSP2D;
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
 * @author AlfieSaHid
 */
public class ProsesBatalSP2DServlet extends HttpServlet {

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
            DaftarSP2D daftarSP2D = new DaftarSP2D();
            List<SP2D> listSP2D = daftarSP2D.getSP2D();
            Collections.sort(listSP2D, new Sp2dComparator());
            String cekSP2D = request.getParameter("proses_batal_sp2d");
            String jsp = "";

            int j = JOptionPane.showConfirmDialog(null, "apakah anda yakin akan membatalkan SP2D ini?",
                    JOptionPane.MESSAGE_TYPE_PROPERTY, JOptionPane.YES_NO_OPTION);

            if (j == JOptionPane.YES_OPTION) {
                String tanggalTolakSP2D = request.getParameter("tanggal_batal_sp2d");
                String nomorTolakSP2D = request.getParameter("nomor_batal_sp2d");
                String keteranganTolakSP2D = request.getParameter("alasan");
                
                long idspm = Long.parseLong(cekSP2D);
                DaftarSPM daftarSPM = new DaftarSPM();
                SPM spm = daftarSPM.findSPM(idspm);
                String statSPM = "1";
                spm.setStatusSpm(statSPM);
                daftarSPM.edit(spm);
            }

            listSP2D = daftarSP2D.getSP2D();
            Collections.sort(listSP2D, new Sp2dComparator());
            request.setAttribute("list_sp2d", listSP2D);
            jsp = "pages/batal_sp2d.jsp";

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
