<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>
body {
background-image: url('https://static.scientificamerican.com/sciam/cache/file/2A451F1D-3FC5-4438-A1DFB859DF8D3AEB_source.jpg?w=590&h=800&4F353870-AA79-41FA-AFBAAEF4F774E4A0');
        background-repeat: no-repeat;
        background-size: cover;
		text-align: center;
		color: white;
}
</style>
<form action='/EditCandidates' method='post' accept-charset="utf-8">
Ehdokas id: <input type='text' name='ehdokas_id' size="35" value='${sessionScope.ehdokas.ehdokas_id}' readonly><br> 
Ehdokkaan etunimi: <input type='text' name='etunimi' size="35" value='${sessionScope.ehdokas.etunimi}'><br>
Ehdokkaan sukunimi: <input type='text' name='sukunimi' size="35" value='${sessionScope.ehdokas.sukunimi}'><br>
Ehdokkaan puolue: <input type='text' name='puolue' size="35" value='${sessionScope.ehdokas.puolue}'><br>
Kotipaikkakunta: <input type='text' name='kotipaikkakunta' size="35" value='${sessionScope.ehdokas.kotipaikkakunta}'><br>
Ikä: <input type='text' name='ika' size="35" value='${sessionScope.ehdokas.ika}'><br>
Ammatti: <input type='text' name='ammatti' size="35" value='${sessionScope.ehdokas.ammatti}'><br>
Miksi haluan eduskuntaan?: <input type='text' name='miksi_eduskuntaan' size="35" value='${sessionScope.ehdokas.miksi_eduskuntaan}'><br>
Mitä asioita haluan edistää?: <input type='text' size="35" name='mita_asioita_haluat_edistaa' value='${sessionScope.ehdokas.mita_asioita_haluat_edistaa}'><br>

<input type='submit' name='ok' value='Send'> 
<a href="/rest/CandidateService/getCandidates" class="loginbutton"></a>
</form>
</body>
</html>