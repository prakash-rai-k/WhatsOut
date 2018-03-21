<div class="panel panel-success panel-posts">
	<div class="panel-heading">
		<h1 class="panel-title">Create a new Event!!</h1>
	</div>
	<!-- panel heading -->

	<div class="panel-body">
		<form id="new-event">
			<div class="form-group row">
				<label class="col-sm-3 event-picture-label">Event logo</label>
				<div class="col-sm-9">
					<input type="file" name="" id="event-picture" /> <img
						src="images/event.png" alt="event picture"
						class="upload-event-picture" />
				</div>
			</div>

			<div class="form-group row">
				<label for="title" class="col-sm-3 col-form-label">Title</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="title"
						placeholder="Title">
				</div>
			</div>

			<div class="form-group row">
				<label for="location" class="col-sm-3 col-form-label">Location</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="location"
						placeholder="Location">
				</div>
			</div>

			<div class="form-group row">
				<label for="description" class="col-sm-3 col-form-label">Description</label>
				<div class="col-sm-9">
					<textarea class="form-control" rows="5" id="description"></textarea>
				</div>
			</div>

			<div class="form-group row">
				<label for="date" class="col-sm-3 col-form-label">Date</label>
				<div class="col-sm-9">
					<input type="date" class="form-control" id="date"
						placeholder="Date">
				</div>
			</div>

			<div class="form-group row">
				<label for="time" class="col-sm-3 col-form-label">Time</label>
				<div class="col-sm-9">
					<input type="time" class="form-control" id="time"
						placeholder="Time">
				</div>
			</div>

			<div class="form-group row">
				<label for="capacity" class="col-sm-3 col-form-label">Capacity</label>
				<div class="col-sm-9">
					<input type="number" class="form-control" id="capacity"
						placeholder="Capacity">
				</div>
			</div>


			<div class="form-group row">
				<label class="col-sm-3">Categories</label>
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
					<button type="submit" class="btn btn-success save-profile">Save
						changes</button>
				</div>
			</div>
		</form>
	</div>
	<!-- panel-body -->

</div>