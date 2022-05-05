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
<c:forEach var="kysymys" items="${requestScope.kysymyslista}" >
<ol>${kysymys.kysymys_id}</ol>
<ol>${kysymys.kysymys}</ol>

			<a href="/rest/QuestionsService/getquestionid/${kysymys.kysymys_id }">Muokkaa</a>
            <a href="/rest/QuestionsService/DeleteQuestions/${kysymys.kysymys_id}">Poista</a>


</c:forEach>
</body>
</html>