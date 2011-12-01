package org.mule.module.googlecalendar.client.facade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.FreeBusyRequest;
import com.google.api.services.calendar.model.FreeBusyRequestItem;
import com.google.api.services.calendar.model.FreeBusyResponse;

public class FreeBusyFacade {

	public FreeBusyResponse getFreeBusy(Calendar service, String timeMin, String timeMax, String[] userIds) throws IOException {
		FreeBusyRequest request = new FreeBusyRequest();

		request.setTimeMin(DateTime.parseRfc3339(timeMin));
		request.setTimeMax(DateTime.parseRfc3339(timeMax));

		List<FreeBusyRequestItem> items = new ArrayList<FreeBusyRequestItem>(userIds.length);
		for (String user : userIds) {
			items.add(new FreeBusyRequestItem().setId(user));
		}
		
		request.setItems(items);

		FreeBusyResponse busyTimes = service.freebusy().query(request).execute();

		return busyTimes;
	}

}
