<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags"%>
<%@ page session="true"%>
<mytags:menu />
<c:url var="approve" value="/leave/approve"></c:url>
<c:url var="reject" value="/leave/reject"></c:url>
<div class="FormLayout">

	<ol class="breadcrumb" style="margin-top: 0%">
		<li class="breadcrumb-item"><a href="index.html">Home</a></li>
		<li class="breadcrumb-item active"><a href="index.html">Leave</a></li>
		<li class="breadcrumb-item active">Approve Leaves</li>
	</ol>
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

	<div style="width: 100%; padding-left: 20px">
		<legend>Approve/Reject Leaves</legend>

	</div>
	<div style="padding-left: 1.5%; padding-right: 1.5%">
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col" bgcolor="#5fc1e8">Employee</th>
					<th scope="col" bgcolor="#5fc1e8">Leave Type</th>
					<th scope="col" bgcolor="#5fc1e8">Date From</th>
					<th scope="col" bgcolor="#5fc1e8">Date To</th>
					<th scope="col" bgcolor="#5fc1e8">Number of Days</th>
					<th scope="col" bgcolor="#5fc1e8">Reason</th>
					<th scope="col" bgcolor="#5fc1e8">Approve</th>
					<th scope="col" bgcolor="#5fc1e8">Reject</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${approveList}" var="leave">
					<tr class="table-light">
						<td>${leave.employee.nameWithInitials}</td>
						<td>${leave.leaveType.leaveTypeName}</td>
						<td>${leave.fromDate}</td>
						<td>${leave.toDate}</td>
						<td>${leave.numberOfDays}</td>
						<td>${leave.reason}</td>
						<td style="text-align: center"><a
							href="${approve}?leaveID=${leave.id}"><i
								class="glyphicon glyphicon-ok"></i></a></td>
						<td style="text-align: center"><a
							href="${reject}?leaveID=${leave.id}"><i
								class="glyphicon glyphicon-remove"></i></a></td>
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
