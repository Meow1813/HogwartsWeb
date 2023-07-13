--liquibase formatted sql

--changeset meow:1
CREATE INDEX student_name_index ON student (name);

--changeset meow:2
CREATE INDEX  faculty_color_index ON faculty (color);