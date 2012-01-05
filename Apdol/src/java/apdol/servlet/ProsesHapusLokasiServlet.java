/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.comparator.LokasiComparator;
import apdol.entity.Lokasi;
import apdol.model.DaftarLokasi;
import apdol.model.exceptions.NonexistentEntityException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ProsesHapusLokasiServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NonexistentEntityException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            DaftarLokasi daftarLokasi = new DaftarLokasi();
            List<Lokasi> listLokasi = daftarLokasi.getLokasi();
            Collections.sort(listLokasi, new LokasiComparator());
            String cekLokasi = request.getParameter("hapus_lokasi");
            String jsp = "";

            int j = JOptionPane.showConfirmDialog(null, "apakah anda yakin akan menghapus ?",
                    JOptionPane.MESSAGE_TYPE_PROPERTY, JOptionPane.YES_NO_OPTION);

            if (j == JOptionPane.YES_OPTION) {
                long idlokasi = Long.parseLong(cekLokasi);
                Lokasi lokasi = daftarLokasi.findLokasi(idlokasi);
                daftarLokasi.destroy(idlokasi);
            }

            listLokasi = daftarLokasi.getLokasi();
            Collections.sort(listLokasi, new LokasiComparator());
            request.setAttribute("list_lokasi", listLokasi);
            jsp = "pages/lokasi.jsp";

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
        try {
            processRequest(request, response);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ProsesHapusLokasiServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ProsesHapusLokasiServlet.class.getName()).log(Level.SEVERE, null, ex);
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
