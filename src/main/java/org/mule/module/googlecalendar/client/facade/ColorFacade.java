package org.mule.module.googlecalendar.client.facade;

import java.io.IOException;

import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Colors;

public class ColorFacade {

	public Colors getColors(Calendar service) throws IOException {
		Colors colors = service.colors().get().execute();
		return colors;
	}
	
}
