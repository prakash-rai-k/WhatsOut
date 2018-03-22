/*
    Author : Prakash rai
    Contact : prakashrainpl@gmail.com
    Date : 2018/03/20
    Description : Custom jquery functions for profile
*/

$(document).ready(function(){
    //Changing profile picture
    $(".upload-profile-picture").click(function () {
        $("#profile-picture").trigger('click');
    });

    //change image on leselection
    $("#profile-picture").change(function(){
        let input = this;
        if (input.files) {
            var reader = new FileReader();

			reader.onload = function(e) {
				$('.upload-profile-picture').attr('src', e.target.result);
			};
			reader.readAsDataURL(input.files[0]);
		}
	});
	
	$('#profile-form').validate({
		
	});
		
	// save profiles on saving changes
	$('#profile-save').click(function() {
		alert(1)
		var fullname= $('#fullname').val();
		var email =$('#email').val();
		var state =$("#state-drop-down").val();
		var city = $("#city-drop-down").val();
		var phone =$("#phone").val();
		var choices =[];
		var interest="";
		$(".form-check-input:checked").each(function(i){
			choices[i] = $(this).val();
			interest += choices[i]+ "%%%%%";
		});
		$.ajax("./Profile", {
			"type": "post",
			"datatype": "json",
			"data" : {
				"fullname" : fullname,
				"email" : email,
				"state" : state,
				"city" :city,
				"phone" : phone,
				"choiceArray":interest
			}
		})
		.done(ajaxSuccess)
		.fail(ajaxFail);
	});
	function ajaxSuccess(){
		$("#profile-msg").empty();
		$("#profile-msg").append("Saved Successfully");
	}
	function ajaxFail(){
		$("#profile-msg").append("Invalid Information.");
	}
});