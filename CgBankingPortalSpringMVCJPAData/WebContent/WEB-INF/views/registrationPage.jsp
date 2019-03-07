<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Registration</title>
<style>
div.error {
	position: relative;
	margin-top: 10px;
	margin-right: 50px;
	padding: 10px;
	border: 2px solid black;
	border-radius: 8px;
	color: red;
	font-weight: bold;
}

.error {
	color: red;
	font-weight: bold;
}

div.formWrapper {
	position: relative;
	margin-top: 10px;
	margin-right: 50px;
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
	width:20%;
	}

input.button {
	background-color: black;
	width: 20%;
	height: 30px;
	border-radius: 5px;
	color: white;
	offset: 3px;
}
</style>
</head>
<body>
	<div>
		<div class="formWrapper">
			<h2>Enroll Account Details here</h2>
			<form:form method="post" action="registerAccount"
				modelAttribute="account">
				<table class="tableForm">
					<tr>
						<td>accountType</td>
						<td><form:input path="accountType" size="30" /></td>
						<%-- <td><form:errors path="accountType" cssClass="error" /></td> --%>
					</tr>
					<tr>
						<td>initBalance</td>
						<td><form:input path="accountBalance" size="30" /></td>
						<%-- <td><form:errors path="accountBalance" cssClass="error" /></td> --%>
					</tr>
				</table>
				<div>
					<div class="buttonWrapper">
						<input class="button" type="submit" name="submit" /> <input
							class="button" type="reset" name="reset" />
					</div>
				</div>
			</form:form>
		</div>
		<div class="error">${errorMessage}</div>
	</div>
</body>
</html>