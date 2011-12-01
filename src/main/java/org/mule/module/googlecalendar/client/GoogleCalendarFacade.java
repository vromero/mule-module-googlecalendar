package org.mule.module.googlecalendar.client;

import java.io.IOException;

import org.mule.module.googlecalendar.client.facade.AclFacade;
import org.mule.module.googlecalendar.client.facade.CalendarsFacade;
import org.mule.module.googlecalendar.client.facade.ColorFacade;
import org.mule.module.googlecalendar.client.facade.EventFacade;
import org.mule.module.googlecalendar.client.facade.FreeBusyFacade;
import org.mule.module.googlecalendar.client.facade.SettingsFacade;

import com.google.api.client.googleapis.auth.oauth2.draft10.GoogleAccessProtectedResource;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Acl;
import com.google.api.services.calendar.model.AclRule;
import com.google.api.services.calendar.model.CalendarList;
import com.google.api.services.calendar.model.CalendarListEntry;
import com.google.api.services.calendar.model.Colors;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;
import com.google.api.services.calendar.model.FreeBusyResponse;
import com.google.api.services.calendar.model.Setting;
import com.google.api.services.calendar.model.Settings;

public class GoogleCalendarFacade {

	Calendar service;

	AclFacade aclFacade;
	CalendarsFacade calendarsFacade;
	ColorFacade colorFacade;
	EventFacade eventFacade;
	FreeBusyFacade freeBusyFacade;
	SettingsFacade settingsFacade;

	HttpTransport httpTransport;
	JacksonFactory jsonFactory;

	String clientId;
	String clientSecret;
	String applicationName;

	public GoogleCalendarFacade() throws IOException {
		httpTransport = new NetHttpTransport();
		jsonFactory = new JacksonFactory();

		aclFacade = new AclFacade();
		calendarsFacade = new CalendarsFacade();
		colorFacade = new ColorFacade();
		eventFacade = new EventFacade();
		freeBusyFacade = new FreeBusyFacade();
		settingsFacade = new SettingsFacade();
	}

	public Calendar getService(String accessToken) throws IOException {
		GoogleAccessProtectedResource accessProtectedResource = new GoogleAccessProtectedResource(accessToken);

		service = Calendar.builder(httpTransport, jsonFactory).setApplicationName(applicationName)
				.setHttpRequestInitializer(accessProtectedResource).build();
		
		return service;
	}

	
	// Acl
	public Acl getCalendarAcl(String accessToken, String calendarId) throws IOException {
		return aclFacade.getCalendarAcl(getService(accessToken), calendarId);
	}

	public AclRule getCalendarAclRule(String accessToken, String calendarId, String ruleId) throws IOException {
		return aclFacade.getCalendarAclRule(getService(accessToken), calendarId, ruleId);
	}

	public String createCalendarAclRule(String accessToken, String calendarId, AclRule aclRule) throws IOException {
		return aclFacade.createCalendarAclRule(getService(accessToken), calendarId, aclRule);
	}

	public String updateCalendarAclRule(String accessToken, String calendarId, String ruleId, String newRole) throws IOException {
		return aclFacade.updateCalendarAclRule(getService(accessToken), calendarId, ruleId, newRole);
	}

	public void removeCalendarAclRule(String accessToken, String calendarId, String ruleId) throws IOException {
		aclFacade.removeCalendarAclRule(getService(accessToken), calendarId, ruleId);
	}

	// Calendars
	public String getCalendarMetadata(String accessToken, String calendarId) throws IOException {
		return calendarsFacade.getCalendarMetadata(getService(accessToken), calendarId);
	}

	public String createCalendar(String accessToken, String summary, String timeZone) throws IOException {
		return calendarsFacade.createCalendar(getService(accessToken), summary, timeZone);
	}

	public String updateCalendarMetadata(String accessToken, String calendarId, String summary) throws IOException {
		return calendarsFacade.updateCalendarMetadata(getService(accessToken), calendarId, summary);
	}

