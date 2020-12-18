INSERT INTO tbl_tariffs (id, price, type, region_id) VALUES (1, 182.67, 'HOT_WATER', 50);
INSERT INTO tbl_tariffs (id, price, type, region_id) VALUES (2, 44.56, 'COLD_WATER', 50);
INSERT INTO tbl_tariffs (id, price, type, region_id) VALUES (3, 38.86, 'DISCHARGE_WATER', 50);
INSERT INTO tbl_tariffs (id, price, type, region_id) VALUES (4, 4.01, 'ELECTRICITY', 50);
SET SQL_SAFE_UPDATES=0;
UPDATE tariff_seq SET next_val=5 where next_val=1;
SET SQL_SAFE_UPDATES=1;