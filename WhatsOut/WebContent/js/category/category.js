/**
 * @Author : Rupendra maharjan
 */

$(document).ready(function(){
	$("#add-category").click(function(){
		console.log('added');
		var category = $("#category-text").val();
		$.ajax("./CategoryController",{
			"type":"get",
			"data": {
				"category": category
			}
		})
		.done(ajaxSuccess)
		.fail(ajaxFailure);
	});
	function ajaxSuccess(data){
		$("#category-text").val('');
		var len = data.length;
		$("#list-category")
		.append(data[len-1].category + '<br/>');
	}
	function ajaxFailure(msg){
		console.log(msg)
	}
});