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
        <form method="POST" action="${contextPath}/confirmPayment">
            <h2 class="form-heading">Your total is: ${booking.price}</h2>
            <input name="bookingName" type="text" class="form-control" placeholder="Name on Card" required/>
            <input name="bookingNumber" type="number" class="form-control" placeholder="Card Number" autofocus="true"
                pattern="^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\d{3})\d{11})$" required/>
            <input name="expiry" type="text" class="form-control" placeholder="Expiry in MM/YY format"
                pattern="^(0[1-9]|1[0-2])\/?([0-9]{4}|[0-9]{2})$"/>
            <input name="cvv" type="password" class="form-control" placeholder="CVV" length="3" pattern="[0-9]{3}"/>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="hidden" name="bookingId" value="${booking.id}"/>

            <button class="btn btn-primary btn-block" type="submit">Pay</button>
        </form>
    </c:if>
</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
