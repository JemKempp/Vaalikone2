<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.*" %> 
 <%@ page import="dao.Dao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>
body {
background-image: url('https://images.adsttc.com/media/images/61ed/244f/5023/5901/6410/01f2/slideshow/unnamed.jpg?1642931347');
        background-repeat: no-repeat;
        background-size: cover;
		text-align: center;
}
</style>

<div class="container">
<div class="row">
<div class="col-9">
<h1> Lisää uusi ehdokas </h1>
<form action='/rest/CandidateService/addcandidate' method='post' accept-charset="utf-8"> 

Ehdokkaan etunimi: <input type='text' name='etunimi' size="35" value=''><br>
Ehdokkaan sukunimi: <input type='text' name='sukunimi' size="35" value=''><br>
Ehdokkaan puolue: <input type='text' name='puolue' size="35" value=''><br>
Kotipaikkakunta: <input type='text' name='kotipaikkakunta' size="35" value=''><br>
Ikä: <input type='text' name='ika' size="35" value=''><br>
Ammatti: <input type='text' name='ammatti' size="35" value=''><br>
Miksi haluan eduskuntaan?: <input type='text' name='miksi_eduskuntaan' size="35" value=''><br>
Mitä asioita haluan edistää?: <input type='text' name='mita_asioita_haluat_edistaa' size="35" value=''><br>
<input type='submit' name='ok' value='Tallenna'> 
<a href="/rest/CandidateService/getCandidates" class="loginbutton"></a> 
</body>
</form>
</div>
</div>
</div>
