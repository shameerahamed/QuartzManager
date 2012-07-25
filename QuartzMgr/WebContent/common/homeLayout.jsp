<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-tiles"
	prefix="tiles"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:getAsString name="title" ignore="true" />
</title>
<link href="css/styles.css" type="text/css" rel="stylesheet" />
</head>
<body topmargin="0" leftmargin="0">
	<table border="0" cellpadding="2" cellspacing="0" align="center"
		width="100%">
		<tr>
			<td colspan="3" height="20%">
					<tiles:insert attribute="header" ignore="true"></tiles:insert>						
			</td>
		</tr>
		<tr>
			<td width="10%" height="650" valign="top" class="menu">
				<tiles:insert attribute="menu" />
			</td>
			<td height="650" valign="top">
				<div class="menusplit"></div>				
			</td>
			<td valign="top">
				<tiles:insert attribute="body" />
			</td>
		</tr>		
		<tr>
			<td colspan="3" height="10%"><tiles:insert attribute="footer" />
			</td>
		</tr>
	</table>
</body>
</html>