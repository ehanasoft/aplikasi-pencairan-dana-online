/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.comparator.KegiatanComparator;
import apdol.entity.Kegiatan;
import apdol.model.DaftarKegiatan;
import apdol.model.exceptions.NonexistentEntityException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
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
@WebServlet(name = "ProsesRekamKegiatanServlet", urlPatterns = {"/ProsesRekamKegiatanServlet"})
public class ProsesEditKegiatanServlet extends HttpServlet {

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
            DaftarKegiatan daftarKegiatan = new DaftarKegiatan();
            String jsp = "";
            // List<Kegiatan> listkegiatan = daftarKegiatan.getKegiatan();

            String kodeKegiatan = request.getParameter("kode_kegiatan");
            String namaKegiatan = request.getParameter("nama_kegiatan");
            String cekKegiatan[] =  request.getParameterValues("cek_kegiatan");
            String indexString = request.getParameter("index");
            for (int i = 0;i <cekKegiatan.length;i++) JOptionPane.showMessageDialog(null, cekKegiatan[i]);

            String idKegiatan = request.getParameter("id_edit_kegiatan");
            Long longIdKegiatan = Long.parseLong(idKegiatan);
            Kegiatan kegiatan = daftarKegiatan.findKegiatan(longIdKegiatan);

            if (kodeKegiatan == "") {
                JOptionPane.showMessageDialog(null, "Kode Kegiatan tidak boleh kosong !");
                request.setAttribute("kegiatan_edit", kegiatan);
                jsp = "pages/edit_kegiatan.jsp";
            } else if (namaKegiatan == "") {
                JOptionPane.showMessageDialog(null, "Nama Kegiatan tidak boleh kosong !");
                request.setAttribute("kegiatan_edit", kegiatan);
                jsp = "pages/edit_kegiatan.jsp";
            } //validate length field
            else if (kodeKegiatan.length() < 4) {
                JOptionPane.showMessageDialog(null, "Kode Kegiatan harus 4 angka !");
                request.setAttribute("kegiatan_edit", kegiatan);
                jsp = "pages/edit_kegiatan.jsp";
            } //validate kodeKegiatan are numbers and not minus
            else if (!this.valNumber(kodeKegiatan)) {
                JOptionPane.showMessageDialog(null, "Kode Kegiatan harus angka dan tidak boleh minus !");
                request.setAttribute("kegiatan_edit", kegiatan);
                jsp = "pages/edit_kegiatan.jsp";
            } //validate zero value
            else if (kodeKegiatan.equalsIgnoreCase("0000")) {
                JOptionPane.showMessageDialog(null, "Kode Kegiatan tidak boleh bernilai nol !");
                request.setAttribute("kegiatan_edit", kegiatan);
                jsp = "pages/edit_kegiatan.jsp";
            } //validate kodeKegiatan on database
            else if (daftarKegiatan.isKodeExist(kodeKegiatan) && !kegiatan.isKodeNoChange(kodeKegiatan)) {
                JOptionPane.showMessageDialog(null, "Kode Kegiatan sudah ada dalam data base !");
                request.setAttribute("kegiatan_edit", kegiatan);
                jsp = "pages/edit_kegiatan.jsp";
            } //validate namaKegiatan on database
            else if (daftarKegiatan.isKodeExist(namaKegiatan) && !kegiatan.isNamaNoChange(namaKegiatan)) {
                JOptionPane.showMessageDialog(null, "Kegiatan sudah ada dalam data base !");
                request.setAttribute("kegiatan_edit", kegiatan);
                jsp = "pages/edit_kegiatan.jsp";
            } else {
                kegiatan.setKdgiat(kodeKegiatan);
                kegiatan.setNmgiat(namaKegiatan);
                daftarKegiatan.edit(kegiatan);
                List<Kegiatan> listKegiatan = daftarKegiatan.getKegiatan();
                listKegiatan = daftarKegiatan.getKegiatan();
                Collections.sort(listKegiatan, new KegiatanComparator());
                request.setAttribute("list_kegiatan", listKegiatan);
                jsp = "pages/kegiatan.jsp";
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
            if (i >= 0) {
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
            Logger.getLogger(ProsesEditKegiatanServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProsesEditKegiatanServlet.class.getName()).log(Level.SEVERE, null, ex);
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
