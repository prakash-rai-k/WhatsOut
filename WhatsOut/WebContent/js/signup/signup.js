/*
* Written On March 20, 2018
* Changes the city list based on the state selected by user.
* Uses the information from Address Database created by Yvan GAKUBA
* Uses the Sign Up page created by Prakash RAI to send and display the data to user
* @Author Rupendra MAHARJAN
*/


$(document).ready(function(){
	$('#state-drop-down').on("change",function(){
		var state = $('#state-drop-down').val();
		$.ajax("./AddressController",
				{
					"type":"get",
					"data":{
						"state": state
					}
				})
				.done(ajaxSuccess)
				.fail(ajaxFail);
	});
	function ajaxSuccess(data){
		$('#city-drop-down').empty();
		$.each(data, function(id, list){
			$('#city-drop-down').append('<option>' + list.city + '</option>');
		})
	}
	function ajaxFail(msg){
		alert(msg)
	}
});

/*
* Written On March 21, 2018
* Form Validation using jquery-validation 
* @Author Rupendra MAHARJAN
*/
$('#signup-form').validate({
	//Rules defined for Page Validation
	rules : {
		firstname : "required",
		lastname : "required",
		city : "required",
		state : "required",
		phone : "required",
		email : {
			required : true,
			email : true
		},
		username : {
			required : true,
			minlength : 2
		},
		password : {
			required : true,
			minlength : 6
		},
		confirmpassword : {
			required : true,
			minlength : 6,
			equalTo : "[name='password']"
		}
	},
	
	//Messages displayed on invalid entries
	messages : {
		firstname : "Please enter your FirstName",
		lastname : "Please enter your LastName",
		city : "Please enter your city",
		state : "Please enter your state",
		phone : "Please enter your phone",
		email : {
			required : "Please enter an email address",
			email : "Please enter a valid email address"
		},
		username : {
			required : "Please enter a username",
			minlength : "Your username must consists of at least 3 characters"
		},
		password : {
			required : "Please provide a password",
			minlength : "Your username must consists of at least 6 characters"
		},
		confirmpassword : {
			required : "Please provide the password",
			minlength : "Your username must consists of at least 6 characters",
			equalTo : "Please enter the same password as above"
		}
	},
	 errorClass: "invalid-data-input",
	
	//Submits the form in case of successful validation
	submitHandler:function(form){
		form.submit();
	}
});
