/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.comparator.PejabatComparator;
import apdol.entity.Pejabat;
import apdol.entity.SatuanKerja;
import apdol.model.DaftarPejabat;
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
 * @author AlfieSaHid
 */
public class EditPejabatServlet extends HttpServlet {

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
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditPejabatServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditPejabatServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            DaftarSatuanKerja daftarSatker = new DaftarSatuanKerja();
            List<SatuanKerja> listSatker = daftarSatker.getSatuanKerja();
            request.setAttribute("list_satker", listSatker);
            
            
            DaftarPejabat daftarPejabat = new DaftarPejabat();
            Pejabat satkerPejabat = new Pejabat();
            List<Pejabat> listPejabat = daftarPejabat.getPejabat();
            Collections.sort(listPejabat, new PejabatComparator());
            request.setAttribute("list_pejabat", listPejabat);
            String jsp = "";
            String cekPejabat[] = request.getParameterValues("edit_pejabat");

            if (cekPejabat == null) {
                JOptionPane.showMessageDialog(null, "Pejabat tidak ada yang dipilih");
                jsp = "pages/pejabat.jsp";
            } else if (cekPejabat.length > 1) {
                JOptionPane.showMessageDialog(null, "Edit salah satu Pejabat saja !");
                jsp = "pages/pejabat.jsp";
            } else {
                Long idPejabat = Long.parseLong(cekPejabat[0]);
                Pejabat pejabat = daftarPejabat.findPejabat(idPejabat);
                request.setAttribute("pejabat_edit", pejabat);
                request.setAttribute("satkerPejabat", satkerPejabat.getSatker());
                jsp = "/pages/edit_pejabat.jsp";
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
