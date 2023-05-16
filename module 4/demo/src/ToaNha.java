import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class ToaNha {
    String ten;
    Date ngayThanhLap;
    int soLuongPhong;
    boolean laGiangDuong;
    List<NhanVien> nhanVienQuanLy;

    public ToaNha(String ten, Date ngayThanhLap, int soLuongPhong, boolean laGiangDuong) {
        this.ten = ten;
        this.ngayThanhLap = ngayThanhLap;
        this.soLuongPhong = soLuongPhong;
        this.laGiangDuong = laGiangDuong;
        this.nhanVienQuanLy = new ArrayList<NhanVien>();
    }

    public void themNhanVien(NhanVien nhanVien) {
        this.nhanVienQuanLy.add(nhanVien);
    }

    public boolean kiemTraSoPhongItHon(ToaNha toaNhaKhac) {
        return this.soLuongPhong < toaNhaKhac.soLuongPhong;
    }

    public boolean kiemTraCungNgayThanhLap(ToaNha toaNhaKhac) {
        return this.ngayThanhLap.equals(toaNhaKhac.ngayThanhLap);
    }

    public String getThongTinNhanVien() {
        if (laGiangDuong || nhanVienQuanLy.isEmpty()) {
            return "Khong co thong tin";
        }
        return nhanVienQuanLy.get(0).hoTen;
    }
}



