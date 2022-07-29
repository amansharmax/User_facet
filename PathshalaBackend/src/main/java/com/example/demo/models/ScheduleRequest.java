package com.example.demo.models;

import lombok.Data;

@Data
public class ScheduleRequest {

	private String full_name;
	private String email_address;
	private String weekday;
	private String start_time;
	private String end_time;
}
