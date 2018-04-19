package edu.matc.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * A class to represent a user role
 */
@Entity(name = "Role")
@Table(name = "role")
public class Role implements Serializable{

    @Getter @Setter private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Getter @Setter private int id;

    @Getter @Setter private String createDate;
    @Getter @Setter private String updateDate;

    @ManyToOne
    @JoinColumns(value = {
            @JoinColumn(name="username", referencedColumnName = "username", nullable = false),
            @JoinColumn(name="user_id", referencedColumnName = "id", nullable = false) })
    @Getter @Setter User user;

    /**
     * Instantiates a new Role.
     */
    public Role() {
    }

    public Role(String name, User user) {
        this.name = name;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleid='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id &&
                Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, id);
    }
}
