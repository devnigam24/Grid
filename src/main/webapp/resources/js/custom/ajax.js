/*
*
*/
function callAjaxGetFullPage(url){
	$.ajax({
	    url: url,
	    crossDomain: true,
	    beforeSend: beforeAjaxCallFunction,
		success: fadeInFadeOut,	   
	    error: ajaxErrorFunction,
	    dataType: 'html',
	    type: 'GET'
	}).done(function(){
		console.log("ajax call over successfully");
	});
}

/*
*
*/
function ajaxErrorFunction(){
	console.log("Some Error on ajax call")
}

/*
*
*/
function beforeAjaxCallFunction(){
	console.log("ajax call initiated");
}


/*
* 
*/
function fadeInFadeOut(data){
	$("#contentBody").fadeOut(2000);
	setTimeout(function(){
		$("#contentBody").html();
		$("#contentBody").html(data).fadeIn(2000);
	},2000);
}

/*
*
*/
/*function callAjaxGetPartialPage(url,divIdToReplace,callback){
	$.ajax({
	    url: url,
	    crossDomain: true,
	    beforeSend: beforeAjaxCallFunction,
		success: function(data){
			$("#"+divIdToReplace+"").html(data);
		},	   
	    error: ajaxErrorFunction,
	    dataType: 'html',
	    type: 'GET'
	}).done(function(){
		if(callback === undefined || callback === null){
			console.log("ajax call over");
		}else{
			eval(callback);
			console.log("ajax call over successfully");
		}
	});
}*/