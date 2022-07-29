package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingResponse {

	private Boolean slot_confirmed;
	private String weekday;
	private String start_time;
	private String end_time;
	private String date;
	private String reason;

}
