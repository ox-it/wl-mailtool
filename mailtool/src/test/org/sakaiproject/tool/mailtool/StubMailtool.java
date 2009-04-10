/**********************************************************************************
 * $URL:$
 * $Id:$
 ***********************************************************************************
 *
 * Copyright (c) 2008 Sakai Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 **********************************************************************************/

package org.sakaiproject.tool.mailtool;

/**
 * Overrides {@link Mailtool} methods such that that class
 * can be instantiated in the absence of a fully-formed
 * Sakai environment.
 * 
 * @author dmccallum@unicon.net
 *
 */
public class StubMailtool extends Mailtool {

	protected String getSiteID() {
		return "THIS_IS_A_STUB_SITE_ID";
	}
	
	protected String getSiteTitle() {
		return "THIS_IS_A_STUB_SITE_TITLE";
	}

	protected String getSiteRealmID() {
		return "/site/" + getSiteID();
	}
	
	public String getGroupAwareRole() {
		return groupAwareRoleDefault;
	}
	
	protected String getConfigParam(String parameter) {
		return "";
	}
	
	public int readMaxNumAttachment() {
		return 10000;
	}
	
	protected String getSiteType() {
		return "";
	}
	
	public void getRecipientSelectors() {
		// do nothing
	}
	
	public void checkifGroupAwareRoleExist() {
		// do nothing
	}
	
	public boolean isEmailArchiveAddedToSite() {
		return false;
	}
	
}
