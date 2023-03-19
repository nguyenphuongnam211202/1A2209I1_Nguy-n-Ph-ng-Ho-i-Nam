use quanlysinhvien;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select *from `subject` 
order by Credit
limit 1;

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.

select *from `subject` s
join mark m on s.SubId = m.SubId
order by m.Mark desc
limit 1;

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
SELECT S.StudentId, S.StudentName,M.StudentId, AVG(Mark) as diemtb FROM Student S 
 left join Mark M on S.StudentId = M.StudentId
 group by s.StudentId
 order by diemtb desc;

select *from mark;
