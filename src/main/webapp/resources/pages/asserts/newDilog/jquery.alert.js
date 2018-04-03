(function($){
	
	$.alert = function(params){
		
		if($('#alertOverlay').length){
			// A alert is already shown on the page:
			return false;
		}
		
		var buttonHTML = '';
		$.each(params.buttons,function(name,obj){
			
			// Generating the markup for the buttons:
			
			buttonHTML += '<a href="#" class="button '+obj['class']+'">'+name+'</a>';
			
			if(!obj.action){
				obj.action = function(){};
			}
		});
		
		var markup = [
			'<div id="alertOverlay">',
			'<div id="alertBox">',
			'<h1><i style="color:white;" class="fa ',params.icon,' aria-hidden="true"></i>&nbsp;&nbsp;',params.title,'</h1>',
//                        '<i style="color:black;" class="fa ',params.icon,' aria-hidden="true"></i>',
			'<p>',params.message,'</p>',
			'<div id="alertButtons">',
			buttonHTML,
			'</div></div></div>'
		].join('');
		
		$(markup).hide().appendTo('body').fadeIn();
		
		var buttons = $('#alertBox .button'),
			i = 0;

		$.each(params.buttons,function(name,obj){
			buttons.eq(i++).click(function(){
				
				// Calling the action attribute when a
				// click occurs, and hiding the alert.
				
				obj.action();
				$.alert.hide();
				return false;
			});
		});
	}

	$.alert.hide = function(){
		$('#alertOverlay').fadeOut(function(){
			$(this).remove();
		});
	}
	
})(jQuery);


(function($){
	
	$.wrnalert = function(params){
		
		if($('#wrnalertOverlay').length){
			// A wrnalert is already shown on the page:
			return false;
		}
		
		var buttonHTML = '';
		$.each(params.buttons,function(name,obj){
			
			// Generating the markup for the buttons:
			
			buttonHTML += '<a href="#" class="button '+obj['class']+'">'+name+'</a>';
			
			if(!obj.action){
				obj.action = function(){};
			}
		});
		
		var markup = [
			'<div id="wrnalertOverlay">',
			'<div id="wrnalertBox">',
			'<h1> Warnning </h1>',
                        '<img src="assets/img/warning.png" class="gritter-image" style="width: 110px;height: 110px;">',
			'<p>',params.message,'</p>',
			'<div id="wrnalertButtons">',
			buttonHTML,
			'</div></div></div>'
		].join('');
		
		$(markup).hide().appendTo('body').fadeIn();
		
		var buttons = $('#wrnalertBox .button'),
			i = 0;

		$.each(params.buttons,function(name,obj){
			buttons.eq(i++).click(function(){
				
				// Calling the action attribute when a
				// click occurs, and hiding the wrnalert.
				
				obj.action();
				$.wrnalert.hide();
				return false;
			});
		});
	}

	$.wrnalert.hide = function(){
		$('#wrnalertOverlay').fadeOut(function(){
			$(this).remove();
		});
	}
	
})(jQuery);