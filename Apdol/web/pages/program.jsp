<%-- 
    Document   : program
    Created on : Dec 9, 2011, 7:54:11 PM
    Author     : AlfieSaHid
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="apdol.model.DaftarProgram"%>
<%@page import="apdol.entity.Program"%>

<% List<Program> listProgram = (List<Program>) request.getAttribute("list_program");%>
<% Program program;%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <%String logedUser = (String) session.getAttribute("username");%>
    <%String roleUser = (String) session.getAttribute("roleuser");%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Program</title>
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
                <center><p ><h3>Program</h3></p>
                    <% Iterator<Program> iterator = listProgram.iterator();%>
                    <center><form >
                            <table id="rounded-corner">
                                <thead>
                                    <tr>
                                        <th scope="col" class="rounded-company">Kode Program</th>
                                        <th scope="col" class="rounded-q1">Nama Program</th>
                                        <th scope="col" class="rounded-q2">Edit</th>                        
                                        <th scope="col" class="rounded-q4">Hapus</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% while (iterator.hasNext()) {
                                            program = iterator.next();%>
                                    <tr>
                                        <td><%=program.getKdprogram()%></td>
                                        <td><%=program.getNmprogram()%></td>
                                        <td><input name="edit_program" src="images/ubah.png" type="image" value="<%=program.getId()%>" formmethod="post" formaction="edit_program" /> </td>
                                        <td><input name="hapus_program" src="images/hapus.png" type="image" value="<%=program.getId()%>" formmethod="post" formaction="hapus_program" /> </td>
                                    </tr>
                                    <%}%>
                                </tbody>
                            </table>
                            <span style="margin: 10px;">
                            </span>
                            <p style="margin: 10px;"><BR>
                                    <input name="Submit" src="images/rekam.png" type="image" value="rekam" formmethod="post" formaction="rekam_program" />

                                    </form></center>                                    
                                    <!-- end .content --></div>
                                    <!-- end .container --></div>
                                    </body>
                                    </html>
