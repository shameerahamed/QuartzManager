package com.taglibs.forms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import org.apache.struts.util.RequestUtils;
import org.apache.struts.util.ResponseUtils;

import com.utils.GlobalConstants;

public class TagUtils implements Serializable, GlobalConstants {

    public static final String NULL_SELECT_VALUE = "NULL_VALUE";

    public static void setReadOnly(HttpServletRequest request, boolean value) {
	request.setAttribute(ATTR_NAME_READ_ONLY, new Boolean(value));
    }

    public static void setPropagateReadOnly(HttpServletRequest request,
	    boolean value) {
	request.setAttribute(ATTR_NAME_PROPAGATE_READ_ONLY, new Boolean(value));
	// Setting the read only attribute in order to make the Current Page
	// read only.
	setReadOnly(request, value);
    }

    public static boolean GetPropagateReadOnly(HttpServletRequest request) {
	Boolean propagateReadOnly = (Boolean) request
		.getAttribute(ATTR_NAME_PROPAGATE_READ_ONLY);

	if (propagateReadOnly == null
		&& request.getParameter(ATTR_NAME_PROPAGATE_READ_ONLY) != null) {
	    propagateReadOnly = new Boolean(
		    request.getParameter(ATTR_NAME_PROPAGATE_READ_ONLY));
	}

	if (propagateReadOnly != null && propagateReadOnly.booleanValue()) {
	    return true;
	}
	return false;
    }

    public static boolean GetReadOnly(HttpServletRequest request) {

	boolean hasParamOverride = (request
		.getParameter(ATTR_NAME_READ_ONLY_OVERRIDE) != null ? true
		: false);

	if (hasParamOverride) {
	    return false;
	}

	boolean hasParam = (request.getParameter(ATTR_NAME_READ_ONLY) != null ? true
		: false);

	if (hasParam) {
	    return true;
	}

	// check request attribute first as it may override request parameter.
	Boolean value = (Boolean) request.getAttribute(ATTR_NAME_READ_ONLY);

	if (value != null) {
	    return value.booleanValue();
	}

	return false;
    }

    /**
     * Determins if the field is read only. Doesn't really do anything but
     * leaves a place-holder to insert a global read-only flag.
     * 
     * @return Returns true if the field should be displayed read-only.
     */
    public static boolean IsReadOnly(Field field) {
	if (GetReadOnly((HttpServletRequest) field.getPageContext()
		.getRequest())) {
	    return true;
	} else {
	    return field.getReadonly();
	}
    }

    /**
     * Retrieves a property value from a bean in the pageContext or the value
     * attribute if it is included in the tag.
     * 
     * @param field
     *            The field whose property is retrieved.
     * 
     * @exception javax.servlet.jsp.JspException
     *                Thrown if the bean or property cannot be found in the page
     *                context.
     * 
     * @return The value of the property. Special HTML characters are replaced
     *         by the standard HTML entities.
     */
    public static String GetProperty(Field field) throws JspException {
	return GetProperty(field, true);
    }

    /**
     * Override the method GetProperty(CibcField field) to enable or disable
     * filter.
     * 
     * @param field
     *            The field whose property is retrieved.
     * @param filter
     *            The field to enable or diable filter.
     * 
     * @exception javax.servlet.jsp.JspException
     *                Thrown if the bean or property cannot be found in the page
     *                context.
     * 
     * @return The value of the property. Special HTML characters are replaced
     *         by the standard HTML entities.
     */
    public static String GetProperty(Field field, boolean filter)
	    throws JspException {
	if (field.getValue() != null) {
	    if (filter) {
		return ResponseUtils.filter(field.getValue());
	    } else {
		return field.getValue();
	    }
	} else {
	    Object prop = GetPropertyObject(field);

	    if (prop == null) {
		prop = "";
	    }

	    if (filter) {
		return ResponseUtils.filter(prop.toString());
	    } else {
		return prop.toString();
	    }
	}
    }

    /**
     * Retrieves a property value from a bean in the pageContext or null
     * 
     * @param field
     *            The field whose property is retrieved.
     * 
     * @exception javax.servlet.jsp.JspException
     *                Thrown if the bean or property cannot be found in the page
     *                context.
     * 
     * @return The value of the property.
     */
    public static Object GetPropertyObject(Field field) throws JspException {
	return RequestUtils.lookup(field.getPageContext(), field.getName(),
		field.getProperty(), null);
    }

    /**
     * Writes the value of the field as a set of HTML paragraphs. Each line in
     * the field's property value is written in its own paragraph.
     * 
     * @param field
     *            The field whose property is written to the page.
     * 
     * @exception javax.servlet.jsp.JspException
     *                Thrown if the bean or property cannot be found in the page
     *                context.
     */
    public static void WriteParagraphs(Field field) throws JspException {
	BufferedReader reader = new BufferedReader(new StringReader(
		GetProperty(field)));

	String line;

	try {
	    while ((line = reader.readLine()) != null) {
		ResponseUtils.write(field.getPageContext(), "<P>");
		// [Ahamed.I 16-Feb-2007] Modified to fix SIT 3458 KITS 0052679
		ResponseUtils.write(field.getPageContext(), line);
		ResponseUtils.write(field.getPageContext(), "</P>\n");
	    }
	} catch (IOException exception) {
	    throw new JspException(exception.getMessage());
	}
    }
}
