<!---    
    Autohor : Prakash Rai
    Date    : 208/03/20
    Contact : prakashrainpl@gmail.com
    Description : Main Layout page for the home page
-->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Home - What's Out</title>
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
<script src="js/home/home.js"></script>

<!-- main.js -->
<script src="js/category/category.js"></script>

<!-- main.js -->
<script src="js/event/event.js"></script>
</head>

<body>
	<!-- banner div -->
	<jsp:include page="../boxes/banner.jsp" />
	<!-- jumbotron -->

	<!-- main body div -->
	<div class="container-fluid main-body">
		<div class="row">
			<!-- leave one col in left corner -->
			<div class="col-md-1"></div>

			<!-- left side bar -->
			<jsp:include page="../boxes/sidebar-left.jsp" />

			<!-- Main content goes here -->
			<div class="col-md-6 main-posts">

				<div id="create-event">
					<jsp:include page="../event/create-form.jsp" />
				</div>

				<!-- event posts -->
				<div class="event-post" id="event-load">
					<c:forEach var="event" items="${events}">
						<div class="panel panel-success panel-posts">
							<div class="panel-heading">
								<h1 class="panel-title">${event.title}</h1>
							</div>
							<!-- panel heading -->

							<div class="panel-body">
								<img src="images/event/${event.id}/${event.logo}"
									class="panel-body-image" /> <Strong>Location : </Strong>
								${event.address.city}, ${event.address.state} <br> <Strong>Organized
									by : </Strong> ${event.eventCreator.firstName}
								${event.eventCreator.middleName} ${event.eventCreator.lastName}
								<br> <Strong>Datetime: </Strong> ${event.happeningOn} <br>
								<p>${event.description}</p>
							</div>
							<!-- panel-body -->

							<div class="panel-footer">
								<ul class="post-feedback">
									<li><i class="glyphicon glyphicon-plus"></i> <span
										class="post-feedback-item">Count me</span></li>
									<li><i class="glyphicon glyphicon-comment"></i> <span
										class="post-feedback-item post-feedback-comment" post-id="1">Say
											something</span></li>
									<li><i class="glyphicon glyphicon-hand-up"></i> <span
										class="post-feedback-item">20 attending</span></li>
								</ul>
							</div>
							<!-- panel-footer -->
						</div>
					</c:forEach>
				</div>
				<!-- event post -->
			</div>

			<!-- Right side bar -->
			<jsp:include page="../boxes/sidebar-right.jsp" />

			<!-- leave one col in right corner -->
			<div class="col-md-1"></div>
		</div>
		<!-- row -->
	</div>
	<!-- container -->
</body>

</html>