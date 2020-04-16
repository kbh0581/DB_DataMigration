package com.demos.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demos.service.TestService;

@RestController
public class TestController {
	@Resource
	TestService testservice;
	
	
	@RequestMapping("/index")
	public List<Map<String, Object>> test() {
		
		return testservice.getList();
	}
	
	@RequestMapping("/index/DelivyRunner")
	public String runner() {
		
		testservice.srmDelivyService();
		
		return "Delvy 완료";
	}
	
	@RequestMapping("/index/purMtRunner")
	public String purMtRunner() {
		
		testservice.srmPurDocMtService();
		
		return "pur MT 완료";
	}
	
	
	@RequestMapping("/index/purDtRunner")
	public String purDtRunner() {
		
		testservice.srmPurDocDtService();
		
		return "pur DT 완료";
	}
	
	
	@RequestMapping("/index/srmGrmRunner")
	public String srmGrRunner() {
		
		testservice.srmGrDocService();
		
		
		return "SRM GR 완료";
	}
	
	
	
	
	
	
	
	
	
}
