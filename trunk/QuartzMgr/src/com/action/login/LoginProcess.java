package com.action.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import com.common.CustomAction;
import com.form.LoginForm;
import com.service.UserService;

public class LoginProcess extends CustomAction {
    private Logger logger = Logger.getLogger("LoginProcess");
    private UserService userService;

    public LoginProcess(UserService userService) {
	super();
	this.userService = userService; 
    }
    
    @Override
    public ActionForward _perform(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {        
        return performDisplay(mapping, form, request, response);
    }

    public ActionForward authenticateUser(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	logger.info("AuthenticateUser");
	String target = "success";
	LoginForm loginForm = (LoginForm) form;	 
	//UserVo userVo = new UserVo();
	//BeanUtils.copyProperties(loginForm, userVo);
	userService.getuser(loginForm);	
	if(loginForm.getUserId() > 0) {
	    request.getSession().setAttribute("userName", loginForm.getUsername());
	    request.getSession().setAttribute("userid", loginForm.getUserId());
	    logger.info("User Authenticated");
	    loginForm = null;
	    target = "SUCCESS";
	} else {
	    logger.info("Authentication Failed");
	    target = "FAILURE";
	    ActionErrors  errors = new ActionErrors();	    
	    errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.invalid","UserName / Password"));
	    saveErrors(request, errors);
	}
	return mapping.findForward(target);
    }

}
