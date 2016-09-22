<%@include file="../includes/header.jsp" %>

<div class="container">
	<h1>Lista de Candidatos</h1>
	<p>${fecha}</p>
	
	
		<p><a class="btn btn-primary btn-xs" href="candidato/buscar" role="button">Buscar</a></p>
		<p><a class="btn btn-primary btn-xs" href="candidato/nuevo" role="button">Crear</a></p>
		
		<br><br>
	
	
	 
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