/*
    Author : Prakash rai
    Contact : prakashrainpl@gmail.com
    Date : 2018/03/20
    Description : Custom jquery functions for events page
*/

$(document).ready(function(){
	// Show hide when comment clicked in post post-feedback-comment
    $(document).on('click', '.post-feedback-comment', function(){
        let postId = $(this).attr('post-id');
        $('#post-comment-' + postId).toggle(100);
    });
    
    $(".upload-event-picture").click(function () {
        $("#event-picture").trigger('click');
    });

    // change image on selection
    $("#event-picture").change(function(){
        let input = this;
        if (input.files) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('.upload-event-picture')
                    .attr('src', e.target.result);
            };
            reader.readAsDataURL(input.files[0]);
        }
    });
    
    // load user events
    $('#my-events').click(function(){
    	loadMyEvents("my-events");
    });
    
 // load user events
    $('#coming-events').click(function(){
    	loadMyEvents("coming-events");
    });
    
 // load user events
    $('#attended-events').click(function(){
    	loadMyEvents("attended-events");
    });
    
    // load user events
    $('#favourite-events').click(function(){
    	loadMyEvents("favourite-events");
    });
    
    //Load events based on type parameter
    function loadMyEvents(type){
    	$.ajax("http://localhost:8080/WhatsOut/Event",{
			"type":"get",
			"data" : {"type": type}
		}).done(loadEventsSuccess)
		  .fail(loadEventsFail);
    }
    
    // show event list and show create form
    $(document).on('click', '#btn-create-event', function(){
    	$('#event-load').fadeOut();
    	$('#create-event').fadeIn();
    });
    
    // load cities on state change
    $('#state').on("change",function(){
		var state = $('#state').val();
		$.ajax("http://localhost:8080/WhatsOut//AddressController",
			{
				"type":"get",
				"data":{
					"state": state
			}
		})
		.done(loadCitiesSuccess)
		.fail(loadCitiesFail);
	});
    
    //populate city select with options
    function loadCitiesSuccess(data){
		$('#city').empty();
		jQuery.each(data, function(key, value){
			$('<option>').html(value.city).appendTo('#city');
		});
	}
    
    //display alert message
	function loadCitiesFail(msg){
		alert('Failed to load cities')
	}
	
  // Used for form validation using jquery validation
    $('#new-event-form').validate({
    	// Rules defined for Page Validation
    	rules : {
    		title : "required",
    		state : "required",
    		city : "required",
    		state : "required",
    		description : "required",
    		capacity : "required",
    		happeningOn : "required",
    		endingOn : "required",
    		category : "required",
    		eventPicture: {
	        required: true,
	        extension: "jpg|png"
    		},
    		
    	},
    	
    	// Messages displayed on invalid entries
    	messages : {
    		title : "Please let us know your event title",
    		state : "Where is it going to be?",
    		city : "Which city?",
    		description : "Tell us something about event.",
    		capacity : "How many people can attend?",
    		happeningOn : "When its happening?",
    		endingOn : "Does it go forever?",
    		category: "Please select category!!",
    		eventPicture : "Please select event picture!!"
    	},
    	errorClass: "invalid-data-input",
    	
    	// Submits the form in case of successful validation
    	submitHandler:function(){
    		saveEvent();
    	}
    });
    
    // save Event
    function saveEvent(){
    	let title = $('#title').val();
    	let state = $('#state').val();
    	let city = $('#city').val();
    	let time = $('#time').val();
    	let timeEnd = $('#time-end').val();
    	let description = $('#description').val();
    	let capacity = $('#capacity').val();
    	let happeningOn = $('#happening-on').val();
    	let endingOn = $('#ending-on').val();
    	let category = $('#category').val();
        let logo = $('#event-picture')[0].files;
        
        if(logo.length > 0){
        	logo = logo[0];
        }
    	
    	let data = {"title": title, "city" : city,  "state" : state, "description" : description, "timeEnd" : timeEnd,
    				"happeningOn" : happeningOn, "endingOn" : endingOn, "category" : category, "time" : time,// "logo":
																												// logo,
    				"capacity": capacity
    				};
    	
    	$.ajax("http://localhost:8080/WhatsOut/Event",
				{
					"type":"POST", 
					"data" : data
				})
				.done(postEventSuccess)
				.fail(postEventFail);
    }
    
    //Event post success event
    function postEventSuccess(msg){
    	loadMyEvents("my-events");
    	$(window).scrollTop(0);
    }
    
    //Event post failed case
    function postEventFail(xhr, status, exception){
    	console.log('error');
    }
    
    // load events in box
    function loadEventsSuccess(data){
    	$('#event-load').html('');
    	$('<div class="dynamic-div">').html(`<button class='btn btn-primary btn-create-event' id="btn-create-event">Create new event</button>`).appendTo('#event-load');
    	
    	jQuery.each(data, function(index,event){
    		let post = `<div class="panel panel-success panel-posts">
							<div class="panel-heading">
								<h1 class="panel-title">${event.title}</h1>
							</div>
							<!-- panel heading -->

							<div class="panel-body">
								<img src="images/event/1/default.png" class="panel-body-image" /> <Strong>Location
									: </Strong> ${event.address}<br> <Strong>Organized by :
								</Strong> ${event.eventCreator} <br> 
								<Strong>Datetime: </Strong> ${event.happeningOn}
								<br> 
								<p>${event.description}</p>
							</div>
							<!-- panel-body -->

							<div class="panel-footer">
								<ul class="post-feedback">
									<li><i class="glyphicon glyphicon-plus"></i> <span
										class="post-feedback-item">Count me</span></li>
									<li><i class="glyphicon glyphicon-comment"></i> <span
										class="post-feedback-item post-feedback-comment" post-id="${event.id}">Say
											something</span></li>
									<li><i class="glyphicon glyphicon-hand-up"></i> <span
										class="post-feedback-item">20 attending</span></li>
								</ul>
							</div>
							<!-- panel-footer -->
							<div class="panel panel-default post-comments" id="post-comment-${event.id}">
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
					</div>`;
    		
    		$('<div class="dynamic-div">').html(post).appendTo('#event-load');
    		
        	$('#create-event').fadeOut();
        	$('#event-load').fadeIn(200);
    		
    	});
    }
    
    // failure ajax call failure handle
    function loadEventsFail(xhr, state, exception){
    	alert('Problem occured while loading your events.')
    }

});