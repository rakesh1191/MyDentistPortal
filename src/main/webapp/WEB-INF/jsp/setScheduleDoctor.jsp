<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
    td{
        cursor:pointer;
        background: -moz-linear-gradient(top, #ffffff, #D1E3E9);
        background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#ffffff), to(#D1E3E9));
        text-align:center;
    }
 
    td:hover{
        background: -moz-linear-gradient(top, #249ee4, #057cc0);
        background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#249ee4), to(#057cc0));
    }
 
    td:active
    {
        background: -moz-linear-gradient(top, #057cc0, #249ee4);
        background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#057cc0), to(#249ee4));
    }
 
    #result{
        font-weight:bold;
        font-size:16pt;
    }
</style>
<!--JAVASCRIPT -->
<script  src="http://code.jquery.com/jquery-1.9.1.min.js" ></script>     
<script type="text/javascript">  
var result;
$(document).ready(function(){
 	// Returns an array with values of the selected (checked) checkboxes in "frm"
    function getSelectedChbox(frm) {
      var selchbox = [];        // array that will store the value of selected checkboxes

      // gets all the input tags in frm, and their number
      var inpfields = frm.getElementsByTagName('input');
      var nr_inpfields = inpfields.length;

      // traverse the inpfields elements, and adds the value of selected (checked) checkbox in selchbox
      for(var i=0; i<nr_inpfields; i++) {
        if(inpfields[i].type == 'checkbox' && inpfields[i].checked == true) selchbox.push(inpfields[i].value);
      }
      result=selchbox;
      document.getElementById("rs").value =result;

      return selchbox;
    }
 	
    document.getElementById('btntest').onclick = function(){
    	  var selchb = getSelectedChbox(this.form);     // gets the array returned by getSelectedChbox()
    	  alert(selchb);
    	}
});
</script>
</head>
<body>
<form action="setScheduleDoctor.html" method="post">
<div id="result"> </div>
    <table id="myTable" border="1" style="border-collapse: collapse;" cellpadding="8">
        <!--1st ROW-->
       <tr>
       <th></th>
       <c:forEach items="${dates}" var="date">
        <th>${date}</th>
        </c:forEach>
        </tr>
        
        	<c:forEach items="${slots}" var="slot">
		        <tr>
		            <th>${slot}</th>
		            <c:forEach items="${dates}" var="date">
		            <td><input type="checkbox" name="chb[]" value="slot${slot} ${date}"><BR></td>		            
					 </c:forEach>
		        </tr>
        	</c:forEach>
       
       
    </table>
    
    <input type="hidden" id="rs" name="getindex" style="width: 500px">
   	<input type="hidden" name="userid" value="${userid}">
    <input type="submit" value="Click" id="btntest" />
    </form>
</body>
</html>