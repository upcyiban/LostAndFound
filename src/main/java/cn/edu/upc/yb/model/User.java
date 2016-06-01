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
    private String title;
    private String detail;
    private int status;
    private String date;
    private String category;
    private boolean isdelet = false;

    public User() {
    }

    public User(String ybuserid, String ybusername, String ybusernick, String ybsex, String ybmoney, String ybexp, String ybrealname, String ybidentity, String title, String detail, int status, String date, String category, boolean isdelet) {
        this.ybuserid = ybuserid;
        this.ybusername = ybusername;
        this.ybusernick = ybusernick;
        this.ybsex = ybsex;
        this.ybmoney = ybmoney;
        this.ybexp = ybexp;
        this.ybrealname = ybrealname;
        this.ybidentity = ybidentity;
        this.title = title;
        this.detail = detail;
        this.status = status;
        this.date = date;
        this.category = category;
        this.isdelet = isdelet;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isdelet() {
        return isdelet;
    }

    public void setIsdelet(boolean isdelet) {
        this.isdelet = isdelet;
    }
}
