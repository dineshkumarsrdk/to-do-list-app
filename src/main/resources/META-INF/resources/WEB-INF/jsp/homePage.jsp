<%@include file="common/navigation.jspf" %>

<html>
	<head>
		<title>ToDoz</title>
		<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="container">
			<div>Welcome ${userID}</div>
			<div>View your todo list<a href="/todo">here</a></div>
		</div>
		<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
		<script src=/webjars/bootstrap/5.1.3/js/bootstrap.min.js></script>
	</body>
</html>