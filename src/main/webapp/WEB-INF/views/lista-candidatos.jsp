<%@ include file="includes/header.jsp"%>


<body>
	<!-- Enlace para volver al indice -->
	<a href=""> &lt; &lt;Volver Index</a>
	<br>

	<h1>Lista Candidatos</h1>


${listaCandidatos}

	<ol>
	<c:forEach items="listaCandidatos" var="miCandidato">
		<li>
			<a href="candidato/detalle/<c:out value="${miCandidato.id}"/>">
				<c:out value="${miCandidato.id}"/>
				<c:out value="${miCandidato.nombre}"/>
				<c:out value="${miCandidato.dni}"/>
			</a>
		</li>

  	</c:forEach>
	</ol>

<%@ include file="includes/footer.jsp"%>