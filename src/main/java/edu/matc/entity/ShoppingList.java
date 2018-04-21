package edu.matc.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * A class to represent a shopping list
 */
@Entity(name = "ShoppingList")
@Table(name = "shoppinglist")
public class ShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Getter @Setter private int id;

    @Getter @Setter private String createDate;
    @Getter @Setter private double totalAmount;
    @Getter @Setter private String updateDate;

    /**
     * The User.
     */
    @ManyToOne
    @JoinColumns(value = {
            @JoinColumn(name="user_id", referencedColumnName = "id", nullable = false) })
    @Getter @Setter User user;

    /**
     * Instantiates a new ShoppingList.
     */
    public ShoppingList() {
    }

    /**
     * Instantiates a new ShoppingList.
     *
     * @param totalAmount the total price for shopping list
     * @param user the user
     */
    public ShoppingList(double totalAmount, User user) {
        this.totalAmount = totalAmount;
        this.user = user;
    }

    @Override
    public String toString() {
        return "ShoppingList{" +
                "listid='" + id + '\'' +
                ", total='$" + totalAmount + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingList list = (ShoppingList) o;
        return id == list.id &&
                Objects.equals(totalAmount, list.totalAmount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(totalAmount, id);
    }
}

