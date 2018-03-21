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

            reader.onload = function (e) {
                $('.upload-profile-picture')
                    .attr('src', e.target.result);
            };
            reader.readAsDataURL(input.files[0]);
        }
    });
});