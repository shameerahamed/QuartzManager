package com.taglibs.forms;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.struts.taglib.html.TextTag;
import org.apache.struts.util.ResponseUtils;

public class DateTag extends CustomTextTag {

    protected Boolean editable_ = Boolean.TRUE;

    public Boolean getEditable() {
	return editable_;
    }

    public void setEditable(Boolean editable) {
	this.editable_ = editable;
    }

    public PageContext getPageContext() {
	return pageContext;
    }

    public DateTag() {
	editable_ = Boolean.FALSE;
    }

    public void setPageContext(PageContext context) {
	pageContext = context;
    }

    @Override
    public int doStartTag() throws JspException {
	setSize("18");
	setMaxlength("18");
	int ret = super.doStartTag();

	if (!TagUtils.IsReadOnly(this) && !getReadonly()) {
	    StringBuffer jcalen = new StringBuffer();
	    jcalen.append("$(function(){")
		    // .append("alert('test');")
		    .append("$('#<div_id>').datetimepicker({")
		    .append("showOn: 'button',")
		    .append("buttonImage: 'images/calendar.gif',")
		    .append("buttonImageOnly: true,")
		    .append("showButtonPanel: false,")
		    .append("timeFormat: 'hh:mm',")
		    .append("dateFormat: 'yy-mm-dd'").append("});")
		    .append(" });");

	    if (getStyleId() == null) {
		setStyleId(getProperty());
	    }
	    ResponseUtils.write(pageContext, "<script>");
	    ResponseUtils.write(pageContext,
		    jcalen.toString().replaceAll("<div_id>", getStyleId()));
	    ResponseUtils.write(pageContext, "</script>");
	}

	return ret;
    }

    /*
     * $('#exp_startdttm').datetimepicker({ showOn: "button", buttonImage:
     * "images/calendar.gif", buttonImageOnly: true, timeFormat: 'hh:mm',
     * dateFormat: 'yy-mm-dd' });
     */

    public void release() {
	required_ = null;
	editable_ = Boolean.FALSE;
	setValue(null);
    }
}
