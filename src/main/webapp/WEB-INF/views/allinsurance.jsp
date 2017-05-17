<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Insurance</title>
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
  	    <th width="120">Insurance Id</th>
    	<th width="120">Insurance code</th>
    	<th width="120">Insurance type</th>
    	<th width="120">Date of Issuance</th>
    	<th width="120">Date of Renewal</th>
    	<th width="120">Date of Expiry</th>
    	<th width="120">Customer Id</th>   
    	<th width="120">Customer Name</th>
    	<th width="120">Customer Address</th> 
    	<th width="120">Customer Phone</th>   	  		
   	</tr>
 <c:forEach var="allinsurance" items="${allinsurance}" varStatus="status">
    <tr>
       <td id="row">${allinsurance.insuranceid}</td>
       <td id="row">${allinsurance.insurancecode}</td>
       <td id="row">${allinsurance.type}</td>
       <td id="row">${allinsurance.dateofIssuance}</td>
       <td id="row">${allinsurance.dateofRenewal}</td>
       <td id="row">${allinsurance.dateofExpiry}</td>
       <td id="row">${allinsurance.customer.customerId}</td>
       <td id="row">${allinsurance.customer.name}</td>
       <td id="row">${allinsurance.customer.address}</td>
       <td id="row">${allinsurance.customer.phone}</td>
<%--        <td style="background-color: #5CACEE"><a href="viewcustomer/${allinsurance.insurancecode}">view</a></td> 
 --%> 	
   <td style="background-color: #5CACEE"><a href="editins/${allinsurance.insuranceid}">edit</a></td>
	  <td style="background-color: #F08080"><a href="deleteinsurance/${allinsurance.insuranceid}">delete</a></td>
   </tr>
</c:forEach>
</table>
    <br>
    <br>
    <br>
    <br>
    <form method="get" action="sortInsuranceByDateOfIssuance">
    	<button id="sortInsuranceByDateOfIssuance" type="submit">sort by Date of Issuance</button>
    </form>
    <br>
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