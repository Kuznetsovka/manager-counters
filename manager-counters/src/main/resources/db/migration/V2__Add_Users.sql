INSERT INTO tbl_users (id, email, name, password, role)
values (1, 'mail@gmail.com', 'Kirill', '$2a$10$ycxma4AB6U6hBKknXgCSBeTBvPLxaxc6Jl5PIILYNidAzpYyu6Goe',  'USER');
INSERT INTO tbl_companies (id, inn, email, name, password ,role)
values (1, 111111111,'mail@gmail.com','DP', '$2a$10$ycxma4AB6U6hBKknXgCSBeTBvPLxaxc6Jl5PIILYNidAzpYyu6Goe', 'COMPANY');
SET SQL_SAFE_UPDATES=0;
UPDATE user_seq SET next_val=2 where next_val=1;
UPDATE company_seq SET next_val=2 where next_val=1;
SET SQL_SAFE_UPDATES=1;