<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Customers</title>
<style type="text/css">

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
    	<th width="120">Customer Name</th>
    	<th width="120">Customer Address</th>
    	<th width="120">Customer Phone</th>
    	<th width="120">Customer DOB</th>
   	</tr>
 <c:forEach var="allcustomers" items="${allcustomers}" varStatus="status">
    <tr>
       <td id="row">${allcustomers.customerId}</td>
       <td id="row">${allcustomers.name}</td>
       <td id="row">${allcustomers.address}</td>
       <td id="row">${allcustomers.phone}</td>
       <td id="row">${allcustomers.dob}</td>
       <td style="background-color: #5CACEE"><a href="viewinsurance/${allcustomers.customerId}">view</a></td> 
 	  <td style="background-color: #5CACEE"><a href="edit/${allcustomers.customerId}">edit</a></td>
	  <td style="background-color: #F08080"><a href="delete/${allcustomers.customerId}">delete</a></td>
     
   </tr>
</c:forEach>
</table>
    <br>
    <br>
    <br>
    <br>
    <form method="get" action="sortCustomerByName">
    	<button id="sortCustomerByName" type="submit">Sort By Name</button>
    </form>
    <br>
    <br>
    <form method="get" action="add">
    	<button id="add" type="submit">Add new Customer</button>
    </form>
     <br>
    <br>
    <br>
    <br>
  	<form method="get" action="allinsurance">
    	<button id="allinsurance" type="submit">Insurance Table</button>
    </form>
</body>
</html>