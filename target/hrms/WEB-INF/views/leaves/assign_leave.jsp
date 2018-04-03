<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags"%>
<%@ page session="true"%>
<mytags:menu />
<script type="text/javascript">
	$('document').ready(function() {
		$("#register-form").validate({
			rules : {
				fromDate : {
					required : true,
					date : true
				},

				toDate : {
					required : true,
					date : true
				},

				NoOfDays : "required",
				reason : "required"

			},
			messages : {

				fromDate : "Please Choose Starting Date",
				toDate : "Please Choose Ending Date",
				NoOfDays : "Enter How Many days do you want to leave",
				reason : "Please Enter the Reason"

			},
			submitHandler : function(form) {
				form.submit();
			}
		});
		$("#fromDate").change(function() {
			calculateDateDiff();
		});
		$("#toDate").change(function() {
			calculateDateDiff();
		});

	});

	function calculateDateDiff() {
		var strFromDate = $('#fromDate').val();
		var strToDate = $('#toDate').val();
		var parsedFromDate = Date.parse(strFromDate);
		var parsedToDate = Date.parse(strToDate);
		var dateDiff = new Date(parsedToDate - parsedFromDate);
		var numberOfDays = (dateDiff / 1000 / 60 / 60 / 24);
		$('#noOfDays').val(numberOfDays);
	}
</script>
<style>
.form-control {
	width: 100%;
}

.FullSizeLayoutCenter {
	width: 65%;
	margin: auto 0% auto 18%;
}

.btn {
	margin-bottom: 2%;
}

#register-form {
	width: 100%;
}

.form {
	margin-top: 2%;
}
</style>
<div class="FormLayout">
	<ol class="breadcrumb" style="margin-top: 0%">
		<li class="breadcrumb-item"><a href="index.html">Home</a></li>
		<li class="breadcrumb-item active">Leave</a></li>
		<li class="breadcrumb-item active">Assign Leave</li>
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
<div class="FullSizeLayoutCenter">
	<br>
	<c:url var="addAction" value="/assignLeaves/add"></c:url>

	<form:form style="margin:0% 0% 3% 0%;" id="register-form"
		action="${addAction}" commandName="appliedLeave">
		<fieldset>
			<legend>Assign Leave</legend>
			<div class="row">
				<div class="col form-group">
					<label for="LeaveType">Employee</label>
					<form:select path="employee.id" name="employee" style="width: 100%"
						class="form-control select2">
						<c:forEach items="${employees}" var="employees">
							<option value="${employees.id}">${employees.nameWithInitials}</option>
						</c:forEach>
					</form:select>
				</div>
				<div class="col form-group">
					<label for="LeaveType">Leave Type</label>
					<form:select path="leaveType.id" name="leaveTypes"
						class="form-control" style="width: 100%">
						<c:forEach items="${leaveTypes}" var="leaveTypes">
							<option value="${leaveTypes.id}">${leaveTypes.leaveTypeName}</option>
						</c:forEach>
					</form:select>
				</div>
			</div>

			<div class="row">
				<div class="col form-group">
					<!-- From Date -->
					<label for="FromDate">From</label>
					<form:input path="fromDate" type="date" class="form-control"
						id="fromDate" />
				</div>

				<div class="col form-group">
					<label for="ToDate">To</label>
					<form:input path="toDate" type="date" class="form-control"
						id="toDate" />
				</div>
			</div>

			<div class="row">
				<div class="col form-group ">
					<label for="NumberOfHolidays">Total days</label> <input
						type="number" class="form-control" readonly="readonly"
						name="NoOfDays" id="noOfDays" value="0" required>
				</div>

				<div class="col form-group">
					<label for="exampleTextarea">Reason</label>
					<form:textarea path="reason" class="form-control" rows="4" />

				</div>
			</div>

		</fieldset>

		<button style="float: right;" type="submit" class="btn btn-primary">Apply</button>
		<button style="float: right; margin-right: 2px" type="reset"
			class="btn btn-Secondary">Reset</button>
	</form:form>


</div>

<!-- </form> -->
<!-- </div> -->


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
