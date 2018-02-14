package edu.matc.entity;

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

    private String email;
    private String password;
    private String username;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private int roleId;

    private String address;
    private String city;
    private String state;
    private String zip;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets password sha.
     *
     * @return the password sha
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password sha.
     *
     * @param password the password sha
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets role id.
     *
     * @return the role id
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * Sets role id.
     *
     * @param roleId the role id
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets zip.
     *
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * Sets zip.
     *
     * @param zip the zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + id + '\'' +
                ", email='" + email + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}
