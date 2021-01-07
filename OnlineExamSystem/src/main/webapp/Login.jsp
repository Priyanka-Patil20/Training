<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
        <link rel="stylesheet" href="styles.css">

</head>
<body>
    <div class="loginbox">
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTvFNvC-X487SmqDBXHlmgzc9lfScRlvX4eKQ&usqp=CAU" class="avatar">

        <h1>User Login</h1>

    <form action="userlogin" method="post" >

                <p>UserName</p>
                <input type="text" name="userid" placeholder="Enter Username"/>
                <p>Password</p>
                <input type="password" id="pass1" name="pass" placeholder="Enter Password"/>

      

 

        <input type="submit" value="login"/>

        <input type="button" value="Register" onclick="location.href='redirect?url=Registration.jsp'" />

        </form>
        <br>
        <p style=color:red> ${data}</p>
        
	
    </div>
    

</body>

</html>
