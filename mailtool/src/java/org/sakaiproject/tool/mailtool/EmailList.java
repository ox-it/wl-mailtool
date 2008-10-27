package org.sakaiproject.tool.mailtool;

import java.util.ArrayList;
import java.util.List;

public class EmailList {

	private List<String> emails;

	public EmailList () {
		this.emails = new ArrayList<String>();
	}

	public EmailList(List<String> emails) {
		this.emails = emails;
	}

	public List<String> getEmails() {
		return emails;
	}
	
	public String getEmailList(String separator) {
		StringBuilder output = new StringBuilder();
		if (!emails.isEmpty()) {
			output.append(emails.get(0));
			for(int count = 1; count < emails.size(); count++) {
				output.append(separator);
				output.append(emails.get(count));
			}
		}
		return output.toString();
	}
	
}
