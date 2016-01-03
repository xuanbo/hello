package com.hello.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by xuan on 16-1-2.
 */

@Entity
@Table(name = "role")
public class Role {

    private int id;

    private String name;

    private Set<User> users;
    private Set<Resource> resources;

    public Role() {
        super();
    }
    public Role(int id, String name, Set<User> users, Set<Resource> resources) {
        super();
        this.id = id;
        this.name = name;
        this.users = users;
        this.resources = resources;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "roles")
    public Set<User> getUsers() {
        return users;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinTable(name = "roleResource" ,
            joinColumns = { @JoinColumn( name ="roleId" )},
            inverseJoinColumns = { @JoinColumn( name = "resourceId") })
    public Set<Resource> getResources() {
        return resources;
    }
    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users=" + users +
                ", resources=" + resources +
                '}';
    }
}
