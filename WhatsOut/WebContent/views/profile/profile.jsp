<!---    
    Autohor : Prakash Rai
    Date    : 208/03/20
    Description : Main Layout page for the home page
-->
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Profile - What's Out</title>
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

<!-- Jquery validation plugin -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.js"></script>

<!-- Custom profile js -->
<script src="js/profile/profile.js" type="text/javascript"></script>
</head>

<body>
	<!-- banner div -->
	<div class="jumbotron banner">
		<div class="container">
			<h3 class="banner-icon">Whats out</h3>

			<div class="dropdown user-profile-dropdown">
				<img src="images/user.jpg"
					class="user-profile-dropdown dropdown-toggle"
					id="user-profile-dropdown" data-toggle="dropdown" />

				<ul class="dropdown-menu" aria-labelled-by="user-profile-dropdown">
					<li><a>My Profile</a></li>
					<li><a>Settings</a></li>
					<li><a>Logout</a></li>

				</ul>
			</div>

		</div>
		<!-- container -->
	</div>
	<!-- jumbotron -->

	<!-- main body div -->
	<div class="container-fluid main-body">
		<div class="row">
			<!-- leave one col in left corner -->
			<div class="col-md-1"></div>

			<!-- Left side menu -->
			<div class="col-md-2 sidebar-left">
				<div class="input-group">
					<input class="form-control" placeholder="Search...">
					<div class="input-group-addon">
						<i class="fa fa-search"></i>
					</div>
				</div>

				<br /> <br />
				<ul class="events-menu ">
					<li><i class="glyphicon glyphicon-user"></i> <span
						class="events-menu-item">My Events</span></li>
					<li><i class="glyphicon glyphicon-hand-up"></i> <span
						class="events-menu-item"></span>Coming Events</span></li>
					<li><i class="glyphicon glyphicon-ok"></i> <span
						class="events-menu-item"></span>Events Attended</span></li>
					<li><i class="glyphicon glyphicon-thumbs-up"></i> <span
						class="events-menu-item"></span>Favourite</span></li>
				</ul>
			</div>
			<!-- col -->

			<!-- Main body content -->
			<div class="col-md-6 main-posts">
				<!-- User profile div -->
				<div class="panel panel-success">
					<div class="panel-heading">
						<h1 class="panel-title">My profile</h1>
					</div>
					<div class="panel-body">
						<div class="user-profile">
							<form>
								<div class="form-group row">
									<label class="col-sm-3 profile-picture-label">Profile
										picture</label>
									<div class="col-sm-9">
										<input type="file" name="" id="profile-picture" /> <img
											src="images/user.jpg" alt="profile picture"
											class="upload-profile-picture" />
									</div>
								</div>

								<div class="form-group row">
									<label for="fullname" class="col-sm-3 col-form-label">Full
										Name</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="fullname"
											placeholder="Fullname" value="${fullname}">
									</div>
								</div>

								<div class="form-group row">
									<label for="email" class="col-sm-3 col-form-label">Email</label>
									<div class="col-sm-9">
										<input type="email" class="form-control" id="email"
											placeholder="Email" value="${email}">
									</div>
								</div>

								<div class="form-group row">
									<label for="address" class="col-sm-3 col-form-label">State</label>
									<div class="col-sm-9">
										<select class="custom-select form-control"
											id="state-drop-down" name="state">
											<c:forEach items="${stateList}" var="state">
												<option>${state}</option>
											</c:forEach>
										</select>
									</div>
								</div>

								<div class="form-group row">
									<label for="address" class="col-sm-3 col-form-label">City</label>
									<div class="col-sm-9">
										<select class="custom-select form-control"
											id="state-drop-down" name="state">
											<c:forEach items="${cityList}" var="state">
												<option>${state}</option>
											</c:forEach>
										</select>
									</div>
								</div>

								<div class="form-group row">
									<label for="phone" class="col-sm-3 col-form-label">Phone</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="phone"
											placeholder="Phone">
									</div>
								</div>


								<div class="form-group row">
									<label class="col-sm-3">My Choices</label>
									<div class="col-sm-9">
										<div class="form-check">
											<label class="form-check-label"> <input
												class="form-check-input" type="checkbox"> Sports <input
												class="form-check-input" type="checkbox"> Music <input
												class="form-check-input" type="checkbox"> Arts <input
												class="form-check-input" type="checkbox"> Dance
											</label>
										</div>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-3"></label>
									<div class="offset-sm-3 col-sm-9">
										<button type="button" id="profile-save"
											class="btn btn-success save-profile">Save changes</button>
									</div>
								</div>
							</form>
						</div>
						<!-- User profile div -->
					</div>
				</div>

				<!-- event post -->
			</div>
			<!-- col-md-8 main-posts -->

			<!-- Right side bar -->
			<div class="col-md-2 sidebar-right">
				<h3>My Interests</h3>
				<ul class="nav flex-column">

					<li class="nav-item"><a class="nav-link" href="#">Sports</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Music</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Photography</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Football</a>
					</li>
				</ul>
			</div>
			<!-- col -->

			<!-- leave one col in right corner -->
			<div class="col-md-1"></div>
		</div>
		<!-- row -->
	</div>
	<!-- container -->
</body>

</html>