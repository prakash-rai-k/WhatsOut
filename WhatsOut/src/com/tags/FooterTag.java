package com.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/*
* Written On March 21, 2018
* Custom Tag to print out the copyright information as footer
* @Author Rupendra MAHARJAN
*/
public class FooterTag extends SimpleTagSupport{
	private String className;
	
	@Override
	public void doTag() throws JspException, IOException{
		String footer = String.format("<div class='%s'>%s</div>",className,"� 2018 Copyright: MUM.EDU" );
		getJspContext().getOut().write(footer);
	}
	
	public void setClassName(String name) {
		this.className=name;
	}
}
