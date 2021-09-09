<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Parse XML</title>
</head>
<body>
	<form action="Controller" method="get">
		<input type="hidden" name="command" value="SAX"/>
		<input type="submit" value="SAX парсер"/>
	</form><br/><br/>
	<form action="Controller" method="get">
		<input type="hidden" name="command" value="DOM"/>
		<input type="submit" value="DOM парсер"/>
	</form><br/><br/>
	<form action="Controller" method="get">
		<input type="hidden" name="command" value="STAX"/>
		<input type="submit" value="StAX парсер"/>
	</form>
</body>
</html>