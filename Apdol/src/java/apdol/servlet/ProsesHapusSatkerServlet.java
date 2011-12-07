/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.comparator.SatuanKerjaComparator;
import apdol.entity.SatuanKerja;
import apdol.model.DaftarSatuanKerja;
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
 * @author AlfieSaHid
 */
@WebServlet(name = "ProsesHapusSatkerServlet", urlPatterns = {"/proses_hapus_satker"})
public class ProsesHapusSatkerServlet extends HttpServlet {

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
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProsesHapusSatkerServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProsesHapusSatkerServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            DaftarSatuanKerja daftarSatuanKerja = new DaftarSatuanKerja();
            List<SatuanKerja> listSatuanKerja = daftarSatuanKerja.getSatuanKerja();
            Collections.sort(listSatuanKerja, new SatuanKerjaComparator());
            String cekSatker[] = request.getParameterValues("cek_satker");
            String jsp = "";
            
            if (cekSatker == null) {
                JOptionPane.showMessageDialog(null, "Satuan Kerja tidak ada yang dipilih",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("list_satker", listSatuanKerja);
                jsp = "pages/satker.jsp";
            } else {
                int j = JOptionPane.showConfirmDialog(null, "apakah anda yakin akan menghapus ?",
                        JOptionPane.MESSAGE_TYPE_PROPERTY, JOptionPane.YES_NO_OPTION);

                if (j == JOptionPane.YES_OPTION) {
                    for (int i = 0; i < cekSatker.length; i++) {
                        long idsatuankerja = Long.parseLong(cekSatker[i]);
                        SatuanKerja saker = daftarSatuanKerja.findSatuanKerja(idsatuankerja);
                        daftarSatuanKerja.destroy(idsatuankerja);
                    }
                }
                listSatuanKerja = daftarSatuanKerja.getSatuanKerja();
                Collections.sort(listSatuanKerja, new SatuanKerjaComparator()); 
                request.setAttribute("list_satker", listSatuanKerja);
                jsp = "pages/satker.jsp";
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
            Logger.getLogger(ProsesHapusBankPosServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProsesHapusBankPosServlet.class.getName()).log(Level.SEVERE, null, ex);
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
