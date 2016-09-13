package com.service;

import java.util.List;

import com.model.Student;

public interface TeamService {
	
	public List<Student> getTeamStructure();

	public void addTeamStructure(String teamStructure);

}
