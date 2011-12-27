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
public class EditSPMServlet extends HttpServlet {

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
            out.println("<title>Servlet EditSPMServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditSPMServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            DaftarRincianKegiatan daftarRincianKegiatan = new DaftarRincianKegiatan();
            List<RincianKegiatan> listRincianKegiatan = daftarRincianKegiatan.getRincianKegiatan();
            request.setAttribute("list_rincian_kegiatan", listRincianKegiatan);
            
            
            DaftarSPM daftarSPM = new DaftarSPM();
            SPM rincianKegiatanSPM = new SPM();
            List<SPM> listSPM = daftarSPM.getSPM();
            Collections.sort(listSPM, new SpmComparator());
            request.setAttribute("list_spm", listSPM);
            String jsp = "";
            String cekSPM[] = request.getParameterValues("cek_spm");

            if (cekSPM == null) {
                JOptionPane.showMessageDialog(null, "SPM tidak ada yang dipilih");
                jsp = "pages/spm.jsp";
            } else if (cekSPM.length > 1) {
                JOptionPane.showMessageDialog(null, "Edit salah satu SPM saja !");
                jsp = "pages/spm.jsp";
            } else {
                Long idSPM = Long.parseLong(cekSPM[0]);
                SPM spm = daftarSPM.findSPM(idSPM);
                request.setAttribute("spm_edit", spm);
                request.setAttribute("rincianKegiatanSPM", rincianKegiatanSPM.getRincianKegiatan());
                jsp = "/pages/edit_spm.jsp";
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
