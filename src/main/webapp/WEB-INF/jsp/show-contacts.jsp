%@ include file ="../webapp.WEB-INF.jsp.common/header.jspf" %>
<%--<%@ include file ="../webapp.WEB-INF.jsp.common/navigation.jspf" %>--%>
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
			<c:forEach items="${contacts}" var="Contact">
			<tr>
				<td>${Contact.firstName}</td>
				<td>${Contact.middleName}</td>
				<td>${Contact.lastName}</td>
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
