package lt.viko.eif.gmauza.librarymanagementfop.model;

import javax.persistence.*;

/**
 * Represents a librarian in a library system. A librarian is a person who manages
 * the activities of a library, such as checking out books, assisting customers,
 * and managing inventory.
 * This class is annotated with JPA annotations to be used as an entity in a relational database.
 */
@Entity
@Table(name = "librarian")
public class Librarian {
    /**
     * The unique identifier of this librarian.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * The first name of this librarian.
     */
    private String name;

    /**
     * The last name of this librarian.
     */
    private String lastName;

    /**
     * The phone number of this librarian.
     */
    private String phoneNumber;

    /**
     * The email address of this librarian.
     */
    private String email;

    /**
     * Creates a new Librarian object with default values for the instance variables.
     * Use the setter methods to set the values of the instance variables later on.
     */

    public Librarian() {
    }

    /**
     * Creates a new Librarian object with the given parameters.
     *
     * @param name        The first name of the librarian.
     * @param lastName    The last name of the librarian.
     * @param phoneNumber The phone number of the librarian.
     * @param email       The email address of the librarian.
     */

    public Librarian(String name, String lastName, String phoneNumber, String email) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * Creates a new Librarian object with the given parameters.
     * This constructor should be used when creating a Librarian object from data
     * retrieved from a database.
     *
     * @param id          The unique identifier of the librarian.
     * @param name        The first name of the librarian.
     * @param lastName    The last name of the librarian.
     * @param phoneNumber The phone number of the librarian.
     * @param email       The email address of the librarian.
     */

    public Librarian(int id, String name, String lastName, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Creates a formatted string representation of the object instance variables.
     *
     * @return A string representing the instance variables of the object.
     */
    @Override
    public String toString() {
        return String.format("Librarian: " +
                        "\n\t\tID = %s" +
                        "\n\t\tName = %s" +
                        "\n\t\tLast name = %s" +
                        "\n\t\tPhone = %s" +
                        "\n\t\tEmail = %s",
                this.id, this.name, this.lastName, this.phoneNumber, this.email);
    }
}
