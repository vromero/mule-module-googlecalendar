package org.mule.module.googlecalendar.client.facade;

import java.io.IOException;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.Calendar.Events.Move;
import com.google.api.services.calendar.Calendar.Events.QuickAdd;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;

public class EventFacade {
	
	public Events getEvents(Calendar service, String calendarId) throws IOException {
		Events events = service.events().list(calendarId).execute();
		return events;
	}

	public Event getEvent(Calendar service, String calendarId, String eventId) throws IOException {
		Event event = service.events().get(calendarId, eventId).execute();
		return event;
	}

	public String createEvent(Calendar service, String calendarId, Event event) throws IOException {
		Event createdEvent = service.events().insert(calendarId, event).execute();
		return createdEvent.getId();
	}

	public String quickAdd(Calendar service, String calendarId, String text) throws IOException {
		QuickAdd quickAdd = service.events().quickAdd(calendarId, text);
		Event createdEvent = quickAdd.execute();
		return createdEvent.getId();
	}

	public String importEvent(Calendar service, String calendarId, Event event) throws IOException {
		Event importedEvent = service.events().calendarImport(calendarId, event).execute();
		return importedEvent.getId();
	}

	
	public DateTime updateEvent(Calendar service, String calendarId, String eventId, Event event) throws IOException {
		Event updatedEvent = service.events().update("primary", event.getId(), event).execute();
		return updatedEvent.getUpdated();
	}

	public DateTime changeOrganizer(Calendar service, String calendarId, String eventId, String destinationCalendarId) throws IOException {
		Move move = service.events().move(calendarId, eventId, destinationCalendarId);
		Event updatedEvent = move.execute();

		return updatedEvent.getUpdated();
	}

	public void deleteEvent(Calendar service, String calendarId, String eventId) throws IOException {
		service.events().delete(calendarId, eventId).execute();
	}

	public Events getRecurringEventInstances(Calendar service, String calendarId, String eventId) throws IOException {
		Events events = service.events().instances(calendarId, eventId).execute();
		return events;
	}

	public Event putExceptionToRecurringEvent(Calendar service, String calendarId, String eventId, String status) throws IOException {
		Events instances = service.events().instances(calendarId, eventId).execute();

		// Select the instance to cancel.
		Event instance = instances.getItems().get(0);
		instance.setStatus(status);

		Event updatedInstance = service.events().update(calendarId, instance.getId(), instance).execute();
		return updatedInstance;
	}

	public void undoChangeToRecurringEvent(Calendar service, String calendarId, String eventId) throws IOException {
		service.events().reset(calendarId, eventId).execute();
	}

}
