package com.demos.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demos.controller.UtilComponent;
import com.demos.dao.TestMigMapper;
import com.demos.tread.TaksRun;
import com.demos.vo.SrmDelivyDocMt;
import com.demos.vo.SrmGrDocMt;
import com.demos.vo.SrmPurDocDt;
import com.demos.vo.SrmPurDocMt;


@Service
public class TestServiceImpl implements TestService{
	
	public static Logger log = LoggerFactory.getLogger(TestServiceImpl.class);
	
	private final static String DELVY_PATH = "classpath:static/SRM_DELIVY.txt"; /*20191115 SRM_DELIVY.txt*/
	private final static String PUR_MT_PATH = "classpath:static/20191028_SRM_PUR_MT_OV.sql";
	private final static String PUR_DT_PATH = "classpath:static/20191028_SRM_PUR_DT_OV.sql_V1";
	private final static String GR_PATH = "classpath:static/20191111_SRM_GR_MT_OV3";
	
	private static int MAX = 0;
	@Autowired
	private TestMigMapper testMigMapper;
	
	@Autowired
	private UtilComponent utilComponent;
	
	
	@Autowired
	private TaksRun tr;
	
	
	
	public List<Map<String, Object>> getList() {
		return testMigMapper.selectOne();
	}
	
	@Override
	public void srmDelivyService() {
		
		String getFilePath = DELVY_PATH;
		int excuteCount =500;
		
		BufferedReader bf =utilComponent.streamSql(getFilePath);
		List<SrmDelivyDocMt>  list =new ArrayList<SrmDelivyDocMt>(); 

		String line=null;
		SrmDelivyDocMt srmDelivyDocMt = null;
		int count = 0;
		try {
			while ((line=bf.readLine())!=null) {
				count++;
	
				srmDelivyDocMt = arrayToDelivObject(line.split("\\|"));
				list.add(srmDelivyDocMt);
				
			}
		} catch (IOException e) {
			
				log.info("count : "+ count + "/ Object :" + srmDelivyDocMt);
				e.printStackTrace();
		}
		
		int listSize = list.size();
		
		  for (int i = 0; i <= listSize/excuteCount; i++) {
			  int start = i * excuteCount;
			  int end = (i+1)*excuteCount <= listSize ? ( i+1)*excuteCount : listSize;
			  System.out.println("start: " + start+ "end :"+ end);
			  
			  tr.runDelivyTaskExcute(i, list.subList(start, end)); 
			
			  try { Thread.sleep(100); } catch (Exception e) { e.printStackTrace(); }
			 
		  }
	}
		 

	

