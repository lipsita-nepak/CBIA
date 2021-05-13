package com.cg.cropbiddinginsuranceapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Account {
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="bankId",referencedColumnName="bankId")
	private Bank bank;
	
	@Id
    private long accountId;
    
  //Constructors
    public Account(){}
    public Account(long accountId)
    {
    	this.accountId=accountId;
    }
    
  //Getters and Setters
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	@Override
	public String toString() {
		return "Account [bank=" + bank + ", accountId=" + accountId + "]";
	}
}
