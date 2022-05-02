<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="data.Questions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Questions</title>
 <link rel="stylesheet" type="text/css" href="../css/jsp.css">
</head>
<body>
<h2>Haluatko varmasti poistaa kysymyksen?</h2>
    <form action='/app/DeleteQuestions.java' method='post'>
        <input type="hidden" name="kysymys_id" value="${sessionScope.kysymys.kysymys_id }">
        <input type='submit' name='ok' value='Poista'>
    </form>
<a href="/rest/QuestionsService/getQuestions" class="loginbutton">Takaisin</a>