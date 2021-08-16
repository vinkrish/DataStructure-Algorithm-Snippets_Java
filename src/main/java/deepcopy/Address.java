package deepcopy;

import java.io.Serializable;

/**
 * 
 * https://www.baeldung.com/java-deep-copy
 *
 */
public class Address implements Serializable, Cloneable {

	// Cloneable Interface way of deep copy
    @Override
    public Object clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Address(this.street, this.getCity(), this.getCountry());
        }
    }

    private static final long serialVersionUID = 1740913841244949416L;
    private String street;
    private String city;

    private String country;

    // Copy constructor way of deep copy
    public Address(Address that) {
        this(that.getStreet(), that.getCity(), that.getCountry());
    }

    public Address(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public Address() {}

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}