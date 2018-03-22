<!---    
    Autohor : Prakash Rai
    Date    : 208/03/20
    Contact : prakashrainpl@gmail.com
    Description : Create event form
-->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="panel panel-success panel-posts">
	<div class="panel-heading">
		<h1 class="panel-title">Create a new Event!!</h1>
	</div>
	<!-- panel heading -->

	<div class="panel-body">
		<form id="new-event-form">
			<div class="form-group row">
				<label class="col-sm-3 event-picture-label">Event logo</label>
				<div class="col-sm-9">
					<input type="file" name="eventPicture" id="event-picture" /> <img
						src="images/event.png" alt="event picture"
						class="upload-event-picture" />
				</div>
			</div>

			<div class="form-group row">
				<label for="title" class="col-sm-3 col-form-label">Title</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="title" name="title"
						placeholder="Title" required>
				</div>
			</div>

			<div class="form-group row">
				<label for="state" class="col-sm-3 col-form-label">State</label>
				<div class="col-sm-9">
					<select id="state" required class="form-control" name="state">
						<option value="">State</option>
						<c:forEach var="state" items="${states}">
							<c:choose>
								<c:when test="${state == userState}">
									<option value="${state}" selected="selected">${state}</option>
								</c:when>

								<c:otherwise>
									<option value="${state}">${state}</option>
								</c:otherwise>
							</c:choose>

						</c:forEach>

					</select>

				</div>
			</div>

			<div class="form-group row">
				<label for="city" class="col-sm-3 col-form-label" name="city">city</label>
				<div class="col-sm-9">
					<select id="city" class="form-control" required>
						<option value="">City</option>
						<c:forEach var="city" items="${cities}">
							<c:choose>
								<c:when test="${city == userCity }">
									<option value="${city}" selected="selected">${city}</option>
								</c:when>

								<c:otherwise>
									<option value="${city}">${city}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group row">
				<label for="happening-on" class="col-sm-3 col-form-label">Happening on</label>
				<div class="col-sm-9">
					<input type="date" class="form-control" id="happening-on" name="happeningOn" placeholder="Happening on" required>
				</div>
			</div>

			<div class="form-group row">
				<label for="time" class="col-sm-3 col-form-label">Time on</label>
				<div class="col-sm-9">
					<input type="time" class="form-control" id="time" name="time" placeholder="Ending on" required>
				</div>
			</div>

			<div class="form-group row">
				<label for="ending-on" class="col-sm-3 col-form-label">Ending on</label>
				<div class="col-sm-9">
					<input type="date" class="form-control" id="ending-on" name="endingOn" placeholder="Ending on" required>
				</div>
			</div>

			<div class="form-group row">
				<label for="time-end" class="col-sm-3 col-form-label">Time on</label>
				<div class="col-sm-9">
					<input type="time" class="form-control" id="time-end" name="timeEnd" placeholder="Ending on" required>
				</div>
			</div>

			<div class="form-group row">
				<label for="capacity" class="col-sm-3 col-form-label">Capacity</label>
				<div class="col-sm-9">
					<input type="number" class="form-control" id="capacity" name="capacity" placeholder="Capacity" required>
				</div>
			</div>

			<div class="form-group row">
				<label for="description" class="col-sm-3 col-form-label">Description</label>
				<div class="col-sm-9">
					<textarea rows="5" class="form-control" name="description" id="description"></textarea>
				</div>
			</div>

			<div class="form-group row">
				<label for="category" class="col-sm-3 col-form-label" name="city" required>Category</label>
				<div class="col-sm-9">
					<select id="category" name="category" class="form-control" required>
						<option value="">Category</option>
						<option value="">City</option>
						<c:forEach var="category" items="${categories}">
							<option value="${category.id}">${category.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-3"></label>
				<div class="offset-sm-3 col-sm-9">
					<button type="submit" class="btn btn-success save-profile">Save
						changes</button>
				</div>
			</div>
		</form>
	</div>
	<!-- panel-body -->

</div>