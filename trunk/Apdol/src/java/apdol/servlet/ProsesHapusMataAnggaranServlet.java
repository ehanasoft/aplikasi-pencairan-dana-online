/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.comparator.MataAnggaranComparator;
import apdol.entity.MataAnggaran;
import apdol.model.DaftarMataAnggaran;
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
@WebServlet(name = "ProsesRekamMataAnggaranServlet", urlPatterns = {"/ProsesRekamMataAnggaranServlet"})
public class ProsesHapusMataAnggaranServlet extends HttpServlet {

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
            DaftarMataAnggaran daftarMataAnggaran = new DaftarMataAnggaran();
            List<MataAnggaran> listMataAnggaran = daftarMataAnggaran.getMataAnggaran();
            Collections.sort(listMataAnggaran, new MataAnggaranComparator());
            String cekMataAnggaran[] = request.getParameterValues("cek_mata_anggaran");
            String jsp = "";

            if (cekMataAnggaran == null) {
                JOptionPane.showMessageDialog(null, "Mata Anggaran tidak ada yang dipilih");
                request.setAttribute("list_mata_anggaran", listMataAnggaran);
                jsp = "pages/mata_anggaran.jsp";
            } else {
                int j = JOptionPane.showConfirmDialog(null, "apakah anda yakin akan menghapus ?",
                        JOptionPane.MESSAGE_TYPE_PROPERTY, JOptionPane.YES_NO_OPTION);

                if (j == JOptionPane.YES_OPTION) {
                    for (int i = 0; i < cekMataAnggaran.length; i++) {
                        long idMataAnggaran = Long.parseLong(cekMataAnggaran[i]);
                        MataAnggaran mataAnggaran = daftarMataAnggaran.findMataAnggaran(idMataAnggaran);
                        daftarMataAnggaran.destroy(idMataAnggaran);
                    }
                }
                listMataAnggaran = daftarMataAnggaran.getMataAnggaran();
                Collections.sort(listMataAnggaran, new MataAnggaranComparator());
                request.setAttribute("list_mata_anggaran", listMataAnggaran);
                jsp = "pages/mata_anggaran.jsp";
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
        try {
            processRequest(request, response);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ProsesHapusMataAnggaranServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProsesHapusMataAnggaranServlet.class.getName()).log(Level.SEVERE, null, ex);
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
