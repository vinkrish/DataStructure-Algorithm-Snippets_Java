package deepcopy;

import java.io.Serializable;

/**
 * 
 * https://www.baeldung.com/java-deep-copy
 * 
 * Sometimes we can't add an additional constructor or override the clone method, in those cases use following ways:
 * 
 * Apache Commons Lang has SerializationUtils#clone 
 * which performs a deep copy when all classes in the object graph implement the Serializable interface.
 * 
 * GSON does not need the Serializable interface to make the conversions
 * 
 * Jackson will be very similar to the one using Gson, but we need to add the default constructor to our classes
 *
 */
public class User implements Serializable, Cloneable {

    private static final long serialVersionUID = -3427002229954777557L;
    private String firstName;
    private String lastName;
    private Address address;

    public User(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    // Copy constructor way of deep copy
    public User(User that) {
        this(that.getFirstName(), that.getLastName(), new Address(that.getAddress()));
    }

    public User() {}

    // Cloneable Interface way of deep copy
    @Override
    public Object clone() {
        User user;
        try {
            user = (User) super.clone();
        } catch (CloneNotSupportedException e) {
            user = new User(this.getFirstName(), this.getLastName(), this.getAddress());
        }
        user.address = (Address) this.address.clone();
        return user;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }
}