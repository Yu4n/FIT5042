package fit5042.tutex.repository.entities;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Eddie Leung
 */
@Embeddable
@Access(AccessType.PROPERTY)
public class Address implements Serializable {

    private String streetNumber;
    private String streetAddress;
    private String suburb;
    private String postcode;
    private String state;

    public Address() {
    }

    public Address(String streetNumber, String streetAddress, String suburb, String postcode, String state) {
        this.streetNumber = streetNumber;
        this.streetAddress = streetAddress;
        this.suburb = suburb;
        this.postcode = postcode;
        this.state = state;
    }

    @Column(name = "street_number")
    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    //complete by adding annotation here for column name = "street_address"
    @Column(name = "street_address")
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    @Column(name = "suburb")
    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    //complete by adding annotation here for column name = "postcode"
    @Column(name = "postcode")
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return streetNumber + " " + streetAddress + ", " + suburb + ", " + state + " " + postcode;
    }
}
