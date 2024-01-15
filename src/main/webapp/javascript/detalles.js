function changeImage(element) {

              var main_product_image = document.getElementById('main_product_image');
              main_product_image.data = element.data;
              main_product_image.src = element.src;
              
            
              
         
              
        
       }
       

$(document).ready(function(){
    $('.zoom').hover(function() {
        $(this).addClass('transition');
    }, function() {
        $(this).removeClass('transition');
    });
});
