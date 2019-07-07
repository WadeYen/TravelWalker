<%@page import="wade.Schedule"%>
<%@page import="wade.ScheduleBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set target="${pageContext.request}"
         property="characterEncoding" value="UTF-8"/>
<!DOCTYPE html>
<jsp:useBean id="kuma" class="wade.ScheduleBean" scope="application"/>
<html>
	<head>
		 <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
		<meta charset="UTF-8">
		<title>建議行程</title>
	</head>
	<body>
		<h1>Test Result</h1>
		
<%
			String t = new Schedule().getCountry();
		%>
		
		<h3><%=t%></h3>
		 
		<p>45622</p>
<!--  
		<table border="1" class= "table">
			<thead>
				<tr>
					<th class ="1">Location Name</th>
					<th>Country</th>
					<th>City</th>
					<th>Type</th>
					<th>Time</th>
				</tr>
			</thead>
			
			<c:set target="${kuma}" property="schedule[0]" value="${kuma.initschedules } "></c:set>
			<c:forEach var="kk" items="${schedules}">
				<tr>
					<td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
  						${kk.locationName}</button></td>
					<td>${kk.country}</td>
					<td>${kk.city}</td>
					<td>${kk.type}</td>
					<td>${kk.time}</td>
				</tr>
		</c:forEach>
		</table>
		
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
    			<div class="modal-content">
      				<div class="modal-header">
        				<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          					<span aria-hidden="true">&times;</span>
        				</button>
      				</div>
      					<div class="modal-body">
         					<ul class="list-group">
         						<c:forEach var="kk" items="${kuma.schedules}">
  									<li class="list-group-item"><div class="radio">
  									<label><input type="radio" name="optradio" checked>${kk.locationName}</label>
									</div></li>
								</c:forEach>
							</ul>
						</div>
      				<div class="modal-footer">
        				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        				<button type="button" class="btn btn-primary">Save changes</button>
      				</div>
    			</div>
  			</div>
		</div>
		
		<!-- Modal -->

		
		
<!--  
		<table border="1">
				<tr>
					<th>第一天</th><th>第二天</th><th>第三天</th>
				</tr>
				<tr>
				<td width="200px">
					<form   onsubmit="return removeDummy(); ">
						<a id="dummy">道頓崛</a><input type="submit" value="Delete" id="dummy"/>
					</form><br>
				<br></td><td><p>${list.country }</p></td><td>梅田</td>
				</tr>
		</table>
-->
		
	</body>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
	<script>
		
		
		function removeDummy () {
			var elem = document.getElementById('dummy');
			elem.parentNode.removeChild(elem);
			return false;
		}
	
	</script>
</html>