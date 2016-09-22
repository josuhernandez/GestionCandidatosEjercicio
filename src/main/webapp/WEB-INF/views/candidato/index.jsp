<%@include file="../includes/header.jsp" %>

<div class="container">
	<h1>Lista de Candidatos</h1>
	<p>${fecha}</p>
	
		<form:form action="candidato/buscar" method="get" commandName="candidato">
			<form:input path="dni" placeholder="Buscar por dni"/>
			<input type="submit" value="Buscar">	
		</form:form>
		
		
		<p><a class="btn btn-primary btn-xs" href="candidato/nuevo" role="button">Crear</a></p>
		
		<br><br>
	
	${msg}
	 
    <c:forEach items="${candidatos}" var="candidato">
    	<a href="candidato/mostrar/${candidato.id}">
      		<c:out value="${candidato.dni}"/> 
      		<c:out value="${candidato.nombre}"/>
      	</a>
      	<a href="candidato/eliminar/${candidato.id}">
      		[X]
      	</a>      
      	      
      <br><br>
    </c:forEach>

	
	
	
	
	
	
	<a href="">Atras</a>

<div class="container">
<%@include file="../includes/footer.jsp" %>