package cn.edu.upc.yb.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by yyljj on 2016/5/21.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String ybuserid;
    private String ybusername;
    private String ybusernick;
    private String ybsex;
    private String ybmoney;
    private String ybexp;
    private String ybrealname;
    private String ybidentity;

    public User() {
    }

    public User(String ybuserid, String ybusername, String ybusernick, String ybsex, String ybmoney, String ybexp, String ybrealname, String ybidentity) {
        this.ybuserid = ybuserid;
        this.ybusername = ybusername;
        this.ybusernick = ybusernick;
        this.ybsex = ybsex;
        this.ybmoney = ybmoney;
        this.ybexp = ybexp;
        this.ybrealname = ybrealname;
        this.ybidentity = ybidentity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYbuserid() {
        return ybuserid;
    }

    public void setYbuserid(String ybuserid) {
        this.ybuserid = ybuserid;
    }

    public String getYbusername() {
        return ybusername;
    }

    public void setYbusername(String ybusername) {
        this.ybusername = ybusername;
    }

    public String getYbusernick() {
        return ybusernick;
    }

    public void setYbusernick(String ybusernick) {
        this.ybusernick = ybusernick;
    }

    public String getYbsex() {
        return ybsex;
    }

    public void setYbsex(String ybsex) {
        this.ybsex = ybsex;
    }

    public String getYbmoney() {
        return ybmoney;
    }

    public void setYbmoney(String ybmoney) {
        this.ybmoney = ybmoney;
    }

    public String getYbexp() {
        return ybexp;
    }

    public void setYbexp(String ybexp) {
        this.ybexp = ybexp;
    }

    public String getYbrealname() {
        return ybrealname;
    }

    public void setYbrealname(String ybrealname) {
        this.ybrealname = ybrealname;
    }

    public String getYbidentity() {
        return ybidentity;
    }

    public void setYbidentity(String ybidentity) {
        this.ybidentity = ybidentity;
    }
}
