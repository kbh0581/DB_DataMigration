package com.demos.vo;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class SrmPurDocMt {
	
	private String purDocNo;
	private String purOrdbTp;
	private String compCd;
	private String purOrg;
	private String purGrp;
	private String custmrCd;
	private String custmrBrkdn;
	private String printYn;
	private String readYn;
	private String purDocConts;
	private String buyerNm;
	private String plantBizrNo;
	private String buyerTel;
	private String buyerFax;
	private String purEviDt;
	private String buyerMail;
	private Date createDt;
	private String createId;
	private Date modifyDt;
	private String modifyId;
	private String ifFlag;

	

}
