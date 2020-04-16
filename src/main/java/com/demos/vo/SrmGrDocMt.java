package com.demos.vo;

import java.util.Date;

import com.demos.vo.SrmPurDocDt.SrmPurDocDtBuilder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SrmGrDocMt {
	
	private String rcvgMtlDoc;
	private String rcvgDate;
	private String rcvgMtlDocItem;
	private String purDocNo;
	private String purDocItemNo;
	private String purOrdrDate;
	private String rcvgPostingDate;
	private String supplier;
	private String supplierBrkdn;
	private String compCd;
	private String purGrp;
	private String mtlCd;
	private String mtlBrkdn;
	private String rcvgPlant;
	private String rcvgStrgLoct;
	private String strgLoctBrkdn;
	private double rcvgQty;
	private String rcvgUom;
	private double uPrice;
	private String rcvgCurr;
	private double rcvgAmt;
	private double invoiceQty;
	private double invoiceAmt;
	private Date createDt;
	private String createId;
	private String modifyId;
	private Date modifyDt;
	private String ifFlag;


}
