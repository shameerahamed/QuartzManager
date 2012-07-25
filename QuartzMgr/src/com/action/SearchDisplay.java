package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.common.CustomAction;
import com.form.SearchForm;
import com.service.TaskService;

public class SearchDisplay extends CustomAction{
    
    private TaskService taskService;
    Integer userId;

    public TaskService getTaskService() {
	return taskService;
    }

    public void setTaskService(TaskService taskService) {
	this.taskService = taskService;
    }    
    
    @Override
    public ActionForward _perform(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
	SearchForm searchForm = (SearchForm) form;
	if(searchForm.getTaskList()!=null) {
	    searchForm.getTaskList().clear();
	}
        return performDisplay(mapping, form, request, response);
    }
    
    public ActionForward getTodayTask(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	SearchForm searchForm = (SearchForm) form;	
	setUserId(request);
	
	if(searchForm.getTaskList()!=null) {
	    searchForm.getTaskList().clear();
	}
	searchForm.setTaskList(taskService.getTodayTask(userId));	
	return mapping.findForward("todayTask") ;
    }
    
    public ActionForward getTaskBySearch(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	SearchForm searchForm = (SearchForm) form;	
	setUserId(request);
	searchForm.setUserId(userId);
	if(searchForm.getTaskList()!=null) {
	    searchForm.getTaskList().clear();
	}
	searchForm.setTaskList(taskService.getTodayTask(userId));
        return mapping.findForward("searchTask");
    }
    
   public ActionForward getAlertTask(ActionMapping mapping, ActionForm form,
	   HttpServletRequest request,HttpServletResponse response) {
       SearchForm searchForm = (SearchForm) form;
       setUserId(request);  
       if(searchForm.getTaskList()!=null) {
	    searchForm.getTaskList().clear();
	}
       searchForm.setTaskList(taskService.getTodayTask(userId));
       searchForm.setTaskList(taskService.getAlertTask(userId));       
       return mapping.findForward("alertTask");
   }
   
   public void setUserId(HttpServletRequest request) {
       if (request.getSession().getAttribute("userid") != null) {
	    userId = (Integer) request.getSession().getAttribute("userid");
	}
   }
}
