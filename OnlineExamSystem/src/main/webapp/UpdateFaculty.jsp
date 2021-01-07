<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles.css">
 <link rel="stylesheet" href="styles.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href= 
"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
          integrity= 
"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous" /> 
  
    <link rel="stylesheet" type="text/css" href= 
"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" /> 
    <link rel="stylesheet" href= 
"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" /> 
    <style> 
        .navbar-nav.navbar-center { 
            position: absolute; 
            left: 50%; 
            transform: translatex(-50%); 
        } 
        </style>
</head>
<body>
<!--NAVBAR STARTING-->
    <nav class="navbar navbar-expand-sm navbar-light bg-light"> 
        <div class="container"> 
            <a class="navbar-brand text-success" href="#"> 
              Online Exam System
            </a> 
            <button class="navbar-toggler" type="button" 
                    data-toggle="collapse"
                    data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent"
                    aria-expanded="false" 
                    aria-label="Toggle navigation"> 
                <span class="navbar-toggler-icon"></span> 
            </button> 
  
            <div class="collapse navbar-collapse" 
                 id="navbarSupportedContent"> 
                <ul class=" nav navbar-nav navbar-center"> 
                    <li class="nav-item active"> 
                        <a class="nav-link" 
                           href="FacultyInfo.jsp"> 
                          Home  
                         <span class="sr-only"> 
                            (current) 
                          </span>
                      </a> 
                    </li> 
                    <li class="nav-item"> 
                        <a class="nav-link" 
                           href="getupdateFaculty"> 
                          Update Faculty
                            
                        </a> 
                    </li> 
                    <li class="nav-item"> 
                        <a class="nav-link" 
                           href="displayexam"> 
                          Create Question Paper
                        </a> 
                    </li> 
                    <li class="nav-item"> 
                        <a class="nav-link" 
                            href="#"> 
                           Delete Questions
                        </a> 
                    </li> 
                    <li class="nav-item"> 
                        <a class="nav-link" 
                            href="viewresult"> 
                          View Result
                        </a> 
                    </li> 
                </ul> 
                <ul class="navbar-nav ml-auto"> 
                    <li class="nav-item"> 
                        <input id="button" type="button" value="Logout" onClick="location.href='redirect?url=Login.jsp' " style= "background: #f31404;color: #fff;font-size: 15px; height: 30px" >
                    </li> 
                </ul>
            
            </div> 
        </div> 
    </nav>
<div class="reg"><h1>Update Faculty details</h1></div>
    <div class="register">
<form class="form" action="updatefaculty" method="post">
<br>
            <br>
            <br>
            <label>Id :</label>
            <input type="text" name="id" value="${id}" />

            <label>Faculty Name :</label>
            <input type="text" name="username" value="${name}" />

            <label>Password :</label>
            <input type="password" id="pass" name="pass" value="${pass}"/>
            <label>Email :</label>
            <input type="text" name="email" value="${email}" />
            <label>Contact Number :</label>
            <input type="text" name="contact" value="${con}" />

            <input type="submit" value="Register"/>

</form>
</div>
</body>
</html>