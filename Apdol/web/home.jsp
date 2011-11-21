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
      <p><% if(logedUser!=null){ %><%="Anda Login sebagai: "+logedUser+" "+ roleUser%><%}%></p>
    <!-- end .content --></div>
  <!-- end .container --></div>
</body>
</html>