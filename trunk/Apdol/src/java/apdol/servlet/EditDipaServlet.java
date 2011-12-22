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
public class EditDipaServlet extends HttpServlet {

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
            out.println("<title>Servlet EditDipaServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditDipaServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            DaftarRincianKegiatan daftarRincianKegiatan = new DaftarRincianKegiatan();
            List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
            request.setAttribute("list_rincian_kegiatan", listRincianKegiatan);
            
            
            DaftarDipa daftarDipa = new DaftarDipa();
            Dipa rincianKegiatanDipa = new Dipa();
            List<Dipa> listDipa = daftarDipa.getDipa();
            Collections.sort(listDipa, new DipaComparator());
            request.setAttribute("list_dipa", listDipa);
            String jsp = "";
            String cekDipa[] = request.getParameterValues("cek_dipa");

            if (cekDipa == null) {
                JOptionPane.showMessageDialog(null, "Dipa tidak ada yang dipilih");
                jsp = "pages/dipa.jsp";
            } else if (cekDipa.length > 1) {
                JOptionPane.showMessageDialog(null, "Edit salah satu Dipa saja !");
                jsp = "pages/dipa.jsp";
            } else {
                Long idDipa = Long.parseLong(cekDipa[0]);
                Dipa dipa = daftarDipa.findDipa(idDipa);
                request.setAttribute("dipa_edit", dipa);
                request.setAttribute("rincianKegiatanDipa", rincianKegiatanDipa.getRincianKegiatan());
                jsp = "/pages/edit_dipa.jsp";
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
