package com.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Student;
import com.service.TeamService;

@Controller
@RequestMapping(value="/team")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public void addingTeam(@RequestParam String teamData) throws UnsupportedEncodingException {
		teamData = java.net.URLDecoder.decode(teamData,"UTF-8");
		
		System.out.println(teamData);
		
		teamService.addTeamStructure(teamData);
		
	}

}
