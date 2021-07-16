package rain;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;



/*
 * 
 * TODO 
 * 
 * Define a class named EnquiryCommand that:
 * 
 * 	a. Implements the Serializable interface
 *  b. Has the following properties, all of type String
 *     
 *     1  name
 *     2  email
 *     3  telephone
 *     4  enquiryDetails
 * 
 * 
 * Add the NotEmpty JSR 303 validation rule to the name,
 * email and enquiryDetails fields. Choose a suitable
 * message to display in the event of validation failure 
 * 
 */
public class EnquiryCommand implements Serializable{
	
	@NotEmpty(message="Name must be provided")
	private String name;
	
	@NotEmpty(message="Email must be provided")
	private String email;
	
	private String telephone;
	
	@NotEmpty(message="EnquiryDetails must be provided")
	private String enquiryDetails;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEnquiryDetails() {
		return enquiryDetails;
	}
	public void setEnquiryDetails(String enquiryDetails) {
		this.enquiryDetails = enquiryDetails;
	}
	
}
