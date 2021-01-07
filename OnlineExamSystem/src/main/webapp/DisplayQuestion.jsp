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
    <style> 
        .navbar-nav.navbar-center { 
            position: absolute; 
            left: 50%; 
            transform: translatex(-50%); 
        }
        .table-wrapper {
    width: 800px;
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
table.table td a.delete {
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
</head>
<body>
  
<div class="container-lg">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-8"><h2>Question Bank <b>Details</b></h2></div>
                    
                </div>
            <table class="table table-bordered">
                <thead>
                
                    <tr>
                        <th>SrNo</th>
                        <th>Question</th>
                        <th>Option 1</th>
                        <th>Option 2</th>
                        <th>Option 3</th>
                        <th>Option 4</th>
                        <th>Correct Answer</th>
                        <th>Marks</th>
                        
                    </tr>
                </thead>
                <tbody>
                <%
                
                List<TestPaper> list = (List<TestPaper>) request.getAttribute("data"); 
     			if (list != null) {
     				int count=1;
     				for (TestPaper e : list) { 
     					
                %>
                
                    <tr>
                        <td><%=count%></td>
                        <td><%=e.getQue()%></td>
                       
                        <td><%=e.getOpt1()%></td>
                        <td><%=e.getOpt2()%></td>
                        <td><%=e.getOpt3()%></td>
                        <td><%=e.getOpt4()%></td>
                        <td><%=e.getAns()%></td>
                        <td><%=e.getMarks()%></td>
                    </tr>
                   
                    <%
                    count++;
     				}
     			}
                    %>
                </tbody>
            </table>
         </div>
    </div>
</div>  
<div align="center">
<button  type="button" onclick="location.href='displayexam'" style= "background: #f31404;color: #fff;font-size: 15px; height: 30px">Back</button>
</div>   

 	
</body>
</html>