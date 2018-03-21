package com.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
*
* @author Rupendra MAHARJAN
* Date: March 19, 2018
* Description: Banner Tag to setup Banner Page in all page
*/
public class BannerTag extends SimpleTagSupport{
	private String firstId, secondId;
	@Override
	public void doTag() throws JspException, IOException{
		String banner = String.format("<div class='%s'>" + 
				"			<h3 class='%s'>%s</h3>\n" + 
				"		</div>",firstId,secondId,"What's Out");
		getJspContext().getOut().write(banner);
	}
	
	public void setFirstId(String name) {
		this.firstId=name;
	}
	public void setSecondId(String name) {
		this.secondId=name;
	}
}
