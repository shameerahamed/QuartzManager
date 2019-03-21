package com.common;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.taglibs.forms.TagUtils;
import com.utils.GlobalConstants;

abstract public class CustomAction extends DispatchAction implements
	Serializable, GlobalConstants {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	ActionForward forward = null;	

	request.setAttribute("currentActionForm", form);
	
	if (request.getParameter(PARAM_WINDOW_NAME) != null
		&& GLOBAL_MAIN_WINDOW_NAME.equals(request
			.getParameter(PARAM_WINDOW_NAME))) {
	    //removeAllForms(request,form.getClass().getName());
	   // removeAllForms(request);   
	}

	try {
	    if (!mapping.getPath().equals(SIGNON_PATH)
		    && !mapping.getPath().equals(SIGNOFF_PATH)
		    && !isLoggedIn(request)) {
		ActionErrors errors = new ActionErrors();
		errors.add(null, new ActionError("Global.error.sessionTimedOut"));
		saveErrors(request, errors);
		request.setAttribute("expired", "true");
		request.setAttribute("forceLogout", "true");
		return new ActionForward(SIGNOFF_PATH + ".do");
	    } else {		
		if (!mapping.getPath().equals(SIGNON_PATH)
			&& !mapping.getPath().equals(SIGNOFF_PATH)
			&& request.getParameter(ATTR_NAME_PROPAGATE_READ_ONLY) != null) {
		    TagUtils.setPropagateReadOnly(request, true);
		}

		if (!TagUtils.GetReadOnly(request) && request.getParameter(ATTR_NAME_PROPAGATE_READ_ONLY) != null) {
		    TagUtils.setReadOnly(request, true);
		}

		forward = dispatch(mapping, form, request, response);
	    }
	} catch (com.common.SignoffException signoff) {
	    resetToken(request);
	    ActionErrors errors = new ActionErrors();
	    errors.add(null, new ActionError("ERROR.LOGIN.UserSignon"));
	    saveErrors(request, errors);
	    request.setAttribute("forceLogout", "true");
	    return getSignOffPage(mapping, request, signoff);
	}
	return forward;
    }

    private ActionForward getSignOffPage(ActionMapping mapping,
	    HttpServletRequest request, com.common.SignoffException signoff) {
	request.getSession().invalidate();
	return mapping.findForward(FORWARD_LOGOFF);
    }

    protected ActionForward dispatch(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	String parameter = mapping.getParameter();

	ActionForward forward;
	if (parameter == null) {
	    return _perform(mapping, form, request, response);
	} else {
	    String name = request.getParameter(parameter);
	    forward = dispatchMethod(mapping, form, request, response, name);
	    if (forward == null) {
		return unspecified(mapping, form, request, response);
	    }
	}
	return forward;
    }

    @Override
    protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	return _perform(mapping, form, request, response);
    }

    protected ActionForward performDisplay(ActionMapping mapping,
	    ActionForm form, HttpServletRequest request,
	    HttpServletResponse response) throws Exception {
	return mapping.findForward(FORWARD_DISPLAY);
    }

    protected ActionForward getSignOffPage(ActionMapping mapping,
	    ActionForm form, HttpServletRequest request,
	    HttpServletResponse response) throws Exception {
	return mapping.findForward(FORWARD_LOGOFF);
    }

    public abstract ActionForward _perform(ActionMapping mapping,
	    ActionForm form, HttpServletRequest request,
	    HttpServletResponse response) throws Exception;

    public static boolean isLoggedIn(HttpServletRequest request)
	    throws Exception {
	// String userName = (String)
	// request.getSession().getAttribute("userName");
	// String userId = (String) request.getSession().getAttribute("userid");

	if (request.getSession().getAttribute("userid") != null
		&& request.getSession().getAttribute("userName") != null) {
	    return true;
	}
	return false;
    }

    public void removeAllForms(HttpServletRequest request, String currentForm)
	    throws Exception {
	java.util.Enumeration enumeration = request.getSession()
		.getAttributeNames();
	while (enumeration.hasMoreElements()) {
	    String element = (String) enumeration.nextElement();
	    if (element.endsWith("Form") && (!element.equals(currentForm)|| !element.endsWith(currentForm) )) {
		request.getSession().removeAttribute(element);
	    }
	}
    }

    public void removeAllForms(HttpServletRequest request) throws Exception {
	removeAllForms(request, "");
    }
}
