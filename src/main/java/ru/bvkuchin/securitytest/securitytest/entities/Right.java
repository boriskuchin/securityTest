package ru.bvkuchin.securitytest.securitytest.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "rights")
public class Right {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @JsonBackReference
    @ManyToMany
    @JoinTable(
            name = "roles_rights",
            joinColumns = @JoinColumn (name = "right_id"),
            inverseJoinColumns = @JoinColumn (name = "role_id")
    )
    private List<Role> roles;


    @Override
    public String toString() {
        return "Right{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
