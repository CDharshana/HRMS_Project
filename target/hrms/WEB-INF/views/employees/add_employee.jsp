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
	<form action="${addAction}" method="post" id="register-form">
		<div class="row">
			<div class="col-lg-1">
				<input type="hidden" name="empID" value="0">
			</div>
			<div class="col-lg-3">
				<h3 class="display-5">User Creation</h3>
			</div>

		</div>
		<hr
			style="background-color: dimgrey; color: dimgrey; border: solid 1px dimgrey; height: 1px;" />
		<h6 style="margin-left: 93px; color: #e63900">Personal Details</h6>

		<div class="row">

			<div class="col-lg-1"></div>
			<div class="col-lg-5">

				<div class="form-group">

					<label for="birthDate" class="col-lg-3-3 control-label">First
						Name</label> <input type="text" class="form-control" name="firstName"
						placeholder="First Name">
				</div>
				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
			<div class="col-lg-5">

				<div class="form-group">
					<label for="birthDate" class="col-lg-3-3 control-label">Personal
						Address</label> <input type="text" class="form-control"
						name="personalAddress" placeholder="Personal Address"> </select>
				</div>
				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
		</div>


		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-5">

				<div class="form-group">
					<label for="birthDate" class="col-lg-3-3 control-label">
						Last Name</label> <input type="text" name="lastName" class="form-control"
						placeholder="Last Name">
				</div>

				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
			<div class="col-lg-5">

				<div class="form-group">
					<label for="birthDate" class="col-lg-3-3 control-label">Current
						Address</label> <input type="text" class="form-control" name="cAddress"
						placeholder="Current Address">
				</div>
				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
		</div>

		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-5">

				<div class="form-group">
					<label for="birthDate" class="col-lg-3-3 control-label">Name
						with Initials</label> <input type="text" class="form-control"
						name="nameWithInitials" placeholder="Name with Initials">
				</div>
			</div>
			<div class="col-lg-5">

				<div class="form-group">
					<label for="birthDate" class="col-lg-3-3 control-label">Gender</label>
					<select class="form-control" name="gender">
						<option value="1">Male</option>
						<option value="2">Female</option>
					</select>
				</div>
				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
		</div>
		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-5">

				<div class="form-group">
					<label for="birthDate" class="col-lg-3-3 control-label">
						Name in full</label> <input type="text" name="nameInFull"
						class="form-control" placeholder="Name in Full">
				</div>

				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
			<div class="col-lg-5">

				<div class="form-group">
					<label for="birthDate" class="col-lg-3-3 control-label">DOB</label>
					<input type="date" fomat="yyyy-mm-dd" class="form-control"
						name="dob" placeholder="Date of Birth">
				</div>
				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
		</div>
		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-5">

				<div class="form-group">
					<label for="birthDate" class="col-lg-3-3 control-label">NIC
						No</label><input type="text" name="nicNo" class="form-control"
						placeholder="NIC No">
				</div>

				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
		</div>
		<hr
			style="background-color: dimgrey; color: dimgrey; border: solid 1px dimgrey; height: 1px;" />
		<h6 style="margin-left: 93px; color: #e63900">Contact Details</h6>

		<div class="row">

			<div class="col-lg-1"></div>
			<div class="col-lg-5">

				<div class="form-group">

					<label for="birthDate" class="col-lg-3-3 control-label">Email</label>
					<input type="email" class="form-control" name="email"
						placeholder="Email">
				</div>
				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
			<div class="col-lg-5">

				<div class="form-group">
					<label for="birthDate" class="col-lg-3-3 control-label">Contact
						No</label> <input type="tel" class="form-control" name="contactNo"
						placeholder="Contact No">
				</div>
				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
		</div>
		<hr
			style="background-color: dimgrey; color: dimgrey; border: solid 1px dimgrey; height: 1px;" />
		<h6 style="margin-left: 93px; color: #e63900">Professional
			Details</h6>

		<div class="row">

			<div class="col-lg-1"></div>
			<div class="col-lg-5">

				<div class="form-group">

					<label for="birthDate" class="col-lg-3-3 control-label">Highest
						Qualifications</label>
					<textarea class="form-control" name="highestQualifications"
						placeholder="Highest Qualifications"></textarea>
				</div>
				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
			<div class="col-lg-5">

				<div class="form-group">
					<label for="birthDate" class="col-lg-3-3 control-label">Years
						of Experiance</label><input type="number" value="0" class="form-control"
						name="yearsOfExperiance">
				</div>
				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
		</div>


		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-5">

				<div class="form-group">
					<label for="birthDate" class="col-lg-3-3 control-label">
						Skills & Specialization</label>
					<textarea class="form-control" name="skillsAndSpecialization"
						placeholder="Skills & Specialization"></textarea>
				</div>

				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
		</div>

		<hr
			style="background-color: dimgrey; color: dimgrey; border: solid 1px dimgrey; height: 1px;" />
		<h6 style="margin-left: 93px; color: #e63900">Education</h6>

		<div class="row">

			<div class="col-lg-1"></div>
			<div class="col-lg-5">

				<div class="form-group">

					<label for="birthDate" class="col-lg-3-3 control-label">University</label>
					<input type="text" class="form-control" name="university"
						placeholder="University">
				</div>
				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
			<div class="col-lg-5">

				<div class="form-group">
					<label for="birthDate" class="col-lg-3-3 control-label">Curently
						Following</label>
					<textarea class="form-control" name="curentlyFollowing"
						placeholder="Curently Following"></textarea>
					</select>
				</div>
				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
		</div>


		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-5">

				<div class="form-group">
					<label for="birthDate" class="col-lg-3-3 control-label">
						Year graduated</label> <input type="text" name="yearGraduated"
						class="form-control" placeholder="Year graduated">
				</div>

				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>

		</div>

		<hr
			style="background-color: dimgrey; color: dimgrey; border: solid 1px dimgrey; height: 1px;" />
		<h6 style="margin-left: 93px; color: #e63900">Official Details</h6>

		<div class="row">

			<div class="col-lg-1"></div>
			<div class="col-lg-5">

				<div class="form-group">

					<label for="birthDate" class="col-lg-3-3 control-label">Date
						of Appointment</label> <input type="date" class="form-control"
						name="dateOfAppointment" placeholder="Date Of of Appointment">
				</div>
				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
			<div class="col-lg-5">

				<div class="form-group">
					<label for="birthDate" class="col-lg-3-3 control-label">Supervisor</label>
					<form:select name="supervisor" class="form-control"
						path="employees">
						<form:options items="${employees}" itemValue="id"
							itemLabel="nameWithInitials" />
					</form:select>

				</div>
				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
		</div>


		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-5">

				<div class="form-group">
					<label for="birthDate" class="col-lg-3-3 control-label">
						Designation</label>
					<form:select class="form-control" path="designations"
						name="designation">
						<form:options items="${designations}" itemValue="id"
							itemLabel="designationName" />

					</form:select>
				</div>

				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
			<div class="col-lg-5">

				<div class="form-group">
					<label for="birthDate" class="col-lg-3-3 control-label">Basic
						Salary</label> <input type="text" value="0.00" class="form-control"
						name="bSalary" placeholder="Basic Salary">
				</div>
				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
		</div>

		<hr
			style="background-color: dimgrey; color: dimgrey; border: solid 1px dimgrey; height: 1px;" />
		<h6 style="margin-left: 93px; color: #e63900">Authorization</h6>

		<div class="row">

			<div class="col-lg-1"></div>
			<div class="col-lg-5">

				<div class="form-group">

					<label for="birthDate" class="col-lg-3-3 control-label">Username</label>
					<input type="text" class="form-control" name="username"
						placeholder="Username">
				</div>
				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
			<div class="col-lg-5">

				<div class="form-group">
					<label for="birthDate" class="col-lg-3-3 control-label">Role</label>
					<select class="form-control" name="role">
						<option value="1">HR Admin</option>
						<option value="2">Employee</option>
					</select>
				</div>
				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
		</div>


		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-5">

				<div class="form-group">
					<label for="birthDate" class="col-lg-3-3 control-label">
						Password</label> <input type="password" name="password"
						class="form-control" placeholder="Password">
				</div>

				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
		</div>

		<div class="row">
			<div class="col-lg-6"></div>
			<div class="col-lg-5" style="text-align: right">
				<button type="reset" class="btn btn-Secondary" style="width: 30%">RESET</button>
				<button style="width: 30%" type="submit" class="btn btn-success">Register</button>
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
<footer> </footer>
</html>

