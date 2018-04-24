package edu.matc.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A class to represent a shopping list
 */
@EqualsAndHashCode(exclude = {"listLines", "createDate", "updateDate"})
@ToString(exclude = {"listLines"})
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
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "ShoppingList_User")
    )
    @Getter @Setter User user;

    @OneToMany(mappedBy = "shoppingList", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.EAGER)
    @Getter @Setter private Set<ListLine> listlines = new HashSet<>();

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

}

