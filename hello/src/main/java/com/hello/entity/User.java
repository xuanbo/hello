package com.hello.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by xuan on 2015/12/26.
 */
@Entity
@Table(name = "user")
public class User {

    private Integer id;

    private String name;
    private String password;

    private Set<Role> roles;

    public User() {
    }

    public User(Integer id, String name, String password, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.roles = roles;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinTable(name = "userRole" ,
            joinColumns = { @JoinColumn( name ="userId" )},
            inverseJoinColumns = { @JoinColumn( name = "roleId") })
    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
