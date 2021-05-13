package com.cg.cropbiddinginsuranceapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name ="Person")
@Inheritance
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	private String name;
	private String contactNumber;
	private String emailId;
	private String aadharNumber;
    private String panNumber;
    
    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="HomeNo", referencedColumnName="houseno")
	private Address homeAddress;
    
    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="accountId",referencedColumnName="accountId")
    private Account bankDetails;
    
    //Constructors
    public Person() {}
    
    public Person(String name, String contactNumber, String emailId,String aadharNumber,String panNumber)
	{
		this.name=name;
		this.contactNumber=contactNumber;
		this.emailId=emailId;
		this.aadharNumber=aadharNumber;
		this.panNumber=panNumber;
	}
	
	//Getters and Setters
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Account getBankDetails() {
		return bankDetails;
	}
	public void setBankDetails(Account bankDetails) {
		this.bankDetails = bankDetails;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	/*@Override
	public String toString() {
		return "Person [userId=" + userId + ", name=" + name + ", contactNumber=" + contactNumber + ", emailId="
				+ emailId + ", aadharNumber=" + aadharNumber + ", panNumber=" + panNumber + "]";
	}*/

	@Override
	public String toString() {
		return "Person [userId=" + userId + ", name=" + name + ", contactNumber=" + contactNumber + ", emailId="
				+ emailId + ", aadharNumber=" + aadharNumber + ", panNumber=" + panNumber + ", homeAddress="
				+ homeAddress + ", bankDetails=" + bankDetails + "]";
	}

	/*@Override
	public String toString() {
		return "Person [userId=" + userId + ", name=" + name + ", contactNumber=" + contactNumber + ", emailId="
				+ emailId + ", aadharNumber=" + aadharNumber + ", panNumber=" + panNumber + ", homeAddress="
				+ homeAddress + "]";
	}*/
	
	
	

}
