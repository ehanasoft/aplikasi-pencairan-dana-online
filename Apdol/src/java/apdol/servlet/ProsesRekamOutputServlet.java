/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.comparator.OutputComparator;
import apdol.entity.Output;
import apdol.model.DaftarOutput;
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
 * @author Hari RZ
 */
@WebServlet(name = "ProsesRekamOutputServlet", urlPatterns = {"/ProsesRekamOutputServlet"})
public class ProsesRekamOutputServlet extends HttpServlet {

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

            Output output = new Output();
            DaftarOutput daftarOutput = new DaftarOutput();
            String jsp = "";

            String kodeOutput = request.getParameter("kode_output");
            String namaOutput = request.getParameter("nama_output");

            //validate blank field
            if (kodeOutput == "") {
                JOptionPane.showMessageDialog(null, "Kode Output tidak boleh kosong !");
                jsp = "pages/rekam_output.jsp";
            } else if (namaOutput == "") {
                JOptionPane.showMessageDialog(null, "Nama Output tidak boleh kosong !");
                jsp = "pages/rekam_output.jsp";
            } //validate length field
            else if (kodeOutput.length() < 2) {
                JOptionPane.showMessageDialog(null, "Kode Output harus 2 angka !");
                jsp = "pages/rekam_output.jsp";
            } //validate kodeOutput are numbers
            else if (!this.valNumber(kodeOutput)) {
                JOptionPane.showMessageDialog(null, "Kode Output harus angka dan tidak boleh minus !");
                jsp = "pages/rekam_output.jsp";
            } //validate zero value
            else if (kodeOutput.equalsIgnoreCase("000000")) {
                JOptionPane.showMessageDialog(null, "Kode Output tidak boleh bernilai nol !");
                jsp = "pages/rekam_output.jsp";
            } //validate record on database
            else if (daftarOutput.isKodeExist(kodeOutput)) {
                JOptionPane.showMessageDialog(null, "Kode Output sudah ada dalam database !");
                jsp = "pages/rekam_output.jsp";
            } //validate record on database
            else if (daftarOutput.isOutputExist(namaOutput)) {
                JOptionPane.showMessageDialog(null, "Output sudah ada dalam database !");
                jsp = "pages/rekam_output.jsp";
            } else {
                output.setKodeOutput(kodeOutput);
                output.setNamaOutput(namaOutput);
                daftarOutput.rekamOutput(output);
                List<Output> listOutput = daftarOutput.getOutput();
                Collections.sort(listOutput, new OutputComparator());
                request.setAttribute("list_output", listOutput);
                jsp = "pages/output.jsp";
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
