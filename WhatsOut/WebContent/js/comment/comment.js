/**
 * @Author : Yvan GAKUBA
 * The following functions sends an ajax request create a comment made by a user on an event wrote by Yvan GAKUBA
 * and this one adds the user to the event attendance list
 */

$(function(){
	var helper;
		
	$(document).on('click', ".add-comment", function(){
		helper=this;
		$.post("./CommentController",{
			"description":$('#comment-'+$(this).attr("title")).val(),
			"eventID": $('#commentID-'+$(this).attr("title")).val()
			}
		).done(successMessage);
	});
	
	function successMessage(data){
		$('<img src="images/user.jpg" class="post-comments-image" />')
		.appendTo("#append-"+$(helper).attr("title"));
		$("<div class='load-old-comments-comment'>")
		.text(data.description)
		.appendTo("#append-"+$(helper).attr("title"))
	}
});