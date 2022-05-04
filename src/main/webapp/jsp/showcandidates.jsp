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
background-image: url('https://images.adsttc.com/media/images/61ed/244f/5023/5901/6410/01f2/slideshow/unnamed.jpg?1642931347');
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
</body>
</html>


           
            
    