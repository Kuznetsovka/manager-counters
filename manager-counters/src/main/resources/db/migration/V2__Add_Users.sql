INSERT INTO users (id, email, name, password, role)
values (1, 'mail@gmail.com', 'Kirill', '$2a$10$ycxma4AB6U6hBKknXgCSBeTBvPLxaxc6Jl5PIILYNidAzpYyu6Goe',  'USER');
INSERT INTO companies (id, inn, email, name, password ,role)
values (2, 111,'mail@gmail.com','DP', '$2a$10$ycxma4AB6U6hBKknXgCSBeTBvPLxaxc6Jl5PIILYNidAzpYyu6Goe', 'COMPANY');
ALTER SEQUENCE user_seq RESTART WITH 3;