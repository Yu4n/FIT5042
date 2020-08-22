/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Guan
 */
@RequestScoped
@Named(value = "property")
public class Property implements Serializable {
	private int propertyId;
	private Double size;
	private Integer numberOfBedrooms;
	private Double price;

	private Address address;
	private ContactPerson contactPerson;

	private HashSet<String> tags;

	private String streetNumber;
	private String streetAddress;
	private String suburb;
	private String postcode;
	private String state;

	private int conactPersonId;
	private String name;
	private String phoneNumber;

	public Property() {
		this.tags = new HashSet<>();
	}

	// non-defaut constructor
	public Property(int propertyId, Address address, Integer numberOfBedrooms, Double size, Double price,
			ContactPerson contactPerson, Set<String> tags) {
		this.propertyId = propertyId;
		this.address = address;
		this.size = size;
		this.numberOfBedrooms = numberOfBedrooms;
		this.price = price;
		this.contactPerson = contactPerson;
		this.tags = (HashSet<String>) tags;
	}

	// =================================================================================
	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getConactPersonId() {
		return conactPersonId;
	}

	public void setConactPersonId(int conactPersonId) {
		this.conactPersonId = conactPersonId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	// ==================================================================================

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public Integer getNumberOfBedrooms() {
		return numberOfBedrooms;
	}

	public void setNumberOfBedrooms(Integer numberOfBedrooms) {
		this.numberOfBedrooms = numberOfBedrooms;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public ContactPerson getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(ContactPerson contactPerson) {
		this.contactPerson = contactPerson;
	}

	public HashSet<String> getTags() {
		return tags;
	}

	public void setTags(HashSet<String> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Property{" + "propertyId=" + propertyId + ", size=" + size + ", numberOfBedrooms=" + numberOfBedrooms
				+ ", price=" + price + ", address=" + address + ", contactPerson=" + contactPerson + ", tags=" + tags
				+ '}';
	}
}
