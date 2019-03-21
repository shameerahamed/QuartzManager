package com.taglibs.forms;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.struts.taglib.html.Constants;
import org.apache.struts.taglib.html.SelectTag;
import org.apache.struts.util.ResponseUtils;

public class CustomSelectTag extends SelectTag implements Field {
    protected String required_;
    protected String label_;
    protected String selectedValue_;
    protected String checkchange_;

    public PageContext getPageContext() {
	return pageContext;
    }

    public void setRequired(String required) {
	required_ = required;
    }

    public String getRequired() {
	return required_;
    }

    public String getCheckchange() {
	return checkchange_;
    }

    public void setCheckchange(String checkchange) {
	checkchange_ = checkchange;

    }

    public int doStartTag() throws JspException {
	/*
	 * Clear the values from the previous select tag.
	 */
	label_ = null;
	selectedValue_ = TagUtils.GetProperty(this, false);

	if (TagUtils.IsReadOnly(this)) {
	    /*
	     * Store the select tag in the page context so nested option and
	     * options tags can find it.
	     */	    
	    pageContext.setAttribute(Constants.SELECT_KEY, this);
	    return EVAL_BODY_BUFFERED;
	} else {	    
	    return super.doStartTag();
	}
    }

    public int doEndTag() throws JspException {
	if (!TagUtils.IsReadOnly(this)) {
	    int ret = super.doEndTag();
	    return ret;
	} else {
	    if (label_ != null) {
		ResponseUtils.write(pageContext, label_);
	    }

	    // Remove the page scope attributes we created
	    pageContext.removeAttribute(Constants.SELECT_KEY);
	}

	return EVAL_PAGE;
    }

    /**
     * Store the label associated with the selected option if it's value matches
     * the selected value. The label is used to render the display-mode version
     * of the tag.
     * 
     * @param value
     *            The value of the current option.
     * @param label
     *            The display label for the current option.
     */
    protected void addOption(String value, String label) {
	// Only store the label for read-only mode if the selected value is
	// not the null value. We usually don't want to display the label for
	// the null value which is usually like "Please select...".
	if (selectedValue_ != null
		&& !selectedValue_
			.equalsIgnoreCase(TagUtils.NULL_SELECT_VALUE)
		&& selectedValue_.equalsIgnoreCase(value)) {
	    label_ = label;
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
	if ("true".equalsIgnoreCase(getCheckchange())) {
	    handlers.append(" onchange=\"setFormDataChanged(this.form)\"");
	}

	super.prepareKeyEvents(handlers);
    }

    public void release() {
	required_ = null;
	label_ = null;
	selectedValue_ = null;
    }
}
