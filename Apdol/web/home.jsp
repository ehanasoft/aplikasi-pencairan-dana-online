<%-- 
    Document   : home
    Created on : Nov 2, 2011, 11:09:56 PM
    Author     : Accio
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="apdol.model.DaftarUser"%>
<%@page import="apdol.entity.User"%>
<% DaftarUser usr = new DaftarUser();%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String logedUser = (String)session.getAttribute("username");%>
<%String roleUser = (String) session.getAttribute("roleuser");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <title>Apdol Testing Main Page</title>
    </head>
    <body>
        <h1><% if(logedUser!=null){ %><%="Anda Login sebagai: "+logedUser+" "+ roleUser%><%}%></h1>
        <% List<User> users = usr.getUser(); %>
        <% Iterator<User> iterator = users.iterator();%>
        <% while (iterator.hasNext()){%><% User next = iterator.next();%> 
        <% out.println(next.getUsername());%><%}%>
        
        <p style="margin: 10px ;color : yellow;"><a href="register">Register    </a></p>
        <p style="margin: 10px;color : yellow;"><a href="lokasi">Lokasi    </a></p>
        <p style="margin: 10px;"><a href="logout">Log Out    </a></p>
    </body>
</html>
