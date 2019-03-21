package com.taglibs.forms;

import org.apache.struts.taglib.logic.CompareTagBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

/**
 * A conditional body block tag that allows for the content of the tag
 * to be printed if the readonly flag in session is the same as the value
 * of the tag attribute.
 *
 * <p>Title: OCP-SB</p>
 * <p>Description: Credit Processing for Small Business</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: CIBC</p>
 * @author Toby Steel
 * @version 1.0
 */

public class CustomReadonlyTag extends CompareTagBase
{
	/**
	 * Evaluate the condition that is being tested by this particular tag,
	 * and return <code>true</code> if the nested body content of this tag
	 * should be evaluated, or <code>false</code> if it should be skipped.
	 * The value attribute must be set to "false" for the readonly status of the
	 * tag to be false, any other input or the omission of the value attribute
	 * will set the readonly status to true. Once set, the value is compared to
	 * the readonly flag set in session. If the tag value is the same as the
	 * session flag, then the body of the tag is rendered, otherwise it is not.
	 *
	 * @exception JspException if a JSP exception occurs
	 */
	public boolean condition() throws JspException
	{
		HttpServletRequest request=(HttpServletRequest)pageContext.getRequest();
		boolean isRequestReadOnly =	TagUtils.GetReadOnly( request );
		boolean isTagReadOnly = true;

		String value = getValue();
		if ( value != null && value.equalsIgnoreCase("false") )
			isTagReadOnly = false;

		if ( isRequestReadOnly == isTagReadOnly )
		{
			return true;
		}
		else
			return false;
	}
}//EOC