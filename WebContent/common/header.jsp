<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>
	<link href="css/styles.css" type="text/css" rel="stylesheet"/>
<!-- 	<link REL="SHORTCUT ICON" HREF="images/favicon.ico"> -->
	<link type="text/css" href="css/theme/jquery.ui.all.css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="js/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="js/ui/jquery.ui.widget.js"></script>
<!-- 	<script type="text/javascript" src="../js/ui/jquery.ui.datepicker.js"></script> -->
	<script type="text/javascript" src="js/ui/jquery-ui-1.8.2.custom.js"></script>
	<script type="text/javascript" src="js/ui/jquery-ui-timepicker-addon.js"></script>
	<script type="text/javascript" src="js/ui/jquery-ui-sliderAccess.js"></script>

<!-- 	<link type="text/css" href="../css/demos.css" rel="stylesheet" /> -->
</head>			
<body>
	<!-- Otherwise -->
	<table width="100%" class="header">
		<tr>
			<td><h2>Quartz Manager</h2></td>
			<td align="right">Welcome, <%=session.getAttribute("userName")%></td>
		</tr>
		<tr>
			<td colspan="2"><%=new java.util.Date() %></td>
		</tr>
	</table>
	<hr> 	
</body>
</html>