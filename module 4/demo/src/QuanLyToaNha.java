import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class QuanLyToaNha {
    List<ToaNha> danhSachToaNha;

    public QuanLyToaNha() {
        this.danhSachToaNha = new ArrayList<ToaNha>();
    }

    public void themToaNha(ToaNha toaNha) {
        this.danhSachToaNha.add(toaNha);
    }

    public int getSoLuongToaNha() {
        return this.danhSachToaNha.size();
    }

    //test các phương thức
    public static void main(String[] args) {
        QuanLyToaNha quanLyToaNha = new QuanLyToaNha();

        ToaNha toaNha1 = new ToaNha("Toa nha A", new Date(2021, 6, 1), 20, true);
        ToaNha toaNha2 = new ToaNha("Toa nha B", new Date(2021, 6, 2), 30, true);
        ToaNha toaNha3 = new ToaNha("Toa nha C", new Date(2021, 6, 2), 25, false);

        NhanVien nhanVien1 = new NhanVien("NV001", "Nguyen Van A");
        //thêm nhân viên
        toaNha1.themNhanVien(nhanVien1);

        //thêm tòa nhà
        quanLyToaNha.themToaNha(toaNha1);
        quanLyToaNha.themToaNha(toaNha2);
        quanLyToaNha.themToaNha(toaNha3);

        //test phương thức lấy số lượng tòa nhà
        System.out.println(quanLyToaNha.getSoLuongToaNha()); // 3

        //test phương thức kiểm tra số phòng
        System.out.println(toaNha1.kiemTraSoPhongItHon(toaNha2)); // true

        //test phương thức lấy thông tin nhân viên
        System.out.println(toaNha3.getThongTinNhanVien()); // Khong co thong tin

        //tets phương thức kiểm tra cùng ngày thành plapaj
        System.out.println(toaNha2.kiemTraCungNgayThanhLap(toaNha3)); // true
    }
}
