<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Insurance</title>
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
<body style="background-color: #f7adca">
<table border="1">
  	<tr style="background-color: #BDFCC9">
  	    <th width="120">Customer Id</th>
    	<th width="120">Customer Name</th>
    	<th width="120">Customer Address</th>
    	<th width="120">Customer Phone</th>
    	<th width="120">Customer DOB</th> 
        <th width="120">Insurance id</th> 
   	</tr>
 <c:forEach var="cust" items="${cust}" varStatus="status">
    <tr>
       <td id="row">${cust.customerId}</td>
       <td id="row">${cust.name}</td>
       <td id="row">${cust.address}</td>
       <td id="row">${cust.phone}</td>
       <td id="row">${cust.dob}</td>
       <td id="row">${cust.insurance}</td>
       <td style="background-color: #5CACEE"><a href="viewcustomer/${cust.customerId}">view</a></td> 
 	  <td style="background-color: #5CACEE"><a href="edit/${cust.customerId}">edit</a></td>
	  <td style="background-color: #F08080"><a href="delete/${cust.customerId}">delete</a></td>
   </tr>
</c:forEach>
</table>
    <br>
    <br>
    <br>
    <form method="get" action="sortInsuranceByDateOfIssuance">
    	<button id="sortInsuranceByDateOfIssuance" type="submit">sort by Date of Issuance</button>
    </form>
    <br>
    <br>
    <br>
    <form method="get" action="sortInsuranceByDateOfExpiry">
    	<button id="sortInsuranceByDateOfExpiry" type="submit">sort by Date of Expiry</button>
    	</form>
    <br>
    <br>
    <br>
    <form method="get" action="addnew">
    	<button id="addnew" type="submit">Add new Insurance</button>
    </form>
     <br>
    <br>
    <br>
    <br>
  	<form method="get" action="allcustomers">
    	<button id="allcustomers" type="submit">Customer Table</button>
    </form>
</body>
</html>