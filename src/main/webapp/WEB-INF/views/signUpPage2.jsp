<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head id="head">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta ng-model="viewport"
	content="width=device-width, initial-scale=0.4">

<%@ include file="includes/resources.inc"%>
<script src="resources/js/jquery/jquery.mobile-1.4.5.min.js"></script>

</head>
<body class="ContentBody" id="contentBody" ng-app="loginSignUpApp">
	<div class="col-xs-12 mainLoginDiv" id="mainLoginBody">
		<div class="col-xs-12" id="signUpDiv">
			<form novalidate class="form-group" name="signUpForm2"
				action="userSignUpAndTimeline.grid"  method="post">
				<input type="hidden" name="secQuestions">
				<input type="hidden" name="charity">
				<div class="signupHeaderLable"></div>
				<div id="signUpPartTwo" ng-controller="securityQuestionAndCharity">
					<div class="form-group col-xs-12 inputBoxDiv" >
						<div class="emailBox col-xs-12">
							<label id="secQuestions" class="col-xs-11 securityQuestionsPlaceholder">Security question</label>
						</div>
					</div>
					<div class="form-group col-xs-12 inputBoxDiv" >
						<div class="emailBox col-xs-12">
							<input type="text" name="securityAnswer" id="securityAnswer" value=""
								placeholder="Security answer" maxlength="100" ng-blur="checkAnswer($event)" /> 
							<span class="col-xs-12 errorMsg">{{securityAnswerErrorMessage}}</span>
						</div>
					</div>
					<div class="form-group col-xs-12 inputBoxDiv" >
						<div class="emailBox col-xs-12">
							<label id="charity" class="col-xs-11 securityQuestionsPlaceholder">
								Charity or non-profit of choice</label>
						</div>
					</div>
					<div class="col-xs-12 inputBoxDiv" id="sliderButtonDiv">
						<div class="sliderBackground" style="background-size: 90%; margin-top:15%;">
							<p id="slider" onSlide="submitUserSignUp();" class="mt10">JOIN NOW</p>
						</div>
					</div>
				</div>

			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	initiateSlider();
	
	$("#secQuestions").on("swipe",function(){
		 getMoreQuestions(this);
	  }); 
	
	$("#charity").on("swipe",function(){
		 populateCharityValues(this);
	  }); 
	
	
</script>
</html>