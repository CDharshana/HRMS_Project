<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags"%>
<%@ page session="true"%>
<mytags:menu />
<script type="text/javascript">
	$('document')
			.ready(
					function() {
						$("#register-form")
								.validate(
										{
											rules : {
												firstName : {
													required : true,
													minlength : 3
												},
												lastName : {
													required : true,
													minlength : 5
												},

												nameWithInitials : "required",
												nameInFull : "required",

												dob : {
													required : true,
													date : true
												},
												personalAddress : {
													required : true,
													minlength : 10
												},

												cAddress : {
													required : true,
													minlength : 10
												},

												nic : {
													required : true,
													minlength : 10
												},

												email : {
													required : true,
													email : true
												},

												contactNo : {
													required : true,
													minlength : 10
												},
												highestQualifications : "required",

												yearsOfExperiance : "required",

												skillsAndSpecialization : {
													required : true,
													minlength : 10
												},

												university : {
													required : true,
													minlength : 5
												},
												curentlyFollowing : "required",

												yearGraduated : {
													required : true,
													number : true,
													minlength : 4

												},

												dateOfAppointment : {
													required : true,
													date : true
												},

												bSalary : {
													required : true,
													number : true,
													minlength : 4,
													maxlength : 10

												},

												username : "required",

												password : "required",

											},
											messages : {

												firstName : {
													required : "Please Enter the First Name",
													minlength : "First Name Should be more than 3 Characters"
												},
												lastName : {
													required : "Please Enter Last Name",
													minlength : "Last Name should be more than 5 characters"
												},

												dob : {
													required : "Please Enter your Birthday",
													Date : "Please Enter Valid Date"
												},

												nameWithInitials : "Please Enter Full Name with Initials",
												nameInFull : "Please Enter Full Name",

												personalAddress : {
													required : "Please Enter your Personal Address",
													minlength : "Address should be more than 10 characters"
												},

												cAddress : {
													required : "Please Enter your Current Address",
													minlength : "Address should be more than 10 characters"
												},

												nic : {
													required : "Please Enter your NIC Number",
													minlength : "NIC should be more than 10 characters"
												},
												email : {
													required : "Please Enter Email",
													email : "Please Enter valid email address"
												},

												contactNo : {
													required : "Please Enter your Contact Number",
													minlength : "Phone Number Should be 10 digits"
												},

												highestQualifications : "Please Enter Highest Qualifications",

												yearsOfExperiance : "Please Enter years of Experiance",

												skillsAndSpecialization : {
													required : "Please Enter your Skills and Specialization",
													minlength : "Skills and Specialization should be described more than 20 characters"
												},

												university : {
													required : "Please enter your University",
													minlength : "University name should be more than 5 characters"
												},

												curentlyFollowing : "What is you do in Curently ?",

												yearGraduated : {
													required : "Please Enter your Gratuate year",
													number : "Invalid Year",
													minlength : "Graduate year should be 4 digit"

												},

												dateOfAppointment : {
													required : "Please Enter your Date of Appointment",
													Date : "Please Enter Valid Date"
												},

												bSalary : {
													required : "Please Enter basic Salary",
													number : "invalid !",
													minlength : "Basic Salary should be more than 1000",
													maxlength : "Basic Salary should be less than 1000000000"

												},

												username : "Please Enter username",

												password : "Please Enter password",

											},
											submitHandler : function(form) {
												form.submit();
											}
										});

					});
</script>

<style>
.myBack {<!--
	background-image: url("Img/back9.jpg");
	-->
}

img {
	border: 1px solid #021a40;
}

.section {
	width: 100%;
	border-bottom: 3px solid #021a40;
	border-top: 3px solid #021a40;
}

#register-form {
	width: 100%;
}
</style>
<div class="myBack">
	<c:url var="addAction" value="/employee/add"></c:url>
	<form action="/hrms/submitVariableDeduction" method="post">
		<div class="row">
			<div class="col-lg-1">
				
			</div>
			<div class="col-lg-3">
				<h3 class="display-5">Add Variable Deduction</h3>
			</div>

		</div>
		<hr
			style="background-color: dimgrey; color: dimgrey; border: solid 1px dimgrey; height: 1px;" />
		<h6 style="margin-left: 93px; color: #e63900">Details</h6>

		<div class="row">

			<div class="col-lg-1"></div>
			<div class="col-lg-5">

				<div class="form-group">

					<label for="description" class="col-lg-3-3 control-label">Description
						</label> <input type="text" class="form-control" name="description"
						value="" >
				</div>
				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
			<div class="col-lg-5">

				<div class="form-group">
					<label for="amount" class="col-lg-3-3 control-label">Amount
						</label> <input type="text" class="form-control"
						name="amount" value=""> </select>
				</div>
				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
			
			
			
		</div>
		
		<div class="row">
						<div class="col-lg-1"></div>
			<div class="col-lg-5">

				<div class="form-group">
					<label for="new_salary" class="col-lg-3-3 control-label">Mode
						</label> <select class="form-control"
						name="mode"> 
						<option value="fixed">Fixed</option>
						<option value="variable">Variable</option>
						</select>
				</div>
				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
			
			
		</div>


	

		<div class="row">
			<div class="col-lg-6"></div>
			<div class="col-lg-5" style="text-align: right">
				<a href="variablededuction" style="width: 30%" class="btn btn-success">Cancel</a>
				<button style="width: 30%" type="submit" class="btn btn-success">Add</button>
			</div>
			<br> <br> <br>
		</div>
	</form>
</div>
<!--myBack-->

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




<div class="row">
	<div class="col-lg-1"></div>
</div>
</div>


</div>

</div>
</body>
</html>

