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
        <form  method="POST" action="${contextPath}/browse" name="searchBody">
            <input name="place" type="text" class="form-control" placeholder="Place" autofocus="true" required/>
            <div class="margin20"></div>
            <input name="date" type="date" class="form-control" placeholder="Date" required/>
            <div class="margin20"></div>
            <input name="time" type="time" class="form-control" placeholder="Time" required/>
            <div class="margin20"></div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button class="btn btn-primary btn-block" type="submit">Search</button>

           <c:if test="${courts != null}">
            <div class="margin20"></div>
            <table class="table table-striped">
                <thead>
                   <tr>
                     <th scope="col">Court Id</th>
                     <th scope="col">Court Name</th>
                     <th scope="col">Court Type</th>
                     <th scope="col">Court Address</th>
                     <th scope="col">Open Time</th>
                     <th scope="col">Close Time</th>
                     <th scope="col">Court Fee</th>
                     <th scope="col">Additional Player Fee</th>
                     <th scope="col">Racket Fee</th>
                     <th scope="col">Action</th>
                   </tr>
                </thead>
                <tbody>
                <c:forEach items="${courts}" var="court">
                    <tr>
                        <td><c:out value="${court.id}"/></td>
                        <td><c:out value="${court.name}"/></td>
                        <td><c:out value="${court.type}"/></td>
                        <td><c:out value="${court.location}"/></td>
                        <td><c:out value="${court.openTime}"/></td>
                        <td><c:out value="${court.closeTime}"/></td>
                        <td><c:out value="${court.fee.courtRentalFee}"/></td>
                        <td><c:out value="${court.fee.additionalPlayerFee}"/></td>
                        <td><c:out value="${court.fee.racketRentalFee}"/></td>
                        <td><a href="${contextPath}/book?courtId=${court.id}&bookingDate=${bookingDate}">Book</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </c:if>
        </form>
    </c:if>
</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
