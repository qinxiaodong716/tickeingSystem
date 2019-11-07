#建立数据库的表

#Module one 权限 [RBAC设计模式去设计表，非常的灵活，扩展性好]
	#airsys_user
	#airsys_role
	#airsys_resource

#Module tow 人资模块 [其实并没有统一的标注，就是根据实际情况设置表]
	#...

#Module Tree 行政模块 [子模块:考情管理、车辆管理、办公用品管理、休假管理]
	#...
	
#例子模块 
create table account(
	id int primary key auto_increment,
	name varchar(50) not null,
	balabce double
)

create table common_user(
	id int primary key auto_increment,
	name varchar(50) not null,
	age integer
)
insert into user(name,age) values("zhangsan",20);
#------------------------------------------------------------
create table AIRPORT(
	airport_code char(3) primary key,
	city varchar(20) not null,
	airport varchar(20)
)

create table AIRPLANE_MODEL(
	model varchar(20) primary key,
	max_sail_length int(6) not null,
	first_class_seats smallint(3) not null,
	business_class_seats smallint(3) not null,
	economy_class_seats smallint(3) not null
)

create table FLIGHT_SCHEDULER(
	flight_number char(6) primary key,
	start_date date not null,
	end_date date not null,
	from_city char(3) not null,
	to_city char(3) not null,
	departure_time date not null,
	arrival_time date not null,
	airplane varchar(20) not null,
	scheduler char(7) not null,
	sail_length int(5) not null
)

create table flight(
	flight_id int(8) primary key auto_increment,
	flight_number char(6),
	departure_date date not null,
	first_class_remain_seats smallint(3) not null,
	business_class_remain_seats smallint(3) not null,
	economy_class_remain_seats smallint(3) not null,
	season_discount double(4,2) not null
)

create table branch(
	branch_id smallint(4) primary key auto_increment,
	name varchar(40) not null,
	address varchar(50) not null,
	telephone varchar(15),
	province varchar(10) not null,
	city varchar(10) not null
)

create table sales(
	sales_id int(6) primary key auto_increment,
	branch_id smallint(4) not null,
	name varchar(10) not null,
	password varchar(10) not null
)

create table ticket_order(
	ticket_order_id bigint(10) primary key auto_increment,
	flight_id int(8) not null,
	passenger_name varchar(40) not null,
	certification_number varchar(20) not null,
	order_date char(1) not null,
	passenger_type char(1) not null,
	branch_id smallint(4) not null,
	sales_id int(6) not null
)
#-----------------------------------------
create table people(
	people_id int primary key auto_increment,
	people_name varchar(20) not null,
	password varchar(32) not null,
	phone varchar(11) not null,
	id_card varchar(18) not null
);
create table order(
	order_id int primary key auto_increment,
	ticket_order_id bigint(10) not null,
	price double not null,
	status smallint not null,
	flight_number char(6) not null,
);
create table admin(
	admin_id smallint primary key auto_increment,
	admin_name varchar(20) not null,
	password varchar(32) not null,
	department_id int not null
);


















