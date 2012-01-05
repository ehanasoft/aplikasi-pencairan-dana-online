<%-- 
    Document   : edit_user
    Created on : Nov 29, 2011, 7:47:46 AM
    Author     : wahid
--%>

<%@page import="apdol.model.DaftarUser"%>
<%@page import="apdol.entity.User"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="apdol.model.DaftarSatuanKerja"%>
<%@page import="apdol.entity.SatuanKerja"%>
<%@page import="javax.swing.JOptionPane"%>


<% User user = (User) request.getAttribute("user_edit");%>

<% List<SatuanKerja> listSatker = (List<SatuanKerja>) request.getAttribute("list_satker");%>
<% SatuanKerja satker;%>
<% Iterator<SatuanKerja> iterator = listSatker.iterator();%>

<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <%String logedUser = (String) session.getAttribute("username");%>
    <%String roleUser = (String) session.getAttribute("roleuser");%>


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Edit User</title>
        <link href="styles/style2.css" rel="stylesheet" type="text/css" /><!--[if lte IE 7]>
        <style>
        .content { margin-right: -1px; } /* this 1px negative margin can be placed on any of the columns in this layout with the same corrective effect. */
        ul.nav a { zoom: 1; }  /* the zoom property gives IE the hasLayout trigger it needs to correct extra whiltespace between the links */
        </style>
        <![endif]-->
        <script type = "text/javascript">
            function disableDrop(){
                if(form_edit_user.roleuser.options[0].selected){
                    form_edit_user.satker.disabled = false;
                }
                else{
                    form_edit_user.satker.disabled = true;
                }
            }
        </script>
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
                    <li><a href="satker">Satuan Kerja</a></li>
                    <li><a href="bank_pos">Bank Pos</a></li>
                    <li><a href="pejabat">Pejabat</a></li>
                    <li><a href="program">Program</a></li>
                    <li><a href="kegiatan">Kegiatan</a></li>
                    <li><a href="output">Output</a></li>
                    <li><a href="mata_anggaran">Mata Anggaran</a></li>
                    <li><a href="rincian_kegiatan">Rincian Kegiatan</a></li>
                    <li><a href="lokasi">Lokasi</a></li>
                </ul>
                <p><strong>Utilitas</strong></p>
                <ul class="nav">
                    <li><a href="user">Registrasi User</a></li>
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
            <div class="logout"><a href="logout"><img src="images/logout.png"/></a>
                <!-- end .logout --></div>
            <div class="content">
                <center><p><% if (logedUser != null) {%><%="Anda Login sebagai: " + logedUser%><%}%></p></center>
                <center><p><h3>Edit User</h3></p>
                    <form name="form_edit_user" action="proses_edit_user" method="post" >
                        <table width="400px">                                
                            <tr>
                                <td width="175px">Nama</td><td><input name="nama" type="text" style="width: 200px" value="<%=user.getNama()%>"></td>
                            </tr>
                            <tr>
                                <td>Jabatan</td><td><input type="text" name="jabatan" style="width: 200px" value="<%=user.getJabatan()%>"></td>
                            </tr>
                            <td width="175px">Username</td><td><input name="username" type="text" style="width: 200px" value="<%=user.getUsername()%>"></td>
                            </tr>
                            <tr>
                                <td>Password</td><td><input type="password" name="password" style="width: 200px" value="<%=user.getPassword()%>"></td>
                                <tr>
                                    <td width="150px">Role User</td>
                                    <td><select name="roleuser" onchange = "disableDrop();">
                                            <option value="2" <% if (user.getRoleuser().equals("2")) {
                                                out.println(" selected=\"selected\"");
                                            }%> selected>Bendahara</option>
                                            <option value="3" <% if (user.getRoleuser().equals("3")) {
                                                out.println(" selected=\"selected\"");
                                            }%>>KPPN</option> </select></td>
                                </tr>
                                <tr><td>Satuan Kerja</td>
                                    <td>
                                        <% while (iterator.hasNext()) {
                                                satker = iterator.next();
                                                if (user.getSatker() == null) {
                                                    out.println("<select name=\"satker\" disabled=\"disabled\">");
                                                    out.println("<option value=" + satker.getKodeSatker() + ">" + satker.getKodeSatker() + " " + satker.getNamaSatker() + "</option>");
                                                } else if (user.getSatker() != null && user.getSatker().getId().equals(satker.getId())) {
                                                    out.println("<select name=\"satker\" >");
                                                    out.println("<option value=" + satker.getKodeSatker() + " selected=\"selected\">" + satker.getKodeSatker() + "-" + satker.getNamaSatker() + "</option>");
                                                } else {
                                                    out.println("<option value=" + satker.getKodeSatker() + ">" + satker.getKodeSatker() + " " + satker.getNamaSatker() + "</option>");
                                                }
                                            }%> </select>         
                                    </td>
                                </tr>
                                    </table>
                                    <p><input type="hidden" name="id_edit_user" value="<%=user.getId()%>"></p></p>
                                    <table width="400px"><tr>
                                            <td align="center"><a href="javascript:document.form_edit_user.reset()"><img src="images/reset.png" border=0 alt="Reset"></a><input name="Submit" src="images/simpan.png" type="image" value="Simpan" /></td>
                                        </tr>
                                    </table>
                                    </form>
                                    </center>          
                                    <!-- end .content --></div>
                                    <!-- end .container --></div>
                                    </body>
                                    </html>
