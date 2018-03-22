/**
 * @Author : Yvan GAKUBA
 * The following functions sends an ajax request to AttendanceController wrote by Yvan GAKUBA
 * and this one adds the user to the event attendance list
 */
$(function(){
	var helper;
    $(document).on('click', ".post-feedback-count-me", function(){
    	helper=this;
       $.get("./AttendanceController?id="+$(this).attr('title'))
       .done(successMethod);
    });
    function successMethod(data){
    	if(data.Message===' Attending!'){
    		$(helper)
    	 	   .empty()
    	 	   .append($("<i class='glyphicon glyphicon-thumbs-up'>").text(""))
    	 	   .addClass("bg-primary")
    	 	   .append(data.Message), 
    	 	   $("#nbr"+$(helper).attr('title'))
    	 	   .empty()
    	 	   .append(data.nbr)
    	 	   .append(" attending");
    	}else{
    		$(helper)
    	 	   .empty()
    	 	   .append($("<i class='glyphicon glyphicon-hands-up'>").text(""))
    	 	   .removeClass("bg-primary")
    	 	   .append(data.Message), 
    	 	   $("#nbr"+$(helper).attr('title'))
    	 	   .empty()
    	 	   .append(data.nbr)
    	 	   .append(" attending");
    	}
    	
    }
});