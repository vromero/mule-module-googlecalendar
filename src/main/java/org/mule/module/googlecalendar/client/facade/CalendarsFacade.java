package org.mule.module.googlecalendar.client.facade;

import java.io.IOException;

import com.google.api.services.calendar.model.Calendar;
import com.google.api.services.calendar.model.CalendarList;
import com.google.api.services.calendar.model.CalendarListEntry;

public class CalendarsFacade {

	public String getCalendarMetadata(com.google.api.services.calendar.Calendar service, String calendarId) throws IOException {
		com.google.api.services.calendar.model.Calendar calendar = service.calendars().get(calendarId).execute();
		return calendar.getSummary();
	}

	public String createCalendar(com.google.api.services.calendar.Calendar service, String summary, String timeZone) throws IOException {
		com.google.api.services.calendar.model.Calendar calendar = new com.google.api.services.calendar.model.Calendar();

		calendar.setSummary(summary);
		calendar.setTimeZone(timeZone);

		com.google.api.services.calendar.model.Calendar createdCalendar = service.calendars().insert(calendar).execute();

		return createdCalendar.getId();
	}

	public String updateCalendarMetadata(com.google.api.services.calendar.Calendar service, String calendarId, String payload) throws IOException {
		Calendar calendar = new Calendar().getFactory().fromString(payload, Calendar.class);
		Calendar updatedCalendar = service.calendars().update(calendar.getId(), calendar).execute();
		return updatedCalendar.getEtag();
	}

	public void clearPrimaryCalendar(com.google.api.services.calendar.Calendar service, String primaryCalendarId) throws IOException {
		service.calendars().clear(primaryCalendarId).execute();
	}

	public void deleteSecondaryCalendar(com.google.api.services.calendar.Calendar service, String secondaryCalendarId) throws IOException {
		service.calendars().delete(secondaryCalendarId).execute();
	}

	public CalendarList getCalendarList(com.google.api.services.calendar.Calendar service) throws IOException {
		CalendarList calendarList = service.calendarList().list().execute();
		return calendarList;
	}

	public CalendarListEntry getCalendarListEntry(com.google.api.services.calendar.Calendar service, String calendarId) throws IOException {
		CalendarListEntry calendarListEntry = service.calendarList().get(calendarId).execute();
		return calendarListEntry;
	}

	public CalendarListEntry addCalendarToList(com.google.api.services.calendar.Calendar service, String calendarId) throws IOException {
		CalendarListEntry calendarListEntry = new CalendarListEntry();
		calendarListEntry.setId(calendarId);

		CalendarListEntry createdCalendarListEntry = service.calendarList().insert(calendarListEntry).execute();

		return createdCalendarListEntry;
	}

	public CalendarListEntry updateCalendarListEntry(com.google.api.services.calendar.Calendar service, String calendarId, CalendarListEntry calendarListEntry) throws IOException {
		CalendarListEntry updatedCalendarListEntry = service.calendarList().update(calendarListEntry.getId(), calendarListEntry).execute();
		return updatedCalendarListEntry;
	}

	public void removeCalendarListEntry(com.google.api.services.calendar.Calendar service, String calendarId) throws IOException {
		service.calendarList().delete(calendarId).execute();
	}

}
