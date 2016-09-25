<%@ include file="../includes/header.jsp"%>


<body>
	<!-- Enlace para volver al indice -->
	<a href=""> &lt; &lt;Volver Index</a>
	<br>

	<h1>Lista Candidatos</h1>
	
	<hr>
    	<ol>
    		<li><a href="<c:url value="/candidato/nuevo"/>">CREAR NUEVO CANDIDATO</a></li>
	   	</ol>
    	
    <hr> 
    
     ${msg}
    

	<br><br>
	
	<h2>Listado de Candidatos</h2>
	<ol>
	<c:forEach items="${listaCandidatos}" var="miCandidato">
		<li>
			<a href="<c:url value="/candidato/detalle/${miCandidato.id}"/>">
				<c:out value="${miCandidato.id}"/>
				<i>--<c:out value="${miCandidato.nombre}"/></i>
				<i>--<c:out value="${miCandidato.dni}"/></i>
				<i>--<c:out value="${fecha}"/></i>
			</a>
			<a href="<c:url value="/candidato/eliminar/${miCandidato.id}"/>">	[X]	</a>
			<a href="<c:url value="/candidato/modificar/${miCandidato.id }"/>"> [Modificar]  </a>
		</li>
		<br>

  	</c:forEach>
	</ol>

<%@ include file="../includes/footer.jsp"%>