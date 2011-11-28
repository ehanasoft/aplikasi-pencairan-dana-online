/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.comparator.OutputComparator;
import apdol.entity.Output;
import apdol.model.DaftarOutput;
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
@WebServlet(name = "ProsesRekamOutputServlet", urlPatterns = {"/ProsesRekamOutputServlet"})
public class ProsesEditOutputServlet extends HttpServlet {

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
            DaftarOutput daftarOutput = new DaftarOutput();
            String jsp = "";
            // List<Output> listoutput = daftarOutput.getOutput();

            String kodeOutput = request.getParameter("kode_output");
            String namaOutput = request.getParameter("nama_output");

            String idOutput = request.getParameter("id_edit_output");
            Long longIdOutput = Long.parseLong(idOutput);
            Output output = daftarOutput.findOutput(longIdOutput);

            if (kodeOutput == "") {
                JOptionPane.showMessageDialog(null, "Kode Output tidak boleh kosong !");
                request.setAttribute("output_edit", output);
                jsp = "pages/edit_output.jsp";
            } else if (namaOutput == "") {
                JOptionPane.showMessageDialog(null, "Nama Output tidak boleh kosong !");
                request.setAttribute("output_edit", output);
                jsp = "pages/edit_output.jsp";
            } //validate length field
            else if (kodeOutput.length() < 2) {
                JOptionPane.showMessageDialog(null, "Kode Output harus 2 angka !");
                request.setAttribute("output_edit", output);
                jsp = "pages/edit_output.jsp";
            } //validate kodeOutput are numbers and not minus
            else if (!this.valNumber(kodeOutput)) {
                JOptionPane.showMessageDialog(null, "Kode Output harus angka !");
                request.setAttribute("output_edit", output);
                jsp = "pages/edit_output.jsp";
            } //validate zero value
            else if (kodeOutput.equalsIgnoreCase("0000")) {
                JOptionPane.showMessageDialog(null, "Kode Output tidak boleh bernilai nol !");
                request.setAttribute("output_edit", output);
                jsp = "pages/edit_output.jsp";
            } //validate kodeOutput on database
            else if (daftarOutput.isKodeExist(kodeOutput) && !output.isKodeNoChange(kodeOutput)) {
                JOptionPane.showMessageDialog(null, "Kode Output sudah ada dalam data base !");
                request.setAttribute("output_edit", output);
                jsp = "pages/edit_output.jsp";
            } //validate namaOutput on database
            else if (daftarOutput.isOutputExist(namaOutput) && !output.isNamaNoChange(namaOutput)) {
                JOptionPane.showMessageDialog(null, "Output sudah ada dalam data base !");
                request.setAttribute("output_edit", output);
                jsp = "pages/edit_output.jsp";
            } else {
                output.setKodeOutput(kodeOutput);
                output.setNamaOutput(namaOutput);
                daftarOutput.edit(output);
                List<Output> listOutput = daftarOutput.getOutput();
                listOutput = daftarOutput.getOutput();
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
        try {
            processRequest(request, response);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ProsesEditOutputServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProsesEditOutputServlet.class.getName()).log(Level.SEVERE, null, ex);
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
