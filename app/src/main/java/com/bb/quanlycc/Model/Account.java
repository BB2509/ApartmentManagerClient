package com.bb.quanlycc.Model;

import java.io.Serializable;

/**
 * Created by LynkMieu on 20/08/2016.
 */
public class Account implements Serializable {
    private int Id;
    private String userName;
    private String email;
    private  String gioitinh;
    private  String room;

    public Account() {
    }

    public Account(int id, String userName, String email, String gioitinh, String room) {
        Id = id;
        this.userName = userName;
        this.email = email;
        this.gioitinh = gioitinh;
        this.room = room;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
