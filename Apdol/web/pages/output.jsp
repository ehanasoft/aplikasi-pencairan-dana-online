<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="apdol.model.DaftarOutput"%>
<%@page import="apdol.entity.Output"%>

<% List<Output> listOutput = (List<Output>) request.getAttribute("list_output");%>
<% Output output;%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%String logedUser = (String)session.getAttribute("username");%>
<%String roleUser = (String) session.getAttribute("roleuser");%>    
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
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
      <% if(roleUser.equals("1")) {%>
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
      <li><a href="output">Output</a></li>
      <li><a href="mata_anggaran">Mata Anggaran</a></li>
      <li><a href="output">Output</a></li>
    </ul>
    <p><strong>Utilitas</strong></p>
    <ul class="nav">
      <li><a href="register">Registrasi User</a></li>
    </ul>
    <% } else if(roleUser.equals("2")) {%>
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
    <% } else if(roleUser.equals("3")) {%>
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
      <p><% if(logedUser!=null){ %><%="Anda Login sebagai: "+logedUser+" "+ roleUser%><%}%></p>
      
       <% Iterator<Output> iterator = listOutput.iterator();%>
        <form >
            <p style="margin: 10px;"><BR>
            <table id="rounded-corner">
                <thead>
                    <tr>
                        <th scope="col" class="rounded-company">Cek</th>
                        <th scope="col" class="rounded-q1">Kode Output</th>
                        <th scope="col" class="rounded-q2">Nama Output</th>
                    </tr>
                </thead>
                    <tbody>
                    <% while (iterator.hasNext()) {
                                  output = iterator.next();%>
                    <tr>
                        <td><input  type="checkbox"  name="cek_output" value="<%=output.getId()%>"></td>
                        <td><%=output.getKodeOutput()%></td>
                        <td><%=output.getNamaOutput()%></td>
                    </tr>
                    <%}%>
                    </tbody>
            </table>
            <span style="margin: 10px;">
            </span>
            <p style="margin: 10px;"><BR>
                <input type="submit" value="rekam" name="rekam" formaction="rekam_output" formmethod="post"/>
                <input type="submit" value="edit" name="edit" formaction="edit_output" formmethod="post"/> 
                <input type="submit" value="hapus" name="hapus" formaction="proses_hapus_output" formmethod="post"/>
        </form>
    <!-- end .content --></div>
  <!-- end .container --></div>
</body>
</html>