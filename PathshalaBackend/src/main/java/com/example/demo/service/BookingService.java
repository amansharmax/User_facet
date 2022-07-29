package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.models.BookingResponse;
import com.example.demo.models.ScheduleRequest;
import com.example.demo.models.TeacherAvailibility;
import com.example.demo.models.TeacherTime;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class BookingService {
	
	public BookingResponse bookClass(ScheduleRequest request) throws StreamReadException, DatabindException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		TeacherAvailibility availibility = objectMapper.readValue(new File("src/main/resources/teacher_availability.json"), TeacherAvailibility.class);
		List<TeacherTime> timingsAvailable = availibility.getAvailability().getOrDefault(request.getWeekday().toLowerCase(), null);
		if(timingsAvailable!=null) {
			for(TeacherTime time: timingsAvailable) {
				if(time.getStart_time().equals(request.getStart_time()) && time.getEnd_time().equals(request.getEnd_time())) {
					return successResponse(request);
				}
			}
		}
		return failureResponse(request);
	}

	private BookingResponse failureResponse(ScheduleRequest request) {
		BookingResponse bookingResponse = new BookingResponse();
		bookingResponse.setSlot_confirmed(false);
		bookingResponse.setReason("teacher is not available on this day");
		return bookingResponse;
	}

	private BookingResponse successResponse(ScheduleRequest request) {
		BookingResponse bookingResponse = new BookingResponse();
		bookingResponse.setSlot_confirmed(true);
		bookingResponse.setWeekday(request.getWeekday());
		bookingResponse.setStart_time(request.getStart_time());
		bookingResponse.setEnd_time(request.getEnd_time());
		bookingResponse.setDate("1 August 2022");
		return bookingResponse;
	}

}
