<!---    
    Autohor : Prakash Rai
    Date    : 208/03/20
    Contact : prakashrainpl@gmail.com
    Description : Main Layout page for the home page
-->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglib/customTag.tld" prefix="cm"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Home - What's Out</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<!-- Font awsome css-->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />
	<!-- Reset default browser CSS -->
	<link rel="stylesheet" href="css/default.css">
	<!-- Custom Login CSS -->
	<link rel="stylesheet" href="css/style.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="js/libraries/jquery.validate.min.js"></script>
	<!-- main.js -->
	<script src="js/home/home.js"></script>
	<!-- main.js -->
	<script src="js/category/category.js"></script>
	<script src="js/attendance/attendance.js"></script>
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
				<input type="hidden" id="post-type" value='recent' />
				<div class="event-post" id="event-load">
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

												<c:if test="${state==currentState}">
													<option selected>${currentState}</option>
												</c:if>
												<c:if test="${state!=currentState}">
													<option>${state}</option>
												</c:if>
											</c:forEach>

										</select>
									</div>
								</div>

								<div class="form-group row">
									<label for="address" class="col-sm-3 col-form-label">City</label>
									<div class="col-sm-9">
										<select class="custom-select form-control" id="city-drop-down"
											name="city">
											<c:forEach items="${cityList}" var="city">
												<c:if test="${city==currentCity}">
													<option selected>${city}</option>
												</c:if>

											</c:forEach>
										</select>
									</div>
								</div>

								<div class="form-group row">
									<label for="phone" class="col-sm-3 col-form-label">Phone</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="phone"
											placeholder="Phone" value="${phone}">
									</div>
								</div>


								<div class="form-group row">
									<label class="col-sm-3">My Choices</label>
									<div class="col-sm-9">
										<div class="form-check">
											<label class="form-check-label"> <c:forEach
													items="${categoryList}" var="category">
													<c:set var="flag" value="0" />
													<c:forEach items="${subscriptionList}" var="subscription">
														<c:if test="${category == subscription}">
															<c:set var="flag" value="1" />
														</c:if>
													</c:forEach>
													<c:if test="${flag==0}">
														<input class="form-check-input" type="checkbox"
															value="${category}"> ${category}
											</c:if>
													<c:if test="${flag==1}">
														<input class="form-check-input" type="checkbox"
															value="${category}" checked> ${category}
											
											</c:if>
												</c:forEach>

											</label>
										</div>
									</div>
								</div>
								<div id="profile-msg"></div>
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
	<cm:footerTag className="footer-copyright py-3 text-center"/>
</body>

</html>