/*
* Written On March 21, 2018
* Adds category to the list as the user inserts new category
* Uses the information provided by Category Page designed by Prakash RAI
* @Author Rupendra MAHARJAN
*/

$(document).ready(function(){
	$("#add-category").click(function(){
		//console.log('added');
		var category = $("#category-text").val();
		$.ajax("http://localhost:8080/WhatsOut/CategoryController",{
			"type":"post",
			"data": {
				"category": category,
				"description":$('#category-description').val()
			}
		})
		.done(ajaxSuccess1)
		.fail(ajaxFailure1);
	});
	function ajaxSuccess1(data){
		$("#my-categories").html('');
		jQuery.each(data, function(key,value){
			$('<li class="nav-item">').html(`<a class="nav-link" href="#">${value.name}</a>`).appendTo("#my-categories");
		});
		$("#category-text").val('');
		
	}
	function ajaxFailure1(msg){
		console.log('fail');
		console.log(msg)
	}
});