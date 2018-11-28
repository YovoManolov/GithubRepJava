<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get number to convert</title>
</head>
<body>
	<form action="ClientServlet" method="post">
		Number to convert: <input type="text" name="numberToConvert"/>
		<input type="submit" value="get"/> 
		
		Response from the service:<textarea name="output" style="width:100%" rows="40">${numberToWordsString}</textarea>
	</form>
</body>
</html>