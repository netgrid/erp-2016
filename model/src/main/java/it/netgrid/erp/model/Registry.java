package it.netgrid.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="registries")
public class Registry {

	public static final String ID_FIELD_NAME="reg_id";
	public static final String REGISTRY_NAME_FIELD_NAME="reg_name";
	public static final String SURNAME_FIELD_NAME="reg_surname";
	public static final String BIRTHDATE_FIELD_NAME = "reg_birthdate";
	public static final String TYPE_FIELD_NAME = "reg_type";
	public static final String ADDRESS_ROAD_FIELD_NAME = "reg_address_road";
	public static final String MAIL_ADDRESS_FIELD_NAME = "reg_mail_address";
	public static final String PHONE_FIELD_NAME = "reg_phone_number";
	public static final String ADDRESS_NUM_FIELD_NAME = "reg_address_num";
	public static final String ADDRESS_CITY_FIELD_NAME = "reg_address_city";
	public static final String ADDRESS_ZIP_FIELD_NAME = "reg_address_zip";
	public static final String ADDRESS_COUNTRY_FIELD_NAME = "reg_address_country";
	
	@Id
	@GeneratedValue
	@Column(name=ID_FIELD_NAME)
	private long id;
	
	@Column(name=REGISTRY_NAME_FIELD_NAME)
	private String name;
	
	@Column(name=SURNAME_FIELD_NAME)
	private String privateSurname;
	
	@Column(name=BIRTHDATE_FIELD_NAME)
	private Date privateBirthDate;
	
	@Column(name=TYPE_FIELD_NAME)
	private char type;
	
	@Column(name=ADDRESS_ROAD_FIELD_NAME)
	private String addressRoad;
	
	@Column(name=ADDRESS_NUM_FIELD_NAME)
	private String addressNum;
	
	@Column(name=ADDRESS_CITY_FIELD_NAME)
	private String addressCity;
	
	@Column(name=ADDRESS_ZIP_FIELD_NAME)
	private String addressZip;
	
	@Column(name=ADDRESS_COUNTRY_FIELD_NAME)
	private String addressCountry;
	
	
	@Column(name=MAIL_ADDRESS_FIELD_NAME)
	private String mailAddress;
	
	@Column(name=PHONE_FIELD_NAME)
	private String phoneNumber;
	
	
	
	public Registry(){};
	
	//costruttre di Registry
	public Registry(long id, 
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
					String phone_number)
	{
		
		this.id=id;
		this.type=type;
		this.name=name;
		this.privateSurname=private_surname;
		this.privateBirthDate=private_birthDate;
		this.addressRoad=address_road;
		this.addressNum=address_num;
		this.addressCity=address_city;
		this.addressZip=address_zip;
		this.addressCountry=address_country;
		this.mailAddress=mail_address;
		this.phoneNumber=phone_number;
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

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public String getPrivateSurname() {
		return privateSurname;
	}

	public void setPrivateSurname(String privateSurname) {
		this.privateSurname = privateSurname;
	}

	public Date getPrivateBirthDate() {
		return privateBirthDate;
	}

	public void setPrivateBirthDate(Date privateBirthDate) {
		this.privateBirthDate = privateBirthDate;
	}

	public String getAddressRoad() {
		return addressRoad;
	}

	public void setAddressRoad(String addressRoad) {
		this.addressRoad = addressRoad;
	}

	public String getAddressNum() {
		return addressNum;
	}

	public void setAddressNum(String addressNum) {
		this.addressNum = addressNum;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressZip() {
		return addressZip;
	}

	public void setAddressZip(String addressZip) {
		this.addressZip = addressZip;
	}

	public String getAddressCountry() {
		return addressCountry;
	}

	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	
}

