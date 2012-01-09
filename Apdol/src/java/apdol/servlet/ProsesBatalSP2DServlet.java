/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.comparator.Sp2dComparator;
import apdol.entity.SP2D;
import apdol.entity.SPM;
import apdol.model.DaftarSP2D;
import apdol.model.DaftarSPM;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ProsesBatalSP2DServlet extends HttpServlet {

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
            SP2D sp2d = new SP2D();
            DaftarSP2D daftarSP2D = new DaftarSP2D();
            String jsp = "";

            String tanggal = request.getParameter("tanggal") + "/";
            String bulan = request.getParameter("bulan") + "/";
            String tahun = request.getParameter("tahun");
            String stringDate = tanggal + bulan + tahun;
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date date = df.parse(stringDate);
            String nomorTolakSP2D = request.getParameter("nomor_tolak_sp2d");
            String keteranganTolakSP2D = request.getParameter("alasan");
            
            //validate blank field
            if ("".equals(nomorTolakSP2D)) {
                JOptionPane.showMessageDialog(null, "Nomor Batal SP2D tidak boleh kosong !",
                        "Kesalahan!", JOptionPane.WARNING_MESSAGE);
                jsp = "pages/input_batal_sp2d.jsp";
            } else if ("".equals(keteranganTolakSP2D)) {
                JOptionPane.showMessageDialog(null, "Alasan Batal SP2D tidak boleh kosong !",
                        "Kesalahan!", JOptionPane.WARNING_MESSAGE);
                jsp = "pages/input_batal_sp2d.jsp";
            } else {
                sp2d.setTanggalTolakSP2D(date);
                sp2d.setNomorTolakSP2D(nomorTolakSP2D);
                sp2d.setKeteranganTolakSP2D(keteranganTolakSP2D);
                List<SP2D>listSP2D = daftarSP2D.getSP2D();
                Collections.sort(listSP2D, new Sp2dComparator());
                request.setAttribute("list_sp2d", listSP2D);
                jsp = "pages/batal_sp2d.jsp";
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
        } catch (ParseException ex) {
            Logger.getLogger(ProsesBatalSP2DServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProsesBatalSP2DServlet.class.getName()).log(Level.SEVERE, null, ex);
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
