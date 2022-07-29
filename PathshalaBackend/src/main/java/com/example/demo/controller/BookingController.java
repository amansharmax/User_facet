package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.BookingResponse;
import com.example.demo.models.ScheduleRequest;
import com.example.demo.service.BookingService;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

@RestController
public class BookingController {
	
	@Autowired
	private BookingService bookingService;

	@PostMapping("/book")
	private BookingResponse bookClass(@RequestBody ScheduleRequest request) throws StreamReadException, DatabindException, IOException {
		BookingResponse response = bookingService.bookClass(request);
		return response;
	}

}