	public void clearPrimaryCalendar(String accessToken, String primaryCalendarId) throws IOException {
		calendarsFacade.clearPrimaryCalendar(getService(accessToken), primaryCalendarId);
	}

	public void deleteSecondaryCalendar(String accessToken, String secondaryCalendarId) throws IOException {
		calendarsFacade.deleteSecondaryCalendar(getService(accessToken), secondaryCalendarId);
	}

	public CalendarList getCalendarList(String accessToken) throws IOException {
		return calendarsFacade.getCalendarList(getService(accessToken));
	}

	public CalendarListEntry getCalendarListEntry(String accessToken, String calendarId) throws IOException {
		return calendarsFacade.getCalendarListEntry(getService(accessToken), calendarId);
	}

	public CalendarListEntry addCalendarToList(String accessToken, String calendarId) throws IOException {
		return calendarsFacade.addCalendarToList(getService(accessToken), calendarId);
	}

	public CalendarListEntry updateCalendarListEntry(String accessToken, String calendarId, CalendarListEntry calendarListEntry) throws IOException {
		return calendarsFacade.updateCalendarListEntry(getService(accessToken), calendarId, calendarListEntry);
	}

	public void removeCalendarListEntry(String accessToken, String calendarId) throws IOException {
		calendarsFacade.removeCalendarListEntry(getService(accessToken), calendarId);
	}
	
	
	// Color
	public Colors getColors(String accessToken) throws IOException {
		return colorFacade.getColors(getService(accessToken));
	}
	
	// Event
	public Events getEvents(String accessToken, String calendarId) throws IOException {
		return eventFacade.getEvents(getService(accessToken), calendarId);
	}

	public Event getEvent(String accessToken, String calendarId, String eventId) throws IOException {
		return eventFacade.getEvent(getService(accessToken), calendarId, eventId);
	}

	public String createEvent(String accessToken, String calendarId, Event event) throws IOException {
		return eventFacade.createEvent(getService(accessToken), calendarId, event);
	}

	public String quickAdd(String accessToken, String calendarId, String text) throws IOException {
		return eventFacade.quickAdd(getService(accessToken), calendarId, text);
	}

	public String importEvent(String accessToken, String calendarId, Event event) throws IOException {
		return eventFacade.importEvent(getService(accessToken), calendarId, event);
	}

	public DateTime updateEvent(String accessToken, String calendarId, String eventId, Event event) throws IOException {
		return eventFacade.updateEvent(getService(accessToken), calendarId, eventId, event);
	}

	public DateTime changeOrganizer(String accessToken, String calendarId, String eventId, String destinationCalendarId) throws IOException {
		return eventFacade.changeOrganizer(getService(accessToken), calendarId, eventId, destinationCalendarId);
	}

	public void deleteEvent(String accessToken, String calendarId, String eventId) throws IOException {
		eventFacade.deleteEvent(getService(accessToken), calendarId, eventId);
	}

	public Events getRecurringEventInstances(String accessToken, String calendarId, String eventId) throws IOException {
		return eventFacade.getRecurringEventInstances(getService(accessToken), calendarId, eventId);
	}

	public Event putExceptionToRecurringEvent(String accessToken, String calendarId, String eventId, String status) throws IOException {
		return eventFacade.putExceptionToRecurringEvent(getService(accessToken), calendarId, eventId, status);
	}

	public void undoChangeToRecurringEvent(String accessToken, String calendarId, String eventId) throws IOException {
		eventFacade.undoChangeToRecurringEvent(getService(accessToken), calendarId, eventId);
	}
	
	// FreeBusy
	public FreeBusyResponse getFreeBusy(String accessToken, String timeMin, String timeMax, String[] userIds) throws IOException {
		return freeBusyFacade.getFreeBusy(getService(accessToken), timeMin, timeMax, userIds);
	}
	

	// Settings
	public Settings getSettings(String accessToken) throws IOException {
		return settingsFacade.getSettings(getService(accessToken));
	}
	
	public Setting getSetting(String accessToken, String settingId) throws IOException {
		return settingsFacade.getSetting(getService(accessToken), settingId);
	}
	
}
