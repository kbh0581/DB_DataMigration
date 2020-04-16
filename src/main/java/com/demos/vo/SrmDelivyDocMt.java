package com.demos.vo;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class SrmDelivyDocMt {
	
	
	private String  delivyDocNo;
	private String delivyDocItemNo;
	private Date delivyDocRegDt;
	private String purReqUser;
	private String compCd;
	private String purDocNo;
	private String purDocItemNo;
	private String delivyEnableDt;
	private String mtlNo;
	private String mtlBrkdn;
	private double delivyQty;
	private double delivyAmt;
	private String useYn;
	private String createId;
	private Date createDt;
	private Date modifyDt;
	private String modifyId;
	private String ifFlag;


}
