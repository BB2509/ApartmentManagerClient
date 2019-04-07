package com.bb.quanlycc.Model;

public class danhsach {
    int id;
   public  String menu;
   public int hinhanh;

    public danhsach(int id, String menu, int hinhanh) {
        this.id = id;
        this.menu = menu;
        this.hinhanh = hinhanh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }
}
