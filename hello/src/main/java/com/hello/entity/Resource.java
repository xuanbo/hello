package com.hello.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by xuan on 16-1-2.
 */

@Entity
@Table(name = "resource")
public class Resource {

    private int id;

    private String authority;
    private String url;

    private Set<Role> roles;


    public Resource(int id, String authority, String url, Set<Role> roles) {
        super();
        this.id = id;
        this.authority = authority;
        this.url = url;
        this.roles = roles;
    }
    public Resource() {
        super();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    @ManyToMany(mappedBy = "resources")
    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", authority='" + authority + '\'' +
                ", url='" + url + '\'' +
                ", roles=" + roles +
                '}';
    }
}
