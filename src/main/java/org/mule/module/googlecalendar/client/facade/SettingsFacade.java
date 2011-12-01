package org.mule.module.googlecalendar.client.facade;

import java.io.IOException;

import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Setting;
import com.google.api.services.calendar.model.Settings;

public class SettingsFacade {

	public Settings getSettings(Calendar service) throws IOException {
		Settings settings = service.settings().list().execute();
		return settings;
	}
	
	public Setting getSetting(Calendar service, String settingId) throws IOException {
		Setting setting = service.settings().get(settingId).execute();
		return setting;
	}
	
}
