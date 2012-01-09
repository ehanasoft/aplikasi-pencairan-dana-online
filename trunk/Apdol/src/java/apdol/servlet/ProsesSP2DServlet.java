/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.entity.BankPos;
import apdol.entity.SP2D;
import apdol.entity.SPM;
import apdol.model.DaftarBankPos;
import apdol.model.DaftarSP2D;
import apdol.model.DaftarSPM;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "ProsesRekamKegiatanServlet", urlPatterns = {"/proses_rekam_kegiatan"})
public class ProsesSP2DServlet extends HttpServlet {

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

            DaftarSPM daftarSpm = new DaftarSPM();
            DaftarSP2D daftarSp2d = new DaftarSP2D();
            DaftarBankPos daftarBankPos = new DaftarBankPos();
            List<BankPos> listBank = daftarBankPos.getBankPos();
            

            String spmString = request.getParameter("spm_id");
            SPM spm = daftarSpm.findSPM(Long.parseLong(spmString));
            SP2D sp2d = new SP2D();
            
            Date date = new Date();

            Double nomor = 100*Math.random();
             Long nomorSp2d = Math.round(nomor);

            sp2d.setBankpos(listBank.get(0));
            sp2d.setNomorSP2D(nomorSp2d.toString());
            sp2d.setSpm(spm);
            spm.setStatusSpm("terproses");
            daftarSpm.edit(spm);
            sp2d.setTanggalSP2D(date);
            daftarSp2d.rekamSP2D(sp2d);
            
            daftarSpm = new DaftarSPM();
            List<SPM> listSpm = daftarSpm.getSPM();
            request.setAttribute("list_spm", listSpm);

            String jsp = "/pages/proses_sp2d.jsp";
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
