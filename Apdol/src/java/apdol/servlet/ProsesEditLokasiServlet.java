/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.comparator.LokasiComparator;
import apdol.entity.Lokasi;
import apdol.model.DaftarLokasi;
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
 * @author Hari RZ
 */
@WebServlet(name = "ProsesRekamLokasiServlet", urlPatterns = {"/ProsesRekamLokasiServlet"})
public class ProsesEditLokasiServlet extends HttpServlet {

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
            out.println("<title>Servlet ProsesRekamLokasiServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProsesRekamLokasiServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            DaftarLokasi daftarLokasi = new DaftarLokasi();
            String jsp = "";
            // List<Lokasi> listlokasi = daftarLokasi.getLokasi();

            String kodeLokasi = request.getParameter("kodelokasi");
            String namaKota = request.getParameter("namakota");
            String namaPropinsi = request.getParameter("namapropinsi");

            String idLokasi = request.getParameter("ideditlokasi");
            Long longIdLokasi = Long.parseLong(idLokasi);
            Lokasi lokasi = daftarLokasi.findLokasi(longIdLokasi);

            if (kodeLokasi == "") {
                JOptionPane.showMessageDialog(null, "Kode Lokasi tidak boleh kosong !");
                request.setAttribute("lokasiedit", lokasi);
                jsp = "pages/editLokasi.jsp";
            } else if (namaKota == null) {
                JOptionPane.showMessageDialog(null, "Nama Kota tidak boleh kosong !");
                request.setAttribute("lokasiedit", lokasi);
                jsp = "pages/editLokasi.jsp";
            } else if (namaPropinsi == null) {
                JOptionPane.showMessageDialog(null, "Nama Propinsi tidak boleh kosong !");
                request.setAttribute("lokasiedit", lokasi);
                jsp = "pages/editLokasi.jsp";
            } //validate zero value
            else if (kodeLokasi.equalsIgnoreCase("0000")) {
                JOptionPane.showMessageDialog(null, "Kode Lokasi tidak boleh bernilai nol !");
                request.setAttribute("lokasiedit", lokasi);
                jsp = "pages/editLokasi.jsp";
            } //validate length field
            else if (kodeLokasi.length() < 4) {
                JOptionPane.showMessageDialog(null, "Kode Lokasi harus 4 angka !");
                request.setAttribute("lokasiedit", lokasi);
                jsp = "pages/editLokasi.jsp";
            } //validate kodeLokasi are numbers
            else if (!lokasi.valNumber(kodeLokasi)) {
                JOptionPane.showMessageDialog(null, "Kode Lokasi harus angka !");
                request.setAttribute("lokasiedit", lokasi);
                jsp = "pages/editLokasi.jsp";
            } //validate record on database
            else if (lokasi.valKodeLokasi(kodeLokasi)) {
                JOptionPane.showMessageDialog(null, "Kode Lokasi sudah ada dalam data base !");
                request.setAttribute("lokasiedit", lokasi);
                jsp = "pages/editLokasi.jsp";
            } else if (lokasi.valNamaKota(namaKota)) {
                JOptionPane.showMessageDialog(null, "Kota sudah ada dalam data base !");
                request.setAttribute("lokasiedit", lokasi);
                jsp = "pages/editLokasi.jsp";
            } else {
                lokasi.setKodeLokasi(kodeLokasi);
                lokasi.setNamaKota(namaKota);
                lokasi.setNamaPropinsi(namaPropinsi);
                daftarLokasi.edit(lokasi);
                List<Lokasi> listLokasi = daftarLokasi.getLokasi();
                listLokasi = daftarLokasi.getLokasi();
                Collections.sort(listLokasi, new LokasiComparator());
                request.setAttribute("listlokasi", listLokasi);
                jsp = "pages/lokasi2.jsp";
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
            Logger.getLogger(ProsesEditLokasiServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProsesEditLokasiServlet.class.getName()).log(Level.SEVERE, null, ex);
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
