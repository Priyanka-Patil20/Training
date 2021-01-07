
<%@page import="java.util.List"%> 
<%@page import="com.vwits.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles.css">
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link href="dist/css/bootstrap.min.css" rel="stylesheet">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<!-- Custom styles for this template -->
<link href="dist/css/dashboard.css" rel="stylesheet">
<script src="https://unpkg.com/feather-icons"></script>
  <script> 
        //set minutes
      
        var mins = 2; 
  
        //calculate the seconds 
        var secs = mins * 60; 
  
        //countdown function is evoked when page is loaded 
        function countdown() { 
            setTimeout('Decrement()', 60); 
        } 
  
        //Decrement function decrement the value. 
        function Decrement() { 
            if (document.getElementById) { 
                minutes = document.getElementById("minutes"); 
                seconds = document.getElementById("seconds"); 
  
                //if less than a minute remaining 
                //Display only seconds value. 
                if (seconds < 59) { 
                    seconds.value = secs; 
                } 
  
                //Display both minutes and seconds 
                //getminutes and getseconds is used to 
                //get minutes and seconds 
                else { 
                    minutes.value = getminutes(); 
                    seconds.value = getseconds(); 
                } 
                //when less than a minute remaining 
                //colour of the minutes and seconds 
                //changes to red 
                if (mins < 1) { 
                    minutes.style.color = "red"; 
                    seconds.style.color = "red"; 
                } 
                //if seconds becomes zero, 
                //then page alert time up 
                if (mins < 0) { 
                    alert('time up');
                  
                    minutes.value = 0; 
                    seconds.value = 0; 
                    document.getElementById("Exam").submit();
                    
                } 
                //if seconds > 0 then seconds is decremented 
                else { 
                    secs--; 
                    setTimeout('Decrement()', 1000); 
                } 
            } 
        } 
  
        function getminutes() { 
            //minutes is seconds divided by 60, rounded down 
            mins = Math.floor(secs / 60); 
            return mins; 
        } 
  
        function getseconds() { 
            //take minutes remaining (as seconds) away  
            //from total seconds remaining 
            return secs - Math.round(mins * 60); 
        } 
    </script> 
<title>Insert title here</title>
</head>
<body onload="countdown();">
<%
		List<TestPaper> questionBank = (List<TestPaper>) request.getAttribute("data");
	
		request.setAttribute("questionBank", questionBank) ;
        int count =1; 
	%>

<div id="wrapper">
  <div id="container">
    <div align="right" ><input id="button" type="button" value="Logout" onClick="location.href='redirect?url=Login.jsp' " style= "background: #f31404;color: #fff;font-size: 15px; height: 30px" ></div>
  </div>
</div>
<div> 
       <label style="color:white">Time Left :: </label> 
        <input id="minutes" type="text" style="width: 15px; 
             border: none; font-size: 16px;  
            font-weight: bold; color: black;"><font size="6"> : 
                        </font> 
        <input id="seconds" type="text" style="width: 25px; 
                        border: none; font-size: 16px; 
                        font-weight: bold; color: black;"> 
    </div> 
<form id="Exam" action="result" method="get">
<div align="center">
<h2 style="color:white"><%=request.getAttribute("name")%> Test</h2>


<div class="quiz-container">
<%
			int count1=1;
			int radioname=0;
          List<TestPaper> list = (List<TestPaper>) request.getAttribute("data"); 
          			if (list != null) { 
          				for (TestPaper t : list) { 
          					%>
          					
           					<div class="form-group" style="color:white; left:58%;">
                                        <label><%=count1%>.&nbsp;&nbsp;<%=t.getQue() %> Marks:<%=t.getMarks() %></label>
                                              </div>
             
                                              <div class="radio" style="color:white" >
                                                    <input type="radio" value="a" name="<%=radioname%>">&nbsp;<%=t.getOpt1()%>
                                              </div>
             
                                              <div class="radio" style="color:white">
                                                    <input  type="radio" value="b" name="<%=radioname%>">&nbsp;<%=t.getOpt2()%>
                                              </div>
             
                                              <div class="radio" style="color:white">
                                                    <input type="radio" value="c" name="<%=radioname%>">&nbsp;<%=t.getOpt3()%>
                                              </div>
             
                                              <div class="radio" style="color:white">
                                                    <input type="radio" value="d" name="<%=radioname%>">&nbsp;<%=t.getOpt4()%>
                                              </div>
                                                                  
                                                              
                                                           
                                              <%
                                                           radioname++;
                                              count1++;    
                                                          
                                                           }
                                              %>
                                              
                                              <br>
                                              <br>
                                             
                                                    <input style= "background: #f31404;color: #fff;font-size: 15px; height: 40px" align=center type="submit" value="Submit Exam" class="btn btn-primary">
                                                    
                                              
           <% 
           				} 
           			
				
          			
          %>
          </div>
          
         
          
</div>

</form>
</body>
</html>