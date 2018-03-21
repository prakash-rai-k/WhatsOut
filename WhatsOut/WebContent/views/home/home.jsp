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

<!-- main.js -->
<script src="js/wo.js"></script>
</head>

<body>
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
					<li><a href="./Logout">Logout</a></li>

				</ul>
			</div>

		</div>
		<!-- container -->
	</div>
	<!-- jumbotron -->

	<div class="container-fluid main-body">
		<div class="row">
			<div class="col-md-1"></div>
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

			<div class="col-md-6 main-posts">
				<div class="event-post">
					<div class="panel panel-success panel-posts">
						<div class="panel-heading">
							<h1 class="panel-title">Mum- Soccer tournament</h1>
						</div>
						<!-- panel heading -->

						<div class="panel-body">
							<img src="images/fun.jpg" class="panel-body-image" /> <Strong>Location
								: </Strong> Recreation center <br> <Strong>Organized by : </Strong>
							William chaparro <br> <Strong>Date : </Strong> Jan 8, 2017 <br>
							<Strong>Time : </Strong>3:30 pm
							<p>Additional classes can be used to vary this layout on a
								per-form basis.</p>
						</div>
						<!-- panel-body -->

						<div class="panel-footer">
							<ul class="post-feedback">
								<li><i class="glyphicon glyphicon-plus"></i> <span
									class="post-feedback-item">Count me</span></li>
								<li><i class="glyphicon glyphicon-comment"></i> <span
									class="post-feedback-item" post-id="1">Say something</span></li>
								<li><i class="glyphicon glyphicon-hand-up"></i> <span
									class="post-feedback-item">20 attending</span></li>
							</ul>
						</div>
						<!-- panel-footer -->
					</div>
					<!-- panel -->

					<div class="panel panel-default post-comments" id="post-comment-1">
						<div class="panel-body">
							<div class="post-old-comments">
								<img src="images/user.jpg" class="post-comments-image" />
								<div class="load-old-comments-comment">Here goes the
									comment. Awsomme!!!Here goes the comment. Awsomme!!!Here goes
									the comment. Awsomme!!!</div>
							</div>

							<div class="post-new-comment">
								<img src="images/user.jpg" class="post-comments-image" /> <input
									type="text" class="form-control comment-textbox"
									placeholder="Write something..." />
							</div>
						</div>
					</div>
					<!-- coments -->
				</div>
				<!-- event post -->

				<div class="event-post">
					<div class="panel panel-success panel-posts">
						<div class="panel-heading">
							<h1 class="panel-title">Mum- Soccer tournament</h1>
						</div>
						<!-- panel heading -->

						<div class="panel-body">
							<img src="images/fun.jpg" class="panel-body-image" /> <Strong>Location
								: </Strong> Recreation center <br> <Strong>Organized by : </Strong>
							William chaparro <br> <Strong>Date : </Strong> Jan 8, 2017 <br>
							<Strong>Time : </Strong>3:30 pm
							<p>Additional classes can be used to vary this layout on a
								per-form basis.</p>
						</div>
						<!-- panel-body -->

						<div class="panel-footer">
							<ul class="post-feedback">
								<li><i class="glyphicon glyphicon-plus"></i> <span
									class="post-feedback-item">Count me</span></li>
								<li><i class="glyphicon glyphicon-comment"></i> <span
									class="post-feedback-item" post-id="3">Say something</span></li>
								<li><i class="glyphicon glyphicon-hand-up"></i> <span
									class="post-feedback-item">20 attending</span></li>
							</ul>
						</div>
						<!-- panel-footer -->
					</div>
					<!-- panel -->

					<div class="panel panel-default post-comments" id="post-comment-3">
						<div class="panel-body">
							<div class="post-old-comments">
								<img src="images/user.jpg" class="post-comments-image" />
								<div class="load-old-comments-comment">Here goes the
									comment. Awsomme!!!Here goes the comment. Awsomme!!!Here goes
									the comment. Awsomme!!!</div>
							</div>

							<div class="post-new-comment">
								<img src="images/user.jpg" class="post-comments-image" /> <input
									type="text" class="form-control comment-textbox"
									placeholder="Write something..." />
							</div>
						</div>
					</div>
					<!-- coments -->
				</div>
				<!-- event post -->

				<div class="event-post">
					<div class="panel panel-success panel-posts">
						<div class="panel-heading">
							<h1 class="panel-title">Mum- Soccer tournament</h1>
						</div>
						<!-- panel heading -->

						<div class="panel-body">
							<img src="images/fun.jpg" class="panel-body-image" /> <Strong>Location
								: </Strong> Recreation center <br> <Strong>Organized by : </Strong>
							William chaparro <br> <Strong>Date : </Strong> Jan 8, 2017 <br>
							<Strong>Time : </Strong>3:30 pm
							<p>Additional classes can be used to vary this layout on a
								per-form basis.</p>
						</div>
						<!-- panel-body -->

						<div class="panel-footer">
							<ul class="post-feedback">
								<li><i class="glyphicon glyphicon-plus"></i> <span
									class="post-feedback-item">Count me</span></li>
								<li><i class="glyphicon glyphicon-comment"></i> <span
									class="post-feedback-item" post-id="2">Say something</span></li>
								<li><i class="glyphicon glyphicon-hand-up"></i> <span
									class="post-feedback-item">20 attending</span></li>
							</ul>
						</div>
						<!-- panel-footer -->
					</div>
					<!-- panel -->

					<div class="panel panel-default post-comments" id="post-comment-2">
						<div class="panel-body">
							<div class="post-old-comments">
								<img src="images/user.jpg" class="post-comments-image" />
								<div class="load-old-comments-comment">Here goes the
									comment. Awsomme!!!Here goes the comment. Awsomme!!!Here goes
									the comment. Awsomme!!!</div>
							</div>

							<div class="post-new-comment">
								<img src="images/user.jpg" class="post-comments-image" /> <input
									type="text" class="form-control comment-textbox"
									placeholder="Write something..." />
							</div>
						</div>
					</div>
					<!-- coments -->
				</div>
				<!-- event post -->
			</div>
			<!-- col-md-6 main-posts -->

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
				<button type="button" name="add-category">Add Category</button>
			</div>
			<!-- col -->
			<div class="col-md-1"></div>
		</div>
		<!-- row -->
	</div>
	<!-- container -->
</body>

</html>