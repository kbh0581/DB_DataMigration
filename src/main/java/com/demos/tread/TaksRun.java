package com.demos.tread;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.demos.dao.TestMigMapper;
import com.demos.vo.SrmDelivyDocMt;
import com.demos.vo.SrmGrDocMt;
import com.demos.vo.SrmPurDocDt;
import com.demos.vo.SrmPurDocMt;


@Component
public class TaksRun {
	
	@Autowired
	private TestMigMapper testMapper;
	
	
	@Async("migDelvyExcute")
	public void runDelivyTaskExcute(int i,List<SrmDelivyDocMt> list) {
		System.out.println(i + "번쨰 수행중" );
		try {
			
			Thread.sleep(10);
			testMapper.inserDelvy(list);
			System.out.println(i + "번쨰 수행끝" );
		} catch (Exception e) {
			System.out.println("@@@@@@@"+i+"[ 수행 중 에러 ]");
			e.printStackTrace();
		}
		
	}
	
	@Async("migPurMtExcute")
	public void runSrmPurMtTaskExcute(int i,List<SrmPurDocMt> list) {
		System.out.println(i + "번쨰 수행중 SrmPurMt" );
		try {
			Thread.sleep(10);
			testMapper.inserPurMt(list);
			System.out.println(i + "번쨰 수행끝 SrmPurMt" );
		} catch (Exception e) {
			System.out.println("@@@@@@@"+i+"[ 수행 중 에러 ]");
			e.printStackTrace();
		}
		
	}
	
	@Async("migPurDtExcute")
	public void runSrmPurDtTaskExcute(int i,List<SrmPurDocDt> list) {
		System.out.println(i + "번쨰 수행중 SrmPurDt" );
		try {
			Thread.sleep(10);
			testMapper.inserPurDt(list);
			System.out.println(i + "번쨰 수행끝 SrmPurDt" );
		} catch (Exception e) {
			System.out.println("@@@@@@@"+i+"[ 수행 중 에러 ]");
			e.printStackTrace();
		}
		
	}
	
	@Async("migGrExcute")
	public void runSrmGrMtTaskExcute(int i,List<SrmGrDocMt> list) {
		System.out.println(i + "번쨰 수행중 SrmPurDt" );
		try {
			Thread.sleep(100);
			
			testMapper.inserGrMtV1(list);
			/*
			
			
			switch (i%5) {
				case 0 :
					testMapper.inserGrMtV1(list);
					break;
				case 1 :
					testMapper.inserGrMtV2(list);
					break;
				case 2 :
					testMapper.inserGrMtV3(list);
					break;
				case 3 :
					testMapper.inserGrMtV4(list);
					break;
				case 4 :
					testMapper.inserGrMtV5(list);
					break;
				default :
					break;
			}
			*/
			System.out.println(i + "번쨰 수행끝 migGrExcute CASE :"+ i %5 );
		} catch (Exception e) {
			System.out.println("@@@@@@@"+i+"[ 수행 중 에러 ]");
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
}
