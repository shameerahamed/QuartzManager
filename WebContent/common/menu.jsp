<%@page import="com.utils.GlobalConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
	function gotoUrl(url,isMain) {		 
		if(isMain != 'false') {
			mainParam = '&'+ '<%=GlobalConstants.PARAM_WINDOW_NAME%>'+ '=' + '<%=GlobalConstants.GLOBAL_MAIN_WINDOW_NAME%>';
		} else {
			mainParam = "";
		}
		location.href = url+mainParam;
	}
</script>
</head>
<body  topmargin="0" leftmargin="0">
<table border="0" cellpadding="5" cellspacing="1" class="menu" width="100%">
	<tr>
		<td><input type="button" value="Home" class="menubtn" onclick="gotoUrl('Controller.do?method=todayTask','true')"/></td>
	</tr>
	<tr>
		<td>
			<input type="button" value="Immediate Action" class="menubtn" onclick="gotoUrl('Controller.do?method=alertTask','true')"/>
		</td>
	</tr>
	<tr>
		<td>
			<input type="button" value="Search" class="menubtn" onclick="gotoUrl('Controller.do?method=searchTask','true')"/>			
		</td>
	</tr> 
	<tr>
		<td>
			<input type="button" value="Add" class="menubtn" onclick="gotoUrl('Controller.do?method=addTask','true')"/>
		</td>
	</tr>
	<tr>
		<td>
			<input type="button" value="History" class="menubtn" onclick="gotoUrl('#','false')"/>
		</td>
	</tr>
	<tr>
		<td>
			<input type="button" value="Help" class="menubtn" onclick="gotoUrl('#','false')"/>			
		</td>
	</tr>
	<tr>
		<td>
			<input type="button" value="Logout" class="menubtn" onclick="gotoUrl('SignOff.do','false')"/>	
		</td>
	</tr>
</table>
</body>
</html>