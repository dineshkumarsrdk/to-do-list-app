<!-- import jstl -->
<%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="common/navigation.jspf" %>

<html>
<head>
<title>ToDoz - Your todo list</title>
<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1>Your todo list</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Status</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<d:forEach items="${todo}" var="todo">
					<tr>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.status}</td>
						<td><a href="delete-todo?ID=${todo.ID}"
							class="btn btn-warning">Delete</a></td>
						<td><a href="update-todo?ID=${todo.ID}"
							class="btn btn-success">Update</a></td>
					</tr>
				</d:forEach>
			</tbody>
		</table>
		<a href="add-todo" class="btn btn-success">Add Todo</a>
	</div>

	<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src=/webjars/bootstrap/5.1.3/js/bootstrap.min.js></script>
	
</body>
</html>
