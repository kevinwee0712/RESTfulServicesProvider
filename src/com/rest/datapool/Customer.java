package com.rest.datapool;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Customer class with four fields
 * 
 *  customerID:  An unique number to identify customer
 *  customerName: Customer's Name
 *  customerAddress: Customer's Personal/Business Address
 *  customerPhoneNumber: Customer's Phone Number
 * 
 * @author Ping Yang(Kevin) Wei
 * @since 2015-09-02
 */

@XmlRootElement
public class Customer {

	private String customerID;
    private String customerName;  
    private String customerAddress;  
    private String customerPhoneNumber;  
    
      
    public Customer() {};  
      
    public Customer(String customerName, String customerAddress, String customerPhoneNumber) {  
        this.setCustomerName(customerName);  
        this.setCustomerAddress(customerAddress);  
        this.setCustomerPhoneNumber(customerPhoneNumber);  
        this.customerID = IdFactory.getInstance().generate();
    }

	public String getCustomerName() {
		return customerName;
	}

	private void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	private void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	private void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getCustomerID() {
		return customerID;
	}
	
	@Override
	public String toString() {
		return "{\"customerID\":\"" + customerID + "\",\"customerName\":\"" + customerName + "\",\"" +
				"customerAddress\":\"" + customerAddress + "\",\"customerPhoneNumber\":\"" + customerPhoneNumber + "\"}";
	}
	
	
	@Override
	public boolean equals(Object o) {
		
		if (o instanceof Customer) {
			
			Customer customer =(Customer) o;
			if (this.customerID.equals(customer.customerID) && 
					this.customerName.equals(customer.customerName) &&
						this.customerAddress.equals(customer.customerAddress) &&
							this.customerPhoneNumber.equals(customer.customerPhoneNumber)) {
				return true;
			}
		}
		return false;
		
	}
	
	@Override
	public int hashCode(){
		return 1;
	};
}
