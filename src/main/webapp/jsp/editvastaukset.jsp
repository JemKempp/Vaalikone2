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
<form action='/rest/VastauksetService/getVastaukset' method='post' accept-charset="utf-8">
<p hidden>Ehdokas id: <input type='hidden' name='ehdokas_id' size="35" value='${sessionScope.ehdokas.ehdokas_id}' readonly><br> </p>
<p hidden>Kysymys id: <input type='hidden' name='kysymys_id' size="35" value='${sessionScope.kysymys.kysymys_id}' readonly><br> </p>
Vastaus: <input type='text' name='vastaus' size="35" value='${sessionScope.vastaus.vastaus}'><br>
Kommentti: <input type='text' name='kommentti' size="35" value='${sessionScope.vastaus.kommentti}'><br>

<input type='submit' name='ok' value='Send'> 
<a href="/rest/VastauksetService/getVastaukset" class="loginbutton"></a>
</form>
</body>
</html>