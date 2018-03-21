package com.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FooterTag extends SimpleTagSupport{
	private String className;
	
	@Override
	public void doTag() throws JspException, IOException{
		String footer = String.format("<div class='%s'>%s</div>",className,"Footer" );
		getJspContext().getOut().write(footer);
	}
	
	public void setClassName(String name) {
		this.className=name;
	}
}
