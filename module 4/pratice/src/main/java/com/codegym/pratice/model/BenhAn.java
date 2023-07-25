package com.codegym.pratice.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.format.DateTimeFormatter;

@Entity
public class BenhAn {
    @Id
    @Column(columnDefinition = "nvarchar(100)")
    private String id;

    @NotBlank(message = "ten benh khong duoc de trong")
    @Column(name = "ten_benh",columnDefinition = "nvarchar(100)")
    private String tenBenh;

    @NotBlank(message = "ngay nhap vien khong duoc de trong")
    @Column(name = "ngay_nhap_vien",columnDefinition = "nvarchar(30)")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}")
    private String ngayNhapVien;

    @Column(name = "ngay_ra_vien",columnDefinition = "nvarchar(100)")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}")
    private String ngayRaVien;

    @ManyToOne
    @JoinColumn(name = "benh_nhan_id")
    private BenhNhan benhNhan;

    public BenhAn() {
    }

    public BenhAn(String id, String tenBenh, String ngayNhapVien, String ngayRaVien, BenhNhan benhNhan) {
        this.id = id;
        this.tenBenh = tenBenh;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
        this.benhNhan = benhNhan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenBenh() {
        return tenBenh;
    }

    public void setTenBenh(String tenBenh) {
        this.tenBenh = tenBenh;
    }

    public String getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(String ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public String getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(String ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }

    public BenhNhan getBenhNhan() {
        return benhNhan;
    }

    public void setBenhNhan(BenhNhan benhNhan) {
        this.benhNhan = benhNhan;
    }
}
