package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.common.CustomAction;
import com.form.LoginForm;
import com.form.TaskForm;
import com.service.TaskService;
import com.utils.DateUtils;

public class TaskDisplay extends CustomAction {
    
    private TaskService taskService;

    public TaskService getTaskService() {
	return taskService;
    }

    public void setTaskService(TaskService taskService) {
	this.taskService = taskService;
    } 

    public ActionForward addTask(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response) {	
	TaskForm taskForm = (TaskForm) form;
	taskForm.resetForm(mapping, request);
	Integer userid = null;
	if (request.getSession().getAttribute("userid") != null) {
	    userid = (Integer) request.getSession().getAttribute("userid");
	}
	taskForm.setUserId(userid);
	//Set the Current date
	taskForm.setExpStartDttm(DateUtils.getDate());
	return mapping.findForward(FORWARD_ADD);
    }

    public ActionForward updateTask(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response) {		
	TaskForm taskForm = (TaskForm) form;
	int taskId;
	if(request.getParameter("taskid")!=null) {
	    taskId = Integer.parseInt(request.getParameter("taskid"));
	    taskService.populateTask(taskId, taskForm);
	}	
	return mapping.findForward(FORWARD_UPDATE);
    }

    @Override
    public ActionForward _perform(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {	
	return performDisplay(mapping, form, request, response);
    }
}
