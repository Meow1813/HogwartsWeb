--liquibase formatted sql

--changeset meow:1
CREATE INDEX student_name_index ON student (name);

--changeset meow:2
CREATE INDEX  faculty_color_index ON faculty (color);

--changeset meow:3
DROP INDEX faculty_color_index; --не заметил что в задании нужно было создать индекс по двум полям
CREATE INDEX faculty_name_color_index ON faculty (name, color);