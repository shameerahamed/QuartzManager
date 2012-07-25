<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">    
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<script src="../js/functions.js" type="text/javascript"></script>
<link href="../css/styles.css" type="text/css" rel="stylesheet">
<link type="text/css" href="../css/jquery/jquery.ui.all.css" rel="stylesheet">
<script type="text/javascript" src="../css/jquery/jquery-1.4.2.js"></script>
<script type="text/javascript" src="../css/jquery/jquery.ui.core.js"></script>
<script type="text/javascript" src="../css/jquery/jquery.ui.widget.js"></script>
<script type="text/javascript" src="../css/jquery/jquery.ui.datepicker.js"></script>
<link type="text/css" href="../css/demos.css" rel="stylesheet">
</head>
<body style="font-size:11px;">
<p align="right" style="display:none"><a href="http://localhost:8090/TaskSheet/index.jsp?logout=true">Log Out</a></p>
<center>
<h3>Quartz Manager</h3>
</center>
<center style="display:none">

	<font color="red" size="3"><html:errors/></font>

<br></center>
<table cellpadding="5" cellspacing="5" border="0" align="center" width="300px" style="border:1px solid #1075EF">
	<html:form action="/LoginProcess.do">
	<tbody><tr>
		<td width="50%">Username</td>
		<td><html:text property="username"/></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><html:password property="password"/></td>
	</tr>	
	<tr>
		<td colspan="2" align="center">
			<html:button styleClass="btn" property="Login" value="Login" onclick="submitForm();"/>
		</td>
	</tr>
</tbody>
</html:form>
</table>
<br><br><br><br><br><br>
<hr>
<div align="center">
	© Copyright 2012. All rights reserved. For internal use only.<br>
    Quartz Manager built on Apr-2012<br>
</div>
</body>
<script>
	function submitForm() {
		document.forms[0].action = "LoginProcess.do?method=authenticateUser";
		document.forms[0].submit();
		return true;
	}
</script>
</html>