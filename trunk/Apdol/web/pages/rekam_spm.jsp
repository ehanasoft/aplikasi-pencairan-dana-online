<%-- 
    Document   : rekam_spm
    Created on : Dec 25, 2011, 10:52:06 PM
    Author     : wahid
--%>

<%@page import="apdol.entity.RincianKegiatan"%>
<%@page import="apdol.entity.Output"%>
<%@page import="java.util.List"%>
<%@page import="apdol.entity.Kegiatan"%>
<%@page import="apdol.entity.MataAnggaran"%>
<%@page import="apdol.model.DaftarMataAnggaran"%>
<%@page import="java.util.Iterator"%>
<%@page import="apdol.model.DaftarOutput"%>
<%@page import="apdol.model.DaftarKegiatan"%>
<%@page import="apdol.model.DaftarSPM"%>
<%@page import="apdol.entity.SPM"%>
<%@page import="javax.swing.JOptionPane"%>

<% List<RincianKegiatan> listRincianKegiatan = (List<RincianKegiatan>) request.getAttribute("list_rincian_kegiatan");
    RincianKegiatan rincianKegiatan;
    Iterator<RincianKegiatan> iterator = listRincianKegiatan.iterator();%>
     
    
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <%String logedUser = (String) session.getAttribute("username");%>
    <%String roleUser = (String) session.getAttribute("roleuser");%>  
    <%String kodeSatker = (String) session.getAttribute("kode_satker");%>  

    <head>
        <script language="javascript">
            <!--//
            //new Option("text","value")
            //this code changes menus
            function nullOptionsDMA(aMenu){
                var tot=aMenu.options.length
                for (i=0;i<tot;i++)
                {
                    aMenu.options[i]=null
                }
                aMenu.options.length=0;
            }
            function MySubjectDMA0(aMenu){
                nullOptionsDMA(aMenu)
                with (aMenu){
                    //Rewrites the text and values
                    options[0]=new Option("Januari");
                    options[1]=new Option("Februari");
                    options[2]=new Option("Maret");
                    options[3]=new Option("April");
                    options[4]=new Option("Mei");
                    options[5]=new Option("Juni");
                    options[6]=new Option("Juli");
                    options[7]=new Option("Agustus");
                    options[8]=new Option("September");
                    options[9]=new Option("Oktober");
                    options[10]=new Option("Nopember");
                    options[11]=new Option("Desember");
                    options[0].selected=true
                }
            }
            function MySubjectDMA1(aMenu){
                nullOptionsDMA(aMenu)
                with (aMenu){
                    //Rewrites the text and values
                    options[0]=new Option("Januari");
                    options[1]=new Option("Maret");
                    options[2]=new Option("April");
                    options[3]=new Option("Mei");
                    options[4]=new Option("Juni");
                    options[5]=new Option("Juli");
                    options[6]=new Option("Agustus");
                    options[7]=new Option("September");
                    options[8]=new Option("Oktober");
                    options[9]=new Option("Nopember");
                    options[10]=new Option("Desember");
                    options[0].selected=true
                }
            }
            function MySubjectDMA2(aMenu){
                nullOptionsDMA(aMenu)
                with (aMenu){
                    //Rewrites the text and values
                    options[0]=new Option("2008");
                    options[1]=new Option("2009");
                    options[2]=new Option("2010");
                    options[3]=new Option("2011");
                    options[4]=new Option("2012");
                    options[5]=new Option("2013");
                    options[0].selected=true
                }
            }
            function MySubjectDMA3(aMenu){
                nullOptionsDMA(aMenu)
                with (aMenu){
                    //Rewrites the text and values
                    options[0]=new Option("2008");
                    options[1]=new Option("2012");
                    options[0].selected=true
                }
            }
            /* ####################### goDM() ####################### */
            function goDMA(aMenu){
                if (aMenu.options.value!="none")
                {
                    location=aMenu.options[aMenu.selectedIndex].value
                }
            }

            /* ####################### setUp ####################### */
            function setUpDMA(){
                with (document.form_rekam_spm) {
                    if (menuSubjectsDMA.selectedIndex==0){
                        menuSubjectsDMA.options[0].selected=true
                        menuFilesDMA.options[0].selected=true
                    }
                    if (menuSubjectsDMA.selectedIndex==1)
                        MySubjectDMA0(menuFilesDMA)
                    if (menuSubjectsDMA.selectedIndex==2)
                        MySubjectDMA1(menuFilesDMA)
                    if (menuSubjectsDMA.selectedIndex==3)
                        MySubjectDMA2(menuFilesDMA)
                    if (menuSubjectsDMA.selectedIndex==4)
                        MySubjectDMA3(menuFilesDMA)
                }
            }
            /* ####################### changeFiles ####################### */
            function changeFilesDMA(){
                aMenu=document.formDoubleMenuDMA.menuSubjectsDMA
                aMenu2=document.formDoubleMenuDMA.menuFilesDMA
                with (aMenu){
                    switch (selectedIndex) {
                        case 0:
                            aMenu2.options.length=0;
                            aMenu2.options[0]=new Option("Pages appear here","none")
                            aMenu2.options[0].selected=true;
                            history.go(0)
                            break
                        case 1:
                            MySubjectDMA0(aMenu2)
                            aMenu2.options[0].text="HTML Subjects"
                            break
                        case 2:
                            MySubjectDMA1(aMenu2)
                            aMenu2.options[0].text="JavaScript Subjects"
                            break
                        case 3:
                            MySubjectDMA2(aMenu2)
                            aMenu2.options[0].text="JavaScript 2 Subjects"
                            break
                        case 4:
                            MySubjectDMA3(aMenu2)
                            aMenu2.options[0].text="Style Sheet Subjects"
                            break
                    }
                }
            }

            //-->

        </script>
        
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Rekam SPM</title>
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
                    <li><a href="tayang_dipa2">Tayang DIPA</a></li>
                </ul>
                <p><strong>Pencairan</strong></p> 
                <ul class="nav">
                    <li><a href="spm">Surat Perintah Membayar</a></li>
                </ul>
                <p><strong>Monitoring</strong></p>
                <ul class="nav">
                    <li><a href="monitoring_spm">Monitoring SPM</a></li>
                    <li><a href="realisasi">Realisasi</a></li>
                </ul>
                <p><strong>Utilitas</strong></p>
                <ul class="nav">
                    <li><a href="cetak_spm">Cetak SPM</a></li>	
                    <li><a href="submit">Submit ke KPPN</a></li>
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
                <center><p>
                        <h3> Rekam SPM</h3></p>
                    <form name="form_rekam_spm" action="proses_rekam_spm" method="post" >
                        <table width="650px">
                            <tr>
                                <td width="300">Nomor SPM</td>
                                <td><input type="text" name="nomor_spm" style="width: 200px" /></td>
                            </tr>
                            <tr>
                                <td width="200">Tanggal SPM</td>
                                <td>
                                    <select name="tanggal" > 
                                        <% for (int i = 0; i<31 ; i++) {%>
                                        <option value="<%=i+1%>" ><%=i+1%></option> <%}%> 
                                    </select>
                                    /
                                    <select name="bulan">
                                      <% for (int i = 0; i<12 ; i++) {%>
                                      <option value="<%=i+1%>"><%=i+1%></option>
                                      <%}%>
                                </select>
                                    /
                                    <select name="tahun">
                                      <option value="2011">2011</option>
                                </select></td>
                            </tr>
                            <tr>
                                <td>Rincian Kegiatan</td>
                                <td>
                                        <select name="rincian_kegiatan"><% while (iterator.hasNext()) {
                                            rincianKegiatan = iterator.next(); 
                                            if (kodeSatker.equalsIgnoreCase(rincianKegiatan.getSatker().getKodeSatker())) {%>
                                            <option value="<%=rincianKegiatan.getId()%>"><%=rincianKegiatan.getSatker().getNamaSatker() + " . " +rincianKegiatan.getKegiatan().getNmgiat() + " . " + rincianKegiatan.getOutput().getNamaOutput() + " . " + rincianKegiatan.getMataAnggaran().getNamaMataAnggaran()%></option><%}}%>
                                    </select>
                                </td>
                            </tr> 
                        
                            <tr>
                                <td width="200">Jumlah Keluar</td>
                                <td><input type="text" name="jumlah_keluar" style="width: 200px" /></td>
                            </tr>
                                    
                            <tr>
                                <td width="200">Jumlah Potongan</td>
                                <td><input type="text" name="jumlah_potongan" style="width: 200px" /></td>
                            </tr>
                        </table>
                <p>&nbsp;</p>
                        <h5>&nbsp;</h5>
                        <table width="400px">
                            <tr>
                                <td align="center"><a href="javascript:document.form_rekam_spm.reset()"><img src="images/reset.png" border=0 alt="Reset"></a><input name="Submit" src="images/simpan.png" type="image" value="Simpan"/> </td>
                            </tr>
                        </table>
                    </form>
                </center>          
                <!-- end .content --></div>
            <!-- end .container --></div>
    </body>
</html>
