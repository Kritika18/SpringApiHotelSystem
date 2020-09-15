package com.web.HotelBooking.DAOModel;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterModel {
	@NotNull(message="First name cannot be missing or empty")
    @Size(min=2, message="First name must not be less than 2 characters")
	String firstName;
	
	 @NotNull(message="Last name cannot be missing or empty")
	 @Size(min=2, message="Last name must not be less than 2 characters")
	String lastName;
	Integer id;
	
//Integer userId;
    
	
//	public Integer getUserId() {
//	return userId;
//}
//public void setUserId(Integer userId) {
//	this.userId = userId;
//}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Email
	String email;
	String mobile;
	
	 @NotNull(message="Password is a required field")
	 @Size(min=8, max=16, message="Password must be equal to or greater than 8 characters and less than 16 characters")
	String password;
	
	public RegisterModel(String string, int i) {
		// TODO Auto-generated constructor stub
	}
	public RegisterModel() {
		// TODO Auto-generated constructor stub
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


}
