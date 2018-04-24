package edu.matc.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A class to represent a store
 */
@EqualsAndHashCode(exclude = {"items", "createDate", "updateDate"})
@ToString(exclude = {"items", "lat", "lon"})
@Entity(name = "Store")
@Table(name = "store")
public class Store {
    @Getter @Setter private String createDate;
    @Getter @Setter private String name;
    @Getter @Setter private String address1;
    @Getter @Setter private String address2;
    @Getter @Setter private String city;
    @Getter @Setter private String state;
    @Getter @Setter private String postalCode;
    @Getter @Setter private BigDecimal lat;
    @Getter @Setter private BigDecimal lon;
    @Getter @Setter private String updateDate;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Getter @Setter private int id;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Getter @Setter private Set<Item> items = new HashSet<>();

    /**
     * Instantiates a new Store.
     */
    public Store() {
    }

    /**
     * Instantiates a new Store.
     *
     * @param name       the name
     * @param address1   the address 1
     * @param city       the city
     * @param state      the state
     * @param postalCode the postal code
     */
    public Store(String name, String address1, String city, String state, String postalCode) {
        this.name = name;
        this.address1 = address1;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

}
