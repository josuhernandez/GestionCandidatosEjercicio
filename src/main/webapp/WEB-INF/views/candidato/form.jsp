<%@ include file="../includes/header.jsp"%>


<body>
	<!-- Enlace para volver al listado -->
	<a href="listado"> &lt; &lt;Volver Listado Candidatos</a>
	<br><br><br>
	
	<c:set var="titulo" value="Modificar Candidato" scope="page"/>
	<c:set var="boton" value="Modificar" scope="page"/>
	<c:if test="${isNew}">
		<c:set var="titulo" value="Crear Candidato" scope="page"/>
		<c:set var="boton" value="Crear" scope="page"/>
	</c:if>
	
	<h1>${titulo}</h1>
	
	<!--  <div id="mydiv">  -->
	<form:form action="candidato/save" method="post" commandName="candidato" >

		<c:if test="${!isNew}">
		<form:label path="id" >id:</form:label> 
		<form:input path="id" readonly="true"/>  <!-- con readonly no se puede cambiar el valor solo leerlo -->
		<form:errors path="id" cssClass="error"/>
		</c:if>
		
		<br><br>
	
		<form:label path="nombre">Nombre:</form:label>
		<form:input path="nombre" placeholder="Minimo 3 letras"/>
		<form:errors path="nombre" cssClass="error"/>
		<br><br>
		
		<form:label path="dni">D.N.I.:</form:label>
		<form:input path="dni"  />
		<form:errors path="dni" cssClass="error"/>
		<br><br>
		
		<input type="submit" value="<c:out value="${boton}"/>" >	
		
	</form:form>
	<!-- </div> -->

<%@ include file="../includes/footer.jsp"%>