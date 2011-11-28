<%-- 
    Document   : rekamUser
    Created on : Nov 1, 2011, 11:00:51 AM
    Author     : Hari RZ
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rekam User</title>
        <link rel="stylesheet" type="text/css" href="style/style.css" />
    </head>
    <body><center>
            <table border="0" cellspacing="0" cellpadding="0" width="800">
                <tr>
                    <td>
                        <table border="0" width="800">
                            <tr style="vertical-align: top">
                                <td width="500" style="vertical-align: top"  align="left">
                                    <h1 style="color: blue;">Halaman Registrasi</h1>
                                    <h2 style="color: blue;">Silahkan Isi Data User</h2>
                                    <form action="proses_rekam_user" method="post" >
                                    <table width="450">
                                        <tr>
                                            <td>Username</td><td><input type="text" name="username" style="width: 200px"></td>
                                        </tr>
                                        <tr>
                                            <td>Password</td><td><input type="text" name="password" style="width: 200px"></td>
                                        </tr>
                                        <tr>
                                            <td>Nama</td><td><input type="text" name="nama" style="width: 200px"></td>
                                        </tr>
                                        <tr>
                                            <td>Kode Satker</td><td><input type="text" name="kodesatker" style="width: 200px"></td>
                                        </tr>
                                        <tr>
                                            <td>Jabatan</td><td><input type="text" name="jabatan" style="width: 200px"></td>
                                        </tr>
                                        <tr>
                                            <td>Role User</td><td><select name="roleuser">
                                                    <option value="2">Bendahara</option>
                                                    <option value="3">KPPN</option> </select></td>
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
