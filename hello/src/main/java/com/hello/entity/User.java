package com.hello.entity;

import javax.persistence.*;

/**
 * Created by xuan on 2015/12/26.
 */
@Entity
@Table(name = "user")
public class User {

    private Integer id;

    private String name;
    private String password;

    private Role role;

    public User() {
    }
    public User(Integer id, String name, String password, Role role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
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

    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinTable(name = "userRole" ,
            joinColumns = { @JoinColumn( name ="userId" )},
            inverseJoinColumns = { @JoinColumn( name = "roleId") })
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
