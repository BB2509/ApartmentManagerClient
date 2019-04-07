package com.bb.quanlycc.Model;



public class tiennuoc {
    int ID,IDusers,tiennuocthangtruoc,tiennuocthangsau,tongtien;
    String ngay;
    String status;
    public tiennuoc(){}

    public tiennuoc(int ID, int IDusers, int tiennuocthangtruoc, int tiennuocthangsau, int tongtien, String ngay, String status) {
        this.ID = ID;
        this.IDusers = IDusers;
        this.tiennuocthangtruoc = tiennuocthangtruoc;
        this.tiennuocthangsau = tiennuocthangsau;
        this.tongtien = tongtien;
        this.ngay = ngay;
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getTiennuocthangtruoc() {
        return tiennuocthangtruoc;
    }

    public void setTiennuocthangtruoc(int tiennuocthangtruoc) {
        this.tiennuocthangtruoc = tiennuocthangtruoc;
    }

    public int getTiennuocthangsau() {
        return tiennuocthangsau;
    }

    public void setTiennuocthangsau(int tiennuocthangsau) {
        this.tiennuocthangsau = tiennuocthangsau;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
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
