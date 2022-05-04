<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="data.Vastaukset" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Vastaukset</title>
 <link rel="stylesheet" type="text/css" href="../css/jsp.css">
</head>
<body>
<h2>Haluatko varmasti poistaa vastauksen?</h2>
    <form action='/rest/VastauksetService/getVastaukset' method='post'>
        <input type="hidden" name="vastaus_id" value="${sessionScope.vastaus.vastaus_id }">
        <input type='submit' name='ok' value='Poista'>
    </form>
<a href="/rest/VastauksetService/getVastaukset" class="loginbutton">Takaisin</a>