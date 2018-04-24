package edu.matc.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * A class to represent a user role
 */
@EqualsAndHashCode(exclude = {"createDate", "updateDate"})
@ToString
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

    @Getter @Setter private String username;

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

}
