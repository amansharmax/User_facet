package com.example.demo.models;

import java.util.List;
import java.util.Map;

import lombok.Data;


@Data
public class TeacherAvailibility {

	private String full_name;
	private String email;
	private Map<String, List<TeacherTime>> availability;

}
