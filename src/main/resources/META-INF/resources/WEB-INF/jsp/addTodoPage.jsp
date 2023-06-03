<%@ taglib prefix="d" uri="http://www.springframework.org/tags/form" %>
<%@include file="common/navigation.jspf" %>
<html>
	<head>
		<title>ToDoz - add todo</title>
		<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
		<link href="/webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css
" rel="stylesheet">
	</head>
	<body>
		<div class="container">
			<h1>Add your todo details</h1>
			<d:form method="post" modelAttribute="todo">
				<fieldset class="mb-3">
					<d:label path="description">Description</d:label>
					<d:input type="text" path="description" required="required"/>
					<d:errors path="description" cssClass="text-warning"/>
				</fieldset>
				<fieldset class="mb-3">
					<d:label path="targetDate">Target Date</d:label>
					<d:input type="text" path="targetDate" required="required"/>
					<d:errors path="targetDate" cssClass="text-warning"/>
				</fieldset>
				<fieldset class="mb-3">
					<d:label path="status">Status</d:label>
					<d:input type="text" path="status" required="required"/>
					<d:errors path="status" cssClass="text-warning"/>
				</fieldset>
				<input type="submit" class="btn btn-success">
			</d:form>
		</div>
	</body>
	<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src=/webjars/bootstrap/5.1.3/js/bootstrap.min.js></script>
	<script src="/webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript">
		$('#targetDate').datepicker({format: 'dd-mm-yyyy'});
	</script>
</html>
