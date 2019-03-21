package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.BeanUtils;

import com.common.CustomAction;
import com.form.SearchForm;
import com.service.TaskService;
import com.vo.SearchVo;

public class SearchProcess extends CustomAction {
    
    private TaskService taskService;

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
	searchForm.getTaskList().clear();
	SearchVo searchVo = new SearchVo(); 
	BeanUtils.copyProperties(searchForm, searchVo);
	searchForm.setTaskList(taskService.getTaskBySearch(searchVo));	
        return mapping.findForward(FORWARD_DISPLAY);
    }
}
