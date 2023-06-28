package demo;

import java.util.Date;

public class MatHang {
    private String tenMatHang;
    private String tenLoai;
    private float gia;
    NhaSanXuat nhaSanXuat;

    public MatHang(){
    }

    public MatHang(String tenMatHang, String tenLoai, float gia, NhaSanXuat nhaSanXuat) {
        this.tenMatHang = tenMatHang;
        this.tenLoai = tenLoai;
        this.gia = gia;
        this.nhaSanXuat = nhaSanXuat;
    }

    public String getTenMatHang() {
        return tenMatHang;
    }

    public void setTenMatHang(String tenMatHang) {
        this.tenMatHang = tenMatHang;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public NhaSanXuat getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(NhaSanXuat nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public Date ngayHetHan(String s){
        Date date = new Date("dd-mm-YYYY" );
        if (tenMatHang.equalsIgnoreCase(""))
    }
}
