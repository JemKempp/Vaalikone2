<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<ol>
<c:forEach var="ehdokas" items="${requestScope.ehdokaslist }">
<li> ${candidate.name}
    <ul>
        <c:forEach var="candidate" items="${ehdokas.candidatelist}">
            <li>${ehdokas.id }:
        </c:forEach>
    </ul>
</c:forEach>
</ol>
</body>
</html>

