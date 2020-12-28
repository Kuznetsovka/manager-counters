create table company_seq (next_val bigint) engine=InnoDB;
insert into company_seq values ( 1 );
create table counter_detail_seq (next_val bigint) engine=InnoDB;
insert into counter_detail_seq values ( 1 );
create table counter_seq (next_val bigint) engine=InnoDB;
insert into counter_seq values ( 1 );
create table house_seq (next_val bigint) engine=InnoDB;
insert into house_seq values ( 1 );
create table region_seq (next_val bigint) engine=InnoDB;
insert into region_seq values ( 1 );
create table tariff_seq (next_val bigint) engine=InnoDB;
insert into tariff_seq values ( 1 );
create table user_seq (next_val bigint) engine=InnoDB;
insert into user_seq values ( 1 );
create table value_seq (next_val bigint) engine=InnoDB;
insert into value_seq values ( 1 );
create table tbl_companies (id bigint not null, inn bigint, email varchar(255), name varchar(255), password varchar(255), role varchar(255), primary key (id)) engine=InnoDB;
create table tbl_counter_detail (id bigint not null, last_date datetime(6), old_value decimal(19,2), price decimal(19,2), counter_id bigint, primary key (id)) engine=InnoDB;
create table tbl_counters (id bigint not null, date_checking datetime(6), is_checking bit not null, name varchar(255), type varchar(255), house_id bigint, tariff_id bigint, primary key (id)) engine=InnoDB;
create table tbl_houses (id bigint not null, address varchar(255), company_id bigint, region_id bigint, user_id bigint, primary key (id)) engine=InnoDB;
create table tbl_regions (id bigint not null, title varchar(255), primary key (id)) engine=InnoDB;
create table tbl_tariffs (id bigint not null, price decimal(19,2), type varchar(255), region_id bigint, primary key (id)) engine=InnoDB;
create table tbl_users (id bigint not null, email varchar(255), name varchar(255), password varchar(255), role varchar(255), primary key (id)) engine=InnoDB;
create table tbl_values (id bigint not null, date datetime(6), value decimal(19,2), counter_id bigint, primary key (id)) engine=InnoDB;
alter table tbl_counter_detail add constraint FKoywp9pnvj5bqhsv05fgvmxcra foreign key (counter_id) references tbl_counters (id);
alter table tbl_counters add constraint FKt0eis16e1fxyn103m0hek4m8r foreign key (house_id) references tbl_houses (id);
alter table tbl_counters add constraint FKnrsb7prfp5iqv33xoxw4w9plc foreign key (tariff_id) references tbl_tariffs (id);
alter table tbl_houses add constraint FKcjwy2udubut8l1odx9u9t27g2 foreign key (company_id) references tbl_companies (id);
alter table tbl_houses add constraint FK32nnyv43p6cbv3a70lhnnywal foreign key (region_id) references tbl_regions (id);
alter table tbl_houses add constraint FK3sbkit5uhv8xb5abh31ioofup foreign key (user_id) references tbl_users (id);
alter table tbl_tariffs add constraint FKluamqcp1v3nhbn44ivkbyahbg foreign key (region_id) references tbl_regions (id);
alter table tbl_values add constraint FKqrrrdjsrt2b3lekdp75qggrfj foreign key (counter_id) references tbl_counters (id);