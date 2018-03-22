/*
    Author : Prakash rai
    Contact : prakashrainpl@gmail.com
    Date : 2018/03/20
    Description : Custom jquery functions for events page
*/

$(document).ready(function(){
	/*
	 * Show/hide comment while clicking on 'Say something'
	 *  Author : prakash rai
	 */
    $(document).on('click', '.post-feedback-comment', function(){
        let postId = $(this).attr('post-id');
        theID=$(this).attr('post-id');
        $('#post-comment-' + postId).toggle(100);
        /*
         * Author: Yvan GAKUBA
         * To send an ajax call to retrieve all the comments*/
        $.get("./CommentController?id="+postId)
        .done(formatData);
    });
    
    function formatData(data){
    	$('.post-old-comments').html('');
    	data.forEach(elt=>{
    		$('.post-old-comments').append(`<div><img src="images/user.jpg" class="post-comments-image">
    		<div class="load-old-comments-comment">${elt.description}</div></div>`);
    	});
    }
    
    $(".upload-event-picture").click(function () {
        $("#event-picture").trigger('click');
    });

    /*
	 * Open windows when profile picture is clicked 
	 * Author : prakash rai
	 */
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
    
    /*
	 * List my events when user clicks 'My events' 
	 * Author : prakash rai
	 */
    $('#my-events').click(function(){
    	loadMyEvents("my-events");
    });
    
    /*
	 * List coming events when user clicks 'Coming events' 
	 * Author : prakash rai
	 */
    $('#coming-events').click(function(){
    	loadMyEvents("coming-events");
    });
    
    /*
	 * Search events based on string inside textbox 
	 * Author : prakash rai
	 */
    $('#search-event').click(function(){
    	loadMyEvents("search");
    });
    
    /*
	 * List attended events when user clicks 'Attended events' 
	 * Author : prakash rai
	 */
    $('#attended-events').click(function(){
    	loadMyEvents("attended-events");
    });
    
    /*
	 * List favourite events when user clicks 'Favourite events' 
	 * Author : prakash rai
	 */
    $('#favourite-events').click(function(){
    	loadMyEvents("favourite-events");
    });
    
    /*
	 * Function that renders events based on user demand
	 * params: type of event (attende/attending/userEvents/search) 
	 * Author : prakash rai
	 */
    function loadMyEvents(type){
    	$('#post-type').val(type);
    	$.ajax("http://localhost:8080/WhatsOut/Event",{
			"type":"get",
			"data" : {"type": type, "searchString" : $('#search-text').val()}
		}).done(loadEventsSuccess)
		  .fail(loadEventsFail);
    }
    
    /*
	 * Show create event form 
	 * Author : prakash rai
	 */
    $(document).on('click', '#btn-create-event', function(){
    	$('#event-load').fadeOut();
    	$('#create-event').fadeIn();
    });
    
    /*
	 * List cities dropdown when state change
	 * Author : prakash rai
	 */
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
    
    /*
	 * Populate city dropdown
	 * Author : prakash rai
	 */
    function loadCitiesSuccess(data){
		$('#city').empty();
		jQuery.each(data, function(key, value){
			$('<option>').html(value.city).appendTo('#city');
		});
	}
    
    /*
	 * List attended events when user clicks 'Attended events' 
	 * Author : prakash rai
	 */
	function loadCitiesFail(msg){
		alert('Failed to load cities')
	}
	
	/*
	 * jquery Validator fucntion to validate new form
	 * Author : prakash rai
	 */
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
    
    /*
	 * New validator method for comparing dates 
	 * Author : prakash rai
	 */
    jQuery.validator.addMethod("greaterThan", 
    		function(value, element, params) {

    		    if (!/Invalid|NaN/.test(new Date(value))) {
    		        return new Date(value) > new Date($(params).val());
    		    }

    		    return isNaN(value) && isNaN($(params).val()) 
    		        || (Number(value) > Number($(params).val())); 
    		},'Must be greater than {0}.');
    $("#ending-on").rules('add', { greaterThan: "#happening-on" });
    
    /*
	 * Save event function
	 * takes values from from and calls servlet through ajax 
	 * Author : prakash rai
	 */
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
        
        if(logo.length > 0) logo = logo[0];
        
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
    
    /*
	 * Handling success 
	 * Author : prakash rai
	 */
    function postEventSuccess(msg){
    	loadMyEvents("my-events");
    	$(window).scrollTop(0);
    }
    
    /*
	 * List attended events when user clicks 'Attended events' 
	 * Author : prakash rai
	 */
    function postEventFail(xhr, status, exception){
    	console.log('error');
    }
    
    /*
	 * populates events after succefull load from ajax
	 * Author : prakash rai
	 */
    function loadEventsSuccess(data){
    	$('#event-load').html('');
    	
    	if($('#post-type').val() === 'search'){
			let searchString = $('#search-text').val();
			$('<div class="alert alert-success">').html(`Search results for <strong>${searchString}</strong>`).appendTo('#event-load');
		}
    	else{
    		$('#search-text').val('');
    	}
    	
    	if(data.length === 0){
    		$('<div class="alert alert-success">').html(`No events found!!`).appendTo('#event-load');
    	}
    	else{
    		if($('#post-type').val() === 'my-events'){
    			$('<div class="dynamic-div">').html(`<button class='btn btn-primary btn-create-event' id="btn-create-event">Create new event</button>`).appendTo('#event-load');
    		}
    		jQuery.each(data, function(index,event){
        		let post = `<div class="panel panel-success panel-posts">
    							<div class="panel-heading">
    								<h1 class="panel-title">${event.title}</h1>
    							</div><!-- panel heading -->

    							<div class="panel-body">
    								<img src="images/event/1/default.png" class="panel-body-image" /> 
    								<div class='post-contents'>
    									<Strong>Location: </Strong> ${event.address}<br> <Strong>Organized by : </Strong> ${event.eventCreator} <br> 
    									<Strong>Datetime: </Strong> ${event.happeningOn}<br> 
    									<p>${event.description}</p>
    								</div>
    							</div><!-- panel-body -->

    							<div class="panel-footer">
								<ul class="post-feedback">
										<li class="post-feedback-count-me bg-primary" title="${event.id}"><i class="glyphicon glyphicon-thumbs-up"></i> <span
										class="post-feedback-item">Attending!</span></li>
									
									<li><i class="glyphicon glyphicon-comment"></i> <span
										class="post-feedback-item post-feedback-comment" post-id="${event.id}">Say
											something</span></li>
									<li><i class="glyphicon glyphicon-hand-up"></i> <span
										class="post-feedback-item" id="nbr${event.id}">${event.totalComing} attending</span></li>
								</ul>
							</div>
							<!-- panel-footer -->
						</div>
						<div class="panel panel-default post-comments post-comments-main" id="post-comment-${event.id}">
							<div class="panel-body" id="body-${event.id}">
								<div class="post-old-comments" id="append-${event.id}">
									<img src="images/user.jpg" class="post-comments-image" />
									<div class="load-old-comments-comment"></div>
								</div>
								<div class="post-new-comment">
									<img src="images/user.jpg" class="post-comments-image" />
									 <input
										type="text" class="form-control comment-textbox comment-input" id="comment-${event.id}"
										placeholder="Write something..."/>
										<input type="hidden" value="${event.id}" id="commentID-${event.id}"/>
										<button title="${event.id}" type="button" class="btn btn-success add-comment" name="add-category">
											<i class="glyphicon glyphicon-comment"></i> Share
										</button>
								</div>
							</div>
    						</div>`;
        		
        		$('<div class="dynamic-div">')
        			.html(post)
        			.appendTo('#event-load');
        		
            	$('#create-event').fadeOut();
            	$('#event-load').fadeIn(200);
        	});
    	}
    }
    
    /*
	 * Method to handle failed condition for loading events
	 * Author : prakash rai
	 */
    function loadEventsFail(xhr, state, exception){
    	alert('Problem occured while loading your events.')
    }

});