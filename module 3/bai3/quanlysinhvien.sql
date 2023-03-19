use quanlysinhvien;
-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’:
select StudentName
from Student
where StudentName like 'h%';
  -- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
select ClassName, StartDate
from Class
where month(StartDate) =12;

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select * 
from `subject`
where Credit between 3 and 5;

-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
update student
set ClassId = 2
where StudentId = 1;
select *from student; 

-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
Select student.StudentId,
	   student.StudentName,
       `subject`.SubName,
       mark.Mark
From student
join mark
on student.StudentId = mark.StudentId
join `subject`
on mark.SubId = `subject`.SubId
order by mark desc, student.StudentName asc;

