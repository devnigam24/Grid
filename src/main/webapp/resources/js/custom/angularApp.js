var loginSignUpApp = angular.module('loginSignUpApp', []);

loginSignUpApp.controller('signUpLoginCtrl',function($scope) {
	$scope.testValue = "signUpLoginCtrl";
});


loginSignUpApp.controller('signUpCtrl',function($scope) {
	$scope.checkEmail = function(e){
		if(e.target.value.trim().length > 0){
			if(e.target.classList.contains('ng-invalid-email')){
				$scope.emailErrorMessage = "Email is invalid";
				if($(".emailError").hasClass('ng-hide')){
					$(".emailError").removeClass('ng-hide');
				}
			}else{
				if(!$(".emailError").hasClass('ng-hide')){
					$(".emailError").addClass('ng-hide');
				}
			}
		}else{
			$scope.emailErrorMessage = "Email is mandatory";
			if($(".emailError").hasClass('ng-hide')){
				$(".emailError").removeClass('ng-hide');
			}
		}
	}
});

var errorMessage = null;
loginSignUpApp.directive('validName', function() {
	return {
		restrict: 'A',
		require : 'ngModel',
		link : function(scope, elm, attrs, ctrl) {
			var regex = /^[a-zA-Z ]+$/;			
			ctrl.$parsers.unshift(function(viewValue) {
				if (viewValue.length > 0 && regex.test(viewValue) && viewValue.length <= 24) {
					ctrl.$setValidity('validName', true);
					scope.firstNameErrorMessage="";
					scope.lastNameErrorMessage="";	
				} else if(viewValue.length === 0) {
					ctrl.$setValidity('minLength', false);
					scope.firstNameErrorMessage="First Name must contain atleast 1 characters";
					scope.lastNameErrorMessage="Last Name must contain atleast 1 characters";					
				}else if(viewValue.length > 24) {
					ctrl.$setValidity('maxLength', false);
					scope.firstNameErrorMessage="First Name must not contains be more than 24 characters";
					scope.lastNameErrorMessage="Last Name must not contains be more than 24 characters";
				}else{
					ctrl.$setValidity('validName', false);
					scope.firstNameErrorMessage="First Name contains invalid characters";
					scope.lastNameErrorMessage="Last Name contains invalid characters";
				}
				return viewValue;
			});

		}
	};
});


loginSignUpApp.directive('validUserName', function($q, $timeout) {
	return {
		require : 'ngModel',
		link : function(scope, elm, attrs, ctrl) {
			var usernames = ['Jimm', 'John', 'Jill', 'Jackie'];
			ctrl.$asyncValidators.validUserName = function(modelValue, viewValue) {
				if (ctrl.$isEmpty(modelValue)) {
					return $q.when();
				}
				scope.userNameErrorMessage="Checking if	username is available...";
				var def = $q.defer();
				$timeout(function() {
					if (usernames.indexOf(modelValue) === -1) {
						//scope.userNameSuccessMessage="This username can be used!";
						def.resolve();
					} else {
						scope.userNameErrorMessage="This username is already taken!";
						def.reject();
					}
				}, 2000);
				return def.promise;
			};			
			ctrl.$parsers.unshift(function(viewValue) {
				if(viewValue.length < 4){
					scope.userNameErrorMessage="User Name must be at least 4 character";
				}else if(viewValue.length > 14){
					scope.userNameErrorMessage="User Name cannot be more than 14 character";
				}else{
					var regex = /^[a-zA-Z0-9_-]{4,14}$/;
					if (regex.test(viewValue)) {
						ctrl.$setValidity('validUserName', true);
						return viewValue;
					} else {
						ctrl.$setValidity('validUserName', false);
						scope.userNameErrorMessage="UserName field contains invalid characters";
						return undefined;
					}
				}
			});
			
		}
	};
});

loginSignUpApp.controller("userPassword",function($scope){
	$scope.checkPassword = function(e){
		if(e.target.value.trim().length < 6){
			$scope.passwordErrorMessage="Password must be at least 6 character";
			//e.target.parentNode.parentNode.parentNode.parentNode.lastElementChild.classList.add("opacityZero")
		}else if(e.target.value.trim().length > 12){
			$scope.passwordErrorMessage="Password cannot be more than 12 characters";
			//e.target.parentNode.parentNode.parentNode.parentNode.lastElementChild.classList.add("opacityZero")
		}else{
			var regex = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@-_])(?=.{6,12})");	
			if (regex.test(e.target.value.trim())) {
				$scope.signUpForm.userPassword.$setValidity("userPassword", true);
				//e.target.parentNode.parentNode.parentNode.parentNode.lastElementChild.classList.remove("opacityZero");
				$scope.passwordErrorMessage="";
			} else {
				$scope.signUpForm.userPassword.$setValidity("userPassword", false);
				$scope.passwordErrorMessage="Password must contain only characters,numbers and special characters like @ - and _";
				//e.target.parentNode.parentNode.parentNode.parentNode.lastElementChild.classList.add("opacityZero");
			}
		}
	}
	$scope.checkPasswordConfirm = function(e){
		if(e.target.value.trim() !== $scope.userPassword){
			$scope.confirmPasswordError="Confirm password do not match";
		}else{
			$scope.confirmPasswordError="";
		}
	}
});

loginSignUpApp.controller("dateOFBirthCtrl",function($scope){
	$scope.checkDOB = function(){
		var monthEntered = (parseInt($("#monthOfDOB").val()) + 1) + "";
		var dayEntered = $("#dayOfDOB").val();
		var yearEntered = $("#yearOfDOB").val();
		var enteredDate = new Date(''+monthEntered+'/'+dayEntered+'/'+yearEntered+'');
		
		if(thisYear - enteredDate.getFullYear() > 18){
			$scope.DOBErrorMessage="";
			$(".nextStep").removeAttr("disabled");
		}else if(thisYear - enteredDate.getFullYear() === 18){
			if(enteredDate.getMonth() >= thisMonth){
				$(".nextStep").attr('disabled', 'disabled');
				$scope.DOBErrorMessage="you have to be atleast 18 years of age";				
			}
		}else{
			$(".nextStep").attr('disabled', 'disabled');
			$scope.DOBErrorMessage="you have to be atleast 18 years of age";
		}
	}
});

loginSignUpApp.controller("securityQuestionAndCharity",function($scope){
	var regex = /^[a-zA-Z ]+$/;	
	$scope.checkAnswer = function(e){
		if (regex.test(e.target.value.trim())) {
			$scope.securityAnswerErrorMessage="";
		} else {
			$scope.securityAnswerErrorMessage="Answer must contain only characters";
			$scope.signUpForm.securityAnswer.$setValidity("securityAnswer", true);
		}
	}
});
