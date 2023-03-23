USE QuanLynghiduongFurama;
-- câu 2:
select *
from nhan_vien
where substring_index(ho_ten,' ', -1) regexp '^[HTK]'
and char_length(ho_ten) <= 15; 
-- câu 3 :
select *
from khach_hang
where
	(timestampdiff(Year,ngay_sinh,now())  between 18 and 50)
	 and(dia_chi like '%Da Nang%' or dia_chi like '%Quang Tri%');
-- câu 4 :
select   kh.ma_khach_hang,
		 kh.ho_ten,
         count(hd.ma_khach_hang) as so_lan_dat_phong
from khach_hang kh
join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
where
    lk.ten_loai_khach = 'Diamond'
group by
    hd.ma_khach_hang
order by
    so_lan_dat_phong ;
    
-- câu 5 :


-- câu 6 :
select ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu
from dich_vu dv
join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
where 
	ma_dich_vu not in(
    select hd.ma_dich_vu
    from dich_vu dv 
    join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
    where (month(ngay_lam_hop_dong) between 1 and 3) and year(ngay_lam_hop_dong) = "2021"
    );
-- câu 7 :
select ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu
from dich_vu dv 
join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
where ma_dich_vu in(
	select dv.ma_dich_vu 
    from dich_vu dv
    join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
    where year(ngay_lam_hop_dong) = 2020
) and ma_dich_vu not in (
	select dv.ma_dich_vu 
    from dich_vu dv
    join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
    where year(ngay_lam_hop_dong) = 2021
);
-- câu 8:
-- cách 1:
select distinct(ho_ten) from khach_hang;
-- cách 2 :
select ho_ten from khach_hang
union
select ho_ten from khach_hang;
-- cách 3 :
select ho_ten from khach_hang
group by ho_ten;
-- câu 9:

-- câu 10:
select hd.ma_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc
from hop_dong hd
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong 
join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
order by hd.ma_hop_dong

-- câu 11: 
    
