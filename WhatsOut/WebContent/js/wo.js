$(document).ready(function(){
    $('.post-feedback-item').click(function(){
        let postId = $(this).attr('post-id');
        console.log($('#post-comment-' + postId).css('display'));
        if( $('#post-comment-' + postId).css('display') == 'none'){
            $('#post-comment-' + postId).show(200);
        }

        else{
            $('#post-comment-' + postId).hide(200);
        }
    });
});