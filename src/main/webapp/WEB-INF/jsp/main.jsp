<!DOCTYPE html>
<html lang="en" ng-app="main">
	<head>
		<title>NK Shorten Url</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/style.css">
		
		<script src="js/jquery.min.js"></script>
		<script src="js/angular.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		
		<script src="js/controller/main.js"></script>
	</head>
	<body ng-controller="MainCtrl">
	
		<nav class="navbar navbar-inverse">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">NK Shorten Url</a>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#">Link List</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">Login</a></li>
					</ul>
				</div>
			</div>
		</nav>
	
		<div class="container text-center">
			<h3>Shorten your link</h3>
			<br>
			<form>
				<div class="form-group col-sm4">
				    <input type="text" class="form-control" id="link" placeholder="your link" ng-model="longLink">
				</div>
				<div class="form-group col-sm4">
				    <button type="submit" class="btn btn-primary" ng-click="getShortenLink()">Get Shorten Link</button>
				</div>
			</form>
		</div>
		
		<div class="container text-center" ng-show="shortenLink != ''">
			<h3>Shorten link . .</h3>
			<a href="{{shortenLink}}" target="_blank">{{shortenLink}}</a>
		</div>
	
		<footer class="container-fluid text-center navbar-fixed-bottom">
			<p>Nopporn Kirapantasan - nopporn.nk@gmail.com</p>
		</footer>
	
	</body>
</html>
