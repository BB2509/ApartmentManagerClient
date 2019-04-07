package com.bb.quanlycc.Model;



public class tiendien {
    int ID,IDusers,tiendienthangtruoc,tiendienthangsau,tiendien;
    String ngay;
    String status;
    public tiendien(){}

    public tiendien(int ID, int IDusers, int tiendienthangtruoc, int tiendienthangsau, int tiendien, String ngay, String status) {
        this.ID = ID;
       // this.IDusers = IDusers;
        this.tiendienthangtruoc = tiendienthangtruoc;
        this.tiendienthangsau = tiendienthangsau;
        this.tiendien = tiendien;
        this.ngay = ngay;
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

//    public int getIDusers() {
//        return IDusers;
//    }
//
//    public void setIDusers(int IDusers) {
//        this.IDusers = IDusers;
//    }

    public int getTiendienthangtruoc() {
        return tiendienthangtruoc;
    }

    public void setTiendienthangtruoc(int tiendienthangtruoc) {
        this.tiendienthangtruoc = tiendienthangtruoc;
    }

    public int getTiendienthangsau() {
        return tiendienthangsau;
    }

    public void setTiendienthangsau(int tiendienthangsau) {
        this.tiendienthangsau = tiendienthangsau;
    }

    public int getTiendien() {
        return tiendien;
    }

    public void setTiendien(int tiendien) {
        this.tiendien = tiendien;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
