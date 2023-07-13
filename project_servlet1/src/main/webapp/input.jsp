<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Input</title>
</head>
<body>
	<form name="frm" method="post" action="/project_servlet1/InputSave">
		ID : <input type="text" name="id"> <br>
		PW : <input type="text" name="pwd"> <br>
		NM : <input type="text" name="name"> <br>
		<input type="submit" value="send">
	</form>
</body>
</html>