package edu.matc.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type Deal.
 */
@Entity(name = "Item")
@Table(name = "item")
public class Item {

    @Getter @Setter private String brand;
    @Getter @Setter private String product;
    @Getter @Setter private String size;
    @Getter @Setter private String salePrice;
    @Getter @Setter private String savingsAmount;
    @Getter @Setter private String saleEndDate;

    @ManyToOne
    @JoinColumn(name = "store_id",
            foreignKey = @ForeignKey(name = "Item_Store")
    )
    @Getter @Setter Store store;

    @OneToMany(mappedBy = "item", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<ListLine> listLines = new HashSet<>();


    @Getter @Setter private boolean active;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Getter @Setter private int id;

    /**
     * Instantiates a new grocery item.
     */
    public Item() {
    }

    /**
     * Instantiates a new item.
     *
     * @param brand         the brand
     * @param product       the product
     * @param size          the size
     * @param salePrice     the sale price
     * @param savingsAmount the savings amount
     * @param saleEndDate   the sale end date
     * @param active        the active
     * @param store         the store
     */
    public Item(String brand, String product, String size, String salePrice, String savingsAmount, String saleEndDate, boolean active, Store store) {
        this.brand = brand;
        this.product = product;
        this.size = size;
        this.salePrice = salePrice;
        this.savingsAmount = savingsAmount;
        this.saleEndDate = saleEndDate;
        this.active = active;
        this.store = store;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemid='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", product='" + product + '\'' +
                ", size='" + size + '\'' +
                ", salePrice='" + salePrice + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id &&
                Objects.equals(brand, item.brand) &&
                Objects.equals(product, item.product) &&
                Objects.equals(size, item.size) &&
                Objects.equals(salePrice, item.salePrice);
    }

    @Override
    public int hashCode() {

        return Objects.hash(brand, product, size, salePrice);
    }
}

