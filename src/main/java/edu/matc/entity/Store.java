package edu.matc.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A class to represent a store
 */
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

    /**
     * Instantiates a new Store.
     */
    public Store() {
    }

    public Store(String name, String address1, String city, String state, String postalCode) {
        this.name = name;
        this.address1 = address1;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return id == store.id &&
                Objects.equals(name, store.name) &&
                Objects.equals(address1, store.address1) &&
                Objects.equals(city, store.city) &&
                Objects.equals(state, store.state);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, id);
    }
}
