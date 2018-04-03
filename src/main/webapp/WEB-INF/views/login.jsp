<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Login - Intervest HRMS</title>

<link href="<c:url value="/resources/login/css/new.css" />"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/pages/css/bootstrap.min.css" />">
</head>
<body>

	<div class="top">
		<h1>Intervest Software Technologies</h1>
		<h3>HR Management System</h3>
	</div>
	<div class="loginBox">
		<img src="<c:url value="/resources/login/img/04.png" />" class="user">
		<h2>Log In Here</h2>
		<c:url var="loginUrl" value="/login" />

		<form:form action="${loginUrl}" method="post">
			<p>USERNAME</p>
			<input type="text" name="username" placeholder="username"
				oninvalid="this.setCustomValidity('Please enter username')">
			<p>PASSWORD</p>
			<input type="password" name="password" placeholder="password"
				oninvalid="this.setCustomValidity('Please enter password')">
			<input type="submit" name="" value="Login">
			<c:if test="${errorMessage!=null}">
				<div class="alert alert-danger"
					style="height: 25px; padding: 1%; text-align: center;">${errorMessage}
				</div>
			</c:if>
			<a href="index1.html">Forget Password</a>
		</form:form>
	</div>
</body>
</html>