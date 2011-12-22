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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author AlfieSaHid
 */
@WebServlet(name = "ProsesRekamPejabatServlet", urlPatterns = {"/proses_rekam_pejabat"})
public class ProsesRekamPejabatServlet extends HttpServlet {

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
            out.println("<title>Servlet ProsesRekamPejabatServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProsesRekamPejabatServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            Pejabat pejabat = new Pejabat();
            DaftarPejabat daftarPejabat = new DaftarPejabat();
            
            String jsp = "";
                        
            String nip = request.getParameter("nip");
            String nama = request.getParameter("nama");
            String kdgol = request.getParameter("golongan");
            String nmjabatan = request.getParameter("jabatan");
            String ketjabatan = request.getParameter("keterangan");
            String kodeSatker = request.getParameter("satker");
            
            SatuanKerja satker = new SatuanKerja();
            DaftarSatuanKerja daftarSatker = new DaftarSatuanKerja();
            List<SatuanKerja> listSatker = daftarSatker.findSatkerByKode(kodeSatker);
            satker = listSatker.get(0);

            //validate blank field
            if ("".equals(nip)) {
                JOptionPane.showMessageDialog(null, "NIP tidak boleh kosong !", 
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                jsp = "pages/rekam_pejabat.jsp";
            } else if ("".equals(nama)) {
                JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                jsp = "pages/rekam_pejabat.jsp";            
            } else if ("".equals(nmjabatan)) {
                JOptionPane.showMessageDialog(null, "Jabatan tidak boleh kosong !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                jsp = "pages/rekam_pejabat.jsp";
            } else if ("".equals(ketjabatan)) {
                JOptionPane.showMessageDialog(null, "Keterangan jabatan tidak boleh kosong !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                jsp = "pages/rekam_pejabat.jsp";
            }
            
            //validate length field
            else if (nip.length() < 18) {
                JOptionPane.showMessageDialog(null, "NIP harus 18 angka !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                jsp = "pages/rekam_pejabat.jsp";
            } 
            
            //validate nip are numbers
            else if (!this.valNumber(nip)) {
                JOptionPane.showMessageDialog(null, "NIP harus angka dan tidak boleh minus !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                jsp = "pages/rekam_pejabat.jsp";
            } 
            
            //validate zero value
            else if (nip.equalsIgnoreCase("000000")) {
                JOptionPane.showMessageDialog(null, "NIP tidak boleh bernilai nol !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                jsp = "pages/rekam_pejabat.jsp";
            } 
            
            //validate record on database
            else if (daftarPejabat.isKodeExist(nip)) {
                JOptionPane.showMessageDialog(null, "NIP sudah ada dalam database !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                jsp = "pages/rekam_pejabat.jsp";
            } else if (daftarPejabat.isNamaExist(nama)) {
                JOptionPane.showMessageDialog(null, "Nama sudah ada dalam database !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                jsp = "pages/rekam_pejabat.jsp";
            } else {
                pejabat.setNip(nip);
                pejabat.setNama(nama);
                pejabat.setKdgol(kdgol);
                pejabat.setNmjabatan(nmjabatan);
                pejabat.setKetjabatan(ketjabatan);
                pejabat.setSatker(satker);
                daftarPejabat.rekamPejabat(pejabat);
                List<Pejabat> listPejabat = daftarPejabat.getPejabat();
                Collections.sort(listPejabat, new PejabatComparator());
                request.setAttribute("list_pejabat", listPejabat);
                jsp = "pages/pejabat.jsp";
            }
            request.setAttribute("list_satker", listSatker);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(jsp);
            requestDispatcher.forward(request, response);
        } finally {
            out.close();
        }
    }
    
    //validate number
    public boolean valNumber(String nip) {
        int j;
        try {
            for (int i = 0; i < nip.length(); i++) {
                String c = nip.substring(i,i+1);
                j = Integer.parseInt(c);
            }
            return true;
            } catch (Exception e) {
            return false;
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
