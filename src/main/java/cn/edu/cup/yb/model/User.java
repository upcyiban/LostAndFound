package cn.edu.cup.yb.model;

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
    private String title;
    private String detail;
    private String ybname;
    private String ybid;
    private String date;
    private int status;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }

    public String getYbname() {
        return ybname;
    }

    public String getYbid() {
        return ybid;
    }

    public String getDate() {
        return date;
    }

    public int getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setYbname(String ybname) {
        this.ybname = ybname;
    }

    public void setYbid(String ybid) {
        this.ybid = ybid;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
