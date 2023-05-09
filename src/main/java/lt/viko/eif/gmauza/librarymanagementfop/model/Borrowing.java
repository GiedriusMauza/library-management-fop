package lt.viko.eif.gmauza.librarymanagementfop.model;

import javax.persistence.*;

/**
 * Represents a borrowing of an item by a user.
 * This class is annotated with JPA annotations to be used as an entity in a relational database.
 */
@Entity
@Table(name = "borrowing")
public class Borrowing {

    /**
     * The unique identifier of this borrowing.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    /**
     * The date when the item was borrowed.
     */
    private String borrowDate;
    /**
     * The date when the item need to be returned.
     */
    private String returnDate;
    /**
     * The item that was borrowed.
     */
    @OneToOne(targetEntity = Item.class, cascade = CascadeType.ALL)
    private Item item;

    /**
     * Creates a new borrowing with no values set.
     */
    public Borrowing() {
    }

    /**
     * Creates a new borrowing with the given values.
     *
     * @param borrowDate the date when the item was borrowed
     * @param returnDate the date when the item was returned
     * @param item       the item that was borrowed
     */
    public Borrowing(String borrowDate, String returnDate, Item item) {
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.item = item;
    }

    /**
     * Creates a new borrowing with the given values, including an id.
     *
     * @param id         the unique identifier of the borrowing
     * @param borrowDate the date when the item was borrowed
     * @param returnDate the date when the item was returned
     * @param item       the item that was borrowed
     */
    public Borrowing(int id, String borrowDate, String returnDate, Item item) {
        this.id = id;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * Returns a string representation of this object.
     * The returned string includes details about the borrowed items, including:
     * ID
     * Borrow Date
     * Return Date
     * Item
     *
     * @return a string representation of this object.
     */
    @Override
    public String toString() {
        return String.format("\n\t\t\t\t\tBorrowed items: " +
                        "\n\t\t\t\t\t\tID = %s" +
                        "\n\t\t\t\t\t\tBorrow Date = %s" +
                        "\n\t\t\t\t\t\tReturn Date = %s" +
                        "\n%s",
                this.id, this.borrowDate, this.returnDate, this.item);
    }
}
