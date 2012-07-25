<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles" %>   
<h2>Search Task</h2>
<html:form action="SearchProcess.do">
<table>
  <tr>
  	<td>Task Name</td>
  	<td><html:text property="taskName"/>
  	<td>Date</td>
  	<td><html:text property="taskDate"/>
  </tr>
  <tr>
  	<td>Status</td>
  	<td><html:text property="status"/>
  	<td>Priority</td>
  	<td><html:text property="priority" value=""/></td>
  </tr>
  <tr>
  	<td colspan="2"><html:submit property="Search" value="Search"/></td>
  	<td colspan="2"><html:button property="Clear" value="Clear" onclick="clearForm()"/></td>
  </tr> 	
</table>
<br/>
</html:form>

<h3>Search Result</h3>
<tiles:insert page="/pages/dashboard.jsp"></tiles:insert>
<script type="text/javascript">
	function clearForm() {
		var form = document.searchForm;
		searchForm.taskName.value = "";
		searchForm.taskDate.value = "";
		searchForm.status.value = "";
		searchForm.priority.value = "";
	}
</script>

<%-- <tiles:insert definition="mainLayout" flush="true">
	<tiles:put name="title" value="Dashboard" />
	<tiles:put name="body" value="/pages/dashboard.jsp" />	
</tiles:insert> --%>