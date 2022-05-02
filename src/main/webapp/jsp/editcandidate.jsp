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
background-image: url('https://images.adsttc.com/media/images/61ed/244f/5023/5901/6410/01f2/slideshow/unnamed.jpg?1642931347');
        background-repeat: no-repeat;
        background-size: cover;
		text-align: center;
		color: white;
}
</style>
<form action='/rest/CandidateService/getCandidates' method='post' accept-charset="utf-8">
<p hidden>Ehdokas id: <input type='hidden' name='ehdokas_id' size="35" value='${sessionScope.ehdokas.ehdokas_id}' readonly><br> </p>
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