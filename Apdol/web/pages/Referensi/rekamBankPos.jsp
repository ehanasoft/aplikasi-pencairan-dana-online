<%-- 
    Document   : rekamBankPos
    Created on : Nov 21, 2011, 9:35:35 AM
    Author     : AlfieSaHid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rekam Bank Pos</title>
        <link rel="stylesheet" type="text/css" href="style/style.css" />
    </head>
    <body>
      <table border="0" cellspacing="0" cellpadding="0" width="800">
                <tr>
                    <td>
                        <table border="0" width="800">
                            <tr style="vertical-align: top">
                                <td width="500" style="vertical-align: top"  align="left">
                                    <h1 style="color: blue;">Halaman Rekam Bank Pos </h1>
                                    <h2 style="color: blue;">Silahkan isi data Bank Pos </h2>
                                    <form action="addbankpos" method="post" >
                                    <table width="450">
                                        <tr>
                                            <td width="116">Kode Bank Pos </td>
                                            <td width="322"><input type="text" name="kdbankpos" style="width: 300px"></td>
                                        </tr>
                                        <tr>
                                            <td>Nama Bank Pos </td>
                                            <td><input type="text" name="nmbankpos" style="width: 300px"></td>
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
    </body>
</html>
