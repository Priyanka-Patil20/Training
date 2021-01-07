<%@page import="com.vwits.model.*"%> 
<%@page import="java.util.List"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="styles.css"> 
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href= 
"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
          integrity= 
"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous" /> 
  
    <link rel="stylesheet" type="text/css" href= 
"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" /> 
    <link rel="stylesheet" href= 
"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" /> 
   
</head>
<body>
 


    <div class="register">
    <h1 align="center" style="color: white">Add Question</h1>
<form class="form" action="insertquestion" method="post"> 
		<label>SrNo</label>
		
 		<input type="number" name="txtid" required="required" >
 		<label>Question</label>
 		<input type="text" name="txtque"  required="required">
 		
 		<label>Option1</label>
 		 <input type="text" name="txtopt1"  required="required">
 		
 		<label>Option2</label><br>
 		 <input type="text" name="txtopt2"  required="required">
 		
 		<label>Option3</label> <br>
 		<input type="text" name="txtopt3"  required="required">
 		
 		<label>Option4</label> <br>
 		<input type="text" name="txtopt4"  required="required" > 
 		
 		<label>Correct Answer</label><br> <input type="text" name="txtcorrect"  required="required" > 
 		
 		<label>Marks</label><br>
 		<input type="number" name="txtmarks"  required="required" ><br>
 		
 		<input type="submit" value="Add Question"/> 
 		
 	</form> 
 	
 	<br><br>
 	
</div>
</body>
</html>