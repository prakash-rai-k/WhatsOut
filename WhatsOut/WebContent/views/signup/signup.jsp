<!---    
    Autohor : Prakash Rai
    Date    : 208/03/20
    Contact : prakashrainpl@gmail.com
    Description : Layout page for sinup page
-->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="wout" uri="/WEB-INF/taglib/customTag.tld"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>What's Out</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Font awsome css-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />

<!-- Reset default browser CSS -->
<link rel="stylesheet" href="css/default.css">

<!-- Custom Login CSS -->
<link rel="stylesheet" href="css/style.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="js/libraries/jquery.validate.min.js"></script>
</head>

<body>
	<div class="jumbotron banner">

		<!-- Banner Using Custom Tag -->
		<wout:bannerTag firstId="container" secondId="banner-icon" />
		<!-- <div class="container">
			<h3 class="banner-icon">Whats out</h3>
		</div> -->
	</div>
	<!-- jumbotron -->

	<div class="container main-body">
		<div class="row">
			<div class="col-md-8">
				<img src="images/fun.jpg" />
			</div>
			<!-- col -->

			<div class="col-md-4">
				<h2>
					<strong>Create new What's out account</strong>
				</h2>
				<br />
				<p>
					Already have one? <a href="/WhatsOut/Login"> Login here </a>
				</p>
				<br />
				<form id="signup-form" action="/WhatsOut/Signup" method="POST">
					<div class="form-group">
						<input type="text" class="form-control" name="firstname"
							placeholder="FirstName" required />
					</div>
					<!-- form-group -->
					<div class="form-group">
						<input type="text" class="form-control" name="middlename"
							placeholder="MiddleName (Optional)" />
					</div>
					<!-- form-group -->
					<div class="form-group">
						<input type="text" class="form-control" name="lastname"
							placeholder="LastName" required />
					</div>

					<!-- Display List of States -->
					<div class="form-group">
						<!-- 
							Displays list of states from database
							Uses address database created by Yvan GAKUBA 
							Modified on March 20, 2018 
							by Rupendra Maharjan 
						-->
						<select class="custom-select form-control" id="state-drop-down"
							name="state">
							<c:forEach items="${stateList}" var="state">
								<option>${state}</option>
							</c:forEach>
						</select>
						<!-- <input type="text" class="form-control" name="state"
							placeholder="State" required/> -->
					</div>
					<!-- form-group -->

					<!-- Display List of Cities -->
					<div class="form-group">
						<select class="custom-select form-control" id="city-drop-down"
							name="city">
							<!-- 
								Cities are loaded based on State using AJAX 
								Uses address database created by Yvan GAKUBA
								Modified on March 20, 2018 
								by Rupendra Maharjan 
							-->

						</select>
					</div>
					<!-- form-group -->
					<div class="form-group">
						<input type="text" class="form-control" name="phone"
							placeholder="Phone" required />
					</div>
					<!-- form-group -->

					<div class="form-group">
						<input type="email" class="form-control" name="email"
							placeholder="Email" required />
					</div>
					<!-- form-group -->

					<div class="form-group">
						<input type="text" class="form-control" name="username"
							placeholder="Username" minlength="3" required />
					</div>
					<!-- form-group -->

					<div class="form-group">
						<input type="password" class="form-control" name="password"
							placeholder="Password" minlength="6" required />
					</div>
					<!-- form-group -->

					<div class="form-group">
						<input type="password" class="form-control" name="confirmpassword"
							placeholder="Confirm Password" minlength="6" required />
					</div>
					<!-- form-group -->

					<div class="form-group">
						<input type="Submit" name="" class="btn btn-success"
							value="Let the fun begin" />
					</div>
					<!-- form group -->
				</form>
				<!-- form -->

			</div>
			<!-- col -->
		</div>
		<!-- row -->
	</div>
	<!-- container -->

	<script src="js/signup/signup.js">
		
	</script>
</body>

</html>
