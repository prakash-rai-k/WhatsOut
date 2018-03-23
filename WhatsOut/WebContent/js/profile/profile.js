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
    
    $('#banner-icon').click(function(){
    	alert();
    	window.location = 'http://localhost:8080/WhatsOut/Home';
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
	
    $('#go-profile').click(function(){
    	$('#event-load').fadeOut();
    	$('#user-profile-form').fadeIn();
    });
	$('#profile-form').validate({
		
	});
		
	/*
	* Written On March 21, 2018
	* Saves the information updated by user using profile page
	* Uses the Profile page designed by Prakash RAI
	* @Author Rupendra MAHARJAN
	*/
	$('#profile-save').click(function() {
		var fullname= $('#fullname').val();
		var email =$('#email').val();
		var state =$("#state-drop-down").val();
		var city = $("#city-drop-down").val();
		var phone =$("#phone").val();
		var choices =[];
		var interest="";
		var i = 0;
		$(".form-check-input:checked").each(function(index,value){
			choices[i] = $(this).val();
			interest += choices[i]+ ",";
			i++;
		});
		console.log(interest);
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