package edu.matc.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent a user
 *
 * @author Rica
 */
@Entity(name = "User")
@Table(name = "user")
public class User {

    @Getter @Setter private String email;

    @Getter @Setter private String password;
    @Getter @Setter private String username;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Getter @Setter private int id;

    @Getter @Setter private String address1;
    @Getter @Setter private String city;
    @Getter @Setter private String state;
    @Getter @Setter private String postalCode;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param email    the email
     * @param password the password
     * @param username the username
     * @param address1  the address
     * @param city     the city
     * @param state    the state
     * @param postalCode      the zip
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

    @Override
    public String toString() {
        return "User{" +
                "userid='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
