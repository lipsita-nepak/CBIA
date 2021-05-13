package com.cg.cropbiddinginsuranceapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Farmer")
@DiscriminatorValue("Farmer")
public class Farmer extends Person {
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="FarmNo",referencedColumnName="houseno")
	private Address farmAddress;

	
	    //Constructors
		public Farmer(){}
		
		public Farmer( String name, String contactNumber, String emailId,String aadharNumber,String panNumber)
		{
			super(name,contactNumber,emailId,aadharNumber,panNumber);
		}
		
		//Getters and Setters
		public Address getFarmAddress() {
			return farmAddress;
		}
		public void setFarmAddress(Address farmAddress) {
			this.farmAddress = farmAddress;
		}
		@Override
		public String toString() {
			return "Farmer [farmAddress=" + farmAddress + "]";
		}
		

}
