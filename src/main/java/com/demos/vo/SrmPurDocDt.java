package com.demos.vo;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class SrmPurDocDt {
	
	
	private String purDocNo;
	private String purDocItemNo;
	private String itemDeliveryDt;
	private String purEviDt;
	private String mtlNo;
	private String mtlBrkdn;
	private double purOrdbQty;
	private double rcvgQty;
	private double invcQty;
	private String rcvgPlant;
	private String rcvgStrgLoct;
	private String issPlant;
	private String baseUom;
	private double uPrice;
	private double invcAmt;
	private String mtlGrp;
	private String rtnItem;
	private String purDocConts;
	private String etcMtr;
	private double purAmt;
	private String priceUnit;
	private String ordbPriceUnit;
	private String strgLoctBrkdn;
	private String purDelFlag;
	private String purComFlag;
	private String slocNm;
	private String purReqUser;
	private Date createDt;
	private String createId;
	private Date modifyDt;
	private String modifyId;
	private String ifFlag;

	
	
	
	


}
