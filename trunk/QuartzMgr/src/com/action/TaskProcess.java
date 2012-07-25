package com.action;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.common.CustomAction;
import com.form.TaskForm;
import com.service.TaskService;
import com.utils.DateUtils;

public class TaskProcess extends CustomAction {    
   
    Logger log = Logger.getLogger("TaskProcess");
    private TaskService taskService;

    public TaskService getTaskService() {
	return taskService;
    }

    public void setTaskService(TaskService taskService) {
	this.taskService = taskService;
    }
    
    public ActionForward addTask(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	TaskForm taskForm = (TaskForm) form;	
	log.info("taskForm " + taskForm.getActStartDttm());	
	taskService.insertTask(taskForm);	
	return mapping.findForward(FORWARD_DISPLAY);
    }
    
    public ActionForward updateTask(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {	
	TaskForm taskForm = (TaskForm) form;
	
	if(taskForm.getExpEndDttm()!=null && !taskForm.getExpEndDttm().isEmpty()) {
		// calculate dev dttm
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(com.utils.DateUtils.textToDate(taskForm.getExpEndDttm()));
		Long dev_dttm = System.currentTimeMillis() - cal.getTimeInMillis();
		
		if(TimeUnit.MILLISECONDS.toMinutes(dev_dttm) > 0) {
		    taskForm.setIsDeviated(1);
		    taskForm.setDevDttm(dev_dttm.toString());
		}
	}
	taskService.updateTask(taskForm);	
	return mapping.findForward(FORWARD_DISPLAY);
    }

    @Override
    public ActionForward _perform(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {	
	return performDisplay(mapping, form, request, response);
    }
}
