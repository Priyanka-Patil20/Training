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
<div class="reg"><h1>Admin Registration</h1></div>
    <div class="register">
<form class="form" action="doadminregistration" method="post">
<br>
            <br>
            <label>Id :</label>
            <input type="text" name="id" placeholder="Enter your ID"/>

            <label>Name :</label>
            <input type="text" name="username" placeholder="Enter your Name"/>

            <label>Password :</label>
            <input type="password" id="pass" name="pass" placeholder="Enter your Password"/>
            <label>Email :</label>
            <input type="text" name="email" placeholder="Enter your Email" />
            <label>Contact Number :</label>
            <input type="text" name="contact" placeholder="Enter your Contact No" />

            <input type="submit" value="Register"/>

</form>
</div>
</body>
</html>