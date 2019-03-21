package com.taglibs.forms;

import javax.servlet.jsp.PageContext;

public interface Field {
	public String getRequired();
	public String getProperty();
	public String getValue();
	public String getName();
	public PageContext getPageContext();
	public boolean getReadonly();
}
