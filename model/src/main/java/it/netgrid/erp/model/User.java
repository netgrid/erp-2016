package it.netgrid.erp.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "users")
public class User {
	public static final String ID_FIELD_NAME = "usr_id";
	public static final String USER_NAME_FIELD_NAME = "usr_username";
	public static final String PASSWORD_FIELD_NAME = "usr_password";
	public static final String ROLE_FIELD_NAME = "usr_role";
	public static final String DATE_ADMISSION_FIELD_NAME = "usr_date_admission";
	public static final String TAX_CODE_FIELD_NAME = "usr_tax_code";
	public static final String STREET_FIELD_NAME = "usr_street";
	public static final String HOUSE_NUMBER_FIELD_NAME = "usr_hause_number";
	public static final String CITY_FIELD_NAME = "usr_city";
	public static final String DATE_OF_BIRTH_FIELD_NAME = "usr_date_of_birth";
	
	@Id
	@GeneratedValue
	@Column(name = ID_FIELD_NAME)
	private Long id;
	
	@Column(name = USER_NAME_FIELD_NAME, unique=true)
	private String username;
	
	@Column(name = PASSWORD_FIELD_NAME)
	private String passsword;
	@Column(name = ROLE_FIELD_NAME)
	private String role;
	@Column(name = DATE_ADMISSION_FIELD_NAME)
	private Date dateAdmission;
	@Column(name = TAX_CODE_FIELD_NAME)
	private String taxCode;
	@Column(name = STREET_FIELD_NAME)
	private String street;
	@Column(name = HOUSE_NUMBER_FIELD_NAME)
	private String houseNumber;
	@Column(name = CITY_FIELD_NAME)
	private String city;
	@Column(name = DATE_OF_BIRTH_FIELD_NAME)
	private Date dateOfBirth;
	
	public User() {}
	
	public User (String username, String password, String role, Date dateAdmission, String taxCode, String street, String houseNumber, String city, Date dateOfBirth){
		this.username = username;
		this.passsword = password;
		this.role = role;
		this.dateAdmission = dateAdmission;
		this.taxCode = taxCode;
		this.street = street;
		this.houseNumber = houseNumber;
		this.city = city;
		this.dateOfBirth = dateOfBirth;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasssword() {
		return passsword;
	}

	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getDateAdmission() {
		return dateAdmission;
	}

	public void setDateAdmission(Date dateAdmission) {
		this.dateAdmission = dateAdmission;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
