/**
 * Mule Development Kit
 * Copyright 2010-2011 (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * This file was automatically generated by the Mule Development Kit
 */
package org.mule.module.googlecalendar;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.mule.api.annotations.Module;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.param.Payload;
import org.mule.module.googlecalendar.client.GoogleCalendarFacade;

import com.google.api.services.calendar.model.AclRule;
import com.google.api.services.calendar.model.CalendarListEntry;
import com.google.api.services.calendar.model.Event;

/**
 * Generic module
 * 
 * @author Victor Romero <victor.romero@gmail.com>
 */
@Module(name = "googlecalendar", schemaVersion = "1.0")
public class GoogleCalendarModule {

	private GoogleCalendarFacade facade;

	@PostConstruct
    public void postConstruct() throws IOException {
		facade = new GoogleCalendarFacade();
    }
	
	
	////////////////////////////////////////////////////////////////
	//
	//	Acl
	//
	////////////////////////////////////////////////////////////////
	
	/**
	 * TODO
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @param calendarId
	 *            Id of the calendar to be used
	 *            
	 * @return Single setting for a user.
	 * @throws IOException
	 */
	@Processor
	public String getCalendarAcl(String accessToken, String calendarId) throws IOException {
		return facade.getCalendarAcl(accessToken, calendarId).toString();
	}

	/**
	 * TODO
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @param calendarId
	 *            Id of the calendar to be used
	 * @param ruleId
	 * 			  TODO
	 *            
	 * @return Single setting for a user.
	 * @throws IOException
	 */
	@Processor
	public AclRule getCalendarAclRule(String accessToken, String calendarId, String ruleId) throws IOException {
		return facade.getCalendarAclRule(accessToken, calendarId, ruleId);
	}

	/**
	 * TODO
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @param calendarId
	 *            Id of the calendar to be used
	 * @param payload
	 * 			  TODO
	 *            
	 * @return Single setting for a user.
	 * @throws IOException
	 */
	@Processor
	public String createCalendarAclRule(String accessToken, String calendarId, @Payload String payload) throws IOException {
		AclRule aclRule = new AclRule().getFactory().fromString(payload, AclRule.class);
		return facade.createCalendarAclRule(accessToken, calendarId, aclRule).toString();
	}

	/**
	 * TODO
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @param calendarId
	 *            Id of the calendar to be used
	 * @param ruleId
	 * 			  TODO
	 * @param newRole
	 * 				TODO
	 *            
	 * @return Single setting for a user.
	 * @throws IOException
	 */
	@Processor
	public String updateCalendarAclRule(String accessToken, String calendarId, String ruleId, String newRole) throws IOException {
		return facade.updateCalendarAclRule(accessToken, calendarId, ruleId, newRole);
	}

	/**
	 * TODO
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @param calendarId
	 *            Id of the calendar to be used
	 * @param ruleId
	 * 			  TODO
	 *            
	 * @return Single setting for a user.
	 * @throws IOException
	 */
	@Processor
	public void removeCalendarAclRule(String accessToken, String calendarId, String ruleId) throws IOException {
		facade.removeCalendarAclRule(accessToken, calendarId, ruleId);
	}

	
	
	////////////////////////////////////////////////////////////////
	//
	//	Calendars
	//
	////////////////////////////////////////////////////////////////

	/**
	 * TODO
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @param calendarId
	 *            Id of the calendar to be used
	 *            
	 * @return Single setting for a user.
	 * @throws IOException
	 */
	@Processor
	public String getCalendarMetadata(String accessToken, String calendarId) throws IOException {
		return facade.getCalendarMetadata(accessToken, calendarId).toString();
	}

	/**
	 * TODO
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @param summary
	 *            Id of the calendar to be used
	 * @param timeZone
	 * 			  TODO
	 *            
	 * @return Single setting for a user.
	 * @throws IOException
	 */
	@Processor
	public String createCalendar(String accessToken, String summary, String timeZone) throws IOException {
		return facade.createCalendar(accessToken, summary, timeZone);
	}

	/**
	 * TODO
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @param calendarId
	 *            Id of the calendar to be used
	 * @param payload
	 * 			  TODO
	 *            
	 * @return Single setting for a user.
	 * @throws IOException
	 */
	@Processor
	public String updateCalendarMetadata(String accessToken, String calendarId, @Payload String payload) throws IOException {
		return facade.updateCalendarMetadata(accessToken, calendarId, payload);
	}

	/**
	 * TODO
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @param primaryCalendarId
	 *            Id of the calendar to be used
	 *            
	 * @return Single setting for a user.
	 * @throws IOException
	 */
	@Processor
	public void clearPrimaryCalendar(String accessToken, String primaryCalendarId) throws IOException {
		facade.clearPrimaryCalendar(accessToken, primaryCalendarId);
	}

