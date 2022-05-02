<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
background-image: url('https://images.adsttc.com/media/images/61ed/244f/5023/5901/6410/01f2/slideshow/unnamed.jpg?1642931347');
        background-repeat: no-repeat;
        background-size: cover;
        text-align: center;
}
</style>
<body>

<h1>Kirjaudu sisään</h1>
<form action="/check" method="post">
<input type="text" name="username" value="">
<input type="password" name="password" value="">

<input type="submit" name="send" value="Check">
</form>
<h1>Lisää käyttäjä</h1>
<form action ="/add" method="post">
<input type="text" name="username" value="">
<input type="password" name="password" value="">

<input type="submit" name="send" value="Add">
</form>
<a href="/logout">Logout</a>
</body>
</html>