package com.taglibs.forms;

import org.apache.struts.taglib.html.TextTag;
import org.apache.struts.util.ResponseUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

public class CustomTextTag extends TextTag implements Field {
    public PageContext getPageContext() {
	return pageContext;
    }

    protected String required_;

    public void setRequired(String required) {
	required_ = required;
    }

    public String getRequired() {
	return required_;
    }

    public int doStartTag() throws JspException {
	if (TagUtils.IsReadOnly(this)) {	    
	    ResponseUtils.write(pageContext, getDisplayValue());
	    return SKIP_BODY;
	} else {	    
	    int ret = super.doStartTag();
	    return ret;
	}
    }

    public String getDisplayValue() throws JspException {
	if (value != null) {
	    return ResponseUtils.filter(value);
	} else if (redisplay || !"password".equals(type)) {
	    return TagUtils.GetProperty(this);
	}
	return "";
    }
}
