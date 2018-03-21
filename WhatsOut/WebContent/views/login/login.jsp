<!-- Custom Tag -->
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
</head>

<body>
	<div class="jumbotron banner">
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
					<strong>Login</strong>
				</h2>
				<br />
				<span class="alert">${errMsg}</span>
				<form action="Login" method="POST">
					<div class="form-group">
						<input type="text" class="form-control" name="login_username"
							placeholder="Username" />
					</div>
					<!-- form-group -->

					<div class="form-group">
						<input type="password" class="form-control" name="login_password"
							placeholder="Password" />
					</div>
					<!-- form-group -->

					<div class="form-group">
						<input type="Submit" name="" class="btn btn-success" value="Login" />
					</div>
					<!-- form group -->
				</form>
				<p>
					Here for the first time? No worries, lets <a
						href="/WhatsOut/Signup">Sign Up here.</a>
				</p>
			</div>
			<!-- col -->
		</div>
		<!-- row -->
	</div>
	<!-- container -->
</body>

</html>