package lt.viko.eif.gmauza.librarymanagementfop.model;


import javax.persistence.*;

/**
 * Represents an item in a library.
 * This class is annotated with JPA annotations to be used as an entity in a relational database.
 */
@Entity
@Table(name = "item")
public class Item {

    /**
     * The unique identifier for this item.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    /**
     * The title of this item.
     */
    private String title;
    /**
     * The author of this item.
     */
    private String author;
    /**
     * The publisher of this item.
     */
    private String publisher;
    /**
     * The production year of this item.
     */
    private int productionYear;
    /**
     * The number of copies of this item in the library.
     */
    private int copiesNumber;
    /**
     * The availability status of this item.
     */
    private boolean status;

    /**
     * Creates a new instance of the Item class.
     */
    public Item() {
    }

    /**
     * Creates a new instance of the Item class with the specified parameters.
     *
     * @param title          the title of the item
     * @param author         the author of the item
     * @param publisher      the publisher of the item
     * @param productionYear the production year of the item
     * @param copiesNumber   the number of copies of the item in the library
     * @param status         the availability status of the item
     */
    public Item(String title, String author, String publisher, int productionYear, int copiesNumber, boolean status) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.productionYear = productionYear;
        this.copiesNumber = copiesNumber;
        this.status = status;
    }

    /**
     * Creates a new instance of the Item class with the specified parameters.
     *
     * @param id             the unique identifier for the item
     * @param title          the title of the item
     * @param author         the author of the item
     * @param publisher      the publisher of the item
     * @param productionYear the production year of the item
     * @param copiesNumber   the number of copies of the item in the library
     * @param status         the availability status of the item
     */
    public Item(int id, String title, String author, String publisher, int productionYear, int copiesNumber, boolean status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.productionYear = productionYear;
        this.copiesNumber = copiesNumber;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public int getCopiesNumber() {
        return copiesNumber;
    }

    public void setCopiesNumber(int copiesNumber) {
        this.copiesNumber = copiesNumber;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Creates a formatted string representation of the object instance variables.
     *
     * @return A string representing the instance variables of the object.
     */
    @Override
    public String toString() {
        return String.format("\t\t\t\t\t\tItem: " + "\n\t\t\t\t\t\t\tID = %s" + "\n\t\t\t\t\t\t\tTitle = %s" + "\n\t\t\t\t\t\t\tAuthor = %s" + "\n\t\t\t\t\t\t\tPublisher = %s" + "\n\t\t\t\t\t\t\tProductionYear = %s" + "\n\t\t\t\t\t\t\tCopiesNumber = %s" + "\n\t\t\t\t\t\t\tStatus = %s", this.id, this.title, this.author, this.publisher, this.productionYear, this.copiesNumber, this.status);
    }
}
