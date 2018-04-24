package edu.matc.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Deal.
 */
@Entity(name = "ListLine")
@Table(name = "listline")
public class ListLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Getter @Setter private int id;

    @Getter @Setter int quantity;

    @ManyToOne
    @Getter @Setter private ShoppingList shoppingList;

    @ManyToOne
    @Getter @Setter private Item item;
}
