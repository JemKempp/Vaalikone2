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
<c:forEach var="kysymys" items="${requestScope.kysymyslista}" >
<ol>${kysymys.kysymys_id}</ol>
<ol>${kysymys.kysymys}</ol>

			<a href="/rest/QuestionsService/EditQuestion/${kysymys.kysymys_id }">Muokkaa</a>
            <a href="/rest/QuestionsService/DeleteQuestions/${kysymys.kysymys_id}">Poista</a>


</c:forEach>
</body>
</html>