<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Confirmation Page</title>
<style>
#button {
     line-height: 12px;
     padding:5px;
     width: 100px;
     font-size: 8pt;
     font-family: tahoma;
     margin-top: 1px;
     margin-right: 0px;
     position:absolute;
     top:0;
     right:0;
 }
 
 #menu {
     line-height: 12px;
     padding:5px;
     width: 100px;
     font-size: 8pt;
     font-family: tahoma;
     margin-top: 1px;
     margin-right: 120px;
     position:absolute;
     top:0;
     right:0;
 }
 
 #row{
 	background-color: #C1C1C1;
 	}
</style>
</head>
<body style="background-color: #EEE9BF">
<table border="1">
  	<tr style="background-color: #BDFCC9">
        <th width="120">Customer Id</th>
		<th width="120">Name</th>
		<th width="120">Phone</th>
	</tr>
    <tr>
       <td id="row">${customerId}</td>
       <td id="row">${name}</td>
       <td id="row">${phone}</td>
 	<td style="background-color: #5CACEE"><a href="deleteConfirm/${cust.cutomerId}">confirm</a></td>  
   </tr>

   </table>
    
    <form method="get" action="/insurance/homepage">
    	<button id="homepage" type="submit">HOME</button>
    </form>
 
</body>
</html>