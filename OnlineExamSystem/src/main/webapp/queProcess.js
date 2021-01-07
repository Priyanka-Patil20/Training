$(function() {
$("#btnSubmit").show();
var currQuestion=1;
var currQue=document.getElementById(""+currQuestion);
currQue.style.display="block";
$('#btn.Next').on('click',function(){
 currQuestion++;
 var nextQue=document.getElementById(""+currQuestion);
 
 if(currQuestion === $(".qList").length){
 $("#btnNext").hide();
 $("#btnSubmit").show();
  }
  
  currQue.style.display="none";
  next.style.display="block";
  cueeQue=nextQue;
});
});