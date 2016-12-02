<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head id="head">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta ng-model="viewport" content="width=device-width, initial-scale=1">

<%@ include file="includes/resources.inc"%>
</head>
<body>
	<div data-role="page" class="col-xs-12 mainLoginDiv" id="mainLoginBody" ng-app="loginSignUpApp">
		<div data-role="header" class="col-xs-12 middle">
			<img class="gridLogo" src="">
			<%@ include file="includes/inputValidationFormServerSideError.inc"%>
			<div class="col-xs-12 middle hide" id="errorDiv">
				<span class="col-xs-10 errorMsg middle"><spring:message code="error.message.login.failed" /></span>
			</div>
		</div>
		<div data-role="content" class="col-xs-12 ui-content" id="firstDiv" ng-controller="signUpLoginCtrl">			
			<div class="col-xs-12 middle" id="sliderButtonDiv">
				<img class="loginSliderButton" src="">
			</div>
			<div class="col-xs-12 middle" id="sliderButtonDiv">
				<img class="signupSliderButton" src="">
			</div>		
		</div>
		<div data-role="content" class="col-xs-12 middle slideButton" id="loginDiv">
			<form data-ajax="false" ng-model="loginForm" action="#" id="loginForm">
				<div class="form-group col-xs-12 middle" id="">
					<input type="text" ng-model="userName" id="userName"  class="ui-corner-all" value=""
						placeholder="username" maxlength="25" />
				</div>
				<div class="form-group col-xs-12 middle" id="">
					<input type="password" ng-model="userPassword" id="userPassword"  class="ui-corner-all"
						value="" placeholder="password" maxlength="25" />
				</div>
				<div class="col-xs-12 middle" id="sliderButtonDiv">
					<img class="loginSliderButton" id="loginButton" src="">
				</div>
			</form>
		</div>
		<%@ include file="includes/footerGeneral.inc"%>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$("#errorDiv").toggle();
		$("#loginDiv").toggle();

		$(".loginSliderButton").on("swiperight", function() {
			goToLoginPage();
		});
		
		$(".signupSliderButton").on("swiperight", function() {
			goToJoinNowPage();
		});
		
		$("#loginButton").on("swiperight", function() {
			checkCredentialsForLogin();
		});
		$("#mainLoginBody").addClass("contentBody");
	});
</script>
</html>