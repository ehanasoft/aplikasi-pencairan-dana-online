/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apdol.servlet;

import apdol.entity.BankPos;
import apdol.model.DaftarBankPos;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AddBankPosServlet", urlPatterns = {"/AddBankPosServlet"})
public class AddBankPosServlet extends HttpServlet {

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
            out.println("<title>Servlet AddBankPosServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddBankPosServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */

            BankPos bankpos = new BankPos();
            DaftarBankPos daftarBankPos = new DaftarBankPos();
            String jsp = "index.jsp";

            String kodeBank = request.getParameter("kdbankpos");
            String namaBank = request.getParameter("nmbankpos");
            bankpos.setKdbankpos(kodeBank);
            bankpos.setNmbankpos(namaBank);
            daftarBankPos.rekamBankPos(bankpos);

            //validate blank field
            if (kodeBank == "") {
                JOptionPane.showMessageDialog(null, "Kode Bank Pos tidak boleh kosong !");
                jsp = "pages/Referensi/rekambankpos.jsp";
            } else if (namaBank == null) {
                JOptionPane.showMessageDialog(null, "Nama Bank Pos tidak boleh kosong !");
                jsp = "pages/rekambankpos.jsp";
            } 
            
            //validate zero value
            else if (kodeBank.equalsIgnoreCase("000")) {
                JOptionPane.showMessageDialog(null, "Kode Bank Pos tidak boleh bernilai nol !");
                jsp = "pages/rekambankpos.jsp";
            } 
            
            //validate length field
            else if (kodeBank.length() < 3) {
                JOptionPane.showMessageDialog(null, "Kode Bank Pos harus 3 angka !");
                jsp = "pages/rekambankpos.jsp";
            } 
            
            //validate kodeLokasi are numbers
            else if (!bankpos.valNumber(kodeBank)) {
                JOptionPane.showMessageDialog(null, "Kode Bank Pos harus angka !");
                jsp = "pages/rekambankpos.jsp";
            } 
            
            //validate record on database
            else if (bankpos.valKodeBank()) {
                JOptionPane.showMessageDialog(null, "Kode Bank Pos sudah ada dalam database !");
                jsp = "pages/rekambankpos.jsp";
            } else if (bankpos.valNamaBank()) {
                JOptionPane.showMessageDialog(null, "Bank Pos sudah ada dalam database !");
                jsp = "pages/rekambankpos.jsp";
            } else {
                daftarBankPos.rekamBankPos(bankpos);
                jsp = "pages/bankpos.jsp";
            }

            List<BankPos> listBank = daftarBankPos.getBankPos();
            request.setAttribute("listbank", listBank);
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
