package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class Controller extends DispatchAction{
    public ActionForward addTask(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
	return mapping.findForward("addTask");
    }
    
    public ActionForward updateTask(ActionMapping mapping,ActionForm form,
	    HttpServletRequest request, HttpServletResponse response) {
	return mapping.findForward("updateTask");
    }
    
    public ActionForward searchTask(ActionMapping mapping,ActionForm form,
	    HttpServletRequest request, HttpServletResponse response) {
	return mapping.findForward("searchTask");
    }
    
   public ActionForward todayTask(ActionMapping mapping,ActionForm form,
	   HttpServletRequest request,HttpServletResponse response) {
       return mapping.findForward("home");
   }
   
   public ActionForward alertTask(ActionMapping mapping,ActionForm form,
	   HttpServletRequest request,HttpServletResponse response) {
       return mapping.findForward("alertTask");
   }
}
