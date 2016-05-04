<%-- 
    Document   : index
    Created on : May 4, 2016, 9:59:52 PM
    Author     : zOzDarKzOz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <spring:url value="/resources/image/thumb" var="thumb" />
        <spring:url value="/resources/image/icon" var="icon" />
        <spring:url value="/resources/js/jquery-2.1.4.min.js" var="jquery" />
        <spring:url value="/resources/js/script.js" var="script" />
        <spring:url value="/resources/js/html5.js" var="html5" />
        <spring:url value="/resources/js/bootstrap.min.js" var="bootstrapjs" />
        <spring:url value="/resources/js/slick.min.js" var="slick" />
    </head>
    <body>
        <form action="" method="post" id="test">
            <input type="submit">
            <textarea id="result"></textarea>
        </form>
        <script type="text/javascript" src="${jquery}"></script>
        <script type="text/javascript" src="${script}"></script>
        <script type="text/javascript" src="${html5}"></script>
        <script type="text/javascript" src="${bootstrapjs}"></script>
    </body>
</html>
