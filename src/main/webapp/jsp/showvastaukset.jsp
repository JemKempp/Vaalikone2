<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>
body {
background-image: url('https://wallpapercave.com/wp/wp2863773.jpg');
        background-repeat: no-repeat;
        background-size: cover;
		text-align: center;
}
</style>

<c:forEach var="vastaus" items="${requestScope.vastauslista}" >
<ol>${vastaus.ehdokas_id}</ol>
<ol>${vastaus.kysymys_id}</ol>
<ol>${vastaus.vastaus}</ol>
<ol>${vastaus.kommentti}</ol>

			<a href="/rest/VastauksetService/getvastausid/${vastaus.vastaus }">Muokkaa</a>
            <a href="/rest/VastauksetService/DeleteVastaukset/${vastaus.vastaus }">Poista</a>

</c:forEach>
</body>
</html>