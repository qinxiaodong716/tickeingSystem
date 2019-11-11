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

/*
 * 订单编号查询订单(前端)
 */
select o.order_id '订单编号',o.price '订单金额',o.status '状态',
			 f.flight_id '航班编号',f.flight_number '航班号',f.departure_date '出发日期',
			 t.ticket_order_id '机票编号',t.passenger_name '乘客姓名',t.certification_number '证件号码',
			 t.order_date '出票日期', t.level '舱位等级',t.passenger_type '乘客类型',
			 fs.from_city '出发机场', fs.to_city '到达机场',fs.departure_time '离港时间',
			 fs.arrival_time '到港时间',fs.sail_length '里程',fs.airplane '机型'
from orders o
JOIN ticket_order t
on o.ticket_order_id = t.ticket_order_id
JOIN flight f
on o.flight_number = f.flight_number
JOIN flight_scheduler fs
on f.flight_number = fs.flight_number
where operator_phone=4
/*
 * 出发地-到达地查询航班(前端)
 */
select f.flight_id '航班号',f.departure_date '出发日期',f.season_discount '季节折扣',f.first_class_remain_seats '头等舱',f.business_class_remain_seats '公务舱',f.economy_class_remain_seats '经济舱'
from flight f
where f.flight_number=(
	select fs.flight_number
	from flight_scheduler fs
	where fs.from_city=(
		select a1.airport_code
		from airport a1
		where a1.city=？
	)and fs.to_city=(
		select a2.airport_code
		from airport a2
		where a2.city=？
	)
)

/*
 *按 id 查找售票员 (后台)
 */


select s.sales_id 'id',s.sales_name 'name',b.branch_name '站点',s.phone '电话',
FROM sales s
JOIN branch b
on s.branch_id = b.branch_id
where s.sales_id=？

/*
 *查询航班信息(后台)
 */
select fs.flight_number '航班号',a1.city '出发地',a2.city '目的地',fs.arrival_time'离港时间',fs.departure_time'到港时间',fs.scheduler'班期',fs.basic_price '基准票价'
from flight_scheduler fs
JOIN airport a1
on fs.from_city = a1.airport_code
join airport a2
on fs.to_city = a2.airport_code

/*
 * 按出发地、目的地、出发时间查询航班信息
 */
select *
FROM flight f
where f.flight_number = (	
	select fs.flight_number
	FROM flight_scheduler fs
	where fs.from_city=(
		select a1.airport_code 
		FROM airport a1
		where a1.city = ""
	) and fs.to_city=(
		select a2.airport_code
		FROM airport a2
		where a2.city = ""
	)and fs.start_date= ""
)
select * from flight f where f.flight_number = (select fs.flight_number FROM flight_scheduler fs where fs.from_city=( select a1.airport_code FROM airport a1 where a1.city = ？) and fs.to_city=(select a2.airport_code FROM airport a2 where a2.city = ？)and fs.start_date= ？)



