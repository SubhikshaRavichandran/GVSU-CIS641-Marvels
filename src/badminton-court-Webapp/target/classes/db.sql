drop schema public cascade;

create schema public;

create table badminton_court (id int8 not null, close_time varchar(5) not null, location varchar(50) not null, name varchar(50) not null, open_time varchar(5) not null, type varchar(50) not null, fee int8, primary key (id));
create table badminton_court_fee (id int8 not null, additional_player_fee float8, court_rental_fee float8, racket_rental_fee float8, primary key (id));
create table booking (id int8 not null, date timestamp, payment_status varchar(10), price float8 not null, court int8 not null, customer int8 not null, primary key (id));
create table customer (id int8 not null, age int4 not null, email varchar(50) not null, fullName varchar(50) not null, password varchar(225) not null, phone varchar(10) not null, userName varchar(50) not null, primary key (id));
create table customer_history (id int8 not null, date timestamp, booking int8 not null, customer int8 not null, primary key (id));

alter table badminton_court add constraint UK_efrpfgfwpj0fvuu8mif5pb3ys unique (name);
alter table badminton_court add constraint FK_q02u1tgoj4g4t4q4ohruop2la foreign key (fee) references badminton_court_fee;
alter table booking add constraint FK_o222jw6wvjetd4ei2e1pk2cpn foreign key (court) references badminton_court;
alter table booking add constraint FK_87ypsm0tmg3uh3w32plb2sm92 foreign key (customer) references customer;
alter table customer_history add constraint FK_ga5e4r5xaj68qfigyaugldebb foreign key (booking) references booking;
alter table customer_history add constraint FK_4jkpuc8ti1pdi59gby7itunpo foreign key (customer) references customer;

create sequence hibernate_sequence;

insert into badminton_court_fee(id, additional_player_fee, court_rental_fee, racket_rental_fee) values(2001, 25, 175, 10);
insert into badminton_court(id, location, name, type, fee, open_time, close_time) values (2001, 'New York, United States', 'New York Courts', 'Grass', 2001, '06:00', '20:00');

insert into badminton_court_fee(id, additional_player_fee, court_rental_fee, racket_rental_fee) values (2002, 35, 185, 20);
insert into badminton_court(id, location, name, type, fee, open_time, close_time) values (2002, 'Boston, United States', 'Boston Courts', 'Dry', 2002, '07:00', '21:00');