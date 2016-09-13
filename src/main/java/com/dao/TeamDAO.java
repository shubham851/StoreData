package com.dao;

import java.util.List;

import com.model.Student;

public interface TeamDAO {
	
	public void addTeamStructure(List<Student> lis);
	public List<Student> getTeamStructure();
	public int hqlTruncate();
}
