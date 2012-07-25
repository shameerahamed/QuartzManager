<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%> 
<%@taglib uri="/WEB-INF/tld/app-taglib.tld" prefix="form"%> 
 <script type="text/javascript">
<!--
/*  function timepicker(divId) {
	 divId = document.getElementById(divId);
	 $(function(divId){
		 $(divId).datetimepicker({
				showOn: "button",
				buttonImage: "../images/calendar.gif",
				buttonImageOnly: true,
				timeFormat: 'hh:mm'
		});
	 });
 } */
 
 /*$(function(){

	 $('#exp_startdttm').datetimepicker({
			showOn: "button",
			buttonImage: "images/calendar.gif",
			buttonImageOnly: true,
			timeFormat: 'hh:mm',
			dateFormat: 'yy-mm-dd'
	});

	$('#exp_enddttm').datetimepicker({
			showOn: "button",
			buttonImage: "images/calendar.gif",
			buttonImageOnly: true,
			timeFormat: 'hh:mm',
			dateFormat: 'yy-mm-dd'
	});

	$('#act_startdttm').datetimepicker({
			showOn: "button",
			buttonImage: "images/calendar.gif",
			buttonImageOnly: true,
			timeFormat: 'hh:mm',
			dateFormat: 'yy-mm-dd'
	});

	$('#act_enddttm').datetimepicker({
			showOn: "button",
			buttonImage: "images/calendar.gif",
			buttonImageOnly: true,
			timeFormat: 'hh:mm',
			dateFormat: 'yy-mm-dd'
	});

	$('#dev_dttm').datetimepicker({
			showOn: "button",
			buttonImage: "images/calendar.gif",
			buttonImageOnly: true,
			timeFormat: 'hh:mm',
			dateFormat: 'yy-mm-dd'
	}); 
 }); */
 //-->
 </script>
	<html:form action="/TaskProcess.do">
	<span class="mand">
	<html:errors/>
	</span>
	<table border="0" cellspacing="0" cellpadding="0" width="80%">		
		<tr>
			<td colspan="3">
					<fieldset>
					    <legend>Task</legend>
							<table border="0" cellspacing="0" cellpadding="0" width="80%">
								<tr>
									<td>
										<table border="0" cellspacing="0" cellpadding="5" width="45%">
											<tr>
												<td>Task</td>
												<td><form:text property="taskName"/></td>
											</tr>
											<tr>
												<td>Description</td>
												<td><form:textarea property="taskDesc" cols="30" maxlength="250"/></td>
										</table>
									</td>
									<td>
										<form:readOnly value="false">
											<table border="0" cellspacing="0" cellpadding="5" width="45%">
												<tr>
													<td>
														<logic:equal name="taskForm" property="taskId" value="0">
															<html:button property="ADD" value="ADD" onclick="actionSubmit('addTask');"/>&nbsp;&nbsp;
														</logic:equal>
														<logic:notEqual name="taskForm" property="taskId" value="0">
															<html:button property="UPDATE" value="UPDATE" onclick="actionSubmit('updateTask');"/>
														</logic:notEqual>
													</td>
												</tr>
												<tr>
													<td><html:button property="CANCEL" value="CANCEL"/></td>
												</tr>
		 									</table>
	 									</form:readOnly>
									</td>
								</tr>
							</table>

							
					</fieldset>
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td>
					<fieldset>
					    <legend>Expected</legend>
							<table border="0" cellspacing="0" cellpadding="5" >
								<tr>
									<td>Start DTTM</td>
									<td>
										<form:date property="expStartDttm" styleId="expStartDttm"></form:date>									
									</td>
								</tr>
								<tr>
									<td>End DTTM</td>
									<td>
										<form:date property="expEndDttm" styleId="expEndDttm"></form:date>										
									</td>
							</table>
					</fieldset>			
			</td>
			<td>&nbsp;</td>
			<td>
					<fieldset>
					    <legend>Actual</legend>
							<table border="0" cellspacing="0" cellpadding="5">
								<tr>
									<td>Start DTTM</td>
									<td><form:date property="actStartDttm" styleId="actStartDttm"></form:date></td>									
								</tr>
								<tr>
									<td>End DTTM</td>
									<td><form:date property="actEndDttm" styleId="actEndDttm"></form:date></td>
							</table>
					</fieldset>
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="3">
					<fieldset>
					    <legend>Status</legend>
							<table border="0" cellspacing="0" cellpadding="5">
								<tr>
									<td>Priority</td>
									<td>
										<form:select property="priority">											
											<form:option value="1">1</form:option>
											<form:option value="2">2</form:option>
											<form:option value="3">3</form:option>
											<form:option value="4">4</form:option>
											<form:option value="5">5</form:option>
										</form:select>
									</td>
									<td>&nbsp;</td>
									<td>% Complete</td>
									<td>
										<form:text property="completePer" style="width:30px;"></form:text>
									</td>
								</tr>
								<tr>
									<td>Status</td>
									<td>
										<form:select property="statusCode" onchange="changeDate(this)">
											<form:option value="1">Open</form:option>
											<form:option value="2">InProgress</form:option>
											<form:option value="3">OnHold</form:option>
											<form:option value="4">Completed</form:option>
										</form:select>
									</td>
									<td>&nbsp;</td>
									<td>Status Comment</td>
									<td>
										<form:textarea property="statComment" rows="2" maxlength="200"/>
									</td>
							</table>
					</fieldset>
			</td>
		</tr>		
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
		<logic:notEqual name="taskForm" property="taskId" value="0">
			<logic:equal name="taskForm" property="isDeviated" value="1">
				<tr>
					<td colspan="3">
							<fieldset>
							    <legend>Deviation </legend>
									<table border="0" cellspacing="0" cellpadding="5">
										<tr>
											<td>Deviation DTTM</td>
											<td>
												<bean:write name="taskForm" property="displayDevDttm"/>												
											</td>
										</tr>
										<tr>
											<td>Reason</td>
											<td>
												<form:textarea property="devReason" maxlength="200"></form:textarea>
											</td>
									</table>
							</fieldset>
					</td>
				</tr>
				<tr>
					<td colspan="3">&nbsp;</td>
				</tr>
			</logic:equal>
		<tr>
			<td colspan="3">
				<fieldset>
				    <legend>Log</legend>
					<table border="0" cellspacing="1" cellpadding="0" width="80%" class="tbl">
						<tr class="tbl_header">
							<th width="10%">S.No</th>
							<th width="25%">DTTM</th>							
							<th  width="25%">Status</th>
							<th>Comments</th>
						</tr>
						<logic:iterate id="taskLog" property="logList" type="com.vo.TaskLogVo" 
											name="taskForm" indexId="idx">
							<tr class="dataTableRowWhite">
								<td align="center"><%=(idx+1) %></td>
								<td><bean:write name="taskLog" property="date" /> </td>
								<td><bean:write name="taskLog" property="status" /></td>
								<td><bean:write name="taskLog" property="statComment"/></td>
							</tr>
						</logic:iterate>
					</table>
				</fieldset>
			</td>
		</tr>
		</logic:notEqual>
	</table>
	</html:form>
<script type="text/javascript">
<!--
	
	function changeDate(elem) {
		form = document.taskForm;
		value = parseInt(elem.value);
		//alert(value);	
		switch (value) {
			case 1:				
				form.actStartDttm.value = "";
				form.actEndDttm.value = "";
				form.completePer.value = "0";
				break;
			case 2:	
				if (form.actStartDttm.value.length == 0) {
					form.actStartDttm.value = $.datepicker.formatDate('yy-mm-dd @',
							new Date());
				}
				break;
			case 3:				
				form.actEndDttm.value = "";
				break;
			case 4:				
				if (form.actStartDttm.value.length > 0) {
					form.actEndDttm.value = $.datepicker.formatDate('yy-mm-dd @',
							new Date());
					form.completePer.value = '100';
				} else {
					alert('Task Not yet Started');
					elem.value = '1';
				}
				break;
		}
	}
	
	function actionSubmit(target) {
		document.taskForm.action = 'TaskProcess.do?method='+target;
		document.taskForm.submit();
	}
//-->
</script>	