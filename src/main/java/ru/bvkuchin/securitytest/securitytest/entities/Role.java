package ru.bvkuchin.securitytest.securitytest.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "roles_rights",
            joinColumns = @JoinColumn (name = "role_id"),
            inverseJoinColumns = @JoinColumn (name = "right_id")
    )
    private List<Right> rights;


    @JsonBackReference
    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn (name = "role_id"),
            inverseJoinColumns = @JoinColumn (name = "user_id")
    )
    private List<User> users;



    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
