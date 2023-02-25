package tn.suptech.examenspring.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "role_name")
    private String name;
    @Column
    private String roleDescription;
    @ManyToMany(mappedBy = "roles")
    private List<User> userList;

    public Role() {
    }

    public Role(Long id, String name, String roleDescription) {
        this.id = id;
        this.name = name;
        this.roleDescription = roleDescription;
    }

    public Role(String name, String roleDescription) {
        this.name = name;
        this.roleDescription = roleDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }


    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descr='" + roleDescription + '\'' +
                ", userList=" + userList +
                '}';
    }
}

