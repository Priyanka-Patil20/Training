<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="styles.css">

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
                           href="AdminMain.jsp"> 
                          Home  
                          <span class="sr-only"> 
                            (current) 
                          </span> 
                      </a> 
                    </li> 
                    <li class="nav-item"> 
                        <a class="nav-link" 
                           href="UserRegister.jsp"> 
                          Register User
                        </a> 
                    </li> 
                    <li class="nav-item"> 
                        <a class="nav-link" 
                           href="getDeleteList"> 
                          Details of User 
                        </a> 
                    </li> 
                    <li class="nav-item"> 
                        <a class="nav-link" 
                            href="getUpdateList"> 
                           Approval of User
                        </a> 
                    </li> 
                </ul> 
                <ul class="navbar-nav ml-auto"> 
                    <li class="nav-item"> 
                        <input id="button" type="button" value="Logout" onClick="location.href='redirect?url=AdminLogin.jsp' " style= "background: #f31404;color: #fff;font-size: 15px; height: 30px" >
                    </li> 
                </ul>
            
            </div> 
        </div> 
    </nav> 

    <div class="reg"><h1>User Registration</h1></div>
    <div class="register">
        <form class="form" action="adminregistration" method="post">
        	<br>
        	<br>
        	
            <label>User Id :</label>
            <input type="text" name="id" placeholder="Enter your Id"/><br/>

            <label>Name :</label>
            <input type="text" name="username" placeholder="Enter your Name"/><br/>

            <label>Password :</label>
            <input type="password" id="pass" name="pass" placeholder="Enter your Password"/><br/>
            <label>Email :</label>
            <input type="text" name="email" placeholder="Enter your Email"/><br/>
            <label>Contact Number :</label>
            <input type="text" name="contact" placeholder="Enter your Contact No"/><br/>
            <label>Profile :</label>
            <input type="text" name="profile" placeholder="Enter Profile Student/Faculty"/><br/>
            <label>Status :</label>
            <input type="text" name="status" placeholder="Enter Status active/unactive"/><br/>

            <input type="submit" value="Register"/>



        </form>
		

<p style=color:red> ${data}</p>


    </div>
    </body>
    </html>