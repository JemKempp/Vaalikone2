<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="data.Candidates" %>
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
		color: black;
}


</style>
<h1> Muokkaa ehdokasta </h1>
<form action='/rest/CandidateService/editcandidates' method='post' accept-charset="utf-8">
<p hidden>Ehdokas id: <input type='hidden' name='ehdokas_id' size="35" value='${requestScope.candidateslist.ehdokas_id}' readonly><br> </p>
Ehdokkaan etunimi: <input type='text' name='etunimi' size="35" value='${requestScope.candidateslist.etunimi}'><br>
Ehdokkaan sukunimi: <input type='text' name='sukunimi' size="35" value='${requestScope.candidateslist.sukunimi}'><br>
Ehdokkaan puolue: <input type='text' name='puolue' size="35" value='${requestScope.candidateslist.puolue}'><br>
Kotipaikkakunta: <input type='text' name='kotipaikkakunta' size="35" value='${requestScope.candidateslist.kotipaikkakunta}'><br>
Ikä: <input type='text' name='ika' size="35" value='${requestScope.candidateslist.ika}'><br>
Ammatti: <input type='text' name='ammatti' size="35" value='${requestScope.candidateslist.ammatti}'><br>
Miksi haluan eduskuntaan?: <input type='text' name='miksi_eduskuntaan' size="35" value='${requestScope.candidateslist.miksi_eduskuntaan}'><br>
Mitä asioita haluan edistää?: <input type='text' size="35" name='mita_asioita_haluat_edistaa' value='${requestScope.candidateslist.mita_asioita_haluat_edistaa}'><br>

<input type='submit' name='ok' value='Tallenna'> 
<a href="/rest/CandidateService/getCandidates" class="loginbutton"></a>
</form>

</body>
</html>