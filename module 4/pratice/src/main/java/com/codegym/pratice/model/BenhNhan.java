package com.codegym.pratice.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class BenhNhan {
    @Id
    @Column(columnDefinition = "nvarchar(100)")
    private String id;

    @NotBlank
    @Column(name = "ten_benh_nhan",columnDefinition = "nvarchar(100)")
    private String tenBenhNhan;

    @NotBlank
    @Column(name = "dia_chi",columnDefinition = "nvarchar(100)")
    private String tenDiaChi;

    @OneToMany(mappedBy = "benhNhan")
    private List<BenhAn> benhAnList;

    public BenhNhan() {
    }

    public BenhNhan(String id, String tenBenhNhan, String tenDiaChi, List<BenhAn> benhAnList) {
        this.id = id;
        this.tenBenhNhan = tenBenhNhan;
        this.tenDiaChi = tenDiaChi;
        this.benhAnList = benhAnList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public String getTenDiaChi() {
        return tenDiaChi;
    }

    public void setTenDiaChi(String tenDiaChi) {
        this.tenDiaChi = tenDiaChi;
    }

    public List<BenhAn> getBenhAnList() {
        return benhAnList;
    }

    public void setBenhAnList(List<BenhAn> benhAnList) {
        this.benhAnList = benhAnList;
    }
}
