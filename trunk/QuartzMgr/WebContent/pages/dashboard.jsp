<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-logic"
	prefix="logic"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles" %>
<table width="100%" border="0" cellspacing="1" cellpadding="4">
  <tr class="tbl_header">
  	<th>S.No</th>
    <th>Task Name</th>
    <th>Start Dttm</th>
    <th>End Dttm</th>
    <th>Status</th>
    <th>Priority</th>
    <th>Action</th>    
  </tr>
  <logic:iterate id="taskList" name="searchForm" property="taskList"
	type="com.vo.TaskVo" indexId="idx">
		<logic:equal name="taskList" property="isDeviated" value="1">
			<tr class="task_dev">
		</logic:equal>
		<logic:notEqual name="taskList" property="isDeviated" value="1">
			<logic:equal name="taskList" property="status" value="Open">
				<tr class="task_open">
			</logic:equal>
			<logic:equal name="taskList" property="status" value="In Progress">
				<tr class="task_inprog">
			</logic:equal>
			<logic:equal name="taskList" property="status" value="On Hold">
				<tr class="task_onhold">
			</logic:equal>
			<logic:equal name="taskList" property="status" value="Completed">
				<tr class="task_completed">
			</logic:equal>
		</logic:notEqual>
				<td align="center"><%=(idx+1)%></td>
				<td><bean:write name="taskList" property="taskName"/> </td>
				<td><bean:write name="taskList" property="expStartDttm"/> </td>
				<td><bean:write name="taskList" property="expEndDttm"/> </td>
				<td><bean:write name="taskList" property="status"/> </td>
				<td><bean:write name="taskList" property="priority"/></td>
				<td align="center">
					<input type="button" class="edit" value=""
						alt="edit?<bean:write name="taskList" property="taskId"/>"
						onclick="location.href='Controller.do?method=updateTask&taskid=<bean:write name="taskList" property="taskId"/>'">
						&nbsp;
						<input type="button" class="view" value=""
						alt="edit?<bean:write name="taskList" property="taskId"/>"
						onclick="location.href='Controller.do?method=updateTask&taskid=<bean:write name="taskList" property="taskId"/>&<%=com.utils.GlobalConstants.ATTR_NAME_READ_ONLY%>=true'">
						&nbsp;
						<input type="button" class="delete" value="" alt="delete?<bean:write name="taskList" property="taskId"/>"
							onclick="deleteTask('<bean:write name="taskList" property="taskId"/>')">
		</td>
		</tr>
   </logic:iterate>
</table>
<br/>
<table width="100%" cellspacing="1" bgcolor="#000000">
	<tbody>
		<tr>
			<td class="task_open" width="20%">Open</td>
			<td class="task_inprog" width="20%">InProgress</td>
			<td class="task_onhold" width="20%">OnHold</td>
			<td class="task_completed" width="20%">Completed</td>
			<td class="task_dev" width="20%">deviated</td>
		</tr>
	</tbody>
</table>
<script type="text/javascript">
<!--
function deleteTask(id) {
	if(confirm('Are you sure, to delete this task ?')) {
		
	}
}
//-->
</script>

