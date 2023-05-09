package lt.viko.eif.gmauza.librarymanagementws.model;

import javax.persistence.*;
import java.util.List;

/**
 * Represents a subscriber in the library system.
 */
@Entity
@Table(name = "subscriber")
public class Subscriber {

    /**
     * The id of the subscriber.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * The first name of the subscriber.
     */
    private String name;

    /**
     * The last name of the subscriber.
     */
    private String lastName;

    /**
     * The address of the subscriber.
     */
    private String address;

    /**
     * The phone number of the subscriber.
     */
    private String phone;

    /**
     * The email address of the subscriber.
     */
    private String email;

    /**
     * The list of borrowings associated with the subscriber.
     */
    @OneToMany(targetEntity = Borrowing.class, cascade = CascadeType.ALL)
    private List<Borrowing> borrowing;

    /**
     * Creates a new subscriber instance with default values.
     */
    public Subscriber() {
    }

    /**
     * Creates a new subscriber instance with specified values for all fields.
     *
     * @param name      The first name of the subscriber.
     * @param lastName  The last name of the subscriber.
     * @param address   The address of the subscriber.
     * @param phone     The phone number of the subscriber.
     * @param email     The email address of the subscriber.
     * @param borrowing The list of borrowings associated with the subscriber.
     */
    public Subscriber(String name, String lastName, String address, String phone, String email, List<Borrowing> borrowing) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.borrowing = borrowing;
    }

    /**
     * Creates a new subscriber instance with specified values for all fields.
     *
     * @param id        The id of the subscriber.
     * @param name      The first name of the subscriber.
     * @param lastName  The last name of the subscriber.
     * @param address   The address of the subscriber.
     * @param phone     The phone number of the subscriber.
     * @param email     The email address of the subscriber.
     * @param borrowing The list of borrowings associated with the subscriber.
     */
    public Subscriber(int id, String name, String lastName, String address, String phone, String email, List<Borrowing> borrowing) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.borrowing = borrowing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Borrowing> getBorrowing() {
        return borrowing;
    }

    public void setBorrowing(List<Borrowing> borrowing) {
        this.borrowing = borrowing;
    }

    /**
     * Creates a formatted string representation of the object instance variables.
     *
     * @return A string representing the instance variables of the object.
     */
    @Override
    public String toString() {
        return String.format("\n\t\t\tSubscriber: " +
                        "\n\t\t\t\tID = %s" +
                        "\n\t\t\t\tName = %s" +
                        "\n\t\t\t\tLast name = %s" +
                        "\n\t\t\t\tAddress = %s" +
                        "\n\t\t\t\tPhone = %s" +
                        "\n\t\t\t\tEmail = %s" +
                        "\n\t\t\t\tBorrowings: %s",
                this.id, this.name, this.lastName, this.address, this.phone, this.email, constructBorrowingList());
    }

    private Object constructBorrowingList() {
        String result = "";
        for (Borrowing borrowing : this.borrowing) {
            result += borrowing.toString();
        }
        return result;
    }
}
