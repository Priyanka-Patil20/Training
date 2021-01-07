<%@page import="com.vwits.model.*"%> 
<%@page import="java.util.List"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title></title>
<link rel="stylesheet" href="styles.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href= 
"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" /> 


<style>
.navbar-nav.navbar-center { 
            position: absolute; 
            left: 50%; 
            transform: translatex(-50%); 
        } 

.table-wrapper {
    width: 1100px;
    margin: 30px auto;
    background: #fff;
    padding: 20px;	
    box-shadow: 0 1px 1px rgba(0,0,0,.05);
}
.table-title {
    padding-bottom: 10px;
    margin: 0 0 10px;
}
.table-title h2 {
    margin: 6px 0 0;
    font-size: 22px;
}
.table-title .add-new {
    float: right;
    height: 30px;
    font-weight: bold;
    font-size: 12px;
    text-shadow: none;
    min-width: 100px;
    border-radius: 50px;
    line-height: 13px;
}
.table-title .add-new i {
    margin-right: 4px;
}
table.table {
    table-layout: fixed;
}
table.table tr th, table.table tr td {
    border-color: #e9e9e9;
}
table.table th i {
    font-size: 13px;
    margin: 0 5px;
    cursor: pointer;
}
table.table th:last-child {
    width: 100px;
}
table.table td a {
    cursor: pointer;
    display: inline-block;
    margin: 0 5px;
    min-width: 24px;
}    
table.table td a.add {
    color: #27C46B;
}
table.table td a.edit {
    color: #FFC107;
}
table.table td i.delete {
    color: #E34724;
}
table.table td i {
    font-size: 19px;
}
table.table td a.add i {
    font-size: 24px;
    margin-right: -1px;
    position: relative;
    top: 3px;
}    
table.table .form-control {
    height: 32px;
    line-height: 32px;
    box-shadow: none;
    border-radius: 2px;
}
table.table .form-control.error {
    border-color: #f50000;
}
table.table td .add {
    display: none;
}
</style>
<script>
$(document).ready(function(){
	$('[data-toggle="tooltip"]').tooltip();
	var actions = $("table td:last-child").html();
	
    
	
	// Delete row on delete button click
	$(document).on("click", ".delete", function(){
		
        $(this).parents("tr").remove();
		$(".add-new").removeAttr("disabled");
    });
});
</script>
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
                           href="#"> 
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
                          Delete User from list 
                          <span class="sr-only"> 
                            (current) 
                          </span> 
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
<div class="container-lg">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-8"><h2>User <b>Details</b></h2></div>
                    
                </div>
            </div>
            <table class="table table-bordered">
                <thead>
                
                    <tr>
                        <th>UserId</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Contact</th>
                        <th>Profile</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                <%
                String id="";
                String name="";
                String email="";
                int contact=0;
                String profile="";
                String status="";
                
                List<User> list = (List<User>) request.getAttribute("data"); 
     			if (list != null) { 
     				for (User u : list) { 
     					/*id=u.getUserid();
     					name=u.getName();
     					email=u.getEmail();
     					contact=u.getContact();
     					profile=u.getProfile();
     					status=u.getStatus();*/
                %>
                
                    <tr>
                        <td><%=u.getUserid()%><input name="tid" type="hidden" value="<%out.print(u.getUserid());%>"/></td>
                        <td><%=u.getName()%></td>
                        <td><%=u.getEmail()%></td>
                        <td><%=u.getContact()%></td>
                        <td><%=u.getProfile()%></td>
                        <td><%=u.getStatus()%></td>
                        <td>
                            
                            <input class="delete" type="button" class="greenbutton" name="delete" onclick="location.href='deleteuser?uid=<%=u.getUserid()%>'" value="Delete" style= "background: #f31404;color: #fff;font-size: 15px; height: 30px"/><i class="material-icons" >&#xE872;</i></a>
                        </td>
                    </tr>
                   
                    <%
     				}
     			}
                    %>
                </tbody>
            </table>
        </div>
    </div>
</div>     
</body>
</html>