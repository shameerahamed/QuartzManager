package com.taglibs.forms;

import javax.servlet.jsp.JspException;

import org.apache.struts.taglib.html.OptionTag;

public class CustomOptionTag extends OptionTag {


    public int doEndTag() throws JspException {
	/*
	 * Find the select tag which wraps this option tag.
	 */
	CustomSelectTag selectTag = (CustomSelectTag) findAncestorWithClass(
		this, CustomSelectTag.class);

	if (selectTag == null) {
	    throw new JspException("Option tags must be wrapped inside a "
		    + "select tag, property = " + getValue());
	}

	/*
	 * If the select tag is read-only then don't render any content for the
	 * option but pass the label to the select tag so it can render the
	 * selected value.
	 */
	if (TagUtils.IsReadOnly(selectTag)) {
	    selectTag.addOption(getValue(), text());
	    return EVAL_PAGE;
	} else {
	    return super.doEndTag();
	}
    }
}
