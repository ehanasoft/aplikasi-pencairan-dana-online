<%-- 
    Document   : BankPos
    Created on : Nov 15, 2011, 9:08:49 AM
    Author     : AlfieSaHid
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank Pos</title>
    </head>
    <body>
        <h1>Daftar Bank Pos</h1>
 <table>
  <tr>
    <td>Pilih</td>
    <td>Kode</td>
    <td>Nama</td>
    <td>Edit</td>
    <td>Hapus</td>
  </tr>
  <c:forEach items="${listbank}" var="bank">
      <tr>
        <td><label>
          <input type="checkbox" name="checkbox" value="checkbox">
        </label></td>
        ${bank.id}
          <td>${bank.kdbankpos}</td>
          <td>${bank.nmbankpos}</td>
          <td><label>
            <input type="submit" name="Edit" value="Edit">
          </label></td>
          <td><label>
            <input type="submit" name="Hapus" value="Hapus">
          </label></td>          
  </c:forEach>
 </table>
        <p style="margin: 15px;color : yellow;"><a href="RekamBankPos">Rekam Bank Pos    </a></p>
        <p style="margin: 15px;color : yellow;"><a href="home">Home    </a></p>
    </body>
</html>
