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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {


            String tanggal = request.getParameter("tanggal") + "/";
            String bulan = request.getParameter("bulan") + "/";
            String tahun = request.getParameter("tahun");
            String stringDate = tanggal + bulan + tahun;
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date date = df.parse(stringDate);
            
            DaftarSPM daftarSpm = new DaftarSPM();
            DaftarSP2D daftarSp2d = new DaftarSP2D();
            DaftarBankPos daftarBankPos = new DaftarBankPos();
            
            String idBank = request.getParameter("bank_id");
            BankPos bankPos = daftarBankPos.findBankPos(Long.parseLong(idBank));

            String spmString = request.getParameter("spm_id");
            SPM spm = daftarSpm.findSPM(Long.parseLong(spmString));
            SP2D sp2d = new SP2D();

            Double nomor = 100*Math.random();
             Long nomorSp2d = Math.round(nomor);

            sp2d.setBankpos(bankPos);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ProsesSP2DServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException ex) {
            Logger.getLogger(ProsesSP2DServlet.class.getName()).log(Level.SEVERE, null, ex);
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
