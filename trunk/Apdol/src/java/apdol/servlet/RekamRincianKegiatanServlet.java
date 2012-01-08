/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.entity.Kegiatan;
import apdol.entity.MataAnggaran;
import apdol.entity.Output;
import apdol.entity.SatuanKerja;
import apdol.model.DaftarKegiatan;
import apdol.model.DaftarMataAnggaran;
import apdol.model.DaftarOutput;
import apdol.model.DaftarSatuanKerja;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hari RZ
 */
@WebServlet(name = "RekamRincianKegiatanServlet", urlPatterns = {"/rekam_rincian_kegiatan"})
public class RekamRincianKegiatanServlet extends HttpServlet {

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
            out.println("<title>Servlet RekamServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RekamServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            DaftarSatuanKerja daftarSatuanKerja = new DaftarSatuanKerja();
            List <SatuanKerja> listSatuanKerja = daftarSatuanKerja.getSatuanKerja();
            request.setAttribute("list_satker", listSatuanKerja);
            
            DaftarKegiatan daftarKegiatan = new DaftarKegiatan();
            List <Kegiatan> listKegiatan = daftarKegiatan.getKegiatan();
            request.setAttribute("list_kegiatan", listKegiatan);
            
            DaftarOutput daftarOutput = new DaftarOutput();
            List <Output> listOutput = daftarOutput.getOutput();
            request.setAttribute("list_output", listOutput);
            
            DaftarMataAnggaran daftarMataAnggaran = new DaftarMataAnggaran();
            List <MataAnggaran> listMataAnggaran = daftarMataAnggaran.getMataAnggaran();
            request.setAttribute("list_mata_anggaran", listMataAnggaran);

            String jsp = "pages/rekam_rincian_kegiatan.jsp";
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
