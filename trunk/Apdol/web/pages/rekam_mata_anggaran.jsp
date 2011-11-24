<%-- 
    Document   : register
    Created on : Dec 19, 2010, 6:26:36 AM
    Author     : ahza
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rekam Mata Anggaran</title>
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
                                    <h2 style="color: blue;">Silahkan isi data Mata Anggaran</h2>
                                    <form action="proses_rekam_mata_anggaran" method="post" >
                                    <table width="450">
                                        <tr>
                                            <td width="100">Kode Mata Anggaran</td><td><input name="kode_mata_anggaran" type="text" style="width: 50px" size="6" maxlength="6"></td>
                                        </tr>
                                        <tr>
                                            <td>Nama Mata Anggaran</td><td><input type="text" name="nama_mata_anggaran" style="width: 300px"></td>
                                        </tr>
                                        <tr>
                                            <td>Nama BKPK</td><td><input type="text" name="nama_BKPK" style="width: 300px"></td>
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
