package org.sakaiproject.tool.mailtool;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;


public class EmailListConverter implements Converter{

	/**
	 * Taken from http://www.regular-expressions.info/email.html
	 * close to RFC 2822
	 */
	private final String EMAIL_REGEXP = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
	
	public Object getAsObject(FacesContext context, UIComponent component, String newValue) {
		String[] possibleEmails = newValue.split("[,;]");
		List<String> emails = new ArrayList<String>(possibleEmails.length);
		List<String> badEmails = new ArrayList<String>();
		for (String email: possibleEmails) {
			// Trim leading and trailing whitespace.
			email = email.trim();
			email = email.replaceFirst("^ +", "");
			if (email.length()>0) {
				if (email.matches(EMAIL_REGEXP)) {
					emails.add(email);
				} else {
					badEmails.add(email);
				}
			}
		}
		if (badEmails.size() > 0) {
			if (badEmails.size() > 1) {
				StringBuilder output = new StringBuilder();
				output.append(badEmails.get(0));
				for (int i = 1; i < badEmails.size(); i++) {
					output.append(", ");
					output.append(badEmails.get(i));
				}
				throw new ConverterException( new FacesMessage("The following emails aren't valid: '"+ output+ "'."));
			} else {
				throw new ConverterException(new FacesMessage("The email address '"+ badEmails.get(0)+ "' isn't valid."));
			}
				
		} else {
			return new EmailList(emails);
		}
		
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof EmailList) {
			return ((EmailList)value).getEmailList(", ");
		}
		return null;
	}

}
