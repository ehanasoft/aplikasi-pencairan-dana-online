/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.comparator.SpmComparator;
import apdol.entity.SPM;
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
public class ProsesMonitoringSPMServlet extends HttpServlet {

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
            out.println("<title>Servlet ProsesMonitoringSPMServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProsesMonitoringSPMServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            DaftarSPM daftarSPM = new DaftarSPM();
            List<SPM> listSPM = daftarSPM.getSPM();
            Collections.sort(listSPM, new SpmComparator());
            String cekSPM = request.getParameter("proses_monitoring_spm");
            String jsp = "";

            int j = JOptionPane.showConfirmDialog(null, "apakah anda akan melihat status SPM ?",
                    JOptionPane.MESSAGE_TYPE_PROPERTY, JOptionPane.YES_NO_OPTION);

            if (j == JOptionPane.YES_OPTION) {
                long idspm = Long.parseLong(cekSPM);
                SPM spm = daftarSPM.findSPM(idspm);
                String statSPM = "1";
                spm.setStatusSpm(statSPM);
                daftarSPM.edit(spm);
            }            
            
            listSPM = daftarSPM.getSPM();
            Collections.sort(listSPM, new SpmComparator());
            request.setAttribute("list_spm", listSPM);
            jsp = "pages/monitoring_spm.jsp";

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
