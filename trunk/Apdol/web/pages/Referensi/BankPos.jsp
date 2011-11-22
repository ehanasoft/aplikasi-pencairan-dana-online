<%-- 
    Document   : BankPos
    Created on : Nov 15, 2011, 9:08:49 AM
    Author     : AlfieSaHid
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <%String logedUser = (String) session.getAttribute("username");%>
    <%String roleUser = (String) session.getAttribute("roleuser");%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Bank Pos</title>
        <link href="styles/style2.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <center><div class="header"><img src="images/sederhana.jpg" /></div></center>

        <div class="container">
            <div class="sidebar1">
                <p><strong>Utilitas</strong></p>
                <ul class="nav">
                    <li><a href="register">Registrasi</a></li>
                </ul>
                <p><strong>Dokumen</strong></p>
                <ul class="nav">
                    <li><a href="dipa">DIPA</a></li>
                </ul>
                <p><strong>Referensi</strong></p>
                <ul class="nav">
                    <li><a href="#">Satuan Kerja</a></li>
                    <li><a href="bankpos">Bank Pos</a></li>
                    <li><a href="#">Pejabat</a></li>
                    <li><a href="#">Program</a></li>
                    <li><a href="#">Kegiatan</a></li>
                    <li><a href="#">Output</a></li>
                    <li><a href="#">Mata Anggaran</a></li>
                    <li><a href="lokasi">Lokasi</a></li>
                </ul>
                <p></p>
                <p></p>
                <p></p>
                <!-- end .sidebar1 --></div>
            <div class="logout"><a href="logout">[Log Out]</a>
                <!-- end .logout --></div>
            <div class="content">
                <h3>Daftar Bank Pos</h3>
                <form>
                <table width="600" border="1">
                    <tr>                        
                        <td><div align="center">Pilih</div></td>
                        <td>Kode</td>
                        <td>Nama Bank Pos</td>                        
                    </tr>
                    <c:forEach items="${listbank}" var="bank">
                        <tr>                                                       
                            <td><div align="center"><input type="checkbox" name="checkbox" value="checkbox" /></div></td>
                            <td>${bank.kdbankpos}</td>
                            <td>${bank.nmbankpos}</td>                            
                        </c:forEach>
                    </tr>
                </table>
                <p>
                    <input type="submit" name="Rekam" value="Rekam" formaction="rekambankpos" formmethod="post"/>
                    <input type="submit" name="Ubah" value="Ubah" />
                    <input type="submit" name="Hapus" value="Hapus" />
                </p>
                </form>
                <!-- end .content --></div>
            <!-- end .container --></div>
    </body>
</html>