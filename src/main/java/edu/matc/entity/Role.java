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

    /**
     * The User.
     */
    @ManyToOne
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "role_user_id_fk")
    )
    @Getter @Setter User user;

    private String username;

    /**
     * Instantiates a new Role.
     */
    public Role() {
    }

    /**
     * Instantiates a new Role.
     *
     * @param name the name
     * @param user the user
     * @param username the username of user
     */
    public Role(User user, String name, String username) {
        this.user = user;
        this.name = name;
        this.username = username;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleid='" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id &&
                Objects.equals(name, role.name) &&
                Objects.equals(username, role.username);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, id);
    }
}
