<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="${locale}">
<head>
	<meta charset="utf-8">
	<title>${pageContext.request.contextPath}/</title>
	<base href="${pageContext.request.contextPath}/"></base>
	
	<link href="<c:url value="/resources/css/styles.css?v=1.0" />" rel="stylesheet">
	
</head>
<body>