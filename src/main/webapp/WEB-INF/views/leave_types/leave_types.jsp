<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags"%>
<%@ page session="true"%>
<mytags:menu />
<script>
	$('#nav').onePageNav({
		currentClass : 'current',
		changeHash : false,
		scrollSpeed : 350,
		scrollThreshold : 0.5,
		filter : '',
		easing : 'swing',
		begin : function() {
			//I get fired when the animation is starting
		},
		end : function() {
			//I get fired when the animation is ending
		},
		scrollChange : function($currentListItem) {
			//I get fired when you enter a section and I pass the list item of the section
		}
	});
</script>
<script type="text/javascript">
	$('document').ready(function() {
		$("#register-form").validate({
			rules : {
				leaveTypeName : {
					required : true,
					minlength : 4
				}

			},
			messages : {
				leaveTypeName : {
					required : "Please provide a Leave Type",
					minlength : "Leave Type at least have 4 characters"
				}

			},
			submitHandler : function(form) {
				form.submit();
			}
		});

	});
</script>
<script>
	$('#nav').onePageNav({
		filter : ':not(.external)'
	});
</script>
<div class="FormLayout">
	<ol class="breadcrumb" style="margin-top: 0%">
		<li class="breadcrumb-item"><a href="index.html">Home</a></li>
		<li class="breadcrumb-item active">Leave</a></li>
		<li class="breadcrumb-item active">Leave Types</li>
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
	<div class="FullSizeLayoutCenter" id="LeaveType">

		<c:url var="addAction" value="/leaveType/add"></c:url>

		<form:form style="margin:0% 0% 3% 0%;" id="register-form"
			action="${addAction}" commandName="leaveType">

			<fieldset>
				<legend>Leave Types</legend>

				<div class="form-group">
					<label class="col-form-label" for="inputDefault">Leave
						type:</label>
					<form:input path="leaveTypeName" class="form-control"
						placeholder="Leave type" id="leave_type" />
				</div>
				<div class="form-group">
					<label class="col-form-label" for="inputDefault">Description:</label>
					<form:textarea path="description" class="form-control" cols="10"
						rows="3" />
				</div>

				<button type="submit" class="btn btn-primary nohover">ADD</button>
				<button type="reset" class="btn btn-Secondary">RESET</button>
			</fieldset>

		</form:form>

	</div>
	<!-- <hr style="background-color: dimgrey;color: dimgrey;border: solid 2px dimgrey;height: 5px;"> -->
	<div class="FullSizeLayout">

		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col" bgcolor="#5fc1e8">Leave Type</th>
					<th scope="col" bgcolor="#5fc1e8">Description</th>
					<th scope="col" bgcolor="#5fc1e8">Edit</th>
					<th scope="col" bgcolor="#5fc1e8">Delete</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${leaveTypeList}" var="leaveType">
					<tr class="table-light">

						<td>${leaveType.leaveTypeName}</td>
						<td>${leaveType.description}</td>
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
