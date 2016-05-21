package cn.edu.cup.yb.model;

import javax.persistence.*;

/**
 * Created by 77dfeba on 2016/5/21.
 */
@Entity
@Table(name = "officialamin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