	/**
	 * TODO
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @param secondaryCalendarId
	 *            Id of the calendar to be used
	 *            
	 * @return Single setting for a user.
	 * @throws IOException
	 */
	@Processor
	public void deleteSecondaryCalendar(String accessToken, String secondaryCalendarId) throws IOException {
		facade.deleteSecondaryCalendar(accessToken, secondaryCalendarId);
	}

	/**
	 * TODO
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 *            
	 * @return Single setting for a user.
	 * @throws IOException
	 */
	@Processor
	public String getCalendarList(String accessToken) throws IOException {
		return facade.getCalendarList(accessToken).toString();
	}

	/**
	 * TODO
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @param calendarId
	 *            Id of the calendar to be used
	 *            
	 * @return Single setting for a user.
	 * @throws IOException
	 */
	@Processor
	public String getCalendarListEntry(String accessToken, String calendarId) throws IOException {
		return facade.getCalendarListEntry(accessToken, calendarId).toString();
	}

	/**
	 * TODO
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @param calendarId
	 *            Id of the calendar to be used
	 *            
	 * @return Single setting for a user.
	 * @throws IOException
	 */
	@Processor
	public String addCalendarToList(String accessToken, String calendarId) throws IOException {
		return facade.addCalendarToList(accessToken, calendarId).toString();
	}

	/**
	 * TODO
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @param calendarId
	 *            Id of the calendar to be used
	 * @param payload
	 * 			  TODO
	 *            
	 * @return Single setting for a user.
	 * @throws IOException
	 */
	@Processor
	public String updateCalendarListEntry(String accessToken, String calendarId, @Payload String payload) throws IOException {
		CalendarListEntry calendarListEntry = new CalendarListEntry().getFactory().fromString(payload, CalendarListEntry.class);
		return facade.updateCalendarListEntry(accessToken, calendarId, calendarListEntry).toString();
	}

	/**
	 * TODO
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @param calendarId
	 *            Id of the calendar to be used
	 *            
	 * @return Single setting for a user.
	 * @throws IOException
	 */
	@Processor
	public void removeCalendarListEntry(String accessToken, String calendarId) throws IOException {
		facade.removeCalendarListEntry(accessToken, calendarId);
	}
	
	
	////////////////////////////////////////////////////////////////
	//
	//	Colors
	//
	////////////////////////////////////////////////////////////////
	
	/**
	 * Retrieve the list of available colors and their associated IDs
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @return List of available colors and their associated IDs.
	 * @throws IOException
	 */
	@Processor
	public String getColors(String accessToken) throws IOException {
		return facade.getColors(accessToken).toString();
	}

	
	////////////////////////////////////////////////////////////////
	//
	//	Event
	//
	////////////////////////////////////////////////////////////////

	/**
	 * TODO
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @param calendarId
	 *            Id of the calendar to be used
	 *            
	 * @return Single setting for a user.
	 * @throws IOException
	 */
	@Processor
	public String getEvents(String accessToken, String calendarId) throws IOException {
		return facade.getEvents(accessToken, calendarId).toString();
	}

	/**
	 * TODO
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @param calendarId
	 *            Id of the calendar to be used
	 * @param eventId
	 * 			  TODO
	 *            
	 * @return Single setting for a user.
	 * @throws IOException
	 */
	@Processor
	public Event getEvent(String accessToken, String calendarId, String eventId) throws IOException {
		return facade.getEvent(accessToken, calendarId, eventId);
	}

	/**
	 * TODO
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @param calendarId
	 *            Id of the calendar to be used
	 * @param payload
	 * 			  TODO
	 *            
	 * @return Single setting for a user.
	 * @throws IOException
	 */
	@Processor
	public String createEvent(String accessToken, String calendarId, String payload) throws IOException {
		Event event = new Event().getFactory().fromString(payload, Event.class);
		return facade.createEvent(accessToken, calendarId, event);
	}

	/**
	 * TODO
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @param calendarId
	 *            Id of the calendar to be used
	 * @param text
	 * 			  TODO
	 *            
	 * @return Single setting for a user.
	 * @throws IOException
	 */
	@Processor
	public String quickAdd(String accessToken, String calendarId, String text) throws IOException {
		return facade.quickAdd(accessToken, calendarId, text);
	}

