package edu.matc.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A class to represent a user
 *
 * @author Rica
 */
@EqualsAndHashCode(exclude = {"shoppingLists", "roles", "createDate", "firstName", "address2", "lat", "lon"})
@ToString(exclude = {"shoppingLists", "roles", "lat", "lon"})
@Entity(name = "User")
@Table(name = "user")
public class User implements Serializable {
    @Getter @Setter private String createDate;
    @Getter @Setter private String email;
    @Getter @Setter private String firstName;

    @Getter @Setter private String password;
    @Getter @Setter private String username;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Getter @Setter private int id;

    @Getter @Setter private String address1;
    @Getter @Setter private String address2;
    @Getter @Setter private String city;
    @Getter @Setter private String state;
    @Getter @Setter private String postalCode;

    @Getter @Setter private double lat;
    @Getter @Setter private double lon;
    @Getter @Setter private String updateDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Getter @Setter private Set<ShoppingList> shoppingLists = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Getter @Setter private Set<Role> roles = new HashSet<>();

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param email      the email
     * @param password   the password
     * @param username   the username
     * @param address1   the address 1
     * @param city       the city
     * @param state      the state
     * @param postalCode the postal code
     */
    public User(String email, String password, String username, String address1, String city, String state, String postalCode) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.address1 = address1;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    public void addRole(Role role) {
        roles.add(role);
        role.setUser(this);
    }

    public void removeRole(Role role){
        roles.remove(role);
        role.setUser(null);
    }
}
