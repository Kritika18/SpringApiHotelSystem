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

	<c:choose>
		<c:when test="${mode=='MODE_HOME' }">
			<div class="container" id="homediv">
				<div class="jumbotron text-center">
					<h1>Welcome to Tecno-tab</h1>
					<h3>Subscribe my channel to support me</h3>
				</div>
			</div>

		</c:when>

		<c:when test="${mode=='MODE_REGISTER' }">
			<div class="container text-center">
				<h3>New Registration</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-user">
					<input type="hidden" name="id" value="${user.id }" />
					<div class="form-group">
						<label class="control-label col-md-3">Username</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="username"
								value="${user.username }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">First Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="firstname"
								value="${user.firstname }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Last Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="lastname"
								value="${user.lastname }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Age </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="age"
								value="${user.age }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="password"
								value="${user.password }" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Register" />
					</div>
				</form>
			</div>
		</c:when>
		<c:when test="${mode=='ALL_USERS' }">
		
		<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/welcome" class="navbar-brand">Tecno-Tab</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<!-- <li><a href="/login">Login Admin</a></li>
					<li><a href="/register">New Registration</a></li>  -->
					<li><a href="/show-users">All Users</a></li>
					<li><a href="/viewbookingreport">Viewreport</a></li>
					<li><a href="/logout">Login Out</a> 
				</ul>
			</div>
		</div>
	</div>
		
			<div class="container text-center" id="tasksDiv">
				<h3>All Users</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Roomtype</th>
								<th>No of rooms</th>
								<th>Rate</th>
								<th>Delete</th>
								<th>Edit</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${users }">
								<tr>
									<td>${user.id}</td>
									<td>${user.roomtype}</td>
									<td>${user.noofrooms}</td>
									<td>${user.rate}</td>
									<td><a href="/delete-user?id=${user.noofrooms }"><span
											class="glyphicon glyphicon-trash"></span></a></td>
									<td><a href="/edit-user?id=${user.noofrooms }"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>

<c:when test="${mode=='S_ROOM' }">
<div class="container" style="margin:50px">
    <div class="row text-center"><strong> User Details</strong></div>
    <div class="row" style="border:1px solid green;padding:10px">
    <table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>RoomTypeId</th>
								<th>roomNo</th>
								<th>rate</th>
								
							</tr>
						</thead>
        <tbody>
        <c:forEach var="buser" items="${sdate }">
								<tr>
									<td>${buser.id}</td>
									<td>${buser.roomtypeid}</td>
									<td>${buser.roomno}</td>
									<td>${buser.rate}</td>
								</tr>
							</c:forEach>
						</tbody>
                      </table>
            </div>
            </div>
</c:when>

<c:when test="${mode=='ALL_BOOKING' }">
<div class="container" style="margin:50px">
    <div class="row text-center"><strong> User Details</strong></div>
    <div class="row" style="border:1px solid green;padding:10px">
    <table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>UserId</th>
								<th>Noofroomsbooked</th>
								<th>TotalPayment</th>
								<th>Checkin</th>
								<th>CheckOut</th>
							</tr>
						</thead>
        <tbody>
        <c:forEach var="buser" items="${booking }">
								<tr>
									<td>${buser.id}</td>
									<td>${buser.userid}</td>
									<td>${buser.noofroomsbooked}</td>
									<td>${buser.totalpay}</td>
									<td>${buser.checkin}</td>
									<td>${buser.checkout}</td>
								</tr>
							</c:forEach>
						</tbody>
                      </table>
            </div>
            </div>
</c:when>

		<c:when test="${mode=='MODE_UPDATE' }">
			<div class="container text-center">
				<h3>Update User</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-user">
					<input type="hidden" name="id" value="${user.id }" />
					<div class="form-group">
						<label class="control-label col-md-3">Username</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="username"
								value="${user.username }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">First Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="firstname"
								value="${user.firstname }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Last Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="lastname"
								value="${user.lastname }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Age </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="age"
								value="${user.age }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="password"
								value="${user.password }" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Update" />
					</div>
				</form>
			</div>
		</c:when>

		<c:when test="${mode=='MODE_LOGIN' }">
		
		<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/welcome" class="navbar-brand">Tecno-Tab</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/login">Login Admin</a></li>
					<li><a href="/register">New Registration</a></li>
					<li><a href="/loginuser">Login User</a> 
				</ul>
			</div>
		</div>
	</div>
			<div class="container text-center">
				<h3>User Login</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="/login-admin">
					<c:if test="${not empty error }">
						<div class= "alert alert-danger">
							<c:out value="${error }"></c:out>
							</div>
					</c:if>
					<div class="form-group">
						<label class="control-label col-md-3">Username</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="username"
								 value="${user.email}" >
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="password"
								value="${user.password }" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Login" />
					</div>
					</form>
					</div>
					</c:when>
					
		<c:when test="${mode=='MODE_SETDATE' }">
		
		<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/welcome" class="navbar-brand">Tecno-Tab</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/login">Login Admin</a></li>
					<li><a href="/register">New Registration</a></li>
					<li><a href="/loginuser">Login User</a> 
				</ul>
			</div>
		</div>
	</div>
			<div class="container text-center">
				<h3>User Login</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="/searchroom">
					
					<div class="form-group">
						<label class="control-label col-md-3">Checkin</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="checkin"
								 value="${booked.checkin}" >
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Checkout</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="checkout"
								value="${booked.checkout }" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Check" />
					</div>
					</form>
					</div>
					</c:when>
	</c:choose>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>