/*
    Author : Prakash rai
    Contact : prakashrainpl@gmail.com
    Date : 2018/03/20
    Description : Custom jquery functions for events page
*/

$(document).ready(function(){
    $(".upload-event-picture").click(function () {
        $("#event-picture").trigger('click');
    });

    //change image on selection
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
    
    $('#my-events').click(function(){
    	$.ajax("http://localhost:8080/WhatsOut/Event",
				{
					"type":"get"
				})
				.done(ajaxSuccess)
				.fail(ajaxFail);
    });
    
    $(document).on('click', '#btn-create-event', function(){
    	console.log('here');
    	$('#event-load').fadeOut();
    	$('#create-event').fadeIn();
    });
    
    function ajaxSuccess(data){
    	$('#event-load').html('');
    	jQuery.each(data, function(index,event){
    		let post = `
    					<button class='btn btn-primary btn-create-event' id="btn-create-event">Create new event</button>
    					<div class="panel panel-success panel-posts">
							<div class="panel-heading">
								<h1 class="panel-title">${event.title}</h1>
							</div>
							<!-- panel heading -->

							<div class="panel-body">
								<img src="images/event/${event.id}/${event.logo}" class="panel-body-image" /> <Strong>Location
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
										class="post-feedback-item post-feedback-comment" post-id="1">Say
											something</span></li>
									<li><i class="glyphicon glyphicon-hand-up"></i> <span
										class="post-feedback-item">20 attending</span></li>
								</ul>
							</div>
							<!-- panel-footer -->
						</div>`;
    		
    		$('<div class="dynamic-div">').html(post).appendTo('#event-load');
    		
    	});
    }
    
    function ajaxFail(xhr, state, exception){
    	//console.log(exception);
    	console.log('fail');
    }

});