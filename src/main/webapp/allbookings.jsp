<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>tecno-tab | home</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/welcome" class="navbar-brand">Tecno-Tab</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/login">Login</a></li>
					<li><a href="/register">New Registration</a></li>
					<li><a href="/show-users">All Users</a></li>
				</ul>
			</div>
		</div>
	</div>



<c:choose>
<c:when test="${mode=='bookings' }">
<div>
<div class="container" style="margin:50px">
    <div class="row text-center"><strong> User Details</strong></div>
    <div class="row" style="border:1px solid green;padding:10px">
        <div class="col-md-4 text-center"><strong>Id</strong></div>
        <div class="col-md-4 text-center"><strong>UserId</strong></div>
        <div class="col-md-4 text-center"><strong>Noofroomsbooked</strong></div>
         <div class="col-md-4 text-center"><strong>TotalPay</strong></div>
          <div class="col-md-4 text-center"><strong>Checkin</strong></div>
           <div class="col-md-4 text-center"><strong>Checkout</strong></div>
    </div>
        <c:forEach var="buser" items="${booking}">
            <div class="row" style="border:1px solid green;padding:10px">
            <div class="col-md-4 text-center">${buser.id}</div>
            <div class="col-md-4 text-center" >${buser.userid}</div>
                <div class="col-md-4 text-center">${buser.noofroomsbooked}</div>
                  <div class="col-md-4 text-center">${buser.totalpay}</div>
                    <div class="col-md-4 text-center">${buser.checkin}</div>
                      <div class="col-md-4 text-center">${buser.checkout}</div>
            </div>
        </c:forEach>

</div>
</div>
</c:when>
</c:choose>
</body>
</html>