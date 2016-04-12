package it.netgrid.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="customers")
public class Customer {

	public static final String ID_FIELD_NAME="customer_id";
	public static final String CUSTOMER_NAME_FIELD_NAME="customer_name";
	public static final String SURNAME_FIELD_NAME="customer_surname";
	public static final String BIRTHDATE_FIELD_NAME = "customer_birthdate";
	public static final String TYPE_FIELD_NAME = "customer_type";
	public static final String ADDRESS_ROAD_FIELD_NAME = "customer_address_road";
	public static final String	MAIL_ADDRESS_FIELD_NAME = "customer_mail_address";
	public static final String PHONE_FIELD_NAME = "customer_phone_number";
	public static final String ADDRESS_NUM_FIELD_NAME = "customer_address_num";
	public static final String ADDRESS_CITY_FIELD_NAME = "customer_address_city";
	public static final String ADDRESS_ZIP_FIELD_NAME = "customer_address_zip";
	public static final String ADDRESS_COUNTRY_FIELD_NAME = "customer_address_country";
	
	@Id
	@GeneratedValue
	@Column(name=ID_FIELD_NAME)
	private long id;
	
	@Column(name=CUSTOMER_NAME_FIELD_NAME)
	private String name;
	
	@Column(name=SURNAME_FIELD_NAME)
	private String private_surname;
	
	@Column(name=BIRTHDATE_FIELD_NAME)
	private Date private_birthDate;
	
	@Column(name=TYPE_FIELD_NAME)
	private char type;
	
	@Column(name=ADDRESS_ROAD_FIELD_NAME)
	private String address_road;
	
	@Column(name=ADDRESS_NUM_FIELD_NAME)
	private String address_num;
	
	@Column(name=ADDRESS_CITY_FIELD_NAME)
	private String address_city;
	
	@Column(name=ADDRESS_ZIP_FIELD_NAME)
	private String address_zip;
	
	@Column(name=ADDRESS_COUNTRY_FIELD_NAME)
	private String address_country;
	
	
	@Column(name=MAIL_ADDRESS_FIELD_NAME)
	private String mail_address;
	
	@Column(name=PHONE_FIELD_NAME)
	private int phone_number;
	
	
	
	public Customer(){};
	
	//costruttre di customer
	public Customer(long id, 
					char type, 
					String name, 
					String private_surname, 
					Date private_birthDate, 
					String address_road,
					String address_num,
					String address_city,
					String address_zip,
					String address_country,
					String mail_address,
					int phone_number)
	{
		
		this.id=id;
		this.type=type;
		this.name=name;
		this.private_surname=private_surname;
		this.private_birthDate=private_birthDate;
		this.address_road=address_road;
		this.address_num=address_num;
		this.address_city=address_city;
		this.address_zip=address_zip;
		this.address_country=address_country;
		this.mail_address=mail_address;
		this.phone_number=phone_number;
	}

	
	//getters & setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrivate_surname() {
		return private_surname;
	}

	public void setPrivate_surname(String private_surname) {
		this.private_surname = private_surname;
	}

	public Date getPrivate_birthDate() {
		return private_birthDate;
	}

	public void setPrivate_birthDate(Date private_birthDate) {
		this.private_birthDate = private_birthDate;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public String getAddress_road() {
		return address_road;
	}

	public void setAddress_road(String address_road) {
		this.address_road = address_road;
	}

	public String getAddress_num() {
		return address_num;
	}

	public void setAddress_num(String address_num) {
		this.address_num = address_num;
	}

	public String getAddress_city() {
		return address_city;
	}

	public void setAddress_city(String address_city) {
		this.address_city = address_city;
	}

	public String getAddress_zip() {
		return address_zip;
	}

	public void setAddress_zip(String address_zip) {
		this.address_zip = address_zip;
	}

	public String getAddress_country() {
		return address_country;
	}

	public void setAddress_country(String address_country) {
		this.address_country = address_country;
	}

	public String getMail_address() {
		return mail_address;
	}

	public void setMail_address(String mail_address) {
		this.mail_address = mail_address;
	}

	public int getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}
	
	
}

