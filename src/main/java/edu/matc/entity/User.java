package edu.matc.entity;

import lombok.Getter;
import lombok.Setter;
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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Getter @Setter private Set<Role> roles = new HashSet<>();

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param password the password
     * @param username the username
     */
    public User(String password, String username) {
        this.password = password;
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(password, user.password) &&
                Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {

        return Objects.hash(email, password, username, id);
    }
}
