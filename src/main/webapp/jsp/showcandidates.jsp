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

<c:forEach var="ehdokas" items="${requestScope.ehdokaslista}" >
<ol>${ehdokas.ehdokas_id}</ol>
<ol>${ehdokas.etunimi}</ol>
<ol>${ehdokas.sukunimi}</ol>
<ol>${ehdokas.puolue}</ol>
<ol>${ehdokas.kotipaikkakunta}</ol>
<ol>${ehdokas.ika}</ol>
<ol>${ehdokas.miksi_eduskuntaan}</ol>
<ol>${ehdokas.mita_asioita_haluat_edistaa}</ol>
<ol>${ehdokas.ammatti}</ol>
			<a href="/rest/CandidateService/getcandidateid/${ehdokas.ehdokas_id }">Muokkaa</a>
            <a href="/rest/CandidateService/DeleteCandidates/${ehdokas.ehdokas_id }">Poista</a>


</c:forEach>
<footer><p>© Tea Lyytinen, Jemina Kemppainen, Kirsi Koskinen</p></footer>
</body>
</html>


           
            
    