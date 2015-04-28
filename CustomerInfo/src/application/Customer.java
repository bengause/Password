package application;

public class Customer {

	private String firstName;
	private String middleInitial;
	private String lastName;
	private boolean isMale;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	
	Customer(){
		
	}
	
	public Customer(String firstName, String middleInitial, String lastName,
			boolean isMale, String address, String city, String state, 
			String zipCode){
		this.firstName = firstName;
		this.setMiddleInitial(middleInitial);
		this.setLastName(lastName);
		this.setMale(isMale);
		this.setAddress(address);
		this.setCity(city);
		this.setState(state);
		this.setZipCode(zipCode);
	}
	
	public void setfirstName(String firstName){
		this.firstName = firstName;
	}
	
	public String getfirstName(){
		return firstName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	
	
	
}
