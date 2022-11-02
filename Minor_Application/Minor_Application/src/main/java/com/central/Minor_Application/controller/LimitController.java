package com.central.Minor_Application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.central.Minor_Application.model.LimitsConfiguration;

import ch.qos.logback.core.net.SyslogOutputStream;
// This is a limit controller 
@RestController
public class LimitController {
	
	@Autowired
	private LimitsConfiguration limits;
	
	@GetMapping("/limitmodule")
	public LimitsConfiguration returnLimits() {
		
		return  new LimitsConfiguration(limits.getMaximum(),limits.getMinimum());
		
	
		
		
	}

}
