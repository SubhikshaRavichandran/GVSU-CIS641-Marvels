<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>home</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<nav class="navbar navbar-dark bg-primary">
    <span class="navbar-brand mb-0 h1">Badminton Court App</span>
    <form class="form-inline" id="logoutForm" method="POST" action="${contextPath}/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Logout</button>
    </form>
</nav>
<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h4>Provide some additional information:</h4>
        <form  method="POST" action="${contextPath}/payment" name="searchBody">
            <span>Number of players:</span>
            <input name="playerCount" type="number" class="form-control" value=1 placeholder="Number of players" autofocus="true"/>
            <div class="margin20"></div>

            <span>Number of extra rackets:</span>
            <input name="racketCount" type="number" class="form-control" value=1 placeholder="Number of rackets" />

            <div class="margin20"></div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <input type="hidden" name="courtId" value="${courtId}"/>

            <input type="hidden" name="userName" value="${pageContext.request.userPrincipal.name}"/>

            <input type="hidden" name="bookingDate" value="${bookingDate}"/>

            <button class="btn btn-primary btn-block" type="submit">Proceed to Payment</button>
        </form>
    </c:if>
</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
