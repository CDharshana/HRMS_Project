<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags"%>
<%@ page session="true"%>
<mytags:menu />

<div class="FormLayout">
	<ol class="breadcrumb" style="margin-top: 0%">
		<li class="breadcrumb-item"><a href="index.html">Home</a></li>
		<li class="breadcrumb-item active">Process</a></li>
	</ol>
</div>

<!-- Leave Type -->

<div class="FormLayout">
	<c:url var="newEmpoyeeLocation" value="/newEmployee"></c:url>
	<div style="padding: 1%">
	 <form action="/hrms/submitProcess" method="post">
	 
	 <h6 style="margin-left: 93px; color: #e63900">Process Details</h6>
		<div class="row">

			<div class="col-lg-1"></div>
			<div class="col-lg-5">

				<div class="form-group">

					<label for="payment" class="col-lg-3-3 control-label">Payment
						</label> 
						<select class="form-control" name="payment">
							<option value="monthly"> Monthly </option>
							<option value="weekly"> Weekly </option>
							<option value="yearly"> Yearly </option>
						</select>
				</div>
				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
			<div class="col-lg-5">

				<div class="form-group">
					<label for="ending_date" class="col-lg-3-3 control-label">Ending Date
						</label> <input type="date" class="form-control"
						name="ending_date" value="">
				</div>
				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
			
			
			
		</div>
		
		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-5">

				<div class="form-group">

 					<label class="radio-inline"><input type="radio" name="apply_to" value="allemployees" checked>All Employees</label>
 					<label class="radio-inline"><input type="radio" name="apply_to" value="oneemployee">One Employee</label>
				</div>
				
				<div class="form-group">
 						<select class="form-control" name="employee" id="employee" disabled>
							<c:forEach items="${employees}" var="employees">
								<option value="${employees.id}">${employees.nameInFull}</option>
							</c:forEach>
						</select>
				</div>
				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
			<div class="col-lg-5">

				<div class="form-group">
				
				</div>
				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
			
		</div>
	<hr>
	<h6 style="margin-left: 93px; color: #e63900">Type</h6>
	<div class="row">
	
			<div class="col-lg-1"></div>
			<div class="col-lg-5">

				<div class="form-group">

 					<label class="radio-inline"><input type="radio" name="type" value="variablepay" checked>Variable Pay</label>
 					<label class="radio-inline"><input type="radio" name="type" value="variablededuction">Variable Deduction</label>
				</div>
				
				<div class="form-group">
 						<select class="form-control" name="variablepay" id="variablepay">
							<c:forEach items="${variablepays}" var="variablepays">
								<option value="${variablepays.id}">${variablepays.description} - ${variablepays.amount}</option>
							</c:forEach>
						</select>
				</div>
				
				<div class="form-group">
 						<select class="form-control" name="variablededuction" id="variablededuction" disabled>
							<c:forEach items="${variabledeductions}" var="variabledeductions">
								<option value="${variabledeductions.id}">${variabledeductions.description} - ${variabledeductions.amount}</option>
							</c:forEach>
						</select>
				</div>
				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
			<div class="col-lg-5">

				<div class="form-group">
				
				</div>
				<!--<button type="submit" class="btn btn-default">Submit</button>-->

			</div>
			
		</div>
		
	 <div class="row">
			<div class="col-lg-6"></div>
			<div class="col-lg-5" style="text-align: right">
				<a href="process" style="width: 30%" class="btn btn-success">Cancel</a>
				<button style="width: 30%" type="submit" class="btn btn-success">Add</button>
			</div>
			<br> <br> <br>
	</div>
	 </form>
		<br/>

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

$( document ).ready(function() {
	
	$('input[name=apply_to]').change(function(){
		var value = $( 'input[name=apply_to]:checked' ).val();
		if (value == "allemployees"){
			$('#employee').prop('disabled', true);
		}
		else{
			$('#employee').prop('disabled', false);
		}
		});
	
	$('input[name=type]').change(function(){
		var value = $( 'input[name=type]:checked' ).val();
		if (value == "variablepay"){
			$('#variablededuction').prop('disabled', true);
			$('#variablepay').prop('disabled', false);
		}
		else{
			$('#variablededuction').prop('disabled', false);
			$('#variablepay').prop('disabled', true);
		}
		});
});
	

</script>
</body>
</html>
