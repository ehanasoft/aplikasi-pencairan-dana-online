<%-- 
    Document   : edit_user
    Created on : Nov 29, 2011, 7:47:46 AM
    Author     : wahid
--%>

<%@page import="apdol.model.DaftarUser"%>
<%@page import="apdol.entity.User"%>
<%@page import="javax.swing.JOptionPane"%>
<% User user = (User) request.getAttribute("user_edit");%>

<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <%String logedUser = (String) session.getAttribute("username");%>
    <%String roleUser = (String) session.getAttribute("roleuser");%>    
    <script  language = "Javascript">

        function ResetForm(which){
            var pass=true
            var first=-1
            if (document.images){
                for (i=0;i<which.length;i++){
                    var tempobj=which.elements[i]
                    if (tempobj.type=="text"){
                        eval(tempobj.value="")
                        if (first==-1) {first=i}
                    }
                    else if (tempobj.type=="checkbox") {
                        eval(tempobj.checked=0)
                        if (first==-1) {first=i}
                    }
                    else if (tempobj.col!="") {
                        eval(tempobj.value="")
                        if (first==-1) {first=i}
                    }
                }
            }
            which.elements[first].focus()
            return false
        }
    </script>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Rekam User</title>
        <link href="styles/style2.css" rel="stylesheet" type="text/css" /><!--[if lte IE 7]>
        <style>
        .content { margin-right: -1px; } /* this 1px negative margin can be placed on any of the columns in this layout with the same corrective effect. */
        ul.nav a { zoom: 1; }  /* the zoom property gives IE the hasLayout trigger it needs to correct extra whiltespace between the links */
        </style>
        <![endif]-->
    </head>

    <body>
        <center><div class="header"><img src="images/sederhana.jpg" /></div></center>

        <div class="container">
            <div class="sidebar1">
                <% if (roleUser.equals("1")) {%>
                <p><strong>Dokumen</strong></p> 
                <ul class="nav">
                    <li><a href="dipa">DIPA</a></li>
                </ul>
                <p><strong>Referensi</strong></p> 
                <ul class="nav">
                    <li><a href="#">Satuan Kerja</a></li>
                    <li><a href="#">Bank Pos</a></li>
                    <li><a href="#">Pejabat</a></li>
                    <li><a href="#">Program</a></li>
                    <li><a href="#">Kegiatan</a></li>
                    <li><a href="#">Output</a></li>
                    <li><a href="mata_anggaran">Mata Anggaran</a></li>
                    <li><a href="lokasi">Lokasi</a></li>
                </ul>
                <p><strong>Utilitas</strong></p>
                <ul class="nav">
                    <li><a href="register">Registrasi User</a></li>
                </ul>
                <% } else if (roleUser.equals("2")) {%>
                <p><strong>Dokumen</strong></p> 
                <ul class="nav">
                    <li><a href="#">Tayang DIPA</a></li>
                </ul>
                <p><strong>Pencairan</strong></p> 
                <ul class="nav">
                    <li><a href="#">Surat Perintah Membayar</a></li>
                </ul>
                <p><strong>Monitoring</strong></p>
                <ul class="nav">
                    <li><a href="#">Realisasi</a></li>
                </ul>
                <p><strong>Utilitas</strong></p>
                <ul class="nav">
                    <li><a href="#">Cetak SPM</a></li>	
                    <li><a href="#">Submit ke KPPN</a></li>
                </ul>
                <% } else if (roleUser.equals("3")) {%>
                <p><strong>Dokumen</strong></p> 
                <ul class="nav">
                    <li><a href="#">Tayang DIPA</a></li>
                </ul>
                <p><strong>Penerimaan</strong></p> 
                <ul class="nav">
                    <li><a href="#">Notifikasi SPM</a></li>
                    <li><a href="#">Tolak SPM</a></li>
                </ul>  
                <p><strong>Pencairan</strong></p> 
                <ul class="nav">
                    <li><a href="#">Proses SP2D</a></li>
                    <li><a href="#">Batal SP2D</a></li>
                </ul>
                <p><strong>Utilitas</strong></p>
                <ul class="nav">
                    <li><a href="#">Cetak SP2D</a></li>	
                </ul>  
                <% }%>
                <p></p>
                <p></p>
                <p></p>


                <!-- end .sidebar1 --></div>
            <div class="logout"><a href="logout">[Log Out]</a>
                <!-- end .logout --></div>
            <div class="content">
                <p><% if (logedUser != null) {%><%="Anda Login sebagai: " + logedUser + " " + roleUser%><%}%></p>
                <center><p><h3> Rekam User</h3></p>
                    <form imgReset="return ResetForm(this)" action="proses_rekam_user" method="post" >
                        <table width="400px">
                            <tr>
                                <td>Username</td><td><input type="text" name="username" style="width: 200px" value="<%=user.getUsername()%>"</td>
                            </tr>
                            <tr>
                                <td>Password</td><td><input type="text" name="password" style="width: 200px" value="<%=user.getPassword()%>"</td>
                            </tr>
                            <tr>
                                <td>Nama</td><td><input type="text" name="nama" style="width: 200px" value="<%=user.getNama()%>"</td>
                            </tr>
                            <tr>
                                <td>Kode Satker</td><td><input type="text" name="kodesatker" style="width: 200px" value="<%=user.getKodeSatker()%>"</td>
                            </tr>
                            <tr>
                                <td>Jabatan</td><td><input type="text" name="jabatan" style="width: 200px" value="<%=user.getJabatan()%>"</td>
                            </tr>
                            <tr>
                                <td>Role User</td><td><select name="roleuser">
                                        <option value="2">Bendahara</option>
                                        <option value="3">KPPN</option> </select></td>
                            </tr></table>
                        <p><input type="hidden" name="id_edit_user" value="<%=user.getId()%>"></p>
                        <table width="400px"><tr>
                                <td align="center"><input type="image" name="imgReset" src="images/reset.png"><input name="Submit" src="images/simpan.png" type="image" value="Simpan" ></td>
                                            </tr>
                                            </table>
                                            </form>
                                            </center>          
                                            <!-- end .content --></div>
                                            <!-- end .container --></div>
                                            </body>
                                            </html>