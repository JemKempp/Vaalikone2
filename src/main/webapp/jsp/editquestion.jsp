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
		color: black;
}
</style>
<h1> Muokkaa kysymyst� </h1>
<form action='/rest/QuestionsService/editquestions' method='post' accept-charset="utf-8">
<p hidden>Kysymys id: <input type='hidden' name='kysymys_id' size="35" value='${requestScope.questionslist.kysymys_id}' readonly><br> </p>
Kysymys: <input type='text' name='kysymys' size="35" value='${requestScope.questionslist.kysymys}'><br>

<input type='submit' name='ok' value='Send'> 
<a href="/rest/QuestionsService/getQuestions" class="loginbutton"></a>
</form>
</body>
</html>