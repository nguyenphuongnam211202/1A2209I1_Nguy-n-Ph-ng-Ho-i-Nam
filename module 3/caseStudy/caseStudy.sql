CREATE DATABASE casestudy;
USE casestudy;

create table vi_tri(
ma_vi_tri int primary key not null,
ten_vi_tri varchar(45) 
);

create table trinh_do(
ma_trinh_do int primary key not null,
ten_trinh_do varchar(45) 
);


create table bo_phan(
ma_bo_phan int primary key not null,
ten_bo_phan varchar(45) 
);

create table nhan_vien(
ma_nhan_vien int primary key not null,
ho_va_ten varchar(45) not null,
ngay_sinh date,
so_cmnd varchar(45),
luong double,
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
ma_vi_tri int,
foreign key(ma_vi_tri) references vi_tri(ma_vi_tri),
ma_trinh_do int,
foreign key(ma_trinh_do) references trinh_do(ma_trinh_do),
ma_bo_phan int,
foreign key(ma_bo_phan) references bo_phan(ma_bo_phan)
);

create table loai_khach(
ma_loai_khach int primary key not null,
ten_loai_khach varchar(45)
);

create table khach_hang(
ma_khach_hang int primary key not null,
ma_loai_khach int,
foreign key (ma_loai_khach) references loai_khach(ma_loai_khach),
ho_ten varchar(45) not null,
ngay_sinh date,
gioi_tinh bit(1),
so_cmnd varchar(45),
sdt varchar(45),
email varchar(45),
diachi varchar(45)
);

create table kieu_thue(
ma_kieu_thue int primary key not null,
ten_kieu_thue varchar(45) not null
);

create table loai_dich_vu(
ma_loai_dv int primary key not null,
ten_loai_dv varchar(45) not null
);

create table dich_vu(
ma_dich_vu int primary key not null,
ten_dich_vu varchar(45) not null,
dien_tich int,
chi_phi_thue double(30,2) not null,
so_nguoi_toi_da int,
ma_kieu_thue int,
foreign key(ma_kieu_thue) references kieu_thue(ma_kieu_thue),
ma_loai_dv int,
foreign key(ma_loai_dv) references loai_dich_vu(ma_loai_dv),
tieu_chuan_phong varchar(45),
mo_ta_tien_nghi_khac varchar(45),
dien_tich_ho_boi double,
so_tang int
);

create table hop_dong(
ma_hop_dong int primary key not null,
ngay_lam_hop_dong datetime not null,
ngay_ket_thuc datetime,
tien_dat_coc double,
ma_nhan_vien int,
foreign key(ma_nhan_vien) references nhan_vien(ma_nhan_vien),
ma_khach_hang int,
foreign key(ma_khach_hang) references khach_hang(ma_khach_hang),
ma_dich_vu int,
foreign key(ma_dich_vu) references dich_vu(ma_dich_vu)
);

create table dich_vu_di_kem(
ma_dv_di_kem int primary key not null,
ten_dv_di_kem varchar(45) not null,
gia double,
don_vi varchar(10),
trang_thai varchar(45)
);

create table hop_dong_chi_tiet(
ma_hd_chi_tiet int primary key not null,
ma_hop_dong int,
foreign key(ma_hop_dong) references hop_dong(ma_hop_dong),
ma_dv_di_kem int,
foreign key(ma_dv_di_kem) references dich_vu_di_kem(ma_dv_di_kem),
so_luong int not null
);


-- Thêm mới thông tin cho tất cả các bảng có trong CSDL để có thể thoả mãn các yêu cầu bên dưới.
insert into vi_tri (ma_vi_tri, ten_vi_tri)
value 
(1, "lễ tân"),
(2, "phục vụ"),
(3, "chuyên viên"),
(4, "giảm sát"),
(5, "quản lý"),
(6, "giám đốc");

insert into trinh_do (ma_trinh_do, ten_trinh_do)
value 
(1, "trung cấp"),
(2, "cao đẳng"),
(3, "đại học"),
(4, "sau đại học");

insert into bo_phan (ma_bo_phan, ten_bo_phan)
value 
(1, "sale-marketing"),
(2, "hành chính"),
(3, "phục vụ"),
(4, "quản lý");

insert into nhan_vien (ma_nhan_vien, ho_va_ten, ngay_sinh, so_cmnd, luong, sdt, email, dia_chi, ma_vi_tri, ma_trinh_do, ma_bo_phan)
value 
(001, "Nguyễn Thị Hiền", '2000-02-12' , '0443028383865', 500, 0973849274,'hhbsj@gmail.com', 'Da Nang', 1 , 1, 2),
(002, "Nguyễn Phương Nam ", '2002-02-11' , '044302002097', 400, 0913574847,'gdfgdvs@gmail.com', 'Da Nang', 1 , 1, 3),
(003, "Võ Minh Hiếu ", '1996-06-10' , '067865886478', 600, 0978568654,'sjbhjcb@gmail.com', 'Da Nang', 3 , 2, 2),
(004, "Trần Phương Nhi ", '1997-10-5' , '076467876578', 1000, 09797697767,'shsahhs@gmail.com', 'Da Nang ', 4 , 4, 4);

insert into loai_khach(ma_loai_khach, ten_loai_khach)
value 
(1, "Diamond"),
(2,"Platinium"),
(3,"Gold"),
(4,"Silver"),
(5,"Member");

insert into loai_dich_vu



