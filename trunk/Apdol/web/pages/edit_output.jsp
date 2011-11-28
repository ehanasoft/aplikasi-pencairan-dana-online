<%-- 
    Document   : register
    Created on : Dec 19, 2010, 6:26:36 AM
    Author     : ahza
--%>

<%@page import="apdol.model.DaftarOutput"%>
<%@page import="apdol.entity.Output"%>
<%@page import="javax.swing.JOptionPane"%>


<% Output output = (Output) request.getAttribute("output_edit");%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Output</title>
        <link rel="stylesheet" type="text/css" href="style/style.css" />
    </head>
    <body><center>
            <table border="0" cellspacing="0" cellpadding="0" width="800">
                <tr>
                    <td>
                      <table border="0" width="800">
                            <tr style="vertical-align: top">
                                <td width="500" style="vertical-align: top"  align="left">
                                    <h1 style="color: blue;">Halaman Edit</h1>
                                    <h2 style="color: blue;">Silahkan isi data Output</h2>
                                    
                                    <form action="proses_edit_output" method="post" >
                                    <table width="450">
                                        <tr>
                                            <td width="100">Kode Output</td><td><input name="kode_output" type="text" style="width: 50px" value ="<%=output.getKodeOutput()%>" size="2" maxlength="2"></td>
                                        </tr>
                                        <tr>
                                            <td>Nama Output</td><td><input type="text" name="nama_output" value="<%=output.getNamaOutput()%>" style="width: 300px" ></td>
                                        </tr>
                                        <tr><td> <input type="hidden" name="id_edit_output" value="<%=output.getId()%>"> </td>
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
