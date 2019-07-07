<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="wade.SuggestSchedule"%>
<%@page import="wade.ScheduleBean"%>
<%@page import="wade.Schedule"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set target="${pageContext.request}"
         property="characterEncoding" value="UTF-8"/>

<!DOCTYPE html>
<jsp:useBean id="kuma" class="wade.ScheduleBean"/>

	<html>
		<head>
		 <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
			<meta charset="UTF-8">
			<title>登入頁面</title>
		</head>
	<body>
		
			
			<h1>Day 1</h1>
			<c:forEach var="kk"  items="${locationList}">
				
					<button type="button" class="btn btn-light">
  						${kk.locationName}</button>
  					<button type="button" class="btn btn-danger">Delete</button>
					
					
		</c:forEach>
		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#locationName" role="button">Add Location</button>
		
		
		<form method = 'post' action = "changeschedulelist">
		<div class="modal fade" id="locationName" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
    			<div class="modal-content">
      				<div class="modal-header">
        				<h5 class="modal-title" id="exampleModalLabel">Change Location</h5>
        				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          					<span aria-hidden="true">&times;</span>
        				</button>
      				</div>
      					<div class="modal-body">
         					<ul class="list-group">
         						<c:forEach var="kk" items="${kuma.schedules}">
  									<li class="list-group-item"><div class="radio">
  									<label>
  									
  									<input type="radio" name="optradio" checked value="${kk.locationName}">${kk.locationName}
  									
  									</label>
									</div></li>
								</c:forEach>
							</ul>
						</div>
      				<div class="modal-footer">
        				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        				<input type ='submit'>
        				<input class="btn btn-primary" type="submit" value="Save changes">
      				</div>
    			</div>
  			</div>
		</div>
		</form>
		
	</body>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</html>