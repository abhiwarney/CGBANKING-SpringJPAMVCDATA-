<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Registration</title>
<style>
.error {
	color: red;
	font-weight: bold;
}

div.documentWrapper {
	display: flex;
}

div.result {
	position: relative;
	margin-top: 10px;
	margin-right: 50px;
	width: ( 100 -70) %;
	padding: 10px;
	border: 2px solid black;
	border-radius: 8px;
	color: green;
	font-size: 30px;
	margin-right: 50px;
	width: (100 -70)%;
	padding: 10px;
	border: 2px solid black;
	border-radius: 8px;
}

div.formWrapper {
	position: relative;
	float: right;
	margin-top: 10px;
	margin-right: 50px;
	width: (100 -70)%;
	padding: 10px;
	border: 2px solid black;
	border-radius: 8px;
}

table.tableForm {
	padding: 16px;
	width: 100%;
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
	width: 100%;
}

input.button {
	background-color: black;
	float: right;
	width: 20%;
	height: 30px;
	border-radius: 5px;
	color: white;
	offset: 3px;
}
</style>
</head>
<body>
	<div class="documentWrapper">
		<div class="formWrapper">
			<h2>Enter Required Details Below:</h2>
			<form method="post" action="fundTransferAccept">
				<table class="tableForm">
					<tr>
						<td>Enter your Account No:</td>
						<td><input name="accountNoFrom" size="30" /></td>
					</tr>
					<tr>
						<td>Enter Beneficiary Account No for Confirmation:</td>
						<td><input name="accountNoTo" size="30" /></td>
					</tr>
					<tr>
						<td>amount to transfer</td>
						<td><input name="amount" size="30" /></td>
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
	</div>
</body>
</html>