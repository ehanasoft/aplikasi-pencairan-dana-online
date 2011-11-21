<%-- 
    Document   : register
    Created on : Dec 19, 2010, 6:26:36 AM
    Author     : ahza
--%>

<%@page import="apdol.model.DaftarLokasi"%>
<%@page import="apdol.entity.Lokasi"%>
<%@page import="javax.swing.JOptionPane"%>


<% Lokasi lokasi = (Lokasi) request.getAttribute("lokasiedit");%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Lokasi</title>
        <link rel="stylesheet" type="text/css" href="style/style.css" />
    </head>
    <body><center>
            <table border="0" cellspacing="0" cellpadding="0" width="800">
                <tr>
                    <td>
                      <table border="0" width="800">
                            <tr style="vertical-align: top">
                                <td width="500" style="vertical-align: top"  align="left">
                                    <h1 style="color: blue;">Halaman Register</h1>
                                    <h2 style="color: blue;">Silahkan isi data lokasi</h2>
                                    
                                    <form action="proseseditlokasi" method="post" >
                                    <table width="450">
                                        <tr>
                                            <td width="100">Kode Lokasi</td><td><input name="kodelokasi" type="text" style="width: 50px" value ="<%=lokasi.getKodeLokasi()%>" size="4" maxlength="4"></td>
                                        </tr>
                                        <tr>
                                            <td>Nama Kota</td><td><input type="text" name="namakota" value="<%=lokasi.getNamaKota()%>" style="width: 300px" ></td>
                                        </tr>
                                        <tr>
                                            <td>Nama Propinsi </td><td><input type="text" name="namapropinsi" value="<%=lokasi.getNamaPropinsi()%>" style="width: 300px"></td>      
                                        <td> <input type="hidden" name="ideditlokasi" value="<%=lokasi.getId()%>"> </td>
                                        </tr>
                                        <tr>
                                            <td></td><td><input type="reset"><input type="submit" value="Simpan" ></td>
                                        </tr>
                                    </table>
                                    </form>
                                </td>
                                </tr>
                        </table>
                    </td>
                </tr>
                </table>
      </center>
    </body>
</html>
