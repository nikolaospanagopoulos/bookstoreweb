package com.bookstore.entities;

import org.hibernate.sql.Select;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NamedQueries(
        {
                @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u ORDER BY u.fullName"),
                @NamedQuery(name = "User.countAll",query = "select COUNT (*) FROM User u"),
                @NamedQuery(name="User.findByEmail",query = "select u from User u where u.email=:email")
        }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    private String email;
    @Column(name = "full_name")
    private String fullName;
    private String password;

    public User(String email, String fullName, String password) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
    }

    public User() {

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
