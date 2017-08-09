<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Block Application</title>

<style>
	body {
	  background: url("/docs/images/demo_bg8.jpg");
	  background-size: 100%;
	  background-repeat: no-repeat;
	}
	textarea{
		text-align:left;
	}
</style>

</head>
<body>

	<h1 style="color:red;"> Block Chain Prototype </h1>
	<br>
	<form name="inarea" action="blockServlet" method="post">
	<fieldset>
	<legend> <B> <p style="font-size: 160%"> Transaction Data: </p> 
	         </B> </legend>
	<div name="div_block_input">
	<B>Enter Data Input </B>
	<br> 
	<textarea name="block_input" rows="4" cols="50"> </textarea><br> <br>
	<input type="submit" value="Submit"> <br>
	</div>
	</fieldset>
	</form>
	
	
	
	<fieldset>
	<legend> <B> <p style="font-size: 160%"; "color: red;"> Display Blocks Information: </p>
	         </B> </legend>
	<div name="div_refresh">
	<p>
	<B>Blocks </B>
	<br>
	<c:forEach items="${list}" var="l">
	
	<textarea rows="4" cols="50">
	
	Index Value:${l.index}, Data:${l.data}, Hash:${l.hash}, Previous Hash:${l.previousHash}, Timestamp:${l.timestamp}
	
	</textarea>
	
	<!-- ><div style="border:1px solid #000">
		<p>Index Value : ${l.index}</p>
		<p>Data : ${l.index}</p>
		<p>Hash : ${l.hash}</p>
		<p>Previous Hash : ${l.previousHash}</p>
		<p>Timestamp : ${l.timestamp}</p>
		
	</div><br><br><br> -->
	
	</c:forEach>
	<input type="submit" value="Refresh"> <br>
	</fieldset>
	
	</p>
	</div>

</body>
</html>