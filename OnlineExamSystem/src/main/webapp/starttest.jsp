<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="container">
    <div align="right" ><input id="button" type="button" value="Logout" onClick="location.href='redirect?url=Login.jsp' " style= "background: #f31404;color: #fff;font-size: 15px; height: 30px" ></div>
  </div>
<div>
<h5 style="color: #fff;font-size: 25px" align="center">Instructions</h5>
<p style="color: #fff;font-size: 25px">1. The examination will comprise of Objective type Multiple Choice Questions (MCQs).<br>
2. All questions are compulsory and each carries One mark.<br>
3. The total number of questions, duration of examination, will be different based on the course, the detail is available on your screen.<br>
4. The Subjects or topics covered in the exam will be as per the Syllabus.<br>
5. There will be NO NEGATIVE MARKING for the wrong answers.</p>

</div>
<div id="container">
    <div align="center" ><input id="button" type="button" value="Start Test" onClick="location.href='Test?eid=<%=request.getAttribute("data") %>' " style= "background: #f31404;color: #fff;font-size: 15px; height: 30px" ></div>
  </div>
</body>
</html>