package com.action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.common.CustomAction;

public class LogoutAction extends CustomAction{

    @Override
    public ActionForward _perform(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	 request.getSession().invalidate();
	 return mapping.findForward("logoff");
    }
    
}