	/**
	 * TODO
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @param calendarId
	 *            Id of the calendar to be used
	 * @param payload
	 * 			  TODO
	 *            
	 * @return Single setting for a user.
	 * @throws IOException
	 */
	@Processor
	public String importEvent(String accessToken, String calendarId, String payload) throws IOException {
		Event event = new Event().getFactory().fromString(payload, Event.class);
		return facade.importEvent(accessToken, calendarId, event);
	}

	/**
	 * TODO
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @param calendarId
	 *            Id of the calendar to be used
	 * @param eventId
	 *            Event to be modified
	 * @param payload
	 * 			  TODO
	 *            
	 * @return Single setting for a user.
	 * @throws IOException
	 */
	@Processor
	public String updateEvent(String accessToken, String calendarId, String eventId, @Payload String payload) throws IOException {
		Event event = new Event().getFactory().fromString(payload, Event.class);
		return facade.updateEvent(accessToken, calendarId, eventId, event).toString();
	}

	/**
	 * TODO
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @param calendarId
	 *            Id of the calendar to be used
	 * @param eventId
	 *            Event to be modified
	 * @param destinationCalendarId
	 * 			  TODO
	 *            
	 * @return Single setting for a user.
	 * @throws IOException
	 */
	@Processor
	public String changeOrganizer(String accessToken, String calendarId, String eventId, String destinationCalendarId) throws IOException {
		return facade.changeOrganizer(accessToken, calendarId, eventId, destinationCalendarId).toString();
	}

	/**
	 * TODO
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @param calendarId
	 *            Id of the calendar to be used
	 * @param eventId
	 *            Event to be modified
	 *            
	 * @return Single setting for a user.
	 * @throws IOException
	 */
	@Processor
	public void deleteEvent(String accessToken, String calendarId, String eventId) throws IOException {
		facade.deleteEvent(accessToken, calendarId, eventId);
	}

	/**
	 * TODO
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @param calendarId
	 *            Id of the calendar to be used
	 * @param eventId
	 *            Event to be modified
	 *            
	 * @return Single setting for a user.
	 * @throws IOException
	 */
	@Processor
	public String getRecurringEventInstances(String accessToken, String calendarId, String eventId) throws IOException {
		return facade.getRecurringEventInstances(accessToken, calendarId, eventId).toString();
	}


	/**
	 * TODO
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @param calendarId
	 *            Id of the calendar to be used
	 * @param eventId
	 *            Event to be modified
	 * @param status
	 * 			  TODO
	 *            
	 * @return Single setting for a user.
	 * @throws IOException
	 */
	@Processor
	public Event putExceptionToRecurringEvent(String accessToken, String calendarId, String eventId, String status) throws IOException {
		return facade.putExceptionToRecurringEvent(accessToken, calendarId, eventId, status);
	}

	/**
	 * Undo changes made to a single occurrence of a recurring event to its original state
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @param calendarId
	 *            Id of the calendar to be used
	 * @param eventId
	 *            Event to be modified
	 *            
	 * @return Single setting for a user.
	 * @throws IOException
	 */
	@Processor
	public void undoChangeToRecurringEvent(String accessToken, String calendarId, String eventId) throws IOException {
		facade.undoChangeToRecurringEvent(accessToken, calendarId, eventId);
	}
	

	
	////////////////////////////////////////////////////////////////
	//
	//	FreeBusy
	//
	////////////////////////////////////////////////////////////////
	
	
	/**
	 * Retrieve busy times for specific calendars
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @param timeMin start of the time window
	 * @param timeMax end of the time window
	 * @param userIds  safadsf
	 * @return List of settings for a user
	 * @throws IOException
	 */	
	@Processor
	public String getFreeBusy(String accessToken, String timeMin, String timeMax, String userIds) throws IOException {
		return facade.getFreeBusy(accessToken, timeMin, timeMax, userIds.split(",")).toString();
	}
	
	
	
	////////////////////////////////////////////////////////////////
	//
	//	Settings
	//
	////////////////////////////////////////////////////////////////
	
	/**
	 * Retrieve the list of settings for a user
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @return List of settings for a user
	 * @throws IOException
	 */
	@Processor
	public String getSettings(String accessToken) throws IOException {
		return facade.getSettings(accessToken).toString();
	}

	/**
	 * Retrieve a single setting for a user.
	 * 
	 * {@sample.xml ../../../doc/GoogleCalendar-connector.xml.sample
	 * googlecalendar:getColors}
	 * 
	 * @param accessToken
	 *            Request authorization
	 * @param settingId
	 *            Id of the setting to be fetched.
	 * @return Single setting for a user.
	 * @throws IOException
	 */
	@Processor
	public String getSetting(String accessToken, String settingId) throws IOException {
		return facade.getSetting(accessToken, settingId).toString();
	}

}
