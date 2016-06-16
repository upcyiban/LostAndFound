package cn.edu.upc.yb.model;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Created by yyljj on 2016/5/21.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String ybuserid;
    private String ybusername;
    private String ybusernick;
    private String ybsex;
    private String title;
    private String detail;
    private int status;
    private String date;
    private String category;//分类 暂时没用到
    private boolean isdelet = false;
    private boolean isloser;//是失主或或捡到东西的人

    public User() {
    }

    /**
     *
     * @param ybuserid
     * @param ybusername
     * @param ybusernick
     * @param ybsex
     * @param title
     * @param detail
     * @param status
     * @param date
     * @param category
     * @param isdelet
     * @param isloser
     */
    public User(String ybuserid, String ybusername, String ybusernick, String ybsex, String title, String detail, int status, String date, String category, boolean isdelet, boolean isloser) {
        this.ybuserid = ybuserid;
        this.ybusername = ybusername;
        this.ybusernick = ybusernick;
        this.ybsex = ybsex;
        this.title = title;
        this.detail = detail;
        this.status = status;
        this.date = date;
        this.category = category;
        this.isdelet = isdelet;
        this.isloser = isloser;
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

    public boolean isloser() {
        return isloser;
    }

    public void setIsloser(boolean isloser) {
        this.isloser = isloser;
    }
}
