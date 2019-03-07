<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Registration</title>
<style>
div.documnetWrapper {
	display: flex;
	width:(100-50)%
}

div.formWrapper {
	position: relative;
	margin-top: 10px;
	margin-right: 10px;
	padding: 10px;
	border: 2px solid black;
	border-radius: 8px;
}

table.tableForm {
	padding: 16px;
	height: 100%;
	border-collapse: collapse;
	font-weight: bold;
	font-size: 16px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

th, td {
	text-align: left;
	padding: 8px;
}

div.buttonWrapper {
	position: relative;
	padding: 6px;
	
}

input.button {
	background-color: black;
	height: 30px;
	border-radius: 5px;
	color: white;
	offset: 3px;
}

div.error {
	position: relative;
	margin-top: 10px;
	margin-right: 50px;
	padding: 10px;
	border: 2px solid black;
	border-radius: 8px;
	color: red;
	font-size: 20;
}
</style>
</head>
<body>
	<div class="documentWrapper">
		<div class="formWrapper">
			<h2>Enter Required Details Below:</h2>
			<form method="post" action="loginAccept">
				<table class="tableForm">
					<tr>
						<td>accountNo</td>
						<td><input type="text" name="accountNo" /></td>
					</tr>
					<tr>
						<td>pinNumber</td>
						<td><input type="text" name="pinNumber" /></td>
					</tr>
				</table>
				<div>
					<div class="buttonWrapper">
						<input class="button" type="submit" name="submit" /> <input
							class="button" type="reset" name="reset" />
					</div>
				</div>
			</form>
		</div>
		<div class="error">${errorMessage}</div>
	</div>
</body>
</html>