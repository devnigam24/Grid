<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head id="head">
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta ng-model="viewport" content="width=device-width, initial-scale=0.4">
		<%@ include file="includes/resources.inc"%>
	</head>
	<body class="ContentBody" id="contentBody" ng-app="loginSignUpApp">
		<div class="col-xs-12 mainLoginDiv hide" id="mainLoginBody" data-role="page">
			<div data-role="header" class="middle">
				<img class="signupHeaderLable" src="">
				<%@ include file="includes/inputValidationFormServerSideError.inc"%>
			</div>
			<div data-role="content" id="signUpDiv" class="ui-content col-xs-12">
				<form data-ajax="false" novalidate class="form-group" name="signUpForm" action="userSignUp.grid" method="post">
					<input type="hidden" name="securityQuestion"> 
					<input type="hidden" name="charityNonProfitOfChoice">						
					<div id="signUpPartOne" data-role="fieldcontain" class="col-xs-12 ui-field-contain"> 
						<div class="form-group col-xs-12" ng-controller="signUpCtrl">								
							<div class="ui-grid-a">
							    <div class="ui-block-a">
							    		<span for="firstName" class="col-xs-12 errorMsg" ng-show="signUpForm.userFirstName.$invalid">{{firstNameErrorMessage}}</span>
							    		<input type="text" class="ui-corner-all jjjj" ng-model="firstName" name="userFirstName" id="userFirstName" required
										placeholder="First Name" ng-maxlength="24" valid-name value="${userFirstName}" />
							    </div>
							    <div class="ui-block-b">
							    		<span class="col-xs-12 errorMsg" ng-show="signUpForm.userLastName.$invalid">{{lastNameErrorMessage}}</span>
							    		<input type="text" class="ui-corner-all" ng-model="lastName" name="userLastName" required
										placeholder="Last Name" ng-maxlength="24" valid-name value="${userLastName}"/> 
							    </div>
							</div>
						</div>
						<div class="form-group col-xs-12" ng-controller="signUpCtrl">
							<span class="col-xs-12 errorMsg emailError">{{emailErrorMessage}}</span>
							<input type="email" class="ui-corner-all" name="userEmail" ng-model="userEmail" required value="${userEmail}"
								placeholder="e-mail" maxlength="50" ng-blur="checkEmail($event)" />
						</div>
						<div class="form-group col-xs-12 inputBoxDiv" id="">
							 <span class="col-xs-12 errorMsg" ng-show="signUpForm.userName.$invalid || signUpForm.userName.$pending.validUserName || signUpForm.userName.$error.validUserName">{{userNameErrorMessage}}</span>
							<input type="text" class="ui-corner-all" ng-model="userName" name="userName" required value="${userName}"
									placeholder="username" maxlength="25" valid-user-name />
						</div>
						<div ng-controller="userPassword">
							<div class="form-group col-xs-12">
								<span class="col-xs-11 errorMsg">{{passwordErrorMessage}}</span>
								<input type="password" class="ui-corner-all" ng-model="userPassword"
									name="userPassword" ng-blur="checkPassword($event)"
									placeholder="password" ng-minlength="6" ng-maxlength="12"
									required /> 
							</div>
							<div class="form-group col-xs-12">
								<span class="col-xs-11 errorMsg">{{confirmPasswordError}}</span>
								<input type="password" class="ui-corner-all" ng-model="confirmPassword"
									ng-model="confirmPassword" ng-maxlength="12" ng-minlength="6"
									placeholder="re-type password"
									ng-blur="checkPasswordConfirm($event)" /> 
							</div>
						</div>
						<div class="form-group col-xs-12" id="dobDiv" ng-controller="dateOFBirthCtrl" data-role="fieldcontain">
							<span class="col-xs-11 errorMsg">{{DOBErrorMessage}}</span>
							<fieldset data-role="controlgroup">
								<div class="ui-grid-b">
									<div class="ui-block-a">
										<select class="hide"></select>
										<select name="monthOfDOB" id="monthOfDOB" ng-model="monthOfDOB" ng-blur="checkDOB()">
											<c:forEach var="monthValue" items="${monthMap}">
												<option value="${monthValue.key}">${monthValue.value}</option>
											</c:forEach>
											<!-- etc. -->
										</select>
									</div>
									<div class="ui-block-b">
										<select id="dayOfDOB" name="dayOfDOB" ng-model="dayOfDOB" ng-blur="checkDOB()">
											<c:forEach var="dayValue" items="${dayList}">
												<option value="${dayValue}">${dayValue}</option>
											</c:forEach>
										</select>
									</div>
									<div class="ui-block-c">
										<select id="yearOfDOB" name="yearOfDOB" ng-model="yearOfDOB"
											ng-blur="checkDOB()" yearOfDOB>
											<c:forEach var="yearValue" items="${yearList}">
												<option value="${yearValue}">${yearValue}</option>
											</c:forEach>
										</select>
										<select class="hide"></select>
									</div>
								</div>
							</fieldset>							
						</div>
					</div>
				</form>
			</div>
		</div>
	</body>
	<script type="text/javascript">
		var errorList = '${ErrorList}';
		var today = '${today}';
		var thisYear = '${defaultYear}';
		var thisMonth = '${defaultMonth}';
		$("#mainLoginBody").fadeIn(2000).removeClass("hide");
	
		$( document ).ready(function() {			
			$("#dayOfDOB-button span").text("");
			$("#yearOfDOB-button span").text("");
			$("#monthOfDOB-button span").text("");
			
			//$("#dayOfDOB-button").css("margin-left:3px");
			//$("#yearOfDOB-button").text("margin-left:2px");
			//$("#monthOfDOB-button").text("margin-left:5px");	
			
			$(document).ready(function() {
				$("#monthOfDOB").children().first().text("Month");
				$("#dayOfDOB").children().first().text("Day");
				$("#yearOfDOB").children().first().text("Year");
			});
			
			$("[type='text']").each(function(){
				$(this).val($(this).attr("value"));
			});
			
			$("[type='email']").each(function(){
				$(this).val($(this).attr("value"));
			});
		});
		
		$("#monthOfDOB").on('change',function(){
			setTimeout(function(){
				$("#monthOfDOB-button span").text("");
			},1);			
		});
		
		$("#dayOfDOB").on('change',function(){
			setTimeout(function(){
				$("#dayOfDOB-button span").text("");
			},1);
			
		});
		$("#yearOfDOB").on('change',function(){
			setTimeout(function(){
				$("#yearOfDOB-button span").text("");
			},1);
		});
	</script>
</html>