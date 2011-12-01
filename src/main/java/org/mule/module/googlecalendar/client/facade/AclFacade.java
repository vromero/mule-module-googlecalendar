package org.mule.module.googlecalendar.client.facade;

import java.io.IOException;

import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Acl;
import com.google.api.services.calendar.model.AclRule;

public class AclFacade {

	public Acl getCalendarAcl(Calendar service, String calendarId) throws IOException {
		Acl acl = service.acl().list(calendarId).execute();
		return acl;
	}

	public AclRule getCalendarAclRule(Calendar service, String calendarId, String ruleId) throws IOException {
		AclRule rule = service.acl().get(calendarId, ruleId).execute();
		return rule;
	}

	public String createCalendarAclRule(Calendar service, String calendarId, AclRule aclRule) throws IOException {
		AclRule createdRule = service.acl().insert(calendarId, aclRule).execute();
		return createdRule.getId();
	}

	public String updateCalendarAclRule(Calendar service, String calendarId, String ruleId, String newRole) throws IOException {
		AclRule rule = service.acl().get(calendarId, ruleId).execute();
		rule.setRole(newRole);

		AclRule updatedRule = service.acl().update(calendarId, rule.getId(), rule).execute();
		return updatedRule.getEtag();
	}

	public void removeCalendarAclRule(Calendar service, String calendarId, String ruleId) throws IOException {
		service.acl().delete(calendarId, ruleId).execute();
	}

}
