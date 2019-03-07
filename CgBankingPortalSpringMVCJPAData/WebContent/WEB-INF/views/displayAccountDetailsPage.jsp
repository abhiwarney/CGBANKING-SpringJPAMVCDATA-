<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
div.contentAccountWrapper {
	position: relative;
	margin-top: 10px;
	margin-right: 50px;
	padding: 10px;
	border: 2px solid black;
	border-radius: 8px;
}

div.contentTransactionWrapper {
	position: relative;
	margin-top: 10px;
	margin-right: 50px;
	padding: 10px;
	border: 2px solid black;
	border-radius: 8px;
}

div.formWrapper {
	position: relative;
	margin-top: 10px;
	margin-right: 50px;
	padding: 10px;
	border: 2px solid black;
	border-radius: 8px;
}

table.detailsTable {
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
	width: 20%;
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
	<div class="documentWrapper">
		<div class="formWrapper">
			<h2>Enter Required Details Below:</h2>
			<form method="post" action="accountDetailsAccept">
				<table class="tableForm">
					<tr>
						<td>accountNo</td>
						<td><input type="text" name="accountNo" /></td>
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

		<div class="contentAccountWrapper">
			Account Details:
			<table class="detailsTable">
				<tr>
					<th>Account Number</th>
					<th>Account Status</th>
					<th>Account Type</th>
					<th>Account Balance</th>
				</tr>
				<tr>
					<td>${account.accountNo}</td>
					<td>${account.accountStatus}</td>
					<td>${account.accountType}</td>
					<td>${account.accountBalance}</td>
				</tr>
			</table>
		</div>
		Transaction Details:
		<div class="contentTransactionWrapper">
			<table class="detailsTable">
				<tr>
					<th>transactionId</th>
					<th>amount</th>
					<th>transactionType</th>
				</tr>
				<c:forEach var="entry" items="${account.transactions}">
					<tr>
						<td><c:out value="${entry.key}" /></td>
						<td><c:out value="${entry.value.amount}" /></td>
						<td><c:out value="${entry.value.transactionType}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>