package edu.matc.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * A class to represent a user role
 */
@Entity(name = "Role")
@Table(name = "role")
public class Role {

    @Getter @Setter private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Getter @Setter private int id;

    @Getter @Setter private String createDate;
    @Getter @Setter private String updateDate;

    /**
     * Instantiates a new Role.
     */
    public Role() {
    }


    @ManyToOne
    @JoinColumns(value = {
            @JoinColumn(name="username", referencedColumnName = "username", nullable = false),
            @JoinColumn(name="user_id", referencedColumnName = "id", nullable = false) })
    @Getter @Setter User user;

}
