<%@include file="../includes/header.jsp" %>

<div class="container">
	<h1>Lista de Candidatos</h1>
	<p>${fecha}</p>
		
		
		
		<form:form action="candidato/buscar/" method="get" commandName="searchItemForm">
			<form:input path="dni"/>
			<input type="submit" value="Buscar">	
		</form:form>
		
		
		
		
		
		 
		
		<p><a class="btn btn-primary btn-xs" href="candidato/nuevo" role="button">Crear</a></p>
		
		<br><br>
	
	<c:if test="${existeMsgEliminar}">
		<div class="alert alert-success" role="alert" dismissible>
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			${msgEliminado}
		</div>
	</c:if>
	
	
	<c:if test="${existeMsgCandidato}">
		<div class="alert alert-success" role="alert" dismissible>
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			${msgBusqueda}
		</div>
		<a href="">Atras</a>
	</c:if>
	
	 
	 
    <c:forEach items="${candidatos}" var="candidato">
    	<a href="candidato/mostrar/${candidato.id}">
      		<c:out value="${candidato.dni}"/> 
      		<c:out value="${candidato.nombre}"/>
      		<c:out value="${candidato.fechaAlta}"/>
      		
      	</a>
      	<a href="candidato/eliminar/${candidato.id}">
      		[X]
      	</a>      
      	      
      <br><br>
    </c:forEach>

<div class="container">
<%@include file="../includes/footer.jsp" %>