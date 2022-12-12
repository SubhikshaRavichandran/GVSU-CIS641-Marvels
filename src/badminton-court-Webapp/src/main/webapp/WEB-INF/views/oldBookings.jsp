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
           <c:if test="${bookings != null}">
            <div class="margin20"></div>
            <table class="table table-striped">
                <thead>
                   <tr>
                     <th scope="col">Booking Id</th>
                     <th scope="col">Court Name</th>
                     <th scope="col">Booking Date</th>
                     <th scope="col">Price</th>
                   </tr>
                </thead>
                <tbody>
                <c:forEach items="${bookings}" var="booking">
                    <tr>
                        <td><c:out value="${booking.id}"/></td>
                        <td><c:out value="${booking.court.name}"/></td>
                        <td><c:out value="${booking.bookingDate}"/></td>
                        <td><c:out value="${booking.price}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </c:if>

    </c:if>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
