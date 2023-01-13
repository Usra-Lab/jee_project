/**
 * 
 */
 
 $(".sidebar ul li").on('click',function(){
			$(".sidebar ul li .active").find(".active");removeClass('active');
			$(this).parent().addClass('active');
		});
		
		