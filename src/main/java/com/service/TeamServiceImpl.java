package com.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.TeamDAO;
import com.model.Student;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {
	
	@Autowired
	private TeamDAO teamDAO;

	public void addTeamStructure(String team) {
		//convert json string to list<student>
		JSONArray outerArr = new JSONArray(team);
		List<Student> lis = new ArrayList<Student>();
		for(int i = 0;i<outerArr.length();i++){
			Student st = new Student();
			JSONObject jsonObj = outerArr.getJSONObject(i);
			String teamName = jsonObj.getString("teamName");
			if(teamName.equalsIgnoreCase("allItems"))
				teamName = "Not Selected";
			String studentName = jsonObj.getString("studentName");
			st.setId(i+1);
			st.setName(studentName);
			st.setTeamName(teamName);
			lis.add(st);
		}
		teamDAO.hqlTruncate();
		teamDAO.addTeamStructure(lis);		
	}

	public List<Student> getTeamStructure() {
		return teamDAO.getTeamStructure();
	}

}
