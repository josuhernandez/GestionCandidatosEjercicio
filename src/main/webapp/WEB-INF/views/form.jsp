<%@ include file="includes/header.jsp"%>


<body>
	<!-- Enlace para volver al listado -->
	<a href="../listado"> &lt; &lt;Volver Listado Candidatos</a>
	<br>
	
	<form:form action="listado" method="post" commandName="candidato/detalle">

	
		<form:label path="id" >id:</form:label> 
		<form:input path="id" readonly="true"/>  <!-- con readonly no se puede cambiar el valor solo leerlo -->
		<form:errors path="id" cssClass="error"/>
		
	<br><br>
	
	<form:label path="nombre">Descripción:</form:label>
	<form:input path="nombre" placeholder="Minimo 3 letras"/>
	<form:errors path="nombre" cssClass="error"/>
	<br><br>
	
	<form:label path="dni">Precio:</form:label>
	<form:input path="dni"/>
	<form:errors path="dni" cssClass="error"/>
	<br><br>
	
	<input type="submit" value="boton" >	
	
</form:form>

<%@ include file="includes/footer.jsp"%>