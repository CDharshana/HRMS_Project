<%@tag import="com.intervest.hrms.model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/pages/css/new.css" />">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/pages/css/font-awesome.min.css" />">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/pages/css/bootstrap-lumen.css" />">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/pages/css/bootstrap-lumen1.css" />">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/pages/css/leave.css" />">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/pages/css/bootstrap.min.css" />">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/pages/css/validation.css" />">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/pages/css/jquery-ui.min.css" />">
<script src="<c:url value="/resources/pages/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/pages/js/bootstrap.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/pages/js/jquery.validate.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/pages/js/jquery-ui.min.js" />"></script>
</head>
<body>
	<c:url var="home" value="/home"></c:url>
	<c:url var="logout" value="/logout"></c:url>
	<c:url var="leaveTypes" value="/leaveTypes"></c:url>
	<c:url var="listEmployees" value="/listEmployees"></c:url>
	<c:url var="holidays" value="/holidays"></c:url>
	<c:url var="leavePeriods" value="/leavePeriods"></c:url>
	<c:url var="applyLeave" value="/applyLeave"></c:url>
	<c:url var="assignLeave" value="/assignLeave"></c:url>
	<c:url var="leaveList" value="/leaveList"></c:url>
	<c:url var="leaveStatus" value="/leaveStatus"></c:url>
	<c:url var="entitlements" value="/entitlements"></c:url>
	<c:url var="approveLeave" value="/approveLeave"></c:url>
	<c:url var="newTraining" value="/newTraining"></c:url>
	<c:url var="trainingPrograms" value="/trainingPrograms"></c:url>
	<c:url var="salaryAdjustment" value="/salaryAdjustment"></c:url>
	<c:url var="employeeSalaries" value="/employeeSalaries"></c:url>
	<c:url var="process" value="/process"></c:url>
	<c:url var="variablepay" value="/variablepay"></c:url>
	<c:url var="variablededuction" value="/variablededuction"></c:url>
	<c:url var="leaveBalance" value="/leaveBalance"></c:url>
	<c:url var="leaveReport" value="/leaveReport"></c:url>
	<c:url var="updateAttendance" value="/fingerprint_upl"></c:url>
	<%
		int userType = ((User) session.getAttribute("loggedUser"))
				.getType();
		System.out.print(userType);
	%></h5>

	<div class="wrapper">

		<div class="top-bar clearfix">
			<div class="top-Image">
				<a href="${home}"> <img
					src="<c:url value="/resources/pages/Img/iv.png" />" alt="new1">
			</div>
			<!--top-Image-->
			<div class="Logo">
				<h1>Intervest</h1>
				<h3>Software Technologies</h3>
			</div>
			<!--site-search-->
			<div class="HR">
				<h2 style="font-size: 24px;">Human Resource Management System</h2>
				<img src="<c:url value="/resources/pages/Img/1.png" />" alt="new1">
			</div>
			<!--HR-->
		</div>
		<!--top-bar-->

		<div class="status clearfix">
			<div class="Logout">
				<a href="${logout}" class="swagButton">LogOut</a>
			</div>
			<!--Logout-->

			<div class="userlogin">
				<h4>User:
					${sessionScope.loggedUser.getEmployee().getNameWithInitials()}</h4>
				<c:choose>
					<c:when test="${sessionScope.loggedUser.type ==1 }">
						<c:set var="role" value="HR Admin" />
					</c:when>
					<c:otherwise>
						<c:set var="role" value="Employee" />
					</c:otherwise>
				</c:choose>

				<h4>
					Role:
					<c:out value="${role}" escapeXml="false" />
				</h4>
			</div>
			<!--userlogin-->
		</div>
		<!--Status-->
		<div class="dropdown">
			<ul class="nav nav-pills">
				<c:if test="${sessionScope.loggedUser.type ==1 }">
					<li class="nav-item"><a class="nav-link hover"
						href="${listEmployees}">Employees</a></li>
				</c:if>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
					role="button" aria-haspopup="true" aria-expanded="false">Leave</a>
					<div class="dropdown-menu">
						<c:if test="${sessionScope.loggedUser.type ==1 }">
							<a class="dropdown-item" href="${entitlements}">Add
								Entitlement</a>
							<a class="dropdown-item" href="${assignLeave}">Assign Leave</a>
						</c:if>

						<a class="dropdown-item" href="${applyLeave}">Apply Leave</a> <a
							class="dropdown-item" href="${approveLeave}">Approve Leave</a> <a
							class="dropdown-item" href="${leaveBalance}">Leave Balance</a>
						<c:if test="${sessionScope.loggedUser.type ==1 }">
							<a class="dropdown-item" href="#"><b>Configure</b></a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="${leaveTypes}">&nbsp &nbsp
								Leave Type</a>
							<a class="dropdown-item" href="${leavePeriods}">&nbsp &nbsp
								Leave Period</a>
							<!-- <a class="dropdown-item" href="#">&nbsp &nbsp Work Week</a> -->
							<a class="dropdown-item" href="${holidays}">&nbsp &nbsp
								Holidays</a>
							<div class="dropdown-divider"></div>

						</c:if>
						<a class="dropdown-item" href="${leaveStatus}">Leave Status</a> <a
							class="dropdown-item" href="${leaveList}">Leave List</a>

						<c:if test="${sessionScope.loggedUser.type ==1 }">
							<a class="dropdown-item" href="#"><b>Reports</b></a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="${leaveReport}">Leave Report</a>
						</c:if>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
					role="button" aria-haspopup="true" aria-expanded="false">Attendance</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">My Attendance</a>
						<c:if test="${sessionScope.loggedUser.type ==1 }">

							<a class="dropdown-item" href="#"><b>Reports</b></a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="${updateAttendance}">Update Attendance </a>
							<a class="dropdown-item" href="#">Attendance Report</a>
						</c:if>
					</div>
					</li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
					role="button" aria-haspopup="true" aria-expanded="false">Salary</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="${salaryAdjustment}"><b>Salary
								Adjustment</b></a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="${employeeSalaries}">Salaries</a> <a
							class="dropdown-item" href="${process}">Process</a> <a
							class="dropdown-item" href="${variablepay}">Variable Pay</a> <a
							class="dropdown-item" href="${variablededuction}">Variable
							Deduction</a>

					</div></li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
					role="button" aria-haspopup="true" aria-expanded="false">Training
						Programs</a>
					<div class="dropdown-menu">
						<c:if test="${sessionScope.loggedUser.type ==1 }">
							<a class="dropdown-item" href="${newTraining}">New Training
								Program</a>

							<div class="dropdown-divider"></div>
						</c:if>
						<a class="dropdown-item" href="${trainingPrograms}">Upcoming</a>


					</div></li>
			</ul>
		</div>