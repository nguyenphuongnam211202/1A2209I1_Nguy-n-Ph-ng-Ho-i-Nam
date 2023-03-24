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

select
    hd.ma_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc as tien_coc,
    sum(hdct.so_luong) as so_luong_dich_vu_di_kem
from
    hop_dong hd
    left join hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
group by
    hd.ma_hop_dong;
	

-- câu 11: 
    select  dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem
    from loai_khach lk
    join khach_hang kh on lk.ma_loai_khach = kh.ma_loai_khach
    join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
    join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
    join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
    where lk.ten_loai_khach = 'Diamond' and ( kh.dia_chi like '%Vinh%' or '%Quang Ngai%');

-- câu 12:
	
-- câu 13: 
create temporary table temp
SELECT dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, SUM(hdct.so_luong) AS so_lan_su_dung
FROM dich_vu_di_kem dvdk JOIN hop_dong_chi_tiet hdct On dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
JOIN hop_dong hd ON hd.ma_hop_dong = hdct.ma_hop_dong
GROUP BY dvdk.ma_dich_vu_di_kem;

create temporary table temp1
select max(temp.so_lan_su_dung) as max_so_lan_su_dung from temp; 

select temp.ma_dich_vu_di_kem, temp.ten_dich_vu_di_kem, temp.so_lan_su_dung
from temp
join temp1 on temp.so_lan_su_dung = temp1.max_so_lan_su_dung;
select @@sql_mode;

SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));

-- câu 14: 
select
hd.ma_hop_dong, ldv.ten_loai_dich_vu, ten_dich_vu_di_kem, count(dvdk.ma_dich_vu_di_kem) as so_lan_su_dung
from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
join hop_dong hd on hdct.ma_hop_dong = hd.ma_hop_dong
join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
group by
	dvdk.ma_dich_vu_di_kem
having so_lan_su_dung = 1;

-- câu 15:
select nv.ma_nhan_vien, nv.ho_ten, td.ten_trinh_do, bp.ten_bo_phan, nv.so_dien_thoai, nv.dia_chi, count(hd.ma_nhan_vien) as so_hop_dong_lap_duoc
from nhan_vien nv
join trinh_do td on nv.ma_trinh_do = td.ma_trinh_do
join bo_phan bp on nv.ma_bo_phan = bp.ma_bo_phan
join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
where year(ngay_lam_hop_dong) between 2020 and 2021
group by hd.ma_nhan_vien 
having so_hop_dong_lap_duoc <= 3;

-- câu 16 :
delete
from nhan_vien nv where not exists (
select ma_nhan_vien
from hop_dong hd
where hd.ngay_lam_hop_dong between '2019-01-01' and '2021-12-31'
and hd.ma_nhan_vien = nv.ma_nhan_vien
);

-- câu 17:








