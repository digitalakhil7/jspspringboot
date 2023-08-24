<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Akhil JSP Practise</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
    <h2>Register Student</h2>
<form action="/saveStudent" method="post">
    Id:<br><input type="text" name="id" id="id"><br>
    Name:<br><input type="text" name="name" id="name"><br><br>
<button type="submit" class="btn">Submit</button>
</form>
</body>
</html>