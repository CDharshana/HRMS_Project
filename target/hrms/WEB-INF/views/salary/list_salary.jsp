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

<!-- Leave Type -->

<div class="FormLayout">
	<c:url var="newEmpoyeeLocation" value="/newEmployee"></c:url>
	
	<div style="padding: 1%">
	
	 <div class="row">
	 
	   <div class="col-lg-4">
	   
	   <form action="/hrms/getSalaryDetails" method="post">
	   
		 
		 <div class="form-group">
				<select class="form-control" name="employee" id="employee">
							<c:forEach items="${employees}" var="employees">
								<option value="${employees.id}">${employees.nameInFull}</option>
							</c:forEach>
				</select>
		 </div>
		 
		<div class="form-group">
				<button style="width: 30%" type="submit" class="btn btn-success">Get Details</button>
		 </div>

	   
	   </form>
	   
	   <hr>
	   
	   <div class="row">
	   
	   		<p> <b> Basic Salary </b> </p>
	   			 ${employee.basicSalary}
	   		<p> </p>
	   
	   </div>
	   
	   </div>
	   
	   <div class="col-lg-4">
	   
	    <table class="table table-hover">
	     <caption>Variable Pay</caption>
			<thead>
				<tr>
					<th scope="col" bgcolor="#5fc1e8" style="text-align: center;">Description
					</th>
					<th scope="col" bgcolor="#5fc1e8" style="text-align: center;">Amount</th>
	
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${variablepays}" var="variablepays">

					<tr class="table-light">

						<td>${variablepays.description}</td>
						<td>${variablepays.amount}</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	   
	   </div>
	   
	   	   <div class="col-lg-4">
	   
	    <table class="table table-hover">
	     <caption>Variable Deduction</caption>
			<thead>
				<tr>
					<th scope="col" bgcolor="#5fc1e8" style="text-align: center;">Description
						Name</th>
					<th scope="col" bgcolor="#5fc1e8" style="text-align: center;">Amount</th>
				
			</tr>
			</thead>
			<tbody>
				<c:forEach items="${variabledeductions}" var="variabledeductions">

					<tr class="table-light">

						<td>${variabledeductions.description}</td>
						<td>${variabledeductions.amount}</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	   
	   </div>
	   
	 
	 </div>


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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

<script>
	

</script>
</body>
</html>
