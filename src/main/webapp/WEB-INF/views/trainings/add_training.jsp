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
				leaveAmount : {
					required : true,
				},

			},
			messages : {
				fromDate : "Please Choose Starting Date",
				toDate : "Please Choose Ending Date",
				leaveAmount : "Enter the leave amount",

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
		var numberOfDays = dateDiff / 1000 / 60 / 60 / 24;
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
		<li class="breadcrumb-item active">Training Programs</a></li>
		<li class="breadcrumb-item active">Add New Trining Program</li>
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
	<c:url var="addAction" value="/trainingPrograms/add"></c:url>

	<form:form style="margin:0% 0% 3% 0%;" id="register-form"
		action="${addAction}" commandName="trainingProgram">
		<fieldset>
			<legend>New Training Program</legend>
			<div class="row">
				<div class="col form-group" style="margin-right: 10%">
					<div class="row">
						<label for="NumberOfHolidays" style="margin-top: 8px">Program
							Title</label>
						<form:input path="title" class="form-control"
							placeholder="Program Title" />
					</div>
					<div class="row">
						<label for="NumberOfHolidays" style="margin-top: 8px">Training
							Provider</label>
						<form:input path="provider" class="form-control"
							placeholder="Training Provider" />
					</div>
					<div class="row">
						<label for="NumberOfHolidays" style="margin-top: 8px">Start
							Date</label>
						<form:input type="date" path="startDate" class="form-control" />
					</div>
					<div class="row">
						<label for="NumberOfHolidays" style="margin-top: 8px">End
							Date</label>
						<form:input type="date" path="endDate" class="form-control" />
					</div>
					<div class="row">
						<label for="NumberOfHolidays" style="margin-top: 8px">Location</label>
						<form:input path="location" class="form-control"
							placeholder="Location" />
					</div>
					<div class="row">
						<label for="NumberOfHolidays" style="margin-top: 8px">Description</label>
						<form:textarea path="description" class="form-control"
							placeholder="Description" />
					</div>

				</div>
				<div class="col-lg-4 form-group">
					<label for="NumberOfHolidays" style="margin-top: 8px">Employees</label>
					<c:forEach items="${employees}" var="employee">
						<div class="row">
							<div class="col form-group ">
								<span> <input id="2" type="checkbox"
									value="${employee.key}" name="empID"> <label for="2">${employee.value}</label>
								</span>
							</div>
						</div>
					</c:forEach>
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
