package com.cg.cropbiddinginsuranceapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Bank {
	
	@Id
	private long bankId;
	private String bankName;
	private String IFSCCode;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="BankPlotNo",referencedColumnName="houseno")
	private Address address;
	
	//Constructors
	public Bank(){}
	
	public Bank(long bankId, String bankName,String IFSCCode)
	{
		this.bankId=bankId;
		this.bankName=bankName;
		this.IFSCCode=IFSCCode;
	}
	
	//Getters and Setters
	public long getBankId() {
		return bankId;
	}
	public void setBankId(long bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getIFSCCode() {
		return IFSCCode;
	}
	public void setIFSCCode(String IFSCCode) {
		this.IFSCCode = IFSCCode;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", IFSCCode=" + IFSCCode + ", address=" + address
				+ "]";
	}
}
