<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Insurance</title>
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
 
   html, body {
    height: 100%;
  }
  #tableContainer-1 {
    height: 100%;
    width: 100%;
    display: table;
  }
  #tableContainer-2 {
    vertical-align: middle;
    display: table-cell;
    height: 100%;
  }
  #myTable {
    margin: 0 auto;
  }
</style>
</head>
<h3>Enter Insurance Details</h3>
<body style="background-color: #f7adca">
	  <div id="tableContainer-1">
  	    <div id="tableContainer-2">
          <form method="post" action="addInsurance">
             <center>
               <table id="myTable" border="1" width="30%" cellpadding="3" style="background-color: #ECE5B6;" WIDTH="30%">
             		
                    <tr>
                        <td> Insurance code : </td><td><input name="insurancecode"  /> </td> 
                    </tr>
                    <tr>
                        <td> Insurance type : </td><td><input name="type"  /> </td> 
                    </tr>
                    <tr>
                        <td> Date of Issuance : </td><td> <input type="date" name="dateofIssuance" /> </td> 
                    </tr>
                    <tr>
                        <td> Date of Renewal : </td><td> <input type="date"  name="dateofRenewal" /> </td> 
                    </tr>
                     <tr>
                        <td> Date of Expiry : </td><td> <input type="date" name="dateofExpiry" /> </td> 
                    </tr>
                    <tr>
                        <td> Customer Id : </td><td><input name="customer.customerId"  /> </td> 
                    </tr>
                    
                    <tr>
                      <td colspan="2" align="center"><input type="submit" value="Add" /></td>
                    </tr>
              </table>
            </center>
        </form>
        <form method="get" action="homepage">
   			 <button id="button" type="submit">Home</button>
		</form>
</body>
</html>