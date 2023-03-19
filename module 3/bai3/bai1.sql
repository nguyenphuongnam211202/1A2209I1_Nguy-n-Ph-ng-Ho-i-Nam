-- hiển thị sinh viên có tên bắt đầu bằng h
select *from student
where StudentName like "h%";

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
select *from class
where StartDate like "%12%";

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5
select *from subject
where Credit > 3 and Credit < 5;

-- Thay đổi mã lớp(ClassID) của sinh viên có tên "hung" là 2.
update student 
set ClassId = 2
where StudentName = "Hung";
select *from student;

-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
SELECT S.StudentId, S.StudentName, Sub.SubName, M.Mark
FROM Student S join Mark M on S.StudentId = M.StudentId join Subject Sub on M.SubId = Sub.SubId
