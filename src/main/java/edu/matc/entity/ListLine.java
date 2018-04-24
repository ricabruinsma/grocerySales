package edu.matc.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Deal.
 */
@EqualsAndHashCode(exclude = {"createDate", "updateDate", "shoppingList", "item"})
@ToString(exclude = {"createDate", "updateDate", "shoppingList", "item"})
@Entity(name = "ListLine")
@Table(name = "listline")
public class ListLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Getter @Setter private int id;

    @Getter @Setter private String createDate;
    @Getter @Setter int quantity;
    @Getter @Setter private String updateDate;

    @ManyToOne
    @Getter @Setter private ShoppingList shoppingList;

    @ManyToOne
    @Getter @Setter private Item item;

    public ListLine() {
    }

    public ListLine(int quantity, ShoppingList shoppingList, Item item) {
        this.quantity = quantity;
        this.shoppingList = shoppingList;
        this.item = item;
    }

}
