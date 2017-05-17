<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Customer</title>
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
<body style="background-color: #C1FFC1">

  <h3>Enter Customer Details For Updation</h3>
	  <div id="tableContainer-1">
  	  	<div id="tableContainer-2">
          <form method="post" action="/insurance/updateCustomer">
             <center>
                <table d="myTable" border="1" width="30%" cellpadding="3" style="background-color: #ECE5B6;" WIDTH="30%">
             		<tr>
                        <td> Customer ID : </td><td> ${customerId} </td> 
                    </tr>
                    <tr>
                        <td> New Customer Name : </td><td> <input name="name" placeholder="${name}"/> </td> 
                    </tr>
                   <tr>
                        <td> New Customer Address : </td><td> <input name="address" placeholder="${address}"/> </td> 
                    </tr>
                    <tr>
                        <td> New Customer Phone : </td><td> <input name="phone" placeholder="${phone}"/> </td> 
                    </tr>
                   <tr>
                        <td> New Customer DOB : </td><td> <input name="dob" placeholder="${dob}"/> </td> 
                    </tr>
                    <tr>
                      <td colspan="2" align="center"><input type="submit" value="UPDATE" /></td>
                    </tr>
                </table>
              </center>
            </form>
          </div>
        </div>
        <form method="get" action="/insurance/homepage">
    		<button id="button" type="submit">HOME</button>
		</form>
</body>
</html>