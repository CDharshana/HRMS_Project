<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags"%>
<%@ page session="true"%>
<mytags:menu />
<div class="FormLayout">

	<ol class="breadcrumb" style="margin-top: 0%">
		<li class="breadcrumb-item"><a href="index.html">Home</a></li>
		<li class="breadcrumb-item active"><a href="index.html">Leave</a></li>
		<li class="breadcrumb-item active">Leave List</li>
	</ol>
	<div class="FullSizeLayoutCenter" style="width: 50%;">


		<form style="margin: 0% 0% 3% 0%;">
			<fieldset>
				<legend>Leave List</legend>



				<!-- From Date -->

				<div class="form-group">
					<label for="FromDate">From</label> <input type="Date"
						class="form-control" id="FromDate">
				</div>

				<!-- To Date -->

				<div class="form-group">
					<label for="ToDate">To</label> <input type="Date"
						class="form-control" id="ToDate1">
				</div>
				<!--Employee ID -->
				<div class="form-group">
					<label class="col-form-label" for="EmployeeName">Employee
						Name</label> <input type="text" class="form-control"
						placeholder="Employee Name" id="EmployeeName">
				</div>

				<button type="button" class="btn btn-primary">Search</button>


			</fieldset>

		</form>
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
					<th scope="col" bgcolor="#5fc1e8">View</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${leavesList}" var="leave">
					<c:if test="${leave.leaveStatus.id==2}">
						<tr class="table-light">
							<td>${leave.employee.nameWithInitials}</td>
							<td>${leave.leaveType.leaveTypeName}</td>
							<td>${leave.fromDate}</td>
							<td>${leave.toDate}</td>
							<td>${leave.numberOfDays}</td>
							<td>${leave.reason}</td>
							<td style="text-align: center"><a href="#"><i class="glyphicon glyphicon-eye-open"></i></a></td>
						</tr>
					</c:if>
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
