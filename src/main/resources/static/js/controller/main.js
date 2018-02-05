var app = angular.module('main', []);

app.controller('MainCtrl', function($rootScope, $scope, $http){
	$scope.shortenLink = "";
	$scope.getShortenLink = function(){
		$scope.shortenLink = "";
		var link = $scope.longLink;
		if(typeof(link) != "undefined" && link != ""){
			$http.post("/api/shorten", link, {
		        withCredentials : false,
		        transformRequest : angular.identity
		    }).then(function(response){
		        if(response.data.code == '1'){
		        	$scope.shortenLink = response.data.data;
		        }else{
		        	console.log(response);
		        	alert(response.data.data);
		        }
		    }).catch(function(response){
		
		    });
		} else {
			alert("please input your link!");
		}
	};
	
//	$scope.getShortenLink();
});