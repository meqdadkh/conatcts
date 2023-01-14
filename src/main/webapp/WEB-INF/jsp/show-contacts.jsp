<html>
<head>
	<title>Contats Application</title>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<table class="table table-striped">
		<caption>Your contacts are</caption>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Middle Name</th>
				<th>Last Name</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contacts}" var="var1">
			<tr>
				<td>${var1.firstName}jj</td>
				<td>${var1.middleName}</td>
				<td>${var1.lastName}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<%--<div>
		<a class="button" href="/add-todo">Add a Todo<a>
	</div>--%>
</div>
<%--
<%@ include file ="../webapp.WEB-INF.jsp.common/footer.jspf" %>--%>
</body>
</html>
