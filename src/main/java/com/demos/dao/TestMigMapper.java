package com.demos.dao;

import java.util.List;
import java.util.Map;

import com.demos.vo.SrmDelivyDocMt;
import com.demos.vo.SrmGrDocMt;
import com.demos.vo.SrmPurDocDt;
import com.demos.vo.SrmPurDocMt;

public interface TestMigMapper {
	
	public List<Map<String, Object>> selectOne();
	
	public void inserDelvy(List<SrmDelivyDocMt> srmDelivyDocMts);
	
	public void inserPurMt(List<SrmPurDocMt> srmPurDocMts);
	
	public void inserPurDt(List<SrmPurDocDt> srmPurDocDts);
	
	public void inserGrMtV1(List<SrmGrDocMt> srmGrDocMts);
	public void inserGrMtV2(List<SrmGrDocMt> srmGrDocMts);
	public void inserGrMtV3(List<SrmGrDocMt> srmGrDocMts);
	public void inserGrMtV4(List<SrmGrDocMt> srmGrDocMts);
	public void inserGrMtV5(List<SrmGrDocMt> srmGrDocMts);

}
