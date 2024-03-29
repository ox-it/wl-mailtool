/**********************************************************************************
* $URL:https://source.sakaiproject.org/contrib/mailtool/branches/2.4.refactor/src/java/org/sakaiproject/tool/mailtool/SelectorTag.java $
* $Id:SelectorTag.java 3486 2007-02-14 19:52:13Z kimsooil@bu.edu $
***********************************************************************************
*
* Copyright (c) 2006, 2007 The Sakai Foundation.
* 
* Licensed under the Educational Community License, Version 1.0 (the "License"); 
* you may not use this file except in compliance with the License. 
* You may obtain a copy of the License at
* 
*      http://www.opensource.org/licenses/ecl1.php
* 
* Unless required by applicable law or agreed to in writing, software 
* distributed under the License is distributed on an "AS IS" BASIS, 
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
* See the License for the specific language governing permissions and 
* limitations under the License.
*
**********************************************************************************/

package org.sakaiproject.tool.mailtool;

import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.webapp.UIComponentTag;

public class SelectorTag extends UIComponentTag {
	public String getRendererType() { return null; }
	public String getComponentType() { return "MailtoolSelector"; }
	
	private String value = null;
	public void setValue(String value) { this.value = value; }
	
	public void setProperties(UIComponent component) {
		super.setProperties(component);
		
		FacesContext context = FacesContext.getCurrentInstance();
		Application app = context.getApplication();
		ValueBinding vb = app.createValueBinding(value);
		component.setValueBinding("value", vb);
	}
	
	public void release() {
		super.release();
		value = null;
	}
}
