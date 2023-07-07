/*Составить первый JOIN-запрос, чтобы получить информацию обо всех студентах
(достаточно получить только имя и возраст студента) школы Хогвартс вместе с названиями факультетов.

Составить второй JOIN-запрос, чтобы получить только тех студентов, у которых есть аватарки.*/

SELECT s.name, s.age, f.name
FROM student s
         INNER JOIN faculty f ON f.id = s.faculty_id;

SELECT student.*
from student
         inner join avatar a on student.id = a.student_id;