	public SrmDelivyDocMt arrayToDelivObject(String[] parser) {
		SrmDelivyDocMt srmDelivyDocMt = null;
		
		try {

			
			
			srmDelivyDocMt = SrmDelivyDocMt.builder()
										.delivyDocNo(parser[0])
										.delivyDocItemNo(parser[1])
										.delivyDocRegDt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(parser[2]))
										.compCd(parser[3])
										.purDocNo(parser[4])
										.purDocItemNo(parser[5])
										.delivyEnableDt(parser[6])
										.mtlNo(parser[7])
										.mtlBrkdn(parser[8])
										.delivyQty(Double.parseDouble(parser[9]))
										.delivyAmt(Double.parseDouble(parser[10]))
										.useYn(parser[11])
										.createId(parser[12])
										.createDt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(parser[13]))
										.modifyDt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(parser[14]))
										.modifyId(parser[15])
										.ifFlag(parser[16]).build();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
				
		return srmDelivyDocMt;
	}


	public void srmPurDocMtService() {
		
		String getFilePath = PUR_MT_PATH;
		int excuteCount =500;
		
		BufferedReader bf =utilComponent.streamSql(getFilePath);
		List<SrmPurDocMt>  list =new ArrayList<SrmPurDocMt>(); 

		String line=null;
		SrmPurDocMt srmPurDocMt = null;
		
		int count = 0;
		try {
			while ((line=bf.readLine())!=null) {
				count++;
				if(count%2==0) {
					 
					srmPurDocMt = arrayToSrmPurMt(utilComponent.lineToArray(line));
					list.add(srmPurDocMt);
				}
			}
		} catch (IOException e) {
				log.error("count : "+ count + "/ Object :" + srmPurDocMt);
			
		}
		  int listSize = list.size();
		  
		  for (int i = 0; i <= listSize/excuteCount; i++) { int start = i *
		  excuteCount; int end = (i+1)*excuteCount <= listSize ? ( i+1)*excuteCount :
		  listSize; System.out.println("start: " + start+ "end :"+ end);
		  
		  tr.runSrmPurMtTaskExcute(i, list.subList(start, end));
		  
		  try { Thread.sleep(100); } catch (Exception e) { e.printStackTrace(); }
		  
		  }
		 
	}
	
	public SrmPurDocMt arrayToSrmPurMt(String[] parser) {
	
		
		SrmPurDocMt srmPurDocMt=null;
		try {
		
		srmPurDocMt = 	srmPurDocMt.builder()
								.purDocNo(parser[0])
								.purOrdbTp(parser[1])
								.compCd(parser[2])
								.purOrg(parser[3])
								.purGrp(parser[4])
								.custmrCd(parser[5])
								.custmrBrkdn(parser[6])
								.printYn(parser[7])
								.readYn(parser[8])
								.purDocConts(parser[9])
								.buyerNm(parser[10])
								.plantBizrNo(parser[11])
								.buyerTel(parser[12])
								.buyerFax(parser[13])
								.purEviDt(parser[14])
								.buyerMail(parser[15])
								
								
								
								.createId(parser[17])
								.modifyId(parser[19])
								.ifFlag(parser[20]).build();
		
		
		if(!"NULL".equals(parser[16])) {
			srmPurDocMt.setCreateDt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(parser[16]));
		} 
		if(!"NULL".equals(parser[18])) {
			srmPurDocMt.setModifyDt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(parser[18]));
		} 
	
		
		} catch (Exception e) {
			System.out.println("MAX:"+MAX);
			e.printStackTrace();
					
		}
		
		return srmPurDocMt;
			
		
	}
	

	
	public void srmPurDocDtService() {

		String getFilePath = PUR_DT_PATH;
		int excuteCount =500;
		
		BufferedReader bf =utilComponent.streamSql(getFilePath);
		List<SrmPurDocDt>  list =new ArrayList<SrmPurDocDt>(); 

		String line=null;
		SrmPurDocDt srPurDocDt = null;
		int count = 0;
		try {
			while ((line=bf.readLine())!=null) {
				count++;
				
					srPurDocDt = arrayToSrmPurDt(utilComponent.lineToArray(line));
					list.add(srPurDocDt);
				
			}
		} catch (IOException e) {
				log.error("count : "+ count + "/ Object :" + srPurDocDt);
			
		}
		
		int listSize = list.size();
		
		  for (int i = 0; i <= listSize/excuteCount; i++) {
			  int start = i * excuteCount;
			  int end = (i+1)*excuteCount <= listSize ? ( i+1)*excuteCount : listSize;
			  System.out.println("start: " + start+ "end :"+ end);
			  
			  tr.runSrmPurDtTaskExcute(i, list.subList(start, end));					
			
			  try { Thread.sleep(100); } catch (Exception e) { e.printStackTrace(); }
			 
		  }
		
	}
	

	public SrmPurDocDt arrayToSrmPurDt(String[] parser) {
		MAX++;
		SrmPurDocDt srmPurDocDt=null;
		try {
		
		srmPurDocDt = 	srmPurDocDt.builder()
											.purDocNo(parser[0])
											.purDocItemNo(parser[1])
											.itemDeliveryDt(parser[2])
											.purEviDt(parser[3])
											.mtlNo(parser[4])
											.mtlBrkdn(parser[5])
											.purOrdbQty(Double.parseDouble(parser[6]))
											.rcvgQty(Double.parseDouble(parser[7]))
											.invcQty(Double.parseDouble(parser[8]))
											.rcvgPlant(parser[9])
											.rcvgStrgLoct(parser[10])
											.issPlant(parser[11])
											.baseUom(parser[12])
											.uPrice(Double.parseDouble(parser[13]))
											.invcAmt(Double.parseDouble(parser[14]))
											.mtlGrp(parser[15])
											.rtnItem(parser[16])
											.purDocConts(parser[17])
											.etcMtr(parser[18])
											.purAmt(Double.parseDouble(parser[19]))
											.priceUnit(parser[20])
											.ordbPriceUnit(parser[21])
											.strgLoctBrkdn(parser[22])
											.purDelFlag(parser[23])
											.purComFlag(parser[24])
											.slocNm(parser[25])
											.purReqUser(parser[26])
											
											.createId(parser[28])
											.modifyId(parser[29])
											.ifFlag(parser[30])
											.build();

		
		
		if(!"NULL".equals(parser[27])) {
			srmPurDocDt.setCreateDt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(parser[27]));
		} 
		if(!"NULL".equals(parser[29])) {
			srmPurDocDt.setModifyDt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(parser[29]));
		} 
	
		
		} catch (Exception e) {
			System.out.println("MAX" + MAX);
			e.printStackTrace();
					
		}
		
		return srmPurDocDt;
			
		
	}
	
	

	
	
	public void srmGrDocService() {

			
			String getFilePath1=GR_PATH+"_V1";
			String getFilePath2=GR_PATH+"_V2";
			String getFilePath3=GR_PATH+"_V3";
			String getFilePath4=GR_PATH+"_V4";
			String getFilePath5=GR_PATH+"_V5";
			
			
			
			
			int excuteCount =500;
			BufferedReader bf1 =utilComponent.streamSql(GR_PATH);
			
		//	BufferedReader bf1 =utilComponent.streamSql(getFilePath1);
		//	BufferedReader bf2 =utilComponent.streamSql(getFilePath2);
		//	BufferedReader bf3 =utilComponent.streamSql(getFilePath3);
		//	BufferedReader bf4 =utilComponent.streamSql(getFilePath4);
		//	BufferedReader bf5 =utilComponent.streamSql(getFilePath5);
			
			List<SrmGrDocMt>  list =new ArrayList<SrmGrDocMt>(); 

			String line=null;
			SrmGrDocMt srmGrDocMt = null;
			int count = 0;
			try {
				while ((line=bf1.readLine())!=null) {
						count++;
						srmGrDocMt = arrayToSrmGrMt(line.split("\\|"));
						list.add(srmGrDocMt);
						System.out.println(count);
				}
				
			} catch (IOException e) {
					log.error("count : "+ count + "/ Object :" + srmGrDocMt);
				
			}
			
			int listSize = list.size();
			
			  for (int i = 0; i <= listSize/excuteCount; i++) {
				  int start = i * excuteCount;
				  int end = (i+1)*excuteCount <= listSize ? ( i+1)*excuteCount : listSize;
				  System.out.println("start: " + start+ "end :"+ end);
				  
				  tr.runSrmGrMtTaskExcute(i, list.subList(start, end));					
				
				 try { Thread.sleep(10); } catch (Exception e) { e.printStackTrace(); }
				 
			  }
			
		
		
		
	}
	
	

	public SrmGrDocMt arrayToSrmGrMt(String[] parser) {
		MAX++;
		SrmGrDocMt srmGrDocMt=null;
		try {
		
			srmGrDocMt = 	SrmGrDocMt.builder()
											.rcvgMtlDoc(parser[0])
											.rcvgDate(parser[1])
											.rcvgMtlDocItem(parser[2])
											.purDocNo(parser[3])
											.purDocItemNo(parser[4])
											.purOrdrDate(parser[5])
											.rcvgPostingDate(parser[6])
											.supplier(parser[7])
											.supplierBrkdn(parser[8])
											.compCd(parser[9])
											.purGrp(parser[10])
											.mtlCd(parser[11])
											.mtlBrkdn(parser[12])
											.rcvgPlant(parser[13])
											.rcvgStrgLoct(parser[14])
											.strgLoctBrkdn(parser[15])
											.rcvgQty(Double.parseDouble(parser[16]))
											.rcvgUom(parser[17])
											.uPrice(Double.parseDouble(parser[18]))
											.rcvgCurr(parser[19])
											.rcvgAmt(Double.parseDouble(parser[20]))
											.invoiceQty(Double.parseDouble(parser[21]))
											.invoiceAmt(Double.parseDouble(parser[22]))
											//.createDt(parser[23])
											.createId(parser[24])
											.modifyId(parser[25])
											//.modifyDt(parser[26])
											.ifFlag(parser[27])
											.build();

		
		
		//if(!"NULL".equals(parser[23])) {
		//	srmGrDocMt.setCreateDt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(parser[23]));
		//} 
		//if(!"NULL".equals(parser[26])) {
		//	srmGrDocMt.setModifyDt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(parser[26]));
		//} 
	
		
		} catch (Exception e) {
			System.out.println("MAX:"+ MAX);
			e.printStackTrace();
					
		}
		
		return srmGrDocMt;
			
		}
	
	

	
	
	
	
	
	
	
	
	
}
