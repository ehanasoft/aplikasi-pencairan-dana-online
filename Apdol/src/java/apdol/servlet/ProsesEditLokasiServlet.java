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
            DaftarLokasi daftarLokasi = new DaftarLokasi();
            String jsp = "";
            // List<Lokasi> listlokasi = daftarLokasi.getLokasi();

            String kodeLokasi = request.getParameter("kode_lokasi");
            String namaKota = request.getParameter("nama_kota");
            String namaPropinsi = request.getParameter("nama_propinsi");

            String idLokasi = request.getParameter("id_edit_lokasi");
            Long longIdLokasi = Long.parseLong(idLokasi);
            Lokasi lokasi = daftarLokasi.findLokasi(longIdLokasi);

            if (kodeLokasi == "") {
                JOptionPane.showMessageDialog(null, "Kode Lokasi tidak boleh kosong !");
                request.setAttribute("lokasi_edit", lokasi);
                jsp = "pages/edit_lokasi.jsp";
            } else if (namaKota == "") {
                JOptionPane.showMessageDialog(null, "Nama Kota tidak boleh kosong !");
                request.setAttribute("lokasi_edit", lokasi);
                jsp = "pages/edit_lokasi.jsp";
            } else if (namaPropinsi == "") {
                JOptionPane.showMessageDialog(null, "Nama Propinsi tidak boleh kosong !");
                request.setAttribute("lokasi_edit", lokasi);
                jsp = "pages/edit_lokasi.jsp";
            } //validate length field
            else if (kodeLokasi.length() < 4) {
                JOptionPane.showMessageDialog(null, "Kode Lokasi harus 4 angka !");
                request.setAttribute("lokasi_edit", lokasi);
                jsp = "pages/edit_lokasi.jsp";
            } //validate kodeLokasi are numbers and not minus
            else if (!this.valNumber(kodeLokasi)) {
                JOptionPane.showMessageDialog(null, "Kode Lokasi harus angka !");
                request.setAttribute("lokasi_edit", lokasi);
                jsp = "pages/edit_lokasi.jsp";
            } //validate zero value
            else if (kodeLokasi.equalsIgnoreCase("0000")) {
                JOptionPane.showMessageDialog(null, "Kode Lokasi tidak boleh bernilai nol !");
                request.setAttribute("lokasi_edit", lokasi);
                jsp = "pages/edit_lokasi.jsp";
            } //validate kodeLokasi on database
            else if (daftarLokasi.isKodeExist(kodeLokasi) && !lokasi.isKodeNoChange(kodeLokasi)) {
                JOptionPane.showMessageDialog(null, "Kode Lokasi sudah ada dalam data base !");
                request.setAttribute("lokasi_edit", lokasi);
                jsp = "pages/edit_lokasi.jsp";
            } //validate namaKota on database
            else if (daftarLokasi.isKotaExist(namaKota) && !lokasi.isNamaNoChange(namaKota)) {
                JOptionPane.showMessageDialog(null, "Kota sudah ada dalam data base !");
                request.setAttribute("lokasi_edit", lokasi);
                jsp = "pages/edit_lokasi.jsp";
            } else {
                lokasi.setKodeLokasi(kodeLokasi);
                lokasi.setNamaKota(namaKota);
                lokasi.setNamaPropinsi(namaPropinsi);
                daftarLokasi.edit(lokasi);
                List<Lokasi> listLokasi = daftarLokasi.getLokasi();
                listLokasi = daftarLokasi.getLokasi();
                Collections.sort(listLokasi, new LokasiComparator());
                request.setAttribute("list_lokasi", listLokasi);
                jsp = "pages/lokasi.jsp";
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(jsp);
            requestDispatcher.forward(request, response);
        } finally {
            out.close();
        }
    }

    public boolean valNumber(String kode) {
        try {
            int i = Integer.parseInt(kode);
            //validate minus input
            if (i > 0) {
                return true;
            }
            return false;
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
