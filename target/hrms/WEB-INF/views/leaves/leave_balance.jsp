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
		<li class="breadcrumb-item active">Leave Balance</a></li>
	</ol>
</div>

<!-- Leave Type -->

<div class="FormLayout">
	<c:url var="newEmpoyeeLocation" value="/newEmployee"></c:url>
	<div style="padding: 1%">

		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col" bgcolor="#5fc1e8" style="text-align: center;">Leave
						Type</th>
					<th scope="col" bgcolor="#5fc1e8" style="text-align: center;">Allocation</th>
					<th scope="col" bgcolor="#5fc1e8" style="text-align: center;">Utilized</th>
					<th scope="col" bgcolor="#5fc1e8" style="text-align: center;">Pending</th>
					<th scope="col" bgcolor="#5fc1e8" style="text-align: center;">Balance</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${leaveBalance}" var="leaveBalance">

					<tr class="table-light">

						<td style="text-align: center;">${leaveBalance[0]}</td>
						<td style="text-align: center;">${leaveBalance[1]}</td>
						<td style="text-align: center;">${leaveBalance[2]}</td>
						<td style="text-align: center;">${leaveBalance[3]}</td>
						<td style="text-align: center;">${leaveBalance[4]}</td>


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
