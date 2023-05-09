package lt.viko.eif.gmauza.librarymanagementfop.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * A class representing a library.
 */
@Entity
@Table(name = "library")
@XmlRootElement(name = "library")
public class Library {

    /**
     * The unique identifier of the library.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    /**
     * The name of the library.
     */
    private String name;

    /**
     * The address of the library.
     */
    private String address;

    /**
     * The work hours of the library.
     */
    private String workHours;

    /**
     * The list of subscribers that are registered to the library.
     */

    @OneToMany(targetEntity = Subscriber.class, cascade = CascadeType.ALL)
    private List<Subscriber> subscribers;

    /**
     * The librarian who manages the library.
     */
    @OneToOne(targetEntity = Librarian.class, cascade = CascadeType.ALL)
    private Librarian librarian;

    /**
     * Constructs a new Library object.
     */
    public Library() {
    }

    /**
     * Constructs a new Library object with the specified parameters.
     *
     * @param name        the name of the library
     * @param address     the address of the library
     * @param workHours   the work hours of the library
     * @param librarian   the librarian who manages the library
     * @param subscribers the list of subscribers that are registered to the library
     */
    public Library(String name, String address, String workHours, Librarian librarian, List<Subscriber> subscribers) {
        this.name = name;
        this.address = address;
        this.workHours = workHours;
        this.subscribers = subscribers;
        this.librarian = librarian;
    }

    /**
     * Constructs a new Library object with the specified parameters.
     *
     * @param id          the unique identifier of the library
     * @param name        the name of the library
     * @param address     the address of the library
     * @param workHours   the work hours of the library
     * @param librarian   the librarian who manages the library
     * @param subscribers the list of subscribers that are registered to the library
     */
    public Library(int id, String name, String address, String workHours, Librarian librarian, List<Subscriber> subscribers) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.workHours = workHours;
        this.subscribers = subscribers;
        this.librarian = librarian;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkHours() {
        return workHours;
    }

    public void setWorkHours(String workHours) {
        this.workHours = workHours;
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    /**
     * Creates a formatted string representation of the object instance variables.
     *
     * @return A string representing the instance variables of the object.
     */
    @Override
    public String toString() {
        return String.format("Library: " +
                        "\n\tID = %s" +
                        "\n\tName = %s" +
                        "\n\tAddress = %s" +
                        "\n\tWork Hours = %s" +
                        "\n\t%s" +
                        "\n\t\tSubscribers: %s",
                this.id, this.name, this.address, this.workHours, this.librarian, constructSubscriberList());
    }

    private Object constructSubscriberList() {
        String result = "";
        for (Subscriber subject : this.subscribers) {
            result += subject.toString();
        }
        return result;
    }
}
