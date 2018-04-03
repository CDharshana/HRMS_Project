<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags"%>
<%@ page session="true"%>
<mytags:menu />

<div class="FormLayout">
	<ol class="breadcrumb" style="margin-top: 0%">
		<li class="breadcrumb-item"><a href="index.html">Home</a></li>
		<li class="breadcrumb-item active">Employees</a></li>
	</ol>
</div>
<c:if test="${hrmsAlert!= null}">
	<c:choose>
		<c:when test="${hrmsAlert.type==1}">
			<c:set var="class" value="alert alert-success alert-dismissable" />
		</c:when>
		<c:when test="${hrmsAlert.type==2}">
			<c:set var="class" value="alert alert-danger alert-dismissable" />
		</c:when>
	</c:choose>

	<div class="<c:out value="${class}" escapeXml="false" />"
		style="margin-left: 10px; margin-right: 10px">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<strong>${hrmsAlert.typeString}</strong> ${hrmsAlert.message}
	</div>

</c:if>
<!-- Leave Type -->

<div class="FormLayout">
	<c:url var="newEmpoyeeLocation" value="/newEmployee"></c:url>
	<a style="float: right; margin-right: 2%; margin-bottom: 2%"
		href="${newEmpoyeeLocation}" class="btn btn-success">New Employee</a>
	<div style="padding: 1%">

		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col" bgcolor="#5fc1e8" style="text-align: center;">Full
						Name</th>
					<th scope="col" bgcolor="#5fc1e8" style="text-align: center;">Gender</th>
					<th scope="col" bgcolor="#5fc1e8" style="text-align: center;">Designation</th>
					<th scope="col" bgcolor="#5fc1e8" style="text-align: center;">NIC
						No.</th>
					<th scope="col" bgcolor="#5fc1e8" style="text-align: center;">Contact
						No.</th>
					<th scope="col" bgcolor="#5fc1e8" style="text-align: center;">Email</th>
					<th scope="col" bgcolor="#5fc1e8" style="text-align: center;">Appointment
						Date</th>
					<th scope="col" bgcolor="#5fc1e8" style="text-align: center;">View</th>
					<th scope="col" bgcolor="#5fc1e8" style="text-align: center;">Edit</th>
					<th scope="col" bgcolor="#5fc1e8" style="text-align: center;">Remove</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employees}" var="employees">

					<tr class="table-light">

						<td>${employees.nameInFull}</td>
						<c:if test="${employees.gender==1}">
							<td>Male</td>
						</c:if>
						<c:if test="${employees.gender==2}">
							<td>Female</td>
						</c:if>

						<td>${employees.designation.designationName}</td>
						<td>${employees.nicNo}</td>
						<td>${employees.contactNo}</td>
						<td>${employees.email}</td>
						<td>${employees.appointmentDate}</td>
						<td><a href="#"><i class="glyphicon glyphicon-eye-open"></i></a></td>
						<td style="text-align: center;"><a href="#"><i
								class="glyphicon glyphicon-edit"></i></a></td>
						<td style="text-align: center;"><a href="#"><i
								class="glyphicon glyphicon-trash"></i></a></td>

					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<div class="End clearfix">
	<div class="End1">
		<ul>
			<li><a href="#">Home</a></li>
			<li><a href="#">About Us</a></li>
			<li><a href="#">Technology</a></li>
			<li><a href="#">Careers</a></li>
			<li><a href="#">Contact Us</a></li>
		</ul>
	</div>
	<!--End1-->
	<div class="link">
		<ul>
			<li><a href="#"><i class="fa fa-facebook-official fa-2x"
					aria-hidden="true"></i></a>
			<li><a href="#"><i class="fa fa-youtube-play fa-2x"
					aria-hidden="true"></i></a>
			<li><a href="#"><i class="fa fa-instagram fa-2x"
					aria-hidden="true"></i></a>
			<li><a href="#"><i class="fa fa-twitter fa-2x"
					aria-hidden="true"></i></a>
			<li><a href="#"><i class="fa fa-linkedin fa-2x"
					aria-hidden="true"></i></a>
		</ul>
	</div>
	<!--link-->
</div>
<!--End-->

<div class="Endpara clearfix">
	<p>© Intervest Software Technologies Pvt Ltd.</p>
</div>

</div>
<!--wrapper-->
</body>
</html>
