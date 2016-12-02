var functionCallCount = 0;

function initiateSlider(){
		$(slider).each(function(){
			$("#slider").draggable({
				axis: 'x',
				containment: 'parent',
				drag: function(event, ui) {
					if (ui.position.left > 400) {
						alert("slide");
					} else {
						// Apparently Safari isn't allowing partial opacity on text with background clip? Not sure.
						// $("h2 span").css("opacity", 100 - (ui.position.left / 5))
					}
				},
				stop: function(event, ui) {
					if (ui.position.left < 551) {
						$(this).animate({
							left: 0
						})
					}
				}
			});
			
			this.addEventListener('touchmove', function(event) {
				event.preventDefault();
				var el = event.target;
				var touch = event.touches[0];
				curX = touch.pageX - this.offsetLeft - 73;
				if(curX <= 0) return;
				if(curX > 400){
					var functionToCall = $(this).attr("onSlide");					
					var Count = parseInt(functionToCall.charAt(parseInt(functionToCall.indexOf("(")) + 1));
					if($(this).attr("disabled") !== undefined){
						if(functionCallCount < Count && $(this).attr("disabled") !== "disabled"){
							eval(functionToCall);
							functionCallCount++;
						}
					}else{
						if(functionCallCount < Count){
							eval(functionToCall);
							functionCallCount++;
						}
					}
					
				}
				el.style.webkitTransform = 'translateX(' + curX + 'px)'; 
			}, false);
			
			this.addEventListener('touchend', function(event) {
				this.style.webkitTransition = '-webkit-transform 0.3s ease-in';
				this.addEventListener( 'webkitTransitionEnd', function( event ) { this.style.webkitTransition = 'none'; }, false );
				this.style.webkitTransform = 'translateX(0px)';
			}, false);
		});
}