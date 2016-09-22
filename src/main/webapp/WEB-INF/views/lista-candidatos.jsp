<%@ include file="includes/header.jsp"%>


<body>
	<!-- Enlace para volver al indice -->
	<a href=""> &lt; &lt;Volver Index</a>
	<br>

	<h1>Lista Candidatos</h1>

	<ol>
	<c:forEach items="lista" var="candidato">
		<li>
			<a href="<c:out value="candidato/detalle/${candidato.id}"/>">
				<c:out value="${candidato.nombre}"/>
				<c:out value="${candidato.dni}"/>
			</a>
		</li>

  	</c:forEach>
	</ol>

<%@ include file="includes/footer.jsp"%>