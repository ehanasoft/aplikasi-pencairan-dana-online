<%-- 
    Document   : edit_pejabat
    Created on : Nov 27, 2011, 6:33:30 AM
    Author     : AlfieSaHid
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="apdol.model.DaftarPejabat"%>
<%@page import="apdol.entity.Pejabat"%>
<%@page import="apdol.model.DaftarSatuanKerja"%>
<%@page import="apdol.entity.SatuanKerja"%>

<% Pejabat pejabat = (Pejabat) request.getAttribute("pejabat_edit");%>
<% List<SatuanKerja> listSatker = (List<SatuanKerja>) request.getAttribute("list_satker");%>
<% SatuanKerja satker;%>
<% Iterator<SatuanKerja> iterator = listSatker.iterator();%>
<% SatuanKerja satkerPejabat = (SatuanKerja) request.getAttribute("satkerPejabat");%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <%String logedUser = (String) session.getAttribute("username");%>
    <%String roleUser = (String) session.getAttribute("roleuser");%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title> Edit Pejabat</title>
        <link href="styles/style2.css" rel="stylesheet" type="text/css" /><!--[if lte IE 7]>
        <style>
        .content { margin-right: -1px; } /* this 1px negative margin can be placed on any of the columns in this layout with the same corrective effect. */
        ul.nav a { zoom: 1; }  /* the zoom property gives IE the hasLayout trigger it needs to correct extra whiltespace between the links */
        </style>
        <![endif]-->
        <script type = "text/javascript">
            function disableDrop(){
                if(form_edit_pejabat.rolejabatan.options[0].selected){
                    form_edit_pejabat.satker.disabled = false;
                    document.getElementById("ket1").style.display = 'block';
                    document.getElementById("ket1").disabled = false;
                    document.getElementById("ket2").style.display = 'none';
                    document.getElementById("ket2").disabled = true;
                }
                else{
                    form_edit_pejabat.satker.disabled = true;
                    document.getElementById("ket1").style.display = 'none';
                    document.getElementById("ket1").disabled = true;
                    document.getElementById("ket2").style.display = 'block';
                    document.getElementById("ket2").disabled = false;
                }
            }
        </script>
    </head>

    <body onLoad="disableDrop()">
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
                <center><p><h3> Edit Pejabat</h3></p>
                    <form name="form_edit_pejabat" action="proses_edit_pejabat" method="post" >
                        <table width="500px">
                            <tr>
                                <td width="200">NIP</td><td><input name="nip" type="text" style="width: 180px" size="18" maxlength="18" value="<%=pejabat.getNip()%>"></td>
                            </tr>
                            <tr>
                                <td>Nama Pejabat</td><td><input type="text" name="nama" style="width: 300px" value="<%=pejabat.getNama()%>"</td>
                            </tr>
                            <tr>                                                    
                                <td>Golongan</td>
                                <td>
                                    <select name="golongan">
                                        <option value="III/a Penata Muda" <% if (pejabat.getKdgol().equals("III/a Penata Muda")) {
                                                out.println(" selected=\"selected\"");
                                            }%>> III/a Penata Muda</option>
                                        <option value="III/b Penata Muda Tk. I" <% if (pejabat.getKdgol().equals("III/b Penata Muda Tk. I")) {
                                                out.println(" selected=\"selected\"");
                                            }%>> III/b Penata Muda Tk. I</option>
                                        <option value="III/c Penata" <% if (pejabat.getKdgol().equals("III/c Penata")) {
                                                out.println(" selected=\"selected\"");
                                            }%>> III/c Penata</option>
                                        <option value="III/d Penata Tk. I" <% if (pejabat.getKdgol().equals("III/d Penata Tk. I")) {
                                                out.println(" selected=\"selected\"");
                                            }%>> III/d Penata Tk. I</option>
                                        <option value="IV/a Pembina" <% if (pejabat.getKdgol().equals("IV/a Pembina")) {
                                                out.println(" selected=\"selected\"");
                                            }%>> IV/a Pembina</option>
                                        <option value="IV/b Pembina Tk. I" <% if (pejabat.getKdgol().equals("IV/b Pembina Tk. I")) {
                                                out.println(" selected=\"selected\"");
                                            }%>> IV/b Pembina Tk. I</option>
                                        <option value="IV/c Pembina Utama Muda" <% if (pejabat.getKdgol().equals("IV/c Pembina Utama Muda")) {
                                                out.println(" selected=\"selected\"");
                                            }%>> IV/c Pembina Utama Muda</option>
                                        <option value="IV/d Pembina Utama Madya" <% if (pejabat.getKdgol().equals("IV/d Pembina Utama Madya")) {
                                                out.println(" selected=\"selected\"");
                                            }%>> IV/d Pembina Utama Madya</option>
                                        <option value="IV/e Pembina Utama" <% if (pejabat.getKdgol().equals("IV/e Pembina Utama")) {
                                                out.println(" selected=\"selected\"");
                                            }%>> IV/e Pembina Utama</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Jabatan Struktural</td><td><input type="text" name="jabatan" style="width: 300px" value="<%=pejabat.getNmjabatan()%>"></td>
                            </tr>
                            <tr>
                                <td width="150px">Wewenang</td>
                                <td><select name="rolejabatan" onchange = "disableDrop();">
                                        <option value="1" <% if (pejabat.getRolejabatan().equals("1")) {
                                                out.println(" selected=\"selected\"");
                                            }%> selected>Bendahara</option>
                                        <option value="2" <% if (pejabat.getRolejabatan().equals("2")) {
                                                out.println(" selected=\"selected\"");
                                            }%>>KPPN</option>KPPN</select></td>
                            </tr>
                            <tr>
                                <td>Jabatan Keuangan</td>
                                <td>                          
                                    <% if (pejabat.getKetjabatan().equals("Penandatangan SPM")) {
                                            out.println("<select id=\"ket1\" name=\"keterangan\" style=\"display: block;\">");
                                            out.println("<option value=\"KPA\">KPA</option>");
                                            out.println("<option value=\"Penandatangan SPM\" selected=\"selected\">Penandatangan SPM</option>");
                                            out.println("</select>");
                                            out.println("<select id=\"ket2\" name=\"keterangan\" style=\"display: none;\">");
                                            out.println("<option value=\"Kasi Pencairan Dana\" >Kasi Pencairan Dana</option>");
                                            out.println("<option value=\"Kasi Bank/Giro Pos\">Kasi Bank/Giro Pos</option>");
                                        } else if (pejabat.getKetjabatan().equals("KPA")) {
                                            out.println("<select id=\"ket1\" name=\"keterangan\" style=\"display: block;\">");
                                            out.println("<option value=\"KPA\" selected=\"selected\">KPA</option>");
                                            out.println("<option value=\"Penandatangan SPM\">Penandatangan SPM</option>");
                                            out.println("</select>");
                                            out.println("<select id=\"ket2\" name=\"keterangan\" style=\"display: none;\">");
                                            out.println("<option value=\"Kasi Pencairan Dana\" >Kasi Pencairan Dana</option>");
                                            out.println("<option value=\"Kasi Bank/Giro Pos\">Kasi Bank/Giro Pos</option>");
                                        } else if (pejabat.getKetjabatan().equals("Kasi Pencairan Dana")) {
                                            out.println("<select id=\"ket1\" name=\"keterangan\" style=\"display: none;\">");
                                            out.println("<option value=\"KPA\">KPA</option>");
                                            out.println("<option value=\"Penandatangan SPM\">Penandatangan SPM</option>");
                                            out.println("</select>");
                                            out.println("<select id=\"ket2\" name=\"keterangan\" style=\"display: block;\">");
                                            out.println("<option value=\"Kasi Pencairan Dana\" selected=\"selected\">Kasi Pencairan Dana</option>");
                                            out.println("<option value=\"Kasi Bank/Giro Pos\">Kasi Bank/Giro Pos</option>");
                                        } else if (pejabat.getKetjabatan().equals("Kasi Bank/Giro Pos")) {
                                            out.println("<select id=\"ket1\" name=\"keterangan\" style=\"display: none;\">");
                                            out.println("<option value=\"KPA\">KPA</option>");
                                            out.println("<option value=\"Penandatangan SPM\">Penandatangan SPM</option>");
                                            out.println("</select>");
                                            out.println("<select id=\"ket2\" name=\"keterangan\" style=\"display: block;\">");
                                            out.println("<option value=\"Kasi Pencairan Dana\">Kasi Pencairan Dana</option>");
                                            out.println("<option value=\"Kasi Bank/Giro Pos\" selected=\"selected\">Kasi Bank/Giro Pos</option>");
                                        } else {
                                            out.println("<select id=\"ket1\" name=\"keterangan\" style=\"display: block;\">");
                                            out.println("<option value=\"KPA\">KPA</option>");
                                            out.println("<option value=\"Penandatangan SPM\">Penandatangan SPM</option>");
                                            out.println("</select>");
                                            out.println("<select id=\"ket2\" name=\"keterangan\" style=\"display: none;\">");
                                            out.println("<option value=\"Kasi Pencairan Dana\">Kasi Pencairan Dana</option>");
                                            out.println("<option value=\"Kasi Bank/Giro Pos\">Kasi Bank/Giro Pos</option>");
                                        }
                                    %>
                                </td>
                            </tr>
                            <tr><td>Satker</td>
                                <td>
                                    <% while (iterator.hasNext()) {
                                            satker = iterator.next();
                                            if (pejabat.getSatker() == null) {
                                                out.println("<select name=\"satker\" disabled=\"disabled\">");
                                                out.println("<option value=" + satker.getKodeSatker() + ">" + satker.getKodeSatker() + " " + satker.getNamaSatker() + "</option>");
                                            } else if (pejabat.getSatker() != null && pejabat.getSatker().getId().equals(satker.getId())) {
                                                out.println("<select name=\"satker\" >");
                                                out.println("<option value=" + satker.getKodeSatker() + " selected=\"selected\">" + satker.getKodeSatker() + "-" + satker.getNamaSatker() + "</option>");
                                            } else {
                                                out.println("<option value=" + satker.getKodeSatker() + ">" + satker.getKodeSatker() + " " + satker.getNamaSatker() + "</option>");
                                            }
                                        }%> </select>         
                                </td>
                            </tr>
                        </table>
                        <p><input type="hidden" name="id_edit_pejabat" value="<%=pejabat.getId()%>"></p>
                        <table width="400px"><tr>
                                <td align="center"><a href="javascript:document.form_rekam_pejabat.reset()"><img src="images/reset.png" border=0 alt="Reset"></a><input name="Submit" src="images/simpan.png" type="image" value="Simpan"/> </td>
                            </tr>
                        </table>
                    </form>
                </center>          
                <!-- end .content --></div>
            <!-- end .container --></div>
    </body>
</html>
