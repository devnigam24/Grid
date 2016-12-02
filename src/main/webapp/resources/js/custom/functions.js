function goToLoginPage(){
	$("#firstDiv").fadeOut(2000);
	setTimeout(function(){
		$("#loginDiv").fadeIn(2000);
	},2000);
}

function goToJoinNowPage(){
	$("#firstDiv").fadeOut(2000);
	$("#gridLogoDiv").fadeOut(2000);
	setTimeout(function(){
		//callAjaxGetPartialPage("http://localhost:8080/GRID/signUpPage.grid","mainLoginBody",null);
		//$("#signUpDiv").fadeIn(2000);
		window.location.href='signUpPage.grid';
	},2000);
	
}

function submitSignUpStepOne(event){
	
}

function checkCredentialsForLogin(){	
	callAjaxGetFullPage("http://localhost:8080/GRID/UserPage.grid");
}

function gotoSignUpNextStep(){
	$("#signUpPartOne").fadeOut(2000);
	setTimeout(function(){
		$("#signUpPartTwo").fadeIn(2000).removeClass("hide");
	},2000);
}

var iii=0
function getMoreQuestions(event){
	var allQuestions = ["Who is your favourite Teacher?","Where did your parents meet?","What was your mother's maiden name?"];
	if(iii === allQuestions.length){
		iii = 0;
	}
	while(iii<allQuestions.length){	
		event.textContent = allQuestions[iii];
		event.classList.remove("securityQuestionsPlaceholder");
		event.classList.add("securityQuestionLabel");
		iii++;
		break;
	}
}

var jjj=0
function populateCharityValues(event){
	var allCharity = ["Charity 1","Charity 2","Charity 3","Charity 4","Charity 5"];
	if(jjj === allCharity.length){
		jjj = 0;
	}
	while(jjj<allCharity.length){	
		event.textContent = allCharity[jjj];
		event.classList.remove("securityQuestionsPlaceholder");
		event.classList.add("securityQuestionLabel");
		jjj++;
		break;
	}
}

function submitUserSignUp(){
	$("[name='securityQuestion']").val($("#secQuestions").text().trim());
	$("[name='charityNonProfitOfChoice']").val($("#charity").text().trim());
	$("[name='signUpForm']").submit();	
}