<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
div.contentWrapper{
position:relative;
align-items:center;
width:400px;
background-color:grey;
border:3px solid black;
font-family: Times New Roman;
font-size: 25px;
color:white;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div class="contentWrapper" align="center">Account Created Successfully, AccountNo Generated :-${account.accountNo},PinNo:-${account.pinNumber}
			</div>
		<div>
			<a href="indexPage">||BACK||</a>
		</div>
	</div>
</body>
</html>