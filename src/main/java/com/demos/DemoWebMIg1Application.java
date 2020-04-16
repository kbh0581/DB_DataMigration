package com.demos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

@SpringBootApplication
public class DemoWebMIg1Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoWebMIg1Application.class, args);
		
		  	
		  System.out.println("run");
		 
		  /* 
			
		  int count=0; int writeCount=0; String line = null;
		  BufferedReader bf =null; FileWriter writer1= null; FileWriter writer2= null;
		  FileWriter writer3= null; FileWriter writer4= null; FileWriter writer5= null;
		  String base="C:\\Users\\dongwha\\Desktop\\20191028_SRM_GR_MT_OV2.sql"; String
		  to ="C:\\Users\\dongwha\\Desktop\\20191031Cover.txt";
		  
		  String v1 = base+"_V1"; String v2 = base+"_V2"; String v3 = base+"_V3";
		  String v4 = base+"_V4"; String v5 = base+"_V5";
		  
		  
		  
			  String fileURL = base;
			  
			  try {
				bf =new BufferedReader(new InputStreamReader(new FileInputStream(new  File(fileURL)),"UTF-8"));
				
				try {
					while ((line=bf.readLine())!=null){
						
						String arr[] = line.split("\\|");
						if(arr.length!=28)
						{
							System.out.println(line);
							System.out.println(arr.length);
						}
						
						
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			 
		  */
			  
			  
			  
			 /* 
			  
		  File file =new File(to); 
		  File file1 =new File(v1); 
		  File file2 =new File(v2);
		  File file3 =new File(v3);
		  File file4 =new File(v4); 
		  File file5 =new File(v5);
		  
		
		  
		  
		  try { 
			  bf =new BufferedReader(new InputStreamReader(new FileInputStream(new  File(fileURL)),"UTF-8"));
			  writer1 =new FileWriter(file1,true); 
			  writer2 =new FileWriter(file2,true); 
			  writer3 =new FileWriter(file3,true); 
			  writer4 =new FileWriter(file4,true); 
			  writer5 =new FileWriter(file5,true);
										  
			  while ((line=bf.readLine())!=null) {
					 count++;
						  
					System.out.println(count);	 
					  switch (count%5) { 
						  case 0: writer1.write(line+"\n"); writer1.flush();writeCount++; break;
						  case 1: writer2.write(line+"\n"); writer2.flush(); writeCount++; break;
						  case 2: writer3.write(line+"\n"); writer3.flush(); writeCount++; break; 
						  case 3: writer4.write(line+"\n"); writer4.flush(); writeCount++; break;
						  case 4: writer5.write(line+"\n"); writer5.flush(); writeCount++; break;
					  
						  
						  default:
						  
						  break; 
					  }
				  
				 }
			  
			  
			  
			  
			  
			  
			  
			  System.out.println("writeCount:" + writeCount);
			  System.out.println("Count:" +count);
		  	} catch (UnsupportedEncodingException | FileNotFoundException e1) { 
		    	e1.printStackTrace(); 
			} catch (IOException e) { 
		  				e.printStackTrace(); 
		  	} finally {
		  		if(bf!=null){
		  			try { bf.close();
		  					writer1.close();
		  					writer2.close();
		  					writer3.close();
		  					writer4.close(); 
		  					writer5.close();
		  
		  } catch (IOException e) {
			  e.printStackTrace(); 
		  }}}
		
		*/
		
		
	}

	
	public static BufferedReader streamSql(String path) {
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

	
	
	 
	  
	
//	 System.out.println("run"); int count=0; int writeCount=0; String line = null;
//	  BufferedReader bf =null; FileWriter writer1= null; FileWriter writer2= null;
//	  FileWriter writer3= null; FileWriter writer4= null; FileWriter writer5= null;
//	  String base="C:\\Users\\dongwha\\Desktop\\20191028_SRM_PUR_DT_OV.sql"; String
//	  to ="C:\\Users\\dongwha\\Desktop\\20191031Cover.txt";
//	  
//	  String v1 = base+"_V1"; String v2 = base+"_V2"; String v3 = base+"_V3";
//	  String v4 = base+"_V4"; String v5 = base+"_V5";
//	  
//	  
//	  
//	  String fileURL = base;
//	  
//	  File file1 =new File(v1);  
//	  
//	  
//	  
//	  
//	  
//	  
//	  
//	  try {
//		  bf =new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileURL)),"UTF-8"));
//		  writer1 =new FileWriter(file1,true);
//	  
//		  while ((line=bf.readLine())!=null) {
//			  
//			  if(line.indexOf("('") > 0) {
//			  writer1.write(line+"\n");
//			  writer1.flush();
//			  writeCount++;
//			  }
//		  
//		  
//		 
//		  count++;
// 
//		  
//		  
//		  
//		  
//		  }
//	  
//		  	System.out.println("writeCount:" + writeCount); System.out.println("Count:" +count);
//	  
//	  
//	  
//	  } catch (UnsupportedEncodingException | FileNotFoundException e) {
//		
//		  		e.printStackTrace(); 
//	  }catch (IOException e) {
//		  
//		  e.printStackTrace(); 
//	  }  finally {
//		  if(bf!=null){
//		  
//		  try { bf.close(); writer1.close(); }
//		
//		  
//		  catch (IOException e) { e.printStackTrace(); } 
//	
//		  }
//	  }
//	
	
	
	
	
	
	 	
	public static  String[] lineToArray(String line) {
		
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
