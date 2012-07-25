package com.taglibs.forms;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.struts.action.Action;
import org.apache.struts.taglib.html.TextareaTag;
import org.apache.struts.util.RequestUtils;
import org.apache.struts.util.ResponseUtils;

public class CustomTextareaTag extends TextareaTag implements Field {
    protected String required_;
    protected String maxLength_;

    protected String checkchange_;

    /**
     * The session attribute key for our locale.
     */

    public PageContext getPageContext() {
	return pageContext;
    }

    public void setRequired(String required) {
	required_ = required;
    }

    public String getRequired() {
	return required_;
    }

    public void setMaxlength(String maxLength) {
	maxLength_ = maxLength;
    }

    public String getMaxlength() {
	return maxLength_;
    }

    public String getCheckchange() {
	return checkchange_;
    }

    public void setCheckchange(String checkchange) {
	checkchange_ = checkchange;

    }

    public int doStartTag() throws JspException {
	if (TagUtils.IsReadOnly(this)) {
	    TagUtils.WriteParagraphs(this);
	    return SKIP_BODY;
	} else {
	    /*
	     * String title = RequestUtils.message(pageContext, null, locale,
	     * "Global.label.maximumLength", new Object[] { getMaxlength() });
	     * setTitle(title);
	     */
	    int ret = super.doStartTag();

	    // Create an appropriate "input" element based on our parameters

	    /* write out the maxlength message */
	    /*
	     * ResponseUtils.write(pageContext, "<br/>"); String message =
	     * RequestUtils.message(pageContext, null, locale,
	     * "Global.label.maximumLength", new Object[] { getMaxlength() });
	     * ResponseUtils.write(pageContext,message);
	     */
	    ResponseUtils.write(pageContext,
		    "<div style=\"visibility:hidden\" id=\"");
	    ResponseUtils.write(pageContext, getProperty() + "maxlen_i18n_msg");
	    ResponseUtils.write(pageContext, "\">");
	    /*
	     * String message = RequestUtils .message(pageContext, null, locale,
	     * "errors.maxlength.nofield", new Object[] { getMaxlength() });
	     * ResponseUtils.write(pageContext, message);
	     */
	    ResponseUtils.write(pageContext, "</div>");
	    // ResponseUtils.write(pageContext, "</TD></TR></TABLE>");
	    return ret;
	}
    }

    /**
     * Prepares the keyboard event handlers, appending them to the the given
     * StringBuffer.
     * 
     * @param handlers
     *            The StringBuffer that output will be appended to.
     */
    protected void prepareKeyEvents(StringBuffer handlers) {
	handlers.append(" onkeyup=\"textLimit(this,");
	handlers.append(getMaxlength());
	handlers.append(");\"");

	// Hariprashath[24-Sep-05] : To trim the text to the specified maxlength
	// when a huge content of text is dragged
	// and dropped in the text area.
	// Fix for KITS Bug Id : 39057
	handlers.append(" onfocus=\"textLimit(this,");
	handlers.append(getMaxlength());
	handlers.append(");\"");

	if ("true".equalsIgnoreCase(getCheckchange())) {
	    handlers.append(" onchange=\"setFormDataChanged(this.form)\"");
	}

	super.prepareKeyEvents(handlers);
    }
}
