<%@include file="../includes/header.jsp" %>

<div class="container">
	
	<c:set var="titulo" value="Modificar candidato" scope="page"/>
	<c:set var="boton" value="Modificar" scope="page"/>
	
	<c:if test="${isNew}">
		<c:set var="titulo" value="Crear Candidato" scope="page"/>
		<c:set var="boton" value="Crear" scope="page"/>
	</c:if>
	
	<h1>${titulo}</h1>


	<form:form action="candidato/save" method="post" commandName="candidato">

	<c:if test="${!isNew}">
		<form:label path="id">id:</form:label> 
		<form:input path="id" readonly="true"/>
		<form:errors path="id" cssClass="error"/>
		<br><br>
	</c:if>
	
	<form:label path="dni">DNI:</form:label>
	<form:input path="dni"/>
	<form:errors path="dni" cssClass="error"/>
	<br><br>
	
	<form:label path="nombre">Nombre:</form:label>
	<form:input path="nombre"/>
	<form:errors path="nombre" cssClass="error"/>
	<br><br>
	
	
	
	
	<input type="submit" value="${boton}">
</form:form>
	
	
	<a href="candidato">Atras</a>
	
	<c:if test="${existeMsg}">
		<div class="alert alert-success" role="alert" dismissible>
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			${msg}
		</div>
	</c:if>
	
	
</div>
<%@include file="../includes/footer.jsp" %>