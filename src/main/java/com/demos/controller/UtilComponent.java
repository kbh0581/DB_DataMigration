package com.demos.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.demos.vo.SrmDelivyDocMt;


@Component
public class UtilComponent {

	
	public BufferedReader streamSql(String path) {
		BufferedReader bf=null; 
		try {
			 bf = new BufferedReader(new InputStreamReader(new FileInputStream(ResourceUtils.getFile(path)),"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bf;
	}
	
	public String[] lineToArray(String line) {
		
		line=line.replace("\t(", "");
		line=line.replace(");", "");
		line=line.trim();
		
		String [] parser=  line.split("', ");			
		
		for (int i = 0; i < parser.length; i++) {
				parser[i] = parser[i].replaceAll("'","");
		}
		
		return parser;
	}
	
	
	
}